package com.exchange.mapper;

import com.exchange.domain.Cantor;
import com.exchange.domain.CantorDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Lenovo on 03.02.2018.
 */
@Component
public class CantorMapper {

    public Cantor mapToCantor(CantorDto cantorDto){
        return new Cantor(
                cantorDto.getId(),
                cantorDto.getDateOfActualization(),
                cantorDto.getPortfolio()
        );
    }

    public CantorDto mapToCantorDto(Cantor cantor){
        return new CantorDto(
                cantor.getId(),
                cantor.getDateOfActualization(),
                cantor.getPortfolio()
        );
    }

    public List<CantorDto> mapToDtoList(List <Cantor> list){
        return list.stream()
                .map(cantor -> new CantorDto(
                        cantor.getId(),
                        cantor.getDateOfActualization(),
                        cantor.getPortfolio()))
                .collect(Collectors.toList());
    }
}
