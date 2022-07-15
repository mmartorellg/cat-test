package com.cat.test.domain;

import lombok.Value;

import java.time.LocalDate;

@Value
public class Price {
    Integer id;
    Integer brandId;
    LocalDate startDate;
    LocalDate endDate;
    Integer priceList;
    Integer productId;
    Integer priority;
    Float price;
    String curr;
}
