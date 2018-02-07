package com.exchange.mapper;

import com.exchange.domain.dto.UserDto;
import com.exchange.domain.user.User;
import org.springframework.stereotype.Component;

/**
 * Created by Lenovo on 07.02.2018.
 */
@Component
public class UserMapper {

    public UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getLogin(),
                user.getSaldo());
        return userDto;
    }
}
