package com.librarysystem.library_system_backend.Service;

import java.util.List;

import com.librarysystem.library_system_backend.Entity.Book;

public interface BookService {
    List<Book> queryBooks();

}
