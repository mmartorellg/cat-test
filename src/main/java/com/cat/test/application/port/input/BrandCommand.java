package com.cat.test.application.port.input;

import com.cat.test.domain.Brand;
import com.cat.test.infrastructure.controller.model.BrandRequest;

import java.util.List;

public interface BrandCommand {
    List<Brand> getAllBrands();
    Brand getBrand(Integer id);
    void saveBrand(Brand product);
    void updateBrand(Integer id, Brand product);
    void deleteBrand(Integer id);
}

