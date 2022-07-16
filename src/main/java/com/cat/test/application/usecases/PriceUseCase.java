package com.cat.test.application.usecases;

import com.cat.test.application.port.input.PriceCommand;
import com.cat.test.application.port.output.PriceRepository;
import com.cat.test.domain.Price;
import com.cat.test.domain.PriceQuery;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class PriceUseCase implements PriceCommand {

    private final PriceRepository priceRepository;

    public PriceUseCase(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public Price queryPrices(PriceQuery priceQuery) {
        return priceRepository.queryPrices(priceQuery).stream().findFirst().orElseThrow(
                NoSuchElementException::new);
    }
}
