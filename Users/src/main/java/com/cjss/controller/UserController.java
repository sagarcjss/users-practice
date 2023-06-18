package com.cjss.controller;

import com.cjss.annotations.EmailValidator;
import com.cjss.entity.Users;
import com.cjss.model.UsersModel;
import com.cjss.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    private UserService userService;

    //To create User in Database........
    @PostMapping("user-save")
    public ResponseEntity<Users> saveUser(@RequestBody @Valid UsersModel usersModel){
        Users users = userService.saveUser(usersModel);
        return new ResponseEntity<>(users, HttpStatus.CREATED);
    }

    //To get User by id provided by client which throws UserNotFoundException
    @GetMapping("get/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Long id){
        Users users = userService.getUserById(id);
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        String message = userService.deleteUserById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @GetMapping("get-user/{email}")
    public ResponseEntity<Users> getUserByEmail(@PathVariable String email){
        Users users = userService.getUserByEmail(email);
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }

    @GetMapping("get-user-email/{email}/{mobileNum}")
    public ResponseEntity<Users> getUserByEmailAndMobileNum(@PathVariable String email, @PathVariable String mobileNum){
        Users users = userService.getUserByEmailAndMobileNum(email, mobileNum);
        return new ResponseEntity<>(users, HttpStatus.FOUND);
    }


    @GetMapping("get-user-email-city/{email}/{city}")
    public ResponseEntity<List<Users>> getUserByEmailAndCity(@PathVariable("email") String email, @PathVariable("city") String city){
        List<Users> users = userService.getUserByEmailAndCity(email, city);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("update-user-by-id/{id}")
    public ResponseEntity<Users> updateUserById(@PathVariable Long id, @RequestBody @Valid UsersModel usersModel){
        Users users = userService.updateUserById(id, usersModel);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PatchMapping("update-user-name-email")
    public void updateUserNameAndEmailById(@RequestParam Long userId, @RequestParam @Valid @NotBlank(message = "Provide Valid Name")
    @Size(min = 2, max = 20 ,message = "Name length should be in 2 to 20 characters") String userName, @RequestParam @Valid @EmailValidator() String email){
        userService.updateNameAndEmailById(userId, userName, email);
    }
}
