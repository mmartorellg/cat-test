package com.cat.test.infrastructure.db.mapper;

import com.cat.test.domain.Brand;
import com.cat.test.domain.Product;
import com.cat.test.infrastructure.db.model.ProductDao;
import org.mapstruct.Mapper;

import java.util.HashMap;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface ProductMapperDB {

    default Map<String, Object> toMap(Product product) {
        Map<String, Object> productMap = new HashMap<>();
        productMap.put("id", product.getId());
        productMap.put("product", product.getProduct());
        return productMap;
    }

    Product toDomain(ProductDao productDao);
}
