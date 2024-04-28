package com.bookshop.BookShopping.business.concretes;

import com.bookshop.BookShopping.business.abstracts.CartService;
import com.bookshop.BookShopping.entities.Book;
import com.bookshop.BookShopping.entities.Cart;
import com.bookshop.BookShopping.repository.abstracts.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    private Cart cart;
    @Autowired
    private BookRepository bookRepository;


    @Override
    public boolean addToCart(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book newBook = optionalBook.get();

            cart.addToCart(newBook);
            return true;
        }

        return false;

    }
}
