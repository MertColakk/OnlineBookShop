package com.bookshop.app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor @NoArgsConstructor
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> myBooks=new ArrayList<>();
    private Double totalCost=0.0;

    public void addBook(Book book) {
        myBooks.add(book);
        this.totalCost += book.getPrice();
    }

    public void removeBook(Book book) {
        myBooks.remove(book);
        this.totalCost -= book.getPrice();
    }

    public List<Book> getBooks() {
        return myBooks;
    }
}
