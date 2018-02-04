package com.exchange.repository;

import com.exchange.domain.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Lenovo on 03.02.2018.
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    @Override
    User save (User user);
    Optional<User> findUserById(Long id);
    Optional<User> findUserByName(String name);
    Optional<User> findUserBySurname(String surname);
    Optional<User> findUserByLogin(String login);
}
