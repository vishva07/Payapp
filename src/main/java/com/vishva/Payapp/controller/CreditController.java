package com.vishva.Payapp.controller;

import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.exchange.CreditResponse;
import com.vishva.Payapp.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(CreditController.CREDIT_API_ENDPOINT)
public class CreditController {

    public final static String CREDIT_API_ENDPOINT = "/credit";

    @Autowired
    private CreditService creditService;

    @PostMapping("/{accId}")
    /*public ResponseEntity<CreditResponse> getResponse(@RequestBody CreditRequest getCreditRequest, @PathVariable String accId) {

        CreditResponse creditResponse = creditService.amountCredited(getCreditRequest, accId);
        return ResponseEntity.ok().body(creditResponse);
    }*/
    public ResponseEntity<CreditResponse> getResponse(@PathVariable String accId, @RequestBody Double amt) {

        CreditResponse creditResponse = creditService.amountCredited(accId, amt);
        return ResponseEntity.ok().body(creditResponse);
    }
}
