package com.exchange.mapper;

import com.exchange.domain.Cantor;
import com.exchange.domain.Currency;
import com.exchange.domain.dto.CurrencyDto;
import com.exchange.domain.user.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Lenovo on 06.02.2018.
 */
@Component
public class Mapper {

    public List<CurrencyDto> mapToCurrencyDtoList(Cantor cantor){

        Map<Currency, Double> map = cantor.getPortfolio();
        List<CurrencyDto> currencyDtos = new ArrayList<>();

        for (Map.Entry<Currency, Double> crc : map.entrySet()){
            CurrencyDto currencyDto = new CurrencyDto(
                    crc.getKey().getId(),
                    crc.getKey().getName(),
                    crc.getKey().getCode(),
                    crc.getKey().getUnit(),
                    crc.getKey().getPurchasePrice(),
                    crc.getKey().getSellPrice(),
                    crc.getKey().getAveragePrice(),
                    crc.getValue()
            );
            currencyDtos.add(currencyDto);
        } return currencyDtos;
    }

    public List<CurrencyDto> mapToCurrencyDtoList(User user){

        Map<Currency, Double> map = user.getWallet();
        List<CurrencyDto> currencyDtos = new ArrayList<>();

        for (Map.Entry<Currency, Double> crc : map.entrySet()){
            CurrencyDto currencyDto = new CurrencyDto(
                    crc.getKey().getId(),
                    crc.getKey().getName(),
                    crc.getKey().getCode(),
                    crc.getKey().getUnit(),
                    crc.getKey().getPurchasePrice(),
                    crc.getKey().getSellPrice(),
                    crc.getKey().getAveragePrice(),
                    crc.getValue()
            );
            currencyDtos.add(currencyDto);
        } return currencyDtos;
    }
}

