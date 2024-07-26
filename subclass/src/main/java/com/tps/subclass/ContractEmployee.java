package com.tps.subclass;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="Contract2")
@PrimaryKeyJoinColumn(name="ID")
public class ContractEmployee extends employee{

    private int PayPerHour;
    private int ContractDuration;


}
