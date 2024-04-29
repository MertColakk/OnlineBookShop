package com.bookshop.BookShopping.services.abstracts;

import com.bookshop.BookShopping.entities.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {
    public Book addBook(Book book);
    public List<Book> getBooks();
    public Optional<Book> getWithID(long id);
    public boolean deleteBook(String name);
}
