package com.librarysystem.library_system_backend.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarysystem.library_system_backend.Entity.Book;
import com.librarysystem.library_system_backend.Repository.BookRepository;
import com.librarysystem.library_system_backend.Service.BookService;

import jakarta.transaction.Transactional;

@Service
public class BookServiceImpl implements BookService{
    
    private final BookRepository bookRepository;
    
    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    @Override
    public List<Book> queryBooks() {
        List<Book> allbooks = bookRepository.query_books();
        return allbooks;
    }
    
}
