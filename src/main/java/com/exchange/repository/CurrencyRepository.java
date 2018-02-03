package com.exchange.repository;

import com.exchange.domain.Currency;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Lenovo on 03.02.2018.
 */
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

    @Override
    Currency save (Currency currency);

    Optional<Currency> findCurrencyById(Long id);
}
