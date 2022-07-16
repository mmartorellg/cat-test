package com.cat.test.infrastructure.controller.mapper;

import com.cat.test.domain.Brand;
import com.cat.test.domain.Price;
import com.cat.test.domain.PriceQuery;
import com.cat.test.domain.Product;
import com.cat.test.infrastructure.controller.model.BrandRequest;
import com.cat.test.infrastructure.controller.model.PriceQueryRequest;
import com.cat.test.infrastructure.controller.model.PriceQueryResponse;
import org.mapstruct.Mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface PriceQueryMapperController {

    PriceQuery toDomain(PriceQueryRequest priceQueryRequest);

    default PriceQueryResponse toResponse(Price price) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
        return PriceQueryResponse.builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .startDate(dateFormat.format(price.getStartDate()))
                .endDate(dateFormat.format(price.getEndDate()))
                .price(price.getPrice()).build();
    }
}
