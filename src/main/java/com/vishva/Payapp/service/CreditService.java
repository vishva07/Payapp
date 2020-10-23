package com.vishva.Payapp.service;

import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.exchange.CreditResponse;

public interface CreditService {

    CreditResponse amountCredited(CreditRequest creditRequest);
}
