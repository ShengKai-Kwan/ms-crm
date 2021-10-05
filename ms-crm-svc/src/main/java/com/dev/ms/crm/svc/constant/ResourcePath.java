package com.dev.ms.crm.svc.constant;

public class ResourcePath {
    public static final String APP_VERSION = "/v1";

    public static final String CUSTOMER_PATH = "/customer";
    public static final String CUSTOMER_INQUIRY = CUSTOMER_PATH + "/inquiry";
    public static final String CUSTOMER_INSERT = CUSTOMER_PATH + "/insert";
    public static final String CUSTOMER_UPDATE = CUSTOMER_PATH + "/update";
    public static final String CUSTOMER_DELETE = CUSTOMER_PATH + "/delete/{id}";

    public static final String ORDER_GROUP_PATH = "/order-group";
    public static final String ORDER_GROUP_INQUIRY = ORDER_GROUP_PATH + "/inquiry";
    public static final String ORDER_GROUP_INSERT = ORDER_GROUP_PATH + "/insert";
    public static final String ORDER_GROUP_UPDATE = ORDER_GROUP_PATH + "/update";
    public static final String ORDER_GROUP_DELETE = ORDER_GROUP_PATH + "/delete/{id}";

    public static final String ORDER_ITEM_PATH = "/order-item";
    public static final String ORDER_ITEM_INQUIRY = ORDER_ITEM_PATH + "/inquiry";
    public static final String ORDER_ITEM_INSERT = ORDER_ITEM_PATH + "/insert";
    public static final String ORDER_ITEM_UPDATE = ORDER_ITEM_PATH + "/update";
    public static final String ORDER_ITEM_DELETE = ORDER_ITEM_PATH + "/delete/{id}";

    public static final String PROMOTION_PATH = "/promotion";
    public static final String PROMOTION_INQUIRY = PROMOTION_PATH + "/inquiry";
    public static final String PROMOTION_INSERT = PROMOTION_PATH + "/insert";
    public static final String PROMOTION_UPDATE = PROMOTION_PATH + "/update";
    public static final String PROMOTION_DELETE = PROMOTION_PATH + "/delete/{id}";
}
