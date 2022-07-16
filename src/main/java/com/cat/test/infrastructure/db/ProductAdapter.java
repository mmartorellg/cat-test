package com.cat.test.infrastructure.db;

import com.cat.test.application.port.output.ProductRepository;
import com.cat.test.domain.Product;
import com.cat.test.infrastructure.db.generic.GenericAdapter;
import com.cat.test.infrastructure.db.mapper.ProductMapperDB;
import com.cat.test.infrastructure.db.model.ProductDao;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ProductAdapter implements ProductRepository {

    private final GenericAdapter genericAdapter;
    private final ProductMapperDB productMapperDB;
    private final String ALL = "SELECT id, product FROM product";
    private final String ONE_BY_ID = "SELECT id, product FROM product WHERE id = :id";
    private final String INSERT = "INSERT INTO product (id, product) values (:id, :product)";
    private final String UPDATE = "UPDATE product SET id = :id, product = :product WHERE id = :id";
    private final String DELETE = "DELETE FROM product WHERE id = :id";

    public ProductAdapter(GenericAdapter genericAdapter, ProductMapperDB productMapperDB) {
        this.genericAdapter = genericAdapter;
        this.productMapperDB = productMapperDB;
    }

    @Override
    public List<Product> getAllProducts() {
        return genericAdapter.getAll(ALL, ProductDao.class).stream().map(productMapperDB::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Product getProduct(Integer id) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("id", id);
        return productMapperDB.toDomain(genericAdapter.getOne(ONE_BY_ID, params, ProductDao.class).orElse(null));
    }

    @Override
    public Integer saveProduct(Product product) {
        Map<String, Object> addressMap = productMapperDB.toMap(product);
        MapSqlParameterSource parameters = new MapSqlParameterSource(addressMap);
        return this.genericAdapter.save(INSERT, parameters);
    }

    @Override
    public Boolean updateProduct(Product product) {
        Map<String, Object> addressMap = productMapperDB.toMap(product);
        MapSqlParameterSource parameters = new MapSqlParameterSource(addressMap);
        return !this.genericAdapter.update(UPDATE, parameters).equals(0);
    }

    @Override
    public Boolean deleteProduct(Integer id) {
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("id", id);
        return this.genericAdapter.delete(DELETE, parameters);
    }
}
