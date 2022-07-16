package com.cat.test.application.port.input;

import com.cat.test.domain.Price;
import com.cat.test.domain.PriceQuery;

import java.util.List;

public interface PriceCommand {
    Price queryPrices(PriceQuery priceQuery);
}

