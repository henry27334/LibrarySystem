package com.librarysystem.library_system_backend.Service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarysystem.library_system_backend.Entity.Inventory;
import com.librarysystem.library_system_backend.Repository.InventoryRepository;
import com.librarysystem.library_system_backend.Service.InventoryService;

import jakarta.transaction.Transactional;

@Service
public class InventoryServiceImpl implements InventoryService{

    private InventoryRepository inventoryRepository;

    @Autowired
    public InventoryServiceImpl (InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }
    
    @Transactional
    @Override
    public List<Inventory> queryInventories() {
        List<Inventory> inventories = inventoryRepository.query_inventories();
        return inventories;
    }

    @Transactional
    @Override
    public int updateBookStatus(int inventoryId, int status) {
        int isSuccess = inventoryRepository.update_book_status(inventoryId, status);
        return isSuccess;
    }

    
}
