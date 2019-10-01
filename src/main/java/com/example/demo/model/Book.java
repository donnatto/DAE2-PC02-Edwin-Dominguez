package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
    private String isbn;
    private List<Author> author;
    private String title;
    private String summary;
    private LocalDate publicationDate;
    private int numberOfPages;
    private String language;

    public Book(String isbn, String title, String summary, LocalDate publicationDate, int numberOfPages, String language) {
        this.isbn = isbn;
        this.title = title;
        this.summary = summary;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
        this.language = language;
    }
}
