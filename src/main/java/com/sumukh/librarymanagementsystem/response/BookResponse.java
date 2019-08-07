package com.sumukh.librarymanagementsystem.response;

import com.sumukh.librarymanagementsystem.entity.BookEntity;
import lombok.Data;

import java.util.List;

@Data
public class BookResponse {
    long totalHits;
    List<BookEntity> bookEntityList;
}
