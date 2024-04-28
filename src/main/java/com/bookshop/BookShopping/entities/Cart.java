package com.bookshop.BookShopping.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> myBooks = new ArrayList<>();

    private double totalCost = 0;

    public boolean addToCart(Book book){
        this.myBooks.add(book);
        totalCost += book.getPrice();

        return true;
    }
}
