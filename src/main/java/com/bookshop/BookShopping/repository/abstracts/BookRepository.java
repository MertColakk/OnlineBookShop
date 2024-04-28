package com.bookshop.BookShopping.repository.abstracts;

import com.bookshop.BookShopping.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
