package com.cat.test.application.port.output;

import com.cat.test.domain.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();

    Product getProduct(Integer id);

    Integer saveProduct(Product product);

    Boolean updateProduct(Product product);

    Boolean deleteProduct(Integer id);
}

