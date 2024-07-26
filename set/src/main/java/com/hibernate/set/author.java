package com.hibernate.set;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "author1")
public class author {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;


        @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, orphanRemoval = true)
        private Set<book> books = new HashSet<>();


}



