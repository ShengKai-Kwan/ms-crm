package com.dev.ms.customer.order.core.service;

import com.dev.core.lib.utility.core.exception.GenericErrorException;
import com.dev.core.lib.utility.core.model.enums.Status;
import com.dev.ms.customer.order.core.entity.Customer;
import com.dev.ms.customer.order.core.entity.OrderGroup;
import com.dev.ms.customer.order.core.entity.Promotion;
import com.dev.ms.customer.order.core.exception.CustomerOrderErrorEnum;
import com.dev.ms.customer.order.core.repository.CustomerRepository;
import com.dev.ms.customer.order.core.repository.OrderGroupRepository;
import com.dev.ms.customer.order.core.repository.PromotionRepository;
import com.dev.ms.customer.order.model.dto.OrderGroupDTO;
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
public class OrderGroupService {

    @Autowired
    private OrderGroupRepository orderGroupRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private PromotionRepository promotionRepo;

    @Autowired
    @Qualifier("baseModelMapper")
    private ModelMapper baseModelMapper;

    public List<OrderGroupDTO> inquiry(){
        return orderGroupRepo.findAll().stream()
                .map(record -> baseModelMapper.map(record, OrderGroupDTO.class))
                .collect(Collectors.toList());
    }

    public OrderGroupDTO insert(OrderGroupDTO orderGroupDTO){
        if(null == orderGroupDTO.getId())
            orderGroupDTO.setId(UUID.randomUUID());
        if(orderGroupRepo.existsById(orderGroupDTO.getId()))
            throw new GenericErrorException(CustomerOrderErrorEnum.ORDER_GROUP_RECORD_ALREADY_EXIST);
        OrderGroup orderGroup = constructOrderGroup(orderGroupDTO);
        return baseModelMapper.map(
                orderGroupRepo.saveAndFlush(orderGroup),
                OrderGroupDTO.class);
    }

    public OrderGroupDTO update(OrderGroupDTO orderGroupDTO){
        if(null == orderGroupDTO.getId() || !orderGroupRepo.existsById(orderGroupDTO.getId()))
            throw new GenericErrorException(CustomerOrderErrorEnum.ORDER_GROUP_RECORD_NOT_FOUND);

        OrderGroup orderGroup = constructOrderGroup(orderGroupDTO);
        return baseModelMapper.map(
                orderGroupRepo.saveAndFlush(orderGroup),
                OrderGroupDTO.class);
    }

    public void delete(UUID id){
        orderGroupRepo.findById(id)
                .ifPresent(record -> {
                    record.setStatus(Status.DELETED);
                    orderGroupRepo.saveAndFlush(record);
                });
    }

    public OrderGroup constructOrderGroup(OrderGroupDTO orderGroupDTO){
        Customer customer = customerRepo.findById(orderGroupDTO.getCustomerId())
                .orElseThrow(() -> new GenericErrorException(CustomerOrderErrorEnum.CUSTOMER_RECORD_NOT_FOUND));

        Promotion promotion = null;
        if(null != orderGroupDTO.getPromotionId()) {
            promotion = promotionRepo.findById(orderGroupDTO.getPromotionId())
                    .orElseThrow(() -> new GenericErrorException(CustomerOrderErrorEnum.PROMOTION_RECORD_NOT_FOUND));
        }

        orderGroupDTO.getOrderItems().stream()
                .forEach(record -> record.setOrderGroupId(orderGroupDTO.getId()));

        OrderGroup orderGroup = baseModelMapper.map(orderGroupDTO, OrderGroup.class);
        orderGroup.setCustomer(customer);
        orderGroup.setPromotion(promotion);
        return orderGroup;
    }
}
