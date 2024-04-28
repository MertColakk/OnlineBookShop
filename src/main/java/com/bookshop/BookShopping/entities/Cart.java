package com.bookshop.BookShopping.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class Cart {
    @OneToMany(cascade = CascadeType.ALL)
    private List<Book> myBooks = new ArrayList<>();

    private double totalCost = 0;

    public void addToCart(Book book){
        this.myBooks.add(book);
        totalCost += book.getPrice();
    }
}
