package com.tph.Hierarchy;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@DiscriminatorValue("CONTRACT")

public class ContractEmployee extends Employee  {




    private float PayPerHour;


    private int contract_duration;


    }



