package org.sid.ebankingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class LoanRequest {

    private double income;
    private double debt;
    private double collateral;
    private int age;
    private int creditscore;
}



