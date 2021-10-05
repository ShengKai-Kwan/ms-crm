package com.dev.ms.crm.core.config;

import org.hibernate.collection.spi.PersistentCollection;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CrmBean {

    @Bean("crmModelMapper")
    public ModelMapper crmModelMapper(){
        ModelMapper modelMapper =new ModelMapper();
        modelMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setPropertyCondition(mappingContext -> !(mappingContext.getSource() instanceof PersistentCollection));
        return modelMapper;
    }
}
