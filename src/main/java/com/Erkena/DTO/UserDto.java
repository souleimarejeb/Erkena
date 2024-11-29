package com.Erkena.DTO;

import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.mapstruct.Mapper;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDto {

    @NotNull(message ="Username cannot be null ")
    @Size(min = 3, message = "Username must have at least 3 characters")
    String username;

    @NotNull(message ="Username cannot be null ")
    @Email(message = "Invalid email format")
    String email;

    String password;

    LocalDate updateAt;

    @PreUpdate
    void beforeUpdate() {
        updateAt = LocalDate.now();
    }



}
