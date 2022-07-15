package com.cat.test.infrastructure.controller.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class BrandRequest {
    Integer id;
    String brand;
}
