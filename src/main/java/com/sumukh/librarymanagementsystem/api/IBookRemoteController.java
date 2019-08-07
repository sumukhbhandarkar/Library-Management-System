package com.sumukh.librarymanagementsystem.api;

import com.sumukh.librarymanagementsystem.entity.BookEntity;
import com.sumukh.librarymanagementsystem.entity.IssuerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

public interface IBookRemoteController {
    String BOOK_ISSUE = "/books/{id}/issue";
    String BOOK_GET_ALL = "/books/";
    String BOOK_SEARCH = "/books/search";
    String BOOKS_LOCATION_UPDATE = "/books/{id}/location";
    String BOOK_RETURNED = "/books/{id}/return";
    String BOOK_HISTORY = "/books/{id}/issue-history";
    String ADD_BOOKS = "/addbook";

    @PostMapping(value = BOOK_ISSUE)
    void issueBooks(@RequestBody BookEntity bookEntity, HttpSession session);

    @ResponseStatus(HttpStatus.OK)
    Iterable<BookEntity> getAllBooks();

    @GetMapping(value = BOOK_SEARCH)
    Optional<BookEntity> searchBooks(@RequestParam(value = "title", required = false) String title,
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
