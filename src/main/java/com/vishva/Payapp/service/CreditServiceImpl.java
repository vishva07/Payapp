package com.vishva.Payapp.service;

import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.model.AccountEntity;
import com.vishva.Payapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void amountCredited(CreditRequest creditRequest) {

         Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(creditRequest.getAccId());
         if(!optionalAccountEntity.isPresent()) {
             throw new IllegalArgumentException("No such account is present");
         }
         AccountEntity accountEntity = optionalAccountEntity.get();
         BigDecimal newBal;
         newBal = accountEntity.balance.add(creditRequest.getAmount());
         accountEntity.setBalance(newBal);
         accountRepository.save(accountEntity);
    }
}
