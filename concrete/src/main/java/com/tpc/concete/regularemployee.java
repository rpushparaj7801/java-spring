package com.tpc.concete;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="regular1")

public class regularemployee extends employee {

    private int salary;

    private int bonus;


}
