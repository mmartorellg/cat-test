package com.cat.test.domain;

import lombok.Value;

import java.util.Date;

@Value
public class PriceQuery {
    Integer productId;
    Integer brandId;
    Date queryDate;
}
