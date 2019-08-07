package com.sumukh.librarymanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor

public class IssuerEntity {
    @Id
    private String issuerID;
    private String issuerName;
    @Id
    private String bookID;
    private String dateOfIssue;
    private String returnDate;
}
