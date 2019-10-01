package com.example.demo.controller;

import com.example.demo.model.Author;
import com.example.demo.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @GetMapping("/authors/add")
    public String addAuthor(Model model) {
        model.addAttribute("author", new Author());
        return "author-add";
    }

    @PostMapping("authos/save")
    public String saveAuthor(Author author, Model model) {
        authorService.create(author);

        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "redirect:/authors";
    }

    @GetMapping("/authors/edit/{dni}")
    public String getAuthorForUpdate(@PathVariable String dni, Model model) {
        Author currentAuthor = authorService.findById(dni);
        model.addAttribute("author", currentAuthor);
        return "author-edit";
    }

    @PostMapping("/authors/update/{dni}")
    public String updateAuthor(@PathVariable String dni, Author author, Model model) {
        authorService.update(author);

        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "redirect:/authors";
    }

    @GetMapping("/authors")
    public String getAuthorsList(Model model) {
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @GetMapping("/athors/delete/{dni}")
    public String deleteAuthor(@PathVariable String dni, Model model) {
        Author currentAuthor = authorService.findById(dni);
        if (currentAuthor != null) {
            authorService.delete(currentAuthor);
        }

        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "redirect:/authors";
    }

}
