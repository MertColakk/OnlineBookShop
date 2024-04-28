package com.bookshop.BookShopping.business.concretes;

import com.bookshop.BookShopping.business.abstracts.BookService;
import com.bookshop.BookShopping.entities.Book;
import com.bookshop.BookShopping.repository.abstracts.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getWithID(long id){

        Optional<Book> book = bookRepository.findById(id);
        return book;
    }

    @Override
    public boolean deleteBook(String name) {
        List<Book> books = bookRepository.findAll();

        for(Book book:books){
            if(book.getName().equals(name)){
                bookRepository.deleteById(book.getId());
                return true;
            }
        }
        return false;
    }
}
