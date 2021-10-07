package com.dev.ms.customer.order.core.service;

import com.dev.core.lib.utility.core.exception.GenericErrorException;
import com.dev.core.lib.utility.core.model.enums.Status;
import com.dev.ms.customer.order.core.entity.Customer;
import com.dev.ms.customer.order.core.exception.CustomerOrderErrorEnum;
import com.dev.ms.customer.order.core.repository.CustomerRepository;
import com.dev.ms.customer.order.model.dto.CustomerDTO;
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
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    @Qualifier("baseModelMapper")
    private ModelMapper baseModelMapper;

    public List<CustomerDTO> inquiry(){
        return customerRepo.findAll().stream()
                .map(record -> baseModelMapper.map(record, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    public CustomerDTO insert(CustomerDTO customerDTO){

        if(null != customerDTO.getId() && customerRepo.existsById(customerDTO.getId()))
            throw new GenericErrorException(CustomerOrderErrorEnum.CUSTOMER_RECORD_ALREADY_EXIST);

        Customer customer = baseModelMapper.map(customerDTO, Customer.class);
        return baseModelMapper.map(
                customerRepo.saveAndFlush(customer),
                CustomerDTO.class);
    }

    public CustomerDTO update(CustomerDTO customerDTO){
        if(null == customerDTO.getId() || !customerRepo.existsById(customerDTO.getId()))
            throw new GenericErrorException(CustomerOrderErrorEnum.CUSTOMER_RECORD_NOT_FOUND);

        Customer customer = baseModelMapper.map(customerDTO, Customer.class);
        return baseModelMapper.map(
                customerRepo.saveAndFlush(customer),
                CustomerDTO.class);
    }

    public void delete(UUID id){
        customerRepo.findById(id)
                .ifPresent(record -> {
                    record.setStatus(Status.DELETED);
                    customerRepo.saveAndFlush(record);
                });
    }
}
