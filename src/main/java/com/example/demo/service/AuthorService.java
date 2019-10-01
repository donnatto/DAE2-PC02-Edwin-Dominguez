package com.example.demo.service;

import com.example.demo.model.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AuthorService implements GenericService<Author, String> {
    List<Author> authors = new ArrayList<>(
            Arrays.asList(
                    new Author("47585213", "Luis", "Manzanero", "Perales", 32, "Nacido en Arequipa"),
                    new Author("63246853", "Maria", "Mercedes", "Miranda", 28, "Nacida en Marte")
            )
    );

    @Override
    public List getAll() {
        return authors;
    }

    @Override
    public void create(Author author) {
        authors.add(author);
    }

    @Override
    public void update(Author author) {
        Author currentAuthor = findById(author.getDni());
        if (currentAuthor != null) {
            int index = authors.indexOf(currentAuthor);
            author.setDni(currentAuthor.getDni());
            authors.set(index, author);
        }
    }

    @Override
    public void delete(Author author) {
        authors.remove(author);
    }

    @Override
    public Author findById(String dni) {
        Author author = authors.stream()
                .filter(a -> a.getDni() == dni).findFirst().orElse(null);
        return author;

    }

}
