package com.Erkena.Interfaces;

import com.Erkena.DTO.UserDto;
import com.Erkena.Entities.Users;

import java.util.List;

public interface IUsersService {
    Users addUser(Users user);

    void deleteUser(int idUser);

    UserDto updatedUser(UserDto user);

    List<UserDto> getUsers();

    UserDto findUserById(int idUser);

}
