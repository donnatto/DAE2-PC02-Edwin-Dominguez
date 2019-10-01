package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {
    private String dni;
    private String firstName;
    private String lastNameFather;
    private String lastNameMother;
    private int age;
    private String biography;
}
