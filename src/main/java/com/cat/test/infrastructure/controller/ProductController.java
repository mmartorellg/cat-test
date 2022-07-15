package com.cat.test.infrastructure.controller;

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


@RestController
@RequestMapping("/api/product")
@Slf4j
public class ProductController {

    @GetMapping()
    public ResponseEntity<List<ProductRequest>> getAllProducts() {
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<ProductRequest> getProduct(@PathVariable final Long id) {
        return null;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody ProductRequest brandRequest) {
    }

    @PutMapping({"{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProduct(@PathVariable final Integer id, @RequestBody ProductRequest brandRequest) {
        log.info("updateProduct {}", brandRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProduct(@PathVariable final Integer id) {
        log.info("deleteProduct {}", id);
    }
}
