package com.librarysystem.library_system_backend.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.library_system_backend.Entity.Book;
import com.librarysystem.library_system_backend.Entity.Inventory;
import com.librarysystem.library_system_backend.Entity.User;
import com.librarysystem.library_system_backend.Service.BookService;
import com.librarysystem.library_system_backend.Service.InventoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/booklist")
@CrossOrigin
public class BookListController {
    
    private BookService bookService;
    private InventoryService inventoryService;

    enum BookStatus
    {
        在庫, 出借中, 整理中, 遺失, 損毀, 廢棄
    }
     

    @Autowired
    public BookListController(BookService bookService, InventoryService inventoryService) {
        this.bookService = bookService;
        this.inventoryService = inventoryService;
    }

    @GetMapping("/getBookDetail")
    public List<Map<String, String>> getBookDetail() {
        List<Book> books = bookService.queryBooks();
        List<Inventory> inventories = inventoryService.queryInventories();

        List<Map<String, String>> bookList = new ArrayList<>();
        for(int i=0; i < books.size(); i++){
            Book newBook = books.get(i);
            Inventory newInventory = inventories.get(i);
            Map<String, String> newBookInfo = new HashMap<>();
            newBookInfo.put("isbn", newBook.getIsbn());
            newBookInfo.put("name", newBook.getName());
            newBookInfo.put("author", newBook.getAuthor());
            newBookInfo.put("introduction", newBook.getIntroduction());
            newBookInfo.put("inventory_id", newInventory.getInventory_id().toString());
            newBookInfo.put("status", BookStatus.values()[newInventory.getStatus()].toString());
            bookList.add(newBookInfo);
        }

        return bookList;
    }

    

}
