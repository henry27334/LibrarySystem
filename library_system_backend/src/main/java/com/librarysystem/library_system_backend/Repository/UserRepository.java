package com.librarysystem.library_system_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.librarysystem.library_system_backend.Entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
    @Procedure(procedureName = "QUERY_PHONE_NUMBER")
    int query_phone_number(String phone_number); 

    @Procedure(procedureName = "CREATE_USER")
    int create_user(String phone_number, String password, String username, String registaration_time, String last_login_time, String salt); 

    @Procedure(procedureName = "QUERY_USER")
    int query_user(String phone_number); 

    @Procedure(procedureName = "QUERY_USER_PASSWORD")
    User query_password(int user_id); 

    @Procedure(procedureName = "UPDATE_LAST_LOGIN_TIME")
    void update_last_login_time(int user_id, String last_login_time); 
}