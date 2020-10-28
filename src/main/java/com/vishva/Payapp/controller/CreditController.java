package com.vishva.Payapp.controller;

import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.exchange.CreditResponse;
import com.vishva.Payapp.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/home")
public class CreditController {

    @Autowired
    private CreditService creditService;

    @GetMapping("/")
    public String index() {
        return "Welcome to Payapp!";
    }

    @PostMapping("/credit")
    public ResponseEntity<CreditResponse> creditAmount(@Valid @RequestBody CreditRequest creditRequest) {

        CreditResponse creditResponse = new CreditResponse();

        creditService.amountCredited(creditRequest);
        creditResponse.setCreditStatus("Success: Thank you for using Payapp, your account is credited successfully!");
        return ResponseEntity.ok().body(creditResponse);
    }

}
