package com.dev.ms.crm.core.exception;

import com.dev.core.lib.utility.core.exception.base.BaseError;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CrmErrorEnum implements BaseError {

    CUSTOMER_RECORD_ALREADY_EXIST("10001", "Customer Record Already Exist"),
    CUSTOMER_RECORD_NOT_FOUND("10002", "Customer Record Not Found"),
    PROMOTION_RECORD_NOT_FOUND("10003", "Promotion Record Not Found"),
    PROMOTION_RECORD_ALREADY_EXIST("10004", "Promotion Record Already Exist"),
    ORDER_GROUP_RECORD_NOT_FOUND("10005", "Order Group Record Not Found"),
    ORDER_GROUP_RECORD_ALREADY_EXIST("10006", "Order Group Record Already Exist"),
    ORDER_ITEM_RECORD_NOT_FOUND("10007", "Order Item Record Not Found"),
    ORDER_ITEM_RECORD_ALREADY_EXIST("10008", "Order Item Record Already Exist");

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
