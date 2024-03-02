package com.librarysystem.library_system_backend.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.librarysystem.library_system_backend.Entity.BorrowingRecord;
import com.librarysystem.library_system_backend.Service.BorrowingRecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/borrowingrecord")
@CrossOrigin
public class BorrowingRecordController {

    private BorrowingRecordService borrowingRecordService;

    @Autowired
    public BorrowingRecordController(BorrowingRecordService borrowingRecordService) {
        this.borrowingRecordService = borrowingRecordService;
    }

    @PostMapping("/createrecord")
    public int createRecord(@RequestBody BorrowingRecord borrowingRecord) {
        int isSuccess = borrowingRecordService.createRecord(borrowingRecord); 
        return isSuccess;
    }

    @PostMapping("/updaterecord")
    public int updateRecord(@RequestBody BorrowingRecord borrowingRecord) {
        int isSuccess = borrowingRecordService.updateRecord(borrowingRecord); 
        return isSuccess;
    }
    
}
