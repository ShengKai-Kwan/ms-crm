package com.dev.ms.crm.core.service;

import com.dev.core.lib.utility.core.exception.GenericErrorException;
import com.dev.core.lib.utility.core.model.enums.Status;
import com.dev.ms.crm.core.entity.Customer;
import com.dev.ms.crm.core.entity.OrderGroup;
import com.dev.ms.crm.core.entity.OrderItem;
import com.dev.ms.crm.core.entity.Promotion;
import com.dev.ms.crm.core.exception.CrmErrorEnum;
import com.dev.ms.crm.core.repository.CustomerRepository;
import com.dev.ms.crm.core.repository.OrderGroupRepository;
import com.dev.ms.crm.core.repository.OrderItemRepository;
import com.dev.ms.crm.core.repository.PromotionRepository;
import com.dev.ms.crm.model.dto.OrderGroupDTO;
import com.dev.ms.crm.model.dto.OrderItemDTO;
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
public class OrderItemService {

    @Autowired
    private OrderGroupRepository orderGroupRepo;

    @Autowired
    private OrderItemRepository orderItemRepo;

    @Autowired
    private PromotionRepository promotionRepo;

    @Autowired
    @Qualifier("baseModelMapper")
    private ModelMapper baseModelMapper;

    public List<OrderItemDTO> inquiry(){
        return orderItemRepo.findAll().stream()
                .map(record -> baseModelMapper.map(record, OrderItemDTO.class))
                .collect(Collectors.toList());
    }

    public OrderItemDTO insert(OrderItemDTO orderItemDTO){
        if(null != orderItemDTO.getId() && orderItemRepo.existsById(orderItemDTO.getId()))
            throw new GenericErrorException(CrmErrorEnum.ORDER_ITEM_RECORD_ALREADY_EXIST);
        OrderItem orderItem = constructOrderItem(orderItemDTO);
        return baseModelMapper.map(
                orderItemRepo.saveAndFlush(orderItem),
                OrderItemDTO.class);
    }

    public OrderItemDTO update(OrderItemDTO orderItemDTO){
        if(null == orderItemDTO.getId() || !orderItemRepo.existsById(orderItemDTO.getId()))
            throw new GenericErrorException(CrmErrorEnum.ORDER_ITEM_RECORD_NOT_FOUND);
        OrderItem orderItem = constructOrderItem(orderItemDTO);
        return baseModelMapper.map(
                orderItemRepo.saveAndFlush(orderItem),
                OrderItemDTO.class);
    }

    public void delete(UUID id){
        orderItemRepo.findById(id)
                .ifPresent(record -> {
                    record.setStatus(Status.DELETED);
                    orderItemRepo.saveAndFlush(record);
                });
    }

    public OrderItem constructOrderItem(OrderItemDTO orderItemDTO){
        OrderGroup orderGroup = orderGroupRepo.findById(orderItemDTO.getOrderGroupId())
                .orElseThrow(() -> new GenericErrorException(CrmErrorEnum.ORDER_GROUP_RECORD_NOT_FOUND));

        Promotion promotion = null;
        if(null != orderItemDTO.getPromotionId()) {
            promotion = promotionRepo.findById(orderItemDTO.getPromotionId())
                    .orElseThrow(() -> new GenericErrorException(CrmErrorEnum.PROMOTION_RECORD_NOT_FOUND));
        }

        OrderItem orderItem = baseModelMapper.map(orderItemDTO, OrderItem.class);
        orderItem.setOrderGroup(orderGroup);
        orderItem.setPromotion(promotion);
        return orderItem;
    }
}
