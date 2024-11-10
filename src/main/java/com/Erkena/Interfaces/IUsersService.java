package com.Erkena.Interfaces;

import com.Erkena.Entities.Users;

import java.util.List;

public interface IUsersService {
    Users addUser(Users user);

    void deleteUser(int idUser);

    Users updateUser(Users user);

    List<Users> getUsers();

    Users findUserById(int idUser);

}
