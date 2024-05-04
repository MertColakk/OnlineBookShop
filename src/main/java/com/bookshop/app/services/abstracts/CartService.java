package com.bookshop.app.services.abstracts;

import com.bookshop.app.models.Book;
import com.bookshop.app.models.User;

import java.util.List;

public interface CartService {
    void addToCart(User user, Book book);
    void removeFromCart(User user, Book book);
    List<Book> getCartItems(User user);
    double getTotal(User user);
}
