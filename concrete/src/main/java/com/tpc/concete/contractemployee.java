package com.tpc.concete;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="contract1")


public class contractemployee extends employee{

    private int payperhour;
    private int contractduration;


}
