package com.bookshop.app.models;

import java.util.Objects;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName, lastName, email, password;
    private int age;
    private boolean isAdmin = false;

    public User(String firstName, String lastName, String email, String password, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
        this.isAdmin =  false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id); // Assuming email is a unique identifier for users
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Assuming email is a unique identifier for users
    }
}
