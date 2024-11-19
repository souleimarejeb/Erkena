package com.Erkena.Services;

import com.Erkena.DTO.UserDto;
import com.Erkena.DTO.UserMapperDto;
import com.Erkena.Entities.Users;
import com.Erkena.Exceptions.NotFoundException;
import com.Erkena.Interfaces.IUsersService;
import com.Erkena.Repositories.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsersServiceImplementation implements IUsersService {

    private final UsersRepository usersRepository;
    private final UserMapperDto userMapperDto;
    @Override
    public Users addUser(Users user) {
        return usersRepository.save(user);
    }

    @Override
    public void deleteUser(int idUser) {
        usersRepository.deleteById(idUser);
    }

    @Override
    public UserDto updatedUser(UserDto payload) {
        Users updatedEntity = userMapperDto.toEntity(payload);
        Users savedPost = usersRepository.save(updatedEntity);
        return userMapperDto.toDTO(savedPost);
    }
    @Override
    public List<UserDto> getUsers() {
        List<Users> users = usersRepository.findAll();
        return userMapperDto.toDTO(users);
    }
    @Override
    public UserDto findUserById(int idUser) {
        if(usersRepository.findById(idUser).isEmpty()){
            throw  new NotFoundException("Requested User Not Found ");
        }
        Optional<Users> user =usersRepository.findById(idUser);
        return userMapperDto.toDTO(user.get());
    }
}
