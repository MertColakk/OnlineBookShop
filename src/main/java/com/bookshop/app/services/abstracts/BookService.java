package com.bookshop.app.services.abstracts;

import com.bookshop.app.models.Book;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public Boolean add(String name, int pageCount, String author, String publisher, String genre, double price);
    public List<Book> show();
    public Book getWithID(long id);
}
