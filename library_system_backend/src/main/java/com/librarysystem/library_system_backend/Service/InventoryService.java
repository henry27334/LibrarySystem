package com.librarysystem.library_system_backend.Service;

import java.util.List;

import com.librarysystem.library_system_backend.Entity.Inventory;

public interface InventoryService {
    List<Inventory> queryInventories();
}
