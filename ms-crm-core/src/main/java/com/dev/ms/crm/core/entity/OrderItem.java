package com.dev.ms.crm.core.entity;


import com.dev.core.lib.utility.core.model.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_order_item")
@EqualsAndHashCode(callSuper = true)
public class OrderItem extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "final_price")
    private double finalPrice;

    @Column(name = "remarks")
    private String remarks;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_grp_id",
        foreignKey = @ForeignKey(name = "fk_order_detail_order_group_id")
    )
    private OrderGroup orderGroup;

    @OneToOne
    @JoinColumn(name = "promotion_id",
            foreignKey = @ForeignKey(name = "fk_order_group_promotion_id")
    )
    private Promotion promotion;
}
