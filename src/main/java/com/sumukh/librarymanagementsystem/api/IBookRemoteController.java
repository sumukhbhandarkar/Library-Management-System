package com.sumukh.librarymanagementsystem.api;

import com.sumukh.librarymanagementsystem.entity.BookEntity;
import com.sumukh.librarymanagementsystem.entity.IssuerEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface IBookRemoteController {
    String BOOK_ISSUE = "/api/books/{id}/issue";
    String BOOK_GET_ALL = "/api/books/";
    String BOOK_SEARCH = "/api/books/search";
    String BOOKS_LOCATION_UPDATE = "/api/books/{id}/location";
    String BOOK_RETURNED = "/api/books/{id}/return";
    String BOOK_HISTORY = "/api/books/{id}/issue-history";
    String ADD_BOOKS = "/api/addbook";

    @PostMapping(value = BOOK_ISSUE)
    void issueBooks(@RequestBody BookEntity bookEntity, HttpSession session);

    @GetMapping(value = BOOK_GET_ALL)
    List<BookEntity> getAllBooks();

    @GetMapping(value = BOOK_SEARCH)
    List<BookEntity> searchBooks(@RequestParam(value = "title", required = false) String title,
                                 @RequestParam(value = "author", required = false) String author,
                                 @RequestParam(value = "publisher", required = false) String publisher,
                                 @RequestParam(value = "isbn", required = false) String isbn);

    @PostMapping(value = BOOKS_LOCATION_UPDATE)
    void updateBookLocation(@RequestParam(value = "bookid", required = true) String bookID,
                            @RequestParam(value = "newLocation", required = true) String newLocation);

    @PostMapping(value = BOOK_RETURNED)
    void returnBooks(@RequestBody BookEntity bookEntity, HttpSession session);

    @GetMapping(value = BOOK_HISTORY)
    List<IssuerEntity> getBookHistory(@RequestParam(value = "bookID", required = true) String bookID);

    @PostMapping(value = ADD_BOOKS)
    void addBooks(@RequestBody BookEntity bookEntity, HttpSession session);

}
