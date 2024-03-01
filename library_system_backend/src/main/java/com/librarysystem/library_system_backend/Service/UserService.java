package com.librarysystem.library_system_backend.Service;

import java.util.List;

import com.librarysystem.library_system_backend.Entity.User;

public interface UserService {
    void create(User user);

    Boolean query(User user);

    List<User> readAll();

    User read(int id);
    
    boolean update(User customer, int id);

    boolean delete(int id);

}
