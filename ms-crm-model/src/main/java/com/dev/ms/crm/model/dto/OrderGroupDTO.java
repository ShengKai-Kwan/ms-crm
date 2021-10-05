package com.dev.ms.crm.model.dto;


import com.dev.core.lib.utility.core.model.dto.BaseEntityDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrderGroupDTO extends BaseEntityDTO {
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime deliveryTime;
    private double amount;
    private String address;
    private String remarks;
    private List<OrderItemDTO> orderItems;
    private UUID customerId;
    private UUID promotionId;
}
