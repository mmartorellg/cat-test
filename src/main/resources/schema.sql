create table BRAND
(
    id              bigint      not null,
    name            varchar(255) not null,
    primary key (id)
);
create table PRODUCT
(
    id              bigint      not null,
    name            varchar(255) not null,
    primary key (id)
);
create table PRICES
(
    ID         bigint    not null,
    BRAND_ID   bigint    not null,
    START_DATE datetime,
    END_DATE   datetime,
    PRICE_LIST integer,
    PRODUCT_ID bigint    not null,
    PRIORITY   integer,
    PRICE      decimal(10, 2),
    CURR       varchar(3) not null,
    primary key (ID)
);
