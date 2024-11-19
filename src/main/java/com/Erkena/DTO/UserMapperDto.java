package com.Erkena.DTO;

import com.Erkena.Entities.Users;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapperDto {
    UserDto toDTO(Users user);
    Users toEntity(UserDto userDto);
    List<UserDto> toDTO(List<Users> users);
}
