package com.hibernate.multiplesession;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class student {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)

    int id;
    String name;
    @Column(name = "school name")
    String sname;
}
