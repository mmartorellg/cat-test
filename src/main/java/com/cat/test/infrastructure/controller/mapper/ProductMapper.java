package com.cat.test.infrastructure.controller.mapper;

import com.cat.test.domain.Product;
import com.cat.test.infrastructure.controller.model.ProductRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductRequest toRequest(Product product);

    Product toDomain(ProductRequest productRequest);
}
