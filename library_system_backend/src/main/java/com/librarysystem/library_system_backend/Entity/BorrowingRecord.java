package com.librarysystem.library_system_backend.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class BorrowingRecord {
    @Id
    private Integer userId;

    @Id
    private Integer inventoryId;

    @Column
    private String borrowingTime;

    @Column
    private String returnTime;
}
