package com.dev.ms.crm.svc.constant;

public class ResourcePath {
    public static final String APP_VERSION = "/v1";

    public static final String CUSTOMER_PATH = "/customer";
    public static final String CUSTOMER_INQUIRY = CUSTOMER_PATH + "/inquiry";
    public static final String CUSTOMER_INSERT = CUSTOMER_PATH + "/insert";
    public static final String CUSTOMER_UPDATE = CUSTOMER_PATH + "/update";
    public static final String CUSTOMER_DELETE = CUSTOMER_PATH + "/delete/{id}";
}
