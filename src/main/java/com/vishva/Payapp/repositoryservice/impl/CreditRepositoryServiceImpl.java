package com.vishva.Payapp.repositoryservice.impl;

import com.vishva.Payapp.model.AccountEntity;
import com.vishva.Payapp.repository.AccountRepository;
import com.vishva.Payapp.repositoryservice.CreditRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CreditRepositoryServiceImpl implements CreditRepositoryService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Optional<AccountEntity> getAccountEntities(String accId) {

        Optional<AccountEntity> optionalAccountEntity = accountRepository.findById(accId);
        return optionalAccountEntity;
    }

}
