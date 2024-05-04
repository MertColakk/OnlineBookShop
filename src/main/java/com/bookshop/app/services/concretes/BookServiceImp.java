package com.bookshop.app.services.concretes;

import com.bookshop.app.models.Book;
import com.bookshop.app.repositories.BookRepository;
import com.bookshop.app.services.abstracts.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImp implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book add(Book book) {
        bookRepository.save(book);

        return book;
    }
    @Override
    public List<Book> show() {
        return bookRepository.findAll();
    }

    @Override
    public Book getWithID(long id) {
        for(Book book:bookRepository.findAll()){
            if(book.getId()==id){
                return book;
            }
        }
        return null;
    }
}
