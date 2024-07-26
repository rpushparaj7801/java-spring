package com.hibernate.manytoone;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "department1")
public class department {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        private String name;

        @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
        private Set<employee> employees = new HashSet<>();


}
