package com.dev.ms.crm.model.dto;


import com.dev.core.lib.utility.core.model.dto.BaseEntityDTO;
import lombok.*;

import java.io.Serializable;

@Builder
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends BaseEntityDTO {

    private String name;
    private String contactNo;
    private String email;
    private String address;
    private Serializable orderGroups;
}
