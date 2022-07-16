package com.cat.test.application.port.output;

import com.cat.test.domain.Brand;

import java.util.List;

public interface BrandRepository {
    List<Brand> getAllBrands();

    Brand getBrand(Integer id);

    Integer saveBrand(Brand product);

    Boolean updateBrand(Brand product);

    Boolean deleteBrand(Integer id);
}

