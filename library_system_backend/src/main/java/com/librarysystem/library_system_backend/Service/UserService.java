package com.librarysystem.library_system_backend.Service;

import com.librarysystem.library_system_backend.Entity.User;

public interface UserService {

    int queryPhoneNumber (User user);

    void create(User user);

    int login(User user);
    
    void updateLastLoginTime(User customer);

}
