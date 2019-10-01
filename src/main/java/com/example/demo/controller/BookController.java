package com.example.demo.controller;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/books/add")
    public String addBook(Model model) {
        model.addAttribute("book", new Book());
        return "book-add";
    }

    @PostMapping("authos/save")
    public String saveBook(Book book, Model model) {
        bookService.create(book);

        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "redirect:/books";
    }

    @GetMapping("/books/edit/{dni}")
    public String getBookForUpdate(@PathVariable String dni, Model model) {
        Book currentBook = bookService.findById(dni);
        model.addAttribute("book", currentBook);
        return "book-edit";
    }

    @PostMapping("/books/update/{dni}")
    public String updateBook(@PathVariable String dni, Book book, Model model) {
        bookService.update(book);

        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getBooksList(Model model) {
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "books";
    }

    @GetMapping("/athors/delete/{dni}")
    public String deleteBook(@PathVariable String dni, Model model) {
        Book currentBook = bookService.findById(dni);
        if (currentBook != null) {
            bookService.delete(currentBook);
        }

        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        return "redirect:/books";
    }



}