package com.librarysystem.library_system_backend.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarysystem.library_system_backend.Entity.BorrowingRecord;
import com.librarysystem.library_system_backend.Repository.BorrowingRecordRepository;
import com.librarysystem.library_system_backend.Service.BorrowingRecordService;

import jakarta.transaction.Transactional;

@Service
public class BorrowingRecordImpl implements BorrowingRecordService {

    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    public BorrowingRecordImpl(BorrowingRecordRepository borrowingRecordRepository) {
        this.borrowingRecordRepository = borrowingRecordRepository;
    }

    @Transactional
    @Override
    public int createRecord(BorrowingRecord borrowingRecord) {
        int isSuccess = borrowingRecordRepository.create_record(borrowingRecord.getUser_id(), borrowingRecord.getInventory_id(),  borrowingRecord.getBorrowing_time());
        return isSuccess;
    }

    @Transactional
    @Override
    public int updateRecord(BorrowingRecord borrowingRecord) {
        int isSuccess = borrowingRecordRepository.update_record(borrowingRecord.getUser_id(), borrowingRecord.getInventory_id(),  borrowingRecord.getReturn_time());
        return isSuccess;
    }
    
}
