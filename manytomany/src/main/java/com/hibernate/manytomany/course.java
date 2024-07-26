package com.hibernate.manytomany;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class course {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String title;

        @ManyToMany(mappedBy = "courses")
        private Set<student> students = new HashSet<>();



}
