package com.librarysystem.library_system_backend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.library_system_backend.Entity.User;
import com.librarysystem.library_system_backend.Service.UserService;

import lombok.val;

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

    @PostMapping(value = "/createUser")
    public ResponseEntity<?> create(@RequestBody User user) {
        userService.create(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
    @PostMapping(value = "/login")
    public int query(@RequestBody User user) {
        int userId = userService.query(user);
        return userId;
    }
}
