package com.librarysystem.library_system_backend.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarysystem.library_system_backend.Entity.User;
import com.librarysystem.library_system_backend.Repository.UserRepository;
import com.librarysystem.library_system_backend.Service.UserService;

import jakarta.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void create(User user) {
        int userId = userRepository.create_user(user.getPhone_number(), user.getPassword(), user.getUsername(), user.getRegistaration_time(), user.getLast_login_time());
        System.out.println("Create sucess: " + userId);
    }

    @Transactional
    @Override
    public int query(User user) {
        int userId = userRepository.query_user(user.getPhone_number(), user.getPassword(), user.getLast_login_time());
        return userId;
    }

    @Transactional
    @Override
    public void updateLastLoginTime(User user) {
        userRepository.update_last_login_time(user.getUser_id(), user.getLast_login_time());
    }

}