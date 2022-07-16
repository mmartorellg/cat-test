package com.cat.test.application.port.input;

import com.cat.test.domain.Brand;
import com.cat.test.infrastructure.controller.model.BrandRequest;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface BrandCommand {
    List<Brand> getAllBrands();
    Brand getBrand(Integer id);
    void saveBrand(Brand brand);
    void updateBrand(Integer id, Brand brand);
    void deleteBrand(Integer id);
}

