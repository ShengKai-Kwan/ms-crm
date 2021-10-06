package com.dev.ms.customer.order.svc.controller;


import com.dev.ms.customer.order.core.service.OrderItemService;
import com.dev.ms.customer.order.model.dto.OrderItemDTO;
import com.dev.ms.customer.order.svc.constant.ResourcePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ResourcePath.APP_VERSION)
public class OrderItemController {

    @Autowired
    private OrderItemService service;

    @GetMapping(value = ResourcePath.ORDER_ITEM_INQUIRY)
    public List<OrderItemDTO> inquiry(){
        return service.inquiry();
    }

    @PostMapping(value = ResourcePath.ORDER_ITEM_INSERT)
    public OrderItemDTO insert(@RequestBody OrderItemDTO dto){
        return service.insert(dto);
    }

    @PostMapping(value = ResourcePath.ORDER_ITEM_UPDATE)
    public OrderItemDTO update(@RequestBody OrderItemDTO dto){
        return service.update(dto);
    }

    @PostMapping(value = ResourcePath.ORDER_ITEM_DELETE)
    public void delete(@PathVariable(value = "id") UUID id){
        service.delete(id);
    }
}
