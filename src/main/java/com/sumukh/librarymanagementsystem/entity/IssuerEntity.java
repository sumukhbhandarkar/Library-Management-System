package com.sumukh.librarymanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class IssuerEntity {
    private String issuerID;
    private String issuerName;
    private String bookID;
    private String dateOfIssue;
    private String returnDate;
}
