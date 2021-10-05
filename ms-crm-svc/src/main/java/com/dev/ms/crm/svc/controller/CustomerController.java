package com.dev.ms.crm.svc.controller;


import com.dev.ms.crm.core.service.CustomerService;
import com.dev.ms.crm.model.dto.CustomerDTO;
import com.dev.ms.crm.svc.constant.ResourcePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ResourcePath.APP_VERSION)
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping(value = ResourcePath.CUSTOMER_INQUIRY)
    public List<CustomerDTO> inquiry(){
        return customerService.inquiry();
    }

    @PostMapping(value = ResourcePath.CUSTOMER_INSERT)
    public CustomerDTO insert(@RequestBody CustomerDTO customerDTO){
        return customerService.insert(customerDTO);
    }

    @PostMapping(value = ResourcePath.CUSTOMER_UPDATE)
    public CustomerDTO update(@RequestBody CustomerDTO customerDTO){
        return customerService.update(customerDTO);
    }

    @PostMapping(value = ResourcePath.CUSTOMER_DELETE)
    public void delete(@PathVariable(value = "id") UUID id){
        customerService.delete(id);
    }
}
