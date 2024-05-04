package com.bookshop.app.services.abstracts;

import com.bookshop.app.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public Book add(Book book);
    public List<Book> show();
    public Book getWithID(long id);
}
