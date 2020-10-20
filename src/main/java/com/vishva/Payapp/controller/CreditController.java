package com.vishva.Payapp.controller;

import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.exchange.CreditResponse;
import com.vishva.Payapp.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CreditController.CREDIT_API_ENDPOINT)
public class CreditController {

    public final static String CREDIT_API_ENDPOINT = "/credit";

    @Autowired
    private CreditService creditService;

    @PostMapping("/{accId}")
    public ResponseEntity<CreditResponse> getResponse(@RequestBody CreditRequest creditRequest) {

        CreditResponse creditResponse;

        if(creditRequest.getAccId() != null && creditRequest.getAmount() != null) {
            creditResponse = creditService.amountCredited(creditRequest);
            return ResponseEntity.ok().body(creditResponse);
        }
        else {
            return ResponseEntity.badRequest().body(null);
        }
    }

}
