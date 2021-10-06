package com.dev.ms.customer.order.core.service;

import com.dev.core.lib.utility.core.model.enums.Status;
import com.dev.ms.customer.order.core.entity.Customer;
import com.dev.ms.customer.order.core.repository.CustomerRepository;
import com.dev.ms.customer.order.model.dto.CustomerDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    private CustomerService customerService;

    private ModelMapper modelMapper;

    @Mock
    CustomerRepository customerRepo;

    @BeforeEach
    void init(){
        modelMapper = new ModelMapper();
        customerService = new CustomerService(customerRepo, modelMapper);
    }

    @Test
    void When_Inquiry_Expect_Success(){
        when(customerRepo.findAll())
                .thenReturn(Arrays.asList(new Customer(), new Customer()));
        List<CustomerDTO> result = customerService.inquiry();
        assertThat(result.size()).isEqualTo(2);
        verify(customerRepo, times(1))
                .findAll();
    }

    @Test
    void When_Insert_Expect_Success(){
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(UUID.randomUUID());
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        when(customerRepo.existsById(customerDTO.getId()))
                .thenReturn(false);
        when(customerRepo.saveAndFlush(customer))
                .thenReturn(customer);
        customerService.insert(customerDTO);
        verify(customerRepo, times(1))
                .existsById(customerDTO.getId());
        verify(customerRepo, times(1))
                .saveAndFlush(customer);
    }

    @Test
    void When_Update_Expect_Success(){
        UUID custId = UUID.randomUUID();
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(custId);
        Customer customer = modelMapper.map(customerDTO, Customer.class);
        when(customerRepo.existsById(custId))
                .thenReturn(true);
        when(customerRepo.saveAndFlush(customer))
                .thenReturn(customer);
        customerService.update(customerDTO);
        verify(customerRepo, times(1))
                .saveAndFlush(customer);
    }

    @Test
    void When_Delete_Expect_Success(){
        UUID custId = UUID.randomUUID();
        Customer customer = new Customer();
        customer.setId(custId);
        customer.setStatus(Status.DELETED);

        when(customerRepo.findById(custId))
                .thenReturn(Optional.of(customer));
        when(customerRepo.saveAndFlush(customer))
                .thenReturn(customer);

        customerService.delete(custId);

        verify(customerRepo, times(1))
                .findById(custId);
        verify(customerRepo, times(1))
                .saveAndFlush(customer);
    }
}
