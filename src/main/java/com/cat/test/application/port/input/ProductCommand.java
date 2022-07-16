package com.cat.test.application.port.input;

import com.cat.test.domain.Product;
import com.cat.test.infrastructure.controller.model.ProductRequest;

import java.util.List;

public interface ProductCommand {
    List<Product> getAllProducts();
    Product getProduct(Integer id);
    void saveProduct(Product product);
    void updateProduct(Integer id, Product product);
    void deleteProduct(Integer id);
}

