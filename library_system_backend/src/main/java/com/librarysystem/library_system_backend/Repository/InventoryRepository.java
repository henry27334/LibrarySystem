package com.librarysystem.library_system_backend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import com.librarysystem.library_system_backend.Entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer>{
    
    @Procedure(procedureName = "QUERY_ALL_INVENTORIES")
    List<Inventory> query_inventories();

    @Procedure(procedureName = "UPDATE_BOOK_STATUS")
    int update_book_status(int inventory_id, int book_status);

}