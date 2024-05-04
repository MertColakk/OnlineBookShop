package com.bookshop.app.services.concretes;

import com.bookshop.app.models.Book;
import com.bookshop.app.models.Cart;
import com.bookshop.app.models.User;
import com.bookshop.app.repositories.UserRepository;
import com.bookshop.app.services.abstracts.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartServiceImp implements CartService {
    private Map<User, Cart> userCarts = new HashMap<>();

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addToCart(User user, Book book) {
        Cart cart = userCarts.get(user);
        if (cart == null) {
            cart = new Cart();
            userCarts.put(user, cart);
        }
        cart.addBook(book);
    }

    @Override
    public void removeFromCart(User user, Book book) {
        Cart cart = userCarts.get(user);
        if (cart != null) {
            cart.removeBook(book);
        }
    }

    @Override
    public List<Book> getCartItems(User user) {
        Cart cart = userCarts.get(user);
        return cart != null ? cart.getBooks() : Collections.emptyList();
    }

    @Override
    public double getTotal(User user) {
        Cart cart = userCarts.get(user);
        return cart != null ? cart.getTotalCost() : 0;
    }
}
