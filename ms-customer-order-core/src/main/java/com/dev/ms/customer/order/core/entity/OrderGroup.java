package com.dev.ms.customer.order.core.entity;


import com.dev.core.lib.utility.core.model.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_order_group")
@EqualsAndHashCode(callSuper = true)
public class OrderGroup extends BaseEntity {

    @Column(name = "delivery_time")
    private LocalDateTime deliveryTime;

    @Column(name = "amount")
    private double amount;

    @Column(name = "address")
    private String address;

    @Column(name = "remarks")
    private String remarks;

    @OneToMany(mappedBy = "orderGroup", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<OrderItem> orderItems;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_id",
        foreignKey = @ForeignKey(name = "fk_order_customer_id")
    )
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "promotion_id",
            foreignKey = @ForeignKey(name = "fk_order_group_promotion_id")
    )
    private Promotion promotion;

}
