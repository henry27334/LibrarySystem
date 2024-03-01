package com.librarysystem.library_system_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.library_system_backend.Entity.Book;
import com.librarysystem.library_system_backend.Service.BookService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookContorller {

    private BookService bookService;

    @Autowired
    public BookContorller(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("getBooks")
    public List<Book> getBookList() {
        List<Book> books = bookService.queryBooks();
        return books;
    }
    
}
