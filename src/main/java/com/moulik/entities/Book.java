package com.moulik.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Parameters;

import javax.persistence.Entity;
import java.util.List;

@Entity
public class Book extends PanacheEntity {

    private String name;
    private String author;
    private Long isbn;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public static List<Book> getBooksByName(String name) {
        return Book.find("name", name).list();
    }

    public static List<Book> getBooksByNameAndAuthor(String name, String author) {
        return Book.find("name = :bookName and author = :authorName",
                    Parameters.with("bookName", name).and("authorName", author).map()
                ).list();
    }
}
