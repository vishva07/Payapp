package com.vishva.Payapp.controller;

import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.exchange.CreditResponse;
import com.vishva.Payapp.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping("/home")
    public String index() {
        return "Welcome to Payapp!";
    }

    @PostMapping("/home/credit")
    public ResponseEntity<CreditResponse> getResponse(@RequestBody CreditRequest creditRequest) {

        CreditResponse creditResponse;

        if(creditRequest.getAccId() != null && creditRequest.getAmount() != null) {
            creditResponse = creditService.amountCredited(creditRequest);
            return ResponseEntity.ok().build();
        }
        else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
