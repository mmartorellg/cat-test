package com.cat.test.infrastructure.controller;

import com.cat.test.application.port.input.BrandCommand;
import com.cat.test.infrastructure.controller.mapper.BrandMapperController;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/brand")
@Slf4j
public class BrandController {

    private final BrandCommand brandCommand;
    private final BrandMapperController brandMapperController;

    public BrandController(BrandCommand brandCommand, BrandMapperController brandMapperController) {
        this.brandCommand = brandCommand;
        this.brandMapperController = brandMapperController;
    }

    @GetMapping()
    public ResponseEntity<List<BrandRequest>> getAllBrands() {
        log.info("getAllBrands");
        return ResponseEntity.ok(brandCommand.getAllBrands().stream()
                .map(brandMapperController::toRequest).collect(Collectors.toList()));
    }

    @GetMapping("{id}")
    public ResponseEntity<BrandRequest> getBrand(@PathVariable final Integer id) {
        log.info("getBrand {}", id);
        return ResponseEntity.ok(brandMapperController.toRequest(brandCommand.getBrand(id)));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void saveBrand(@RequestBody BrandRequest brandRequest) {
        log.info("saveBrand {}", brandRequest);
        brandCommand.saveBrand(brandMapperController.toDomain(brandRequest));
    }

    @PutMapping({"{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateBrand(@PathVariable final Integer id, @RequestBody BrandRequest brandRequest) {
        log.info("updateBrand {} {}", id, brandRequest);
        brandCommand.updateBrand(id, brandMapperController.toDomain(brandRequest));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBrand(@PathVariable final Integer id) {
        log.info("deleteBrand {}", id);
        brandCommand.deleteBrand(id);
    }
}
