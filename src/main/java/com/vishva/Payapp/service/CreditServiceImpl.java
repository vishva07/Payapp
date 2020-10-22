package com.vishva.Payapp.service;

import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.exchange.CreditResponse;
import com.vishva.Payapp.model.AccountEntity;
import com.vishva.Payapp.repository.AccountRepository;
import com.vishva.Payapp.repositoryservice.CreditRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepositoryService creditRepositoryService;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public CreditResponse amountCredited(CreditRequest creditRequest) {

        List<AccountEntity> creditList = creditRepositoryService.getAccountList(creditRequest.getAccId());

        BigDecimal newBal;

        for (AccountEntity acc : creditList) {
            if(acc.getAccId().equals(creditRequest.getAccId())) {
                BigDecimal a = acc.getBalance();
                BigDecimal b = creditRequest.getAmount();
                newBal = a.add(b);
                acc.setBalance(newBal);

                accountRepository.save(acc);
            }
        }
        CreditResponse creditResponse = new CreditResponse(creditList);
        return creditResponse;
    }
}
