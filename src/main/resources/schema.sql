create table BRAND
(
    ID              integer      not null,
    BRAND            varchar(255) not null,
    primary key (ID)
);
create table PRODUCT
(
    ID              integer      not null,
    PRODUCT            varchar(255) not null,
    primary key (ID)
);
create table PRICES
(
    ID         integer    not null,
    BRAND_ID   integer    not null,
    START_DATE datetime,
    END_DATE   datetime,
    PRICE_LIST integer,
    PRODUCT_ID integer    not null,
    PRIORITY   integer,
    PRICE      decimal(10, 2),
    CURR       varchar(3) not null,
    primary key (ID),
    foreign key (BRAND_ID) references BRAND(ID),
    foreign key (PRODUCT_ID) references PRODUCT(ID)
);
