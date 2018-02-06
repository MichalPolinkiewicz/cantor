package com.exchange.repository;

import com.exchange.domain.Cantor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Lenovo on 03.02.2018.
 */
@Repository
public interface CantorRepository extends CrudRepository<Cantor, Long> {

    @Override
    Cantor save (Cantor cantor);
    Optional<Cantor> getCantorById(Long id);
    List<Cantor> findAll();
}
