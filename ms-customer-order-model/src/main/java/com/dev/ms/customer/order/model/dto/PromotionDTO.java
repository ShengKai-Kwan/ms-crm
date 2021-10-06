package com.dev.ms.customer.order.model.dto;


import com.dev.core.lib.utility.core.model.entity.BaseEntity;
import com.dev.ms.customer.order.model.enums.PromotionType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PromotionDTO extends BaseEntity {

    private String name;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
    private PromotionType type;
    private double promotionRate;
}
