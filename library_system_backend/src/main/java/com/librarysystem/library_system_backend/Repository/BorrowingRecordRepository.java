package com.librarysystem.library_system_backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;

import com.librarysystem.library_system_backend.Entity.BorrowingRecord;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Integer> {
    
    @Procedure(procedureName = "CREATE_BORROWING_RECORD")
    int create_record(int user_id, int inventory_id, String borrowing_time);

    @Procedure(procedureName = "UPDATE_BORROWING_RECORD")
    int update_record(int user_id, int inventory_id, String return_time);
}