package com.dev.ms.crm.model.dto;


import com.dev.core.lib.utility.core.model.entity.BaseEntity;
import lombok.*;

import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDTO extends BaseEntity {

    private String name;
    private double unitPrice;
    private double finalPrice;
    private String remarks;
    private UUID orderGroupId;
    private UUID promotionId;
}
