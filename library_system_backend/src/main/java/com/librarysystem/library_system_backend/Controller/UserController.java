package com.librarysystem.library_system_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.library_system_backend.Entity.User;
import com.librarysystem.library_system_backend.Service.UserService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/queryphonenumber")
    public int queryPhoneNumber(@RequestBody User user) {
        int isExist = userService.queryPhoneNumber(user);
        return isExist;
    }

    @PostMapping(value = "/createuser")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PostMapping(value = "/login")
    public int login(@RequestBody User user) {
        int userId = userService.login(user);
        return userId;
    }

    @PostMapping(value = "/logout")
    public void logout(@RequestBody User user) {
        userService.updateLastLoginTime(user);
    }
}
