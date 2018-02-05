package com.exchange.repository;

import com.exchange.domain.Cantor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lenovo on 03.02.2018.
 */
@Repository
public interface CantorRepository extends CrudRepository<Cantor, Long> {

    @Override
    Cantor save (Cantor cantor);

}
