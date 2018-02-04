package com.exchange.repository;

import com.exchange.domain.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lenovo on 04.02.2018.
 */
@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Long> {

    Transaction save(Transaction transaction);
}
