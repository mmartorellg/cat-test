package com.cat.test.infrastructure.controller;

import com.cat.test.application.port.input.ProductCommand;
import com.cat.test.infrastructure.controller.mapper.ProductMapperController;
import com.cat.test.infrastructure.controller.model.ProductRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    private final ProductCommand productCommand;
    private final ProductMapperController productMapperController;

    public ProductController(ProductCommand productCommand, ProductMapperController productMapperController) {
        this.productCommand = productCommand;
        this.productMapperController = productMapperController;
    }

    @GetMapping()
    public ResponseEntity<List<ProductRequest>> getAllProducts() {
        log.info("getAllProducts");
        return ResponseEntity.ok(productCommand.getAllProducts().stream()
                .map(productMapperController::toRequest).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductRequest> getProduct(@PathVariable final Integer id) {
        log.info("getProduct {}", id);
        return ResponseEntity.ok(productMapperController.toRequest(productCommand.getProduct(id)));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody ProductRequest productRequest) {
        log.info("saveProduct {}", productRequest);
        productCommand.saveProduct(productMapperController.toDomain(productRequest));
    }

    @PutMapping({"{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable final Integer id, @RequestBody ProductRequest productRequest) {
        log.info("updateProduct {} {}", id, productRequest);
        productCommand.updateProduct(id, productMapperController.toDomain(productRequest));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable final Integer id) {
        log.info("deleteProduct {}", id);
        productCommand.deleteProduct(id);
    }
}
