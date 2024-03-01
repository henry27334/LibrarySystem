package com.librarysystem.library_system_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.librarysystem.library_system_backend.Entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Procedure(procedureName = "CREATE_USER")
    int create_user(String phone_number, String password, String username, String registaration_time, String last_login_time); 

    @Procedure(procedureName = "QUERY_USER")
    int query_user(String phone_number, String password, String last_login_time); 
}