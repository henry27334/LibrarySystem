package com.librarysystem.library_system_backend.Service.Impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarysystem.library_system_backend.Common.PasswordSecurity;
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
    public int queryPhoneNumber(User user) {
        int isExist = userRepository.query_phone_number(user.getPhone_number());
        return isExist;
    }

    @Transactional
    @Override
    public void create(User user) {
        String salt = PasswordSecurity.addSalt();
        String passwordEncryption = PasswordSecurity.encryptionWithSalt(user.getPassword(), salt);
        user.setPassword(passwordEncryption);
        int userId = userRepository.create_user(user.getPhone_number(), user.getPassword(), user.getUsername(), user.getRegistaration_time(), user.getLast_login_time(), salt);
    }

    @Transactional
    @Override
    public int login(User user) {
        int userId = userRepository.query_user(user.getPhone_number());
        User fetchUser = userRepository.query_password(userId);
        String encryptionFromFront =  PasswordSecurity.encryptionWithSalt(user.getPassword(), fetchUser.getSalt());
        
        if (!fetchUser.getPassword().equals(encryptionFromFront)){
            userId = -1;
        }
    
        return userId;
    }

    @Transactional
    @Override
    public void updateLastLoginTime(User user) {
        userRepository.update_last_login_time(user.getUser_id(), user.getLast_login_time());
    }



}