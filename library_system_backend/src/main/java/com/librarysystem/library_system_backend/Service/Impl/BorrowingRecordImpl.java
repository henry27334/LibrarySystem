package com.librarysystem.library_system_backend.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.librarysystem.library_system_backend.Entity.BorrowingRecord;
import com.librarysystem.library_system_backend.Repository.BorrowingRecordRepository;
import com.librarysystem.library_system_backend.Service.BorrowingRecordService;

import jakarta.transaction.Transactional;

public class BorrowingRecordImpl implements BorrowingRecordService {

    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    public BorrowingRecordImpl(BorrowingRecordRepository borrowingRecordRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
    }

    @Transactional
    @Override
    public int createRecord(BorrowingRecord borrowingRecord) {
        int isSuccess = borrowingRecordRepository.create_record(borrowingRecord.getUserId(), borrowingRecord.getInventoryId(),  borrowingRecord.getBorrowingTime());
        return isSuccess;
    }
    
}
