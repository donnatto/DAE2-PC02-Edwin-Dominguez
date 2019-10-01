package com.example.demo.service;

import com.example.demo.model.Author;
import com.example.demo.model.Book;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BookService implements GenericService<Book, String> {

    List<Book> books = new ArrayList<>(
            Arrays.asList(new Book("1234", new ArrayList<Author>() , "Harry Potter","La historia de un mago" , LocalDate.now(), 320, "español")
                    )
    );

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public void create(Book book) {
        books.add(book);
    }

    @Override
    public void update(Book book) {
        Book currentBook = findById(book.getIsbn());
        if (currentBook != null) {
            int index = books.indexOf(currentBook);
            book.setIsbn(currentBook.getIsbn());
            books.set(index, book);
        }
    }

    @Override
    public void delete(Book book) {
        books.remove(book);
    }

    @Override
    public Book findById(String isbn) {
        Book book = books.stream()
                .filter(book1 -> book1.getIsbn() == isbn).findFirst().orElse(null);
        return book;
    }
}
