package com.cat.test.infrastructure.db.mapper;

import com.cat.test.domain.Brand;
import com.cat.test.infrastructure.db.model.BrandDao;
import org.mapstruct.Mapper;

import java.util.HashMap;

@Mapper(componentModel = "spring")
public interface BrandMapper {

    HashMap<String, Object> toMap(Brand brand);

    Brand toDomain(BrandDao brandDao);
}
