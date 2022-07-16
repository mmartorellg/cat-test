package com.cat.test.infrastructure.db.mapper;

import com.cat.test.domain.Product;
import com.cat.test.infrastructure.db.model.ProductDao;
import org.mapstruct.Mapper;

import java.util.HashMap;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    HashMap<String, Object> toMap(Product product);

    Product toDomain(ProductDao productDao);
}
