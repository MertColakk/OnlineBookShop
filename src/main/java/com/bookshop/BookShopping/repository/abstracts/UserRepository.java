package com.bookshop.BookShopping.repository.abstracts;

import com.bookshop.BookShopping.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
