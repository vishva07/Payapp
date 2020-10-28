package com.vishva.Payapp.service.impl;

import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.model.AccountEntity;
import com.vishva.Payapp.repository.AccountRepository;
import com.vishva.Payapp.repositoryservice.CreditRepositoryService;
import com.vishva.Payapp.service.CreditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private CreditRepositoryService creditRepositoryService;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void amountCredited(CreditRequest creditRequest) {

         Optional<AccountEntity> optionalAccountEntity = creditRepositoryService.getAccountEntities(creditRequest.getAccId());

         if(optionalAccountEntity.isEmpty()) {
             throw new IllegalArgumentException("Failure: Please enter the correct account number");
         }

         else {
             AccountEntity accountEntity = optionalAccountEntity.get();
             BigDecimal newBal;
             newBal = accountEntity.balance.add(creditRequest.getAmount());
             accountEntity.setBalance(newBal);
             accountRepository.save(accountEntity);
         }
    }
}
