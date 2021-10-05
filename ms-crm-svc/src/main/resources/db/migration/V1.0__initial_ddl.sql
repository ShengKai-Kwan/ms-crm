CREATE TABLE t_customer (
    id uuid NOT NULL,
    name varchar(255) NULL,
    contact_no varchar(20) NULL,
    email varchar(50) NULL,
    address varchar(255) NULL,
    created_time timestamptz NULL,
    updated_time timestamptz NULL,
    version int4 NULL,
    created_by varchar(255) NOT NULL,
    updated_by varchar(255) NULL,
    status varchar(50) NULL,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
);

CREATE TABLE t_promotion (
    id uuid NOT NULL,
    name varchar(255) NULL,
    start_dt timestamptz NOT NULL,
    end_dt timestamptz NULL,
    promotion_type varchar(255),
    promotion_rate real NULL,
    created_time timestamptz NULL,
    updated_time timestamptz NULL,
    version int4 NULL,
    created_by varchar(255) NOT NULL,
    updated_by varchar(255) NULL,
    status varchar(50) NULL,
    CONSTRAINT promotion_pkey PRIMARY KEY (id)
);

CREATE TABLE t_order_group (
    id uuid NOT NULL,
    delivery_time timestamptz NULL,
    amount real NULL,
    address varchar(255) NULL,
    remarks text NULL,
    customer_id uuid NULL,
    promotion_id uuid NULL,
    created_time timestamptz NULL,
    updated_time timestamptz NULL,
    version int4 NULL,
    created_by varchar(255) NOT NULL,
    updated_by varchar(255) NULL,
    status varchar(50) NULL,
    CONSTRAINT order_group_pkey PRIMARY KEY (id),
    CONSTRAINT fk_order_group_customer_id FOREIGN KEY (customer_id) REFERENCES t_customer(id) ON DELETE CASCADE,
    CONSTRAINT fk_order_group_promotion_id FOREIGN KEY (promotion_id) REFERENCES t_promotion(id) ON DELETE CASCADE
);

CREATE TABLE t_order_item (
    id uuid NOT NULL,
    name varchar(255) NULL,
    unit_price real NULL,
    final_price real NULL,
    remarks text NULL,
    order_grp_id uuid NULL,
    promotion_id uuid NULL,
    created_time timestamptz NULL,
    updated_time timestamptz NULL,
    version int4 NULL,
    created_by varchar(255) NOT NULL,
    updated_by varchar(255) NULL,
    status varchar(50) NULL,
    CONSTRAINT order_item_pkey PRIMARY KEY (id),
    CONSTRAINT fk_order_item_order_grp_id FOREIGN KEY (order_grp_id) REFERENCES t_order_group(id) ON DELETE CASCADE,
    CONSTRAINT fk_order_item_promotion_id FOREIGN KEY (promotion_id) REFERENCES t_promotion(id) ON DELETE CASCADE
);