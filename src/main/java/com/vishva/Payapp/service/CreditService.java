package com.vishva.Payapp.service;

import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.exchange.CreditResponse;

public interface CreditService {
    public CreditResponse amountCredited(String accId, Double amt);

    //CreditResponse amountCredited(CreditRequest creditRequest, String accId);
}
