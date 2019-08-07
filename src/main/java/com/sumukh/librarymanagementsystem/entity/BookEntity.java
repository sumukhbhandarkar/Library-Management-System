package com.sumukh.librarymanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@Document(indexName = "test", type = "_doc", shards = 3)
public class BookEntity {
    private String bookTitle;
    @Id
    private String bookID;
    private String bookGenre;
    private String bookAuthor;
    private String bookState;
    private String issuerID;
}
