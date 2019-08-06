package com.sumukh.librarymanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Getter
@Setter
public class BookEntity {
    private String bookTitle;
    private String bookID;
    private String bookGenre;
    private String bookAuthor;
    private String bookState;
    private String issuerID;
}
