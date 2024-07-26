package com.tpc.concete;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="employee1")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private  int id;
    private String name;


}
