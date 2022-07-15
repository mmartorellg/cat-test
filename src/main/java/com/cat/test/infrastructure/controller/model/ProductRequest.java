package com.cat.test.infrastructure.controller.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class ProductRequest {
    Integer id;
    String product;
}
