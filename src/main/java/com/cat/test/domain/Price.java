package com.cat.test.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    Integer id;
    Integer brandId;
    Date startDate;
    Date endDate;
    Integer priceList;
    Integer productId;
    Integer priority;
    Float price;
    String curr;
}
