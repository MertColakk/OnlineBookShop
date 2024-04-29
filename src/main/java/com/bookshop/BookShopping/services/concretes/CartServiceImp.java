package com.bookshop.BookShopping.services.concretes;

import com.bookshop.BookShopping.services.abstracts.CartService;
import com.bookshop.BookShopping.entities.Book;
import com.bookshop.BookShopping.entities.Cart;
import com.bookshop.BookShopping.repository.abstracts.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImp implements CartService {
    @Autowired
    private Cart cart;
    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addToCart(long id) {
        List<Book> books = bookRepository.findAll();
        for(Book book:books){
            if(book.getId()==id){
                cart.addToCart(book);
            }
        }
    }

    @Override
    public List<Book> showAllCart() {
        return cart.getMyBooks();
    }

    @Override
    public double getTotalCost() {
        return cart.getTotalCost();
    }
}
