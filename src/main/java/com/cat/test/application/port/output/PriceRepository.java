package com.cat.test.application.port.output;

import com.cat.test.domain.Price;
import com.cat.test.domain.PriceQuery;

import java.util.List;

public interface PriceRepository {
    List<Price> queryPrices(PriceQuery priceQuery);
}

