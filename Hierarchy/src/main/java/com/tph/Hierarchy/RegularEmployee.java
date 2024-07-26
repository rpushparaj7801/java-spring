package com.tph.Hierarchy;


import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("REGULAR")
public class RegularEmployee extends Employee {



    private float salary;

    private int bonus;


}
