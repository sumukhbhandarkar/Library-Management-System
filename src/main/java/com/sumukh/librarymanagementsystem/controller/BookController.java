package com.sumukh.librarymanagementsystem.controller;

import com.sumukh.librarymanagementsystem.entity.BookEntity;
import com.sumukh.librarymanagementsystem.entity.IssuerEntity;
import com.sumukh.librarymanagementsystem.repo.BookRepo;
import com.sumukh.librarymanagementsystem.repo.IssuerRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private IssuerRepo issuerRepo;

    private static final String[] EMPTY_ARRAY = new String[0];

    @PostMapping("/issueBooks")
    public void issueBooks(BookEntity bookEntity, IssuerEntity issuerEntity) {
        String bookID = bookEntity.getBookID();
        String issuerName = issuerEntity.getIssuerName();
        issuerEntity.setBookID(bookEntity.getBookID());
        issuerRepo.save(issuerEntity);
        bookEntity.setBookState("Issued");
        bookRepo.save(bookEntity);
        log.info("Book with id " + bookID + " is issued to " + issuerName);
    }

    @GetMapping("/get")
    public Iterable<BookEntity> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/search/{keyword}")
    public Optional<BookEntity> searchBooks(String title, String author, String publisher, String isbn) {
        return bookRepo.findById(isbn);
    }

    @PostMapping("/updateBook")
    public void updateBookLocation(String bookID, String newLocation) {
        BookEntity book = (BookEntity) bookRepo.findAllById(Collections.singleton(bookID));
        book.setBookGenre(newLocation);
        bookRepo.save(book);
        log.info("Book location / genre updated");
    }

    @PostMapping("/returnBooks")
    public void returnBooks(IssuerEntity issuerEntity) {
        String bookID = issuerEntity.getBookID();
        issuerEntity.setBookID("NA");
        issuerRepo.save(issuerEntity);
        Optional<BookEntity> entity = bookRepo.findById(bookID);
        log.info("Book with id " + bookID + " is returned");
    }

    @GetMapping("/history/{id}")
    public Iterable<BookEntity> getBookHistory(String bookID) {
        return bookRepo.findAllById(Collections.singleton(bookID));
    }

    @PostMapping("/addbook")
    public void addBooks(@RequestBody List<BookEntity> books) {
        bookRepo.saveAll(books);
    }
}
