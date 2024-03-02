package com.librarysystem.library_system_backend.Service;

import java.util.List;

import com.librarysystem.library_system_backend.Entity.User;

public interface UserService {
    void create(User user);

    int query(User user);
    
    void updateLastLoginTime(User customer);

}
