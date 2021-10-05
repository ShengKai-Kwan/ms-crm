package com.dev.ms.crm.core.exception;

import com.dev.core.lib.utility.exception.base.BaseError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CrmErrorEnum implements BaseError {

    CUSTOMER_NOT_FOUND("10001", "Customer Record Not Found");

    private final String appCode = "CRM";
    private final String code;
    private final String description;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public String getApplication() {
        return this.appCode;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
