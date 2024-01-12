package com.scaler.EcomProductService.demo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.AUTO;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bookName;
    @ManyToOne
    @JoinColumn(name = "author_id")

    public Author author;

    public Book(){}

    public Book(String bookName, Author author)
    {
        this.bookName= bookName;
        this.author = author;
    }
}
