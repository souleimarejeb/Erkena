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
    public List<Users> getUsers(){
        return   usersService.getUsers();
    }

    @PostMapping("/add-user")
    public ResponseEntity<Users> addUser(@RequestBody Users payload)
    {
        Users newUser= usersService.addUser(payload);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    @PatchMapping("/upadate-user")
    public ResponseEntity<Users> updateUser(@RequestBody UserDto payload)
    {
        Users updatedUser= usersService.updateUser(payload);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    @GetMapping("/get-user/{userId}")
    public  Users findUserByID(@PathVariable("userId") int param){
         return usersService.findUserById(param);
    }

    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<Void>  deleteUser(@PathVariable("userId") int param){
        usersService.deleteUser(param);
        return ResponseEntity.ok().build();
    }

}
