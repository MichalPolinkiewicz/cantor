package com.exchange.repository;

import com.exchange.domain.user.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Lenovo on 04.02.2018.
 */
@Repository
public interface UserRoleRepository extends CrudRepository<UserRole, Long> {

    UserRole save (UserRole userRole);
}
