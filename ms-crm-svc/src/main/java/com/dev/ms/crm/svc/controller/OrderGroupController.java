package com.dev.ms.crm.svc.controller;


import com.dev.ms.crm.core.service.OrderGroupService;
import com.dev.ms.crm.model.dto.OrderGroupDTO;
import com.dev.ms.crm.svc.constant.ResourcePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ResourcePath.APP_VERSION)
public class OrderGroupController {

    @Autowired
    private OrderGroupService service;

    @GetMapping(value = ResourcePath.ORDER_GROUP_INQUIRY)
    public List<OrderGroupDTO> inquiry(){
        return service.inquiry();
    }

    @PostMapping(value = ResourcePath.ORDER_GROUP_INSERT)
    public OrderGroupDTO insert(@RequestBody OrderGroupDTO orderGroupDTO){
        return service.insert(orderGroupDTO);
    }

    @PostMapping(value = ResourcePath.ORDER_GROUP_UPDATE)
    public OrderGroupDTO update(@RequestBody OrderGroupDTO orderGroupDTO){
        return service.update(orderGroupDTO);
    }

    @PostMapping(value = ResourcePath.ORDER_GROUP_DELETE)
    public void delete(@PathVariable(value = "id") UUID id){
        service.delete(id);
    }
}
