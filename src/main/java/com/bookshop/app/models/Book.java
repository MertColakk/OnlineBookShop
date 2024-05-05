package com.bookshop.app.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    public Book(String name, int pageCount, String author, String publisher, double price, String genre) {
        this.name = name;
        this.pageCount = pageCount;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.genre = genre;
    }

    private int pageCount;
    private String author,publisher;
    private double price;
    private String genre;
}
