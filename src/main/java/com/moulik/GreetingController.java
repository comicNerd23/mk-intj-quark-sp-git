package com.moulik;

import com.moulik.entities.Book;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class GreetingController {

    @GetMapping("/greeting")
    public String hello() {
        return "Hello Spring";
    }

    @PostMapping("/book")
    @Transactional
    public void addBook(Book book) {
        Book.persist(book);
    }

    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return Book.listAll();
    }

    @DeleteMapping("/book/{id}")
    @Transactional
    public void deleteBook(@PathVariable Long id) {
        Book.deleteById(id);
    }

    @GetMapping("/book/{id}")
    public List<Book> getBookById(@PathVariable Long id) {
        return Book.findById(id);
    }

    @GetMapping("/book/name/{bookName}")
    public List<Book> getBooksByName(@PathVariable String bookName) {
        return Book.getBooksByName(bookName);
    }

    @GetMapping("/book/name/{bookName}/{authorName}")
    public List<Book> getBooksByNameAndAuthor(@PathVariable String bookName, @PathVariable String authorName) {
        return Book.getBooksByNameAndAuthor(bookName, authorName);
    }

}
