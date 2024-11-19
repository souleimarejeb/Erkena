package com.Erkena.Controllers;

import com.Erkena.DTO.UserDto;
import com.Erkena.Entities.Users;
import com.Erkena.Interfaces.IUsersService;
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
    public List<UserDto> getUsers(){
        return   usersService.getUsers();
    }

    @PostMapping("/add-user")
    public ResponseEntity<Users> addUser(@RequestBody Users payload)
    {
        Users newUser= usersService.addUser(payload);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @PatchMapping("/upadate-user")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto payload)
    {
        return ResponseEntity.ok(usersService.updatedUser(payload));
    }

    @GetMapping("/get-user/{userId}")
    public  UserDto findUserByID(@PathVariable("userId") int param){
         return usersService.findUserById(param);
    }

    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<Void>  deleteUser(@PathVariable("userId") int param){
        usersService.deleteUser(param);
        return ResponseEntity.ok().build();
    }

}
