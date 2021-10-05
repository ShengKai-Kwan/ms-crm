package com.dev.ms.crm.core.service;

import com.dev.core.lib.utility.exception.GenericErrorException;
import com.dev.core.lib.utility.model.enums.Status;
import com.dev.ms.crm.core.entity.Customer;
import com.dev.ms.crm.core.exception.CrmErrorEnum;
import com.dev.ms.crm.core.repository.CustomerRepository;
import com.dev.ms.crm.model.dto.CustomerDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    @Qualifier("crmModelMapper")
    private ModelMapper crmModelMapper;

    public List<CustomerDTO> inquiry(){
        return customerRepo.findAll().stream()
                .map(record -> crmModelMapper.map(record, CustomerDTO.class))
                .collect(Collectors.toList());
    }

    public CustomerDTO insert(CustomerDTO customerDTO){
        Customer customer = customerRepo.saveAndFlush(
                crmModelMapper.map(customerDTO, Customer.class));
        return crmModelMapper.map(customer, CustomerDTO.class);
    }

    public CustomerDTO update(CustomerDTO customerDTO){
        if(null == customerDTO.getId() || !customerRepo.existsById(customerDTO.getId()))
            throw new GenericErrorException(CrmErrorEnum.CUSTOMER_NOT_FOUND);

        Customer customer = customerRepo.saveAndFlush(
                crmModelMapper.map(customerDTO, Customer.class));
        return crmModelMapper.map(customer, CustomerDTO.class);
    }

    public void delete(UUID id){
        customerRepo.findById(id)
                .ifPresent(record -> {
                    record.setStatus(Status.DELETED);
                    customerRepo.saveAndFlush(record);
                });
    }
}
