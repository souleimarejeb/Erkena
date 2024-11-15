package com.Erkena.Services;

import com.Erkena.DTO.UserDto;
import com.Erkena.Entities.Users;
import com.Erkena.Exceptions.NotFoundException;
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
    public Users updateUser(UserDto payload) {
        Users foundUser = usersRepository.findUsersByUsername(payload.getUsername());
        System.out.println(foundUser.getUsername());
        foundUser.setEmail(payload.getEmail());
        foundUser.setPassword(payload.getPassword());
        foundUser.setUpdateAt(payload.getUpdateAt());
        return usersRepository.save(foundUser);
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
