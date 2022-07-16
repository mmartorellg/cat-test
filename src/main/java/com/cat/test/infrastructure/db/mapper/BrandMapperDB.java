package com.cat.test.infrastructure.db.mapper;

import com.cat.test.domain.Brand;
import com.cat.test.infrastructure.db.model.BrandDao;
import org.mapstruct.Mapper;

import java.util.HashMap;
import java.util.Map;

@Mapper(componentModel = "spring")
public interface BrandMapperDB {

    default Map<String, Object> toMap(Brand brand) {
        return Map.of(
                "id", brand.getId(),
                "brand", brand.getBrand()
        );
    }

    Brand toDomain(BrandDao brandDao);
}
