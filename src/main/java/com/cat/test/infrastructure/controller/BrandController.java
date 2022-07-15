package com.cat.test.infrastructure.controller;

import com.cat.test.infrastructure.controller.model.BrandRequest;
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
@RequestMapping("/api/brand")
@Slf4j
public class BrandController {

    @GetMapping()
    public ResponseEntity<List<BrandRequest>> getAllBrands() {
        return null;
    }

    @GetMapping("{id}")
    public ResponseEntity<BrandRequest> getBrand(@PathVariable final Long id) {
        return null;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBrand(@RequestBody BrandRequest brandRequest) {
    }

    @PutMapping({"{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBrand(@PathVariable final Integer id, @RequestBody BrandRequest brandRequest) {
        log.info("updateBrand {}", brandRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrand(@PathVariable final Integer id) {
        log.info("deleteBrand {}", id);
    }
}
