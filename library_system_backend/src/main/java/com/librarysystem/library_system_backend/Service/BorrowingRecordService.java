package com.librarysystem.library_system_backend.Service;

import com.librarysystem.library_system_backend.Entity.BorrowingRecord;

public interface BorrowingRecordService {
    int createRecord(BorrowingRecord borrowingRecord);

    int updateRecord(BorrowingRecord borrowingRecord);

}
