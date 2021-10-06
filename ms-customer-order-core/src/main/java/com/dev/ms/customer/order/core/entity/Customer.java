package com.dev.ms.customer.order.core.entity;


import com.dev.core.lib.utility.core.model.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_customer")
@EqualsAndHashCode(callSuper = true)
public class Customer extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "contact_no")
    private String contactNo;

    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "customer")
    private List<OrderGroup> orderGroups;
}
