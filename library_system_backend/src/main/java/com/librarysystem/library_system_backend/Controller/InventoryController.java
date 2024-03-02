package com.librarysystem.library_system_backend.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.library_system_backend.Entity.Inventory;
import com.librarysystem.library_system_backend.Service.InventoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




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
    
    @PostMapping("/rentbook")
    public int updateRentStatus(@RequestBody Inventory inventory) {
        int isSuccess = inventoryService.updateBookStatus(inventory.getInventory_id(), 1);
        return isSuccess;
    }
    
    @PostMapping("/returnbook")
    public int returnbook(@RequestBody Inventory inventory){
        int isSuccess = inventoryService.updateBookStatus(inventory.getInventory_id(), 0);
        return isSuccess;
    }
}
