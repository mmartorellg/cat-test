package com.cat.test.infrastructure.controller;

import com.cat.test.infrastructure.controller.model.PriceQueryRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DisplayName("Test for FeeController")
@SpringBootTest
@AutoConfigureMockMvc
public class FeeControllerTest {

    @Autowired
    private MockMvc mockMvc;
    private final ObjectMapper mapper = new ObjectMapper();
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");

    @DisplayName("Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 (ADIDAS)")
    @Test
    void queryPricesTest1() throws Exception {
        PriceQueryRequest priceQueryRequest = PriceQueryRequest.builder().brandId(1).productId(35455)
                .queryDate(formatter.parse("2020-06-14-10.00.00")).build();
        mockMvc.perform(post("/api/fee")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(priceQueryRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.5f));
    }

    @DisplayName("Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 (ADIDAS)")
    @Test
    void queryPricesTest2() throws Exception {
        PriceQueryRequest priceQueryRequest = PriceQueryRequest.builder().brandId(1).productId(35455)
                .queryDate(formatter.parse("2020-06-14-16.00.00")).build();
        mockMvc.perform(post("/api/fee")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(priceQueryRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(25.45f));
    }

    @DisplayName("Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 (ADIDAS)")
    @Test
    void queryPricesTest3() throws Exception {
        PriceQueryRequest priceQueryRequest = PriceQueryRequest.builder().brandId(1).productId(35455)
                .queryDate(formatter.parse("2020-06-14-21.00.00")).build();
        mockMvc.perform(post("/api/fee")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(priceQueryRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(35.5f));
    }

    @DisplayName("Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 (ADIDAS)")
    @Test
    void queryPricesTest4() throws Exception {
        PriceQueryRequest priceQueryRequest = PriceQueryRequest.builder().brandId(1).productId(35455)
                .queryDate(formatter.parse("2020-06-15-10.00.00")).build();
        mockMvc.perform(post("/api/fee")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(priceQueryRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(30.5f));
    }

    @DisplayName("Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 (ADIDAS)")
    @Test
    void queryPricesTest5() throws Exception {
        PriceQueryRequest priceQueryRequest = PriceQueryRequest.builder().brandId(1).productId(35455)
                .queryDate(formatter.parse("2020-06-16-21.00.00")).build();
        mockMvc.perform(post("/api/fee")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(priceQueryRequest)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(38.95f));
    }
}
