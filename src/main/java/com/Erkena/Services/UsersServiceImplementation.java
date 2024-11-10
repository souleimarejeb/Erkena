package com.Erkena.Services;

import com.Erkena.Entities.Users;
import com.Erkena.Exceptions.NotFoundException;
import com.Erkena.Exceptions.UserExceptions;
import com.Erkena.Interfaces.IUsersService;
import com.Erkena.Repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsersServiceImplementation implements IUsersService {

    UsersRepository usersRepository;
    @Override
    public Users addUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteUser(int idUser) {
        usersRepository.deleteById(idUser);
    }

    @Override
    public Users updateUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public List<Users> getUsers() {

        return usersRepository.findAll();
    }

    @Override
    public Users findUserById(int idUser) {
        if(usersRepository.findById(idUser).isEmpty()){
            throw  new NotFoundException("Requested User Not Found ");
        }
        return usersRepository.findById(idUser).orElse(null);
    }
}
