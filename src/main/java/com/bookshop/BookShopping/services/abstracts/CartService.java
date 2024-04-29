package com.bookshop.BookShopping.services.abstracts;

import com.bookshop.BookShopping.entities.Book;

import java.util.List;

public interface CartService {
    void addToCart(long id);
    List<Book> showAllCart();
    double getTotalCost();
}
