package com.cat.test.application.usecases;

import com.cat.test.application.port.input.BrandCommand;
import com.cat.test.application.port.output.BrandRepository;
import com.cat.test.domain.Brand;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class BrandUseCase implements BrandCommand {

    private final BrandRepository brandRepository;

    public BrandUseCase(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public List<Brand> getAllBrands() {
        return brandRepository.getAllBrands();
    }

    @Override
    public Brand getBrand(Integer id) {
        Brand result = brandRepository.getBrand(id);
        if (result == null)
            throw new NoSuchElementException();
        return result;
    }

    @Override
    public void saveBrand(Brand brand) {
        brandRepository.saveBrand(brand);
    }

    @Override
    public void updateBrand(Integer id, Brand brand) {
        if (!id.equals(brand.getId()))
            throw new NoSuchElementException();
        getBrand(id);
        brandRepository.updateBrand(brand);
    }

    @Override
    public void deleteBrand(Integer id) {
        getBrand(id);
        brandRepository.deleteBrand(id);
    }
}
