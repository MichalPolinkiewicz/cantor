package com.exchange.mapper;

import com.exchange.domain.Currency;
import com.exchange.domain.CurrencyDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Lenovo on 03.02.2018.
 */
@Component
public class CurrencyMapper {

    public Currency mapToCurrency(CurrencyDto currencyDto){
        return new Currency(
                currencyDto.getId(),
                currencyDto.getName(),
                currencyDto.getCode(),
                currencyDto.getUnit(),
                currencyDto.getPurchasePrice(),
                currencyDto.getSellPrice(),
                currencyDto.getAveragePrice(),
                currencyDto.getAveragePrices()
        );
    }

    public CurrencyDto mapToCurrencyDto(Currency currency){
        return new CurrencyDto(
                currency.getId(),
                currency.getName(),
                currency.getCode(),
                currency.getUnit(),
                currency.getPurchasePrice(),
                currency.getSellPrice(),
                currency.getAveragePrice(),
                currency.getAveragePrices()
        );
    }

    public List<CurrencyDto> mapToDtoList(List<Currency> list){
        return list.stream()
                .map(currency -> new CurrencyDto(
                        currency.getId(),
                        currency.getName(),
                        currency.getCode(),
                        currency.getUnit(),
                        currency.getPurchasePrice(),
                        currency.getSellPrice(),
                        currency.getAveragePrice(),
                        currency.getAveragePrices()
                ))
                .collect(Collectors.toList());
    }
}
