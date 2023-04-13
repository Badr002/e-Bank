package org.sid.ebankingbackend.web;

import org.sid.ebankingbackend.entities.LoanRequest;
import org.sid.ebankingbackend.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/laon")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping("/check-eligibility")
    public ResponseEntity<?>checkLoanEligibility(@RequestBody LoanRequest loanrequest){
        boolean isLoanEligible = loanService.isLoanEligible(loanrequest);
        if (isLoanEligible){
            return ResponseEntity.ok("loan is eligible.");

        }else{
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body("loan is not eligible");


        }



    }


}
