package com.cat.test.infrastructure.db;

import com.cat.test.application.port.output.BrandRepository;
import com.cat.test.domain.Brand;
import com.cat.test.infrastructure.db.generic.GenericAdapter;
import com.cat.test.infrastructure.db.mapper.BrandMapper;
import com.cat.test.infrastructure.db.model.BrandDao;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class BrandAdapter implements BrandRepository {

    private final GenericAdapter genericAdapter;
    private final BrandMapper brandMapper;
    private final String ALL = "SELECT id, brand FROM brand";
    private final String ONE_BY_ID = "SELECT id, brand FROM brand WHERE id = :id";
    private final String INSERT = "INSERT INTO brand (id, brand) values (:id, : brand)";
    private final String UPDATE = "UPDATE brand SET id = :id, brand = :brand WHERE id = :id";
    private final String DELETE = "DELETE FROM brand WHERE id = :id";

    public BrandAdapter(GenericAdapter genericAdapter, BrandMapper brandMapper) {
        this.genericAdapter = genericAdapter;
        this.brandMapper = brandMapper;
    }

    @Override
    public List<Brand> getAllBrands() {
        return genericAdapter.getAll(ALL, BrandDao.class).stream().map(brandMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Brand getBrand(Integer id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return brandMapper.toDomain(genericAdapter.getOne(ONE_BY_ID, params, BrandDao.class).orElse(null));
    }

    @Override
    public Integer saveBrand(Brand brand) {
        Map<String, Object> addressMap = brandMapper.toMap(brand);
        MapSqlParameterSource parameters = new MapSqlParameterSource(addressMap);
        return this.genericAdapter.save(INSERT, parameters);
    }

    @Override
    public Boolean updateBrand(Brand brand) {
        Map<String, Object> addressMap = brandMapper.toMap(brand);
        MapSqlParameterSource parameters = new MapSqlParameterSource(addressMap);
        return !this.genericAdapter.update(UPDATE, parameters).equals(0);
    }

    @Override
    public Boolean deleteBrand(Integer id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id);
        return this.genericAdapter.delete(DELETE, parameters);
    }
}
