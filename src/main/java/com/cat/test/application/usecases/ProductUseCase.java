package com.cat.test.application.usecases;

import com.cat.test.application.port.input.ProductCommand;
import com.cat.test.application.port.output.ProductRepository;
import com.cat.test.domain.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class ProductUseCase implements ProductCommand {

    private final ProductRepository productRepository;

    public ProductUseCase(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProduct(Integer id) {
        Product result = productRepository.getProduct(id);
        if (result == null)
            throw new NoSuchElementException();
        return result;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.saveProduct(product);
    }

    @Override
    public void updateProduct(Integer id, Product product) {
        if (!id.equals(product.getId()))
            throw new NoSuchElementException();
        getProduct(id);
        productRepository.updateProduct(product);
    }

    @Override
    public void deleteProduct(Integer id) {
        getProduct(id);
        productRepository.deleteProduct(id);
    }
}
