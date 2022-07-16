package com.cat.test.infrastructure.controller.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceQueryResponse {
    Integer productId;
    Integer brandId;
    Integer priceList;
    String startDate;
    String endDate;
    Float price;
}
