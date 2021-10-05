package com.dev.ms.crm.svc.controller;


import com.dev.ms.crm.core.service.PromotionService;
import com.dev.ms.crm.model.dto.PromotionDTO;
import com.dev.ms.crm.svc.constant.ResourcePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(ResourcePath.APP_VERSION)
public class PromotionController {

    @Autowired
    private PromotionService service;

    @GetMapping(value = ResourcePath.PROMOTION_INQUIRY)
    public List<PromotionDTO> inquiry(){
        return service.inquiry();
    }

    @PostMapping(value = ResourcePath.PROMOTION_INSERT)
    public PromotionDTO insert(@RequestBody PromotionDTO dto){
        return service.insert(dto);
    }

    @PostMapping(value = ResourcePath.PROMOTION_UPDATE)
    public PromotionDTO update(@RequestBody PromotionDTO dto){
        return service.update(dto);
    }

    @PostMapping(value = ResourcePath.PROMOTION_DELETE)
    public void delete(@PathVariable(value = "id") UUID id){
        service.delete(id);
    }
}
