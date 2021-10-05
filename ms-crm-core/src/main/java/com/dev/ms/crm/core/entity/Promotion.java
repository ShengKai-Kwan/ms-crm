package com.dev.ms.crm.core.entity;


import com.dev.core.lib.utility.core.model.entity.BaseEntity;
import com.dev.ms.crm.model.enums.PromotionType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_promotion")
@EqualsAndHashCode(callSuper = true)
public class Promotion extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "start_dt")
    private LocalDate startDate;

    @Column(name = "end_dt")
    private LocalDate endDate;

    @Column(name = "promotion_type")
    private PromotionType type;

    @Column(name = "promotion_rate")
    private double promotionRate;
}
