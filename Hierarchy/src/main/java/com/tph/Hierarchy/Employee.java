package com.tph.Hierarchy;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "EMPLOYEE_TYPE", discriminatorType = DiscriminatorType.STRING)

@Table(name = "Employee")
@Getter
@Setter
public class Employee {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)


    private int id;
    private String name;


}
