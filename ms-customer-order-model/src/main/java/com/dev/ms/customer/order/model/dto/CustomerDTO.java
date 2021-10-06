package com.dev.ms.customer.order.model.dto;


import com.dev.core.lib.utility.core.model.dto.BaseEntityDTO;
import lombok.*;

import java.util.List;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class  CustomerDTO extends BaseEntityDTO {

    private String name;
    private String contactNo;
    private String email;
    private String address;
    private List<OrderGroupDTO> orderGroups;
}
