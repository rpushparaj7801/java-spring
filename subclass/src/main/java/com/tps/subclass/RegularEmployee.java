package com.tps.subclass;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Regular2")
@PrimaryKeyJoinColumn(name="ID")
public class RegularEmployee extends employee{

    private  int salary;
    private int bonus;


}
