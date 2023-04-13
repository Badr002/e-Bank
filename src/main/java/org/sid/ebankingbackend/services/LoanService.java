package org.sid.ebankingbackend.services;

import lombok.Data;
import org.sid.ebankingbackend.entities.LoanRequest;
import org.springframework.stereotype.Service;

@Service @Data

public class LoanService {
    private static final double MAX_DEBT_TO_INCOME_RATIO=0.4;

    public boolean isLoanEligible(LoanRequest loanRequest){
        double debtToIncomeRatio = calculatedDebtToIncomeRatio(loanRequest.getDebt(), loanRequest.getIncome());
        if(debtToIncomeRatio > MAX_DEBT_TO_INCOME_RATIO ){
            return false;
        }
        if (loanRequest.getCollateral() <0 ){
            return false;
        }
        if (loanRequest.getAge() < 18 ){
            return false;
        }
        if (loanRequest.getCreditscore() <600){
            return false;
        }
        return  true;
    }
    private double calculatedDebtToIncomeRatio(double debt,double income){
        if(income == 0){
            return 0;
        }
        return debt/ income;
    }
}
