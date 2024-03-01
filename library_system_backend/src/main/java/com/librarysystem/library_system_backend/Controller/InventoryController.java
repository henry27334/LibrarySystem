package com.librarysystem.library_system_backend.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.library_system_backend.Entity.Inventory;
import com.librarysystem.library_system_backend.Service.BookService;
import com.librarysystem.library_system_backend.Service.InventoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryController {
    
    private InventoryService inventoryService;

    @Autowired
    public InventoryController (InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping("/getInventories")
    public List<Inventory> getInventories() {
        List<Inventory> inventories = inventoryService.queryInventories();
        return inventories;
    }
    
}
