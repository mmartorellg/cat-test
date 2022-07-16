package com.cat.test.infrastructure.controller;

import com.cat.test.application.port.input.PriceCommand;
import com.cat.test.domain.Price;
import com.cat.test.infrastructure.controller.mapper.PriceQueryMapperController;
import com.cat.test.infrastructure.controller.model.PriceQueryRequest;
import com.cat.test.infrastructure.controller.model.PriceQueryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fee")
@Slf4j
public class PriceController {

    private final PriceCommand priceCommand;
    private final PriceQueryMapperController priceQueryMapperController;

    public PriceController(PriceCommand priceCommand, PriceQueryMapperController priceQueryMapperController) {
        this.priceCommand = priceCommand;
        this.priceQueryMapperController = priceQueryMapperController;
    }

    @PostMapping()
    public ResponseEntity<PriceQueryResponse> queryPrices(@RequestBody PriceQueryRequest priceQueryRequest) {
        log.info("queryPrices {}", priceQueryRequest);
        Price price = priceCommand.queryPrices(priceQueryMapperController.toDomain(priceQueryRequest));
        return ResponseEntity.ok(priceQueryMapperController.toResponse(price));
    }
}
