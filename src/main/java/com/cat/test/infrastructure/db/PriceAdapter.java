package com.cat.test.infrastructure.db;

import com.cat.test.application.port.output.PriceRepository;
import com.cat.test.domain.Price;
import com.cat.test.domain.PriceQuery;
import com.cat.test.infrastructure.db.generic.GenericAdapter;
import com.cat.test.infrastructure.db.mapper.PriceMapperDB;
import com.cat.test.infrastructure.db.mapper.ProductMapperDB;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PriceAdapter implements PriceRepository {

    private final GenericAdapter genericAdapter;
    private final PriceMapperDB priceMapperDB;
    private final String QUERY = "SELECT * FROM PRICE WHERE BRAND_ID = :brandId AND PRODUCT_ID = :productId AND " +
            "START_DATE < :queryDate AND END_DATE > :queryDate ORDER BY priority DESC LIMIT 1";

    public PriceAdapter(GenericAdapter genericAdapter, PriceMapperDB priceMapperDB) {
        this.genericAdapter = genericAdapter;
        this.priceMapperDB = priceMapperDB;
    }

    @Override
    public List<Price> queryPrices(PriceQuery priceQuery) {
        return genericAdapter.queryForList(QUERY, priceMapperDB.toMap(priceQuery), Price.class);
    }
}
