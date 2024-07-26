package com.hibernate.list;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Entity
public class book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private author author;



    @Override
    public String toString() {
        return "book{" + "id=" + id + ", title='" + title + '\'' + ", author=" + author + '}';
    }
}
