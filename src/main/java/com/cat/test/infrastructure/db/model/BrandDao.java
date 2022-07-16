package com.cat.test.infrastructure.db.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class BrandDao {
    Integer id;
    String brand;
}
