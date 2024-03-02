package com.librarysystem.library_system_backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.librarysystem.library_system_backend.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, String>{

    @Procedure(procedureName = "QUERY_ALL_BOOKS")
    List<Book> query_books();
    
}
