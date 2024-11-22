package com.Erkena.Controllers;

import com.Erkena.DTO.UserDto;
import com.Erkena.Entities.Users;
import com.Erkena.Interfaces.IUsersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")

public class UsersController {

    private final IUsersService usersService;

    @GetMapping("/all-users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return ResponseEntity.ok(usersService.getUsers());
    }

    @PostMapping("/add-user")
    public ResponseEntity<Users> addUser(@RequestBody Users payload) {

        return new ResponseEntity<>(usersService.addUser(payload), HttpStatus.CREATED);
    }

    @PatchMapping("/upadate-user")
    public ResponseEntity<UserDto> updateUser(@RequestBody @Valid UserDto payload) {
        return ResponseEntity.ok(usersService.updatedUser(payload));
    }

    @GetMapping("/get-user/{userId}")
    public ResponseEntity<UserDto> findUserByID(@PathVariable("userId") int param) {
        usersService.findUserById(param);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userId") int param) {
        usersService.deleteUser(param);
        return ResponseEntity.ok().build();
    }

}
