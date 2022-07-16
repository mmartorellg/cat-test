package com.cat.test.infrastructure.controller.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PriceQueryRequest {
    Integer productId;
    Integer brandId;
    @JsonFormat(pattern = "yyyy-MM-dd-HH.mm.ss")
    Date queryDate;
}
