package com.dev.ms.crm.core.exception;

import com.dev.core.lib.utility.core.exception.base.BaseError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CrmErrorEnum implements BaseError {

    CUSTOMER_RECORD_ALREADY_EXIST("10001", "Customer Record Not Found"),
    CUSTOMER_RECORD_NOT_FOUND("10002", "Customer Record Not Found");

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
