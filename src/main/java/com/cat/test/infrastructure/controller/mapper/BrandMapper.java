package com.cat.test.infrastructure.controller.mapper;

import com.cat.test.domain.Brand;
import com.cat.test.infrastructure.controller.model.BrandRequest;
import org.mapstruct.Mapper;

@Mapper
public interface BrandMapper {

    BrandRequest toRequest(Brand brand);

    Brand toDomain(BrandRequest brandRequest);
}
