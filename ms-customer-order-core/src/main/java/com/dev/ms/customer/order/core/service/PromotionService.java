package com.dev.ms.customer.order.core.service;

import com.dev.core.lib.utility.core.exception.GenericErrorException;
import com.dev.core.lib.utility.core.model.enums.Status;
import com.dev.ms.customer.order.core.entity.Promotion;
import com.dev.ms.customer.order.core.exception.CustomerOrderErrorEnum;
import com.dev.ms.customer.order.core.repository.PromotionRepository;
import com.dev.ms.customer.order.model.dto.PromotionDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepo;

    @Autowired
    @Qualifier("baseModelMapper")
    private ModelMapper baseModelMapper;

    public List<PromotionDTO> inquiry(){
        return promotionRepo.findAll().stream()
                .map(record -> baseModelMapper.map(record, PromotionDTO.class))
                .collect(Collectors.toList());
    }

    public PromotionDTO insert(PromotionDTO promotionDTO){

        if(null != promotionDTO.getId() && promotionRepo.existsById(promotionDTO.getId()))
            throw new GenericErrorException(CustomerOrderErrorEnum.CUSTOMER_RECORD_ALREADY_EXIST);

        Promotion promotion = baseModelMapper.map(promotionDTO, Promotion.class);
        return baseModelMapper.map(
                promotionRepo.saveAndFlush(promotion),
                PromotionDTO.class);
    }

    public PromotionDTO update(PromotionDTO promotionDTO){
        if(null == promotionDTO.getId() || !promotionRepo.existsById(promotionDTO.getId()))
            throw new GenericErrorException(CustomerOrderErrorEnum.CUSTOMER_RECORD_NOT_FOUND);

        Promotion promotion = baseModelMapper.map(promotionDTO, Promotion.class);
        return baseModelMapper.map(
                promotionRepo.saveAndFlush(promotion),
                PromotionDTO.class);
    }

    public void delete(UUID id){
        promotionRepo.findById(id)
                .ifPresent(record -> {
                    record.setStatus(Status.DELETED);
                    promotionRepo.saveAndFlush(record);
                });
    }
}
