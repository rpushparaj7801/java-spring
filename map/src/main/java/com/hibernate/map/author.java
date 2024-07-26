package com.hibernate.map;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@Table(name = "author2")
public class author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
    @MapKey(name = "genre") // Map using book genre as key
    private Map<String, book> books = new HashMap<>();
    public void addBook(book book) {
        books.put(book.getGenre(), book); // Using genre as key
        book.setAuthor(this);
    }
}
