package com.vishva.Payapp.service;

import com.vishva.Payapp.dto.Credit;
import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.exchange.CreditResponse;
import com.vishva.Payapp.repositoryservice.CreditRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepositoryService creditRepositoryService;

    @Override
    public CreditResponse amountCredited(CreditRequest creditRequest) {

        List<Credit> creditList = creditRepositoryService.getAccountList(creditRequest.getAccId());

        BigDecimal newBal;

        for (Credit acc : creditList) {
            if(acc.getAccId().equals(creditRequest.getAccId())) {
                BigDecimal a = acc.getBalance();
                BigDecimal b = creditRequest.getAmount();
                newBal = a.add(b);
                acc.setBalance(newBal);
            }
        }
        CreditResponse creditResponse = new CreditResponse(creditList);
        return creditResponse;
    }
}
