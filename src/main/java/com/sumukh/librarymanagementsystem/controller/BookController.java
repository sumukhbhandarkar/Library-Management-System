package com.sumukh.librarymanagementsystem.controller;

import com.sumukh.librarymanagementsystem.api.IBookRemoteController;
import com.sumukh.librarymanagementsystem.entity.BookEntity;
import com.sumukh.librarymanagementsystem.entity.IssuerEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
public class BookController implements IBookRemoteController {

    @Override
    public void issueBooks(BookEntity bookEntity, HttpSession session) {

    }

    @Override
    public List<BookEntity> getAllBooks() {
        return null;
    }

    @Override
    public List<BookEntity> searchBooks(String title, String author, String publisher, String isbn) {
        return null;
    }

    @Override
    public void updateBookLocation(String bookID, String newLocation) {

    }

    @Override
    public void returnBooks(BookEntity bookEntity, HttpSession session) {

    }

    @Override
    public List<IssuerEntity> getBookHistory(String bookID) {
        return null;
    }

    @Override
    public void addBooks(BookEntity bookEntity, HttpSession session) {

    }
}
