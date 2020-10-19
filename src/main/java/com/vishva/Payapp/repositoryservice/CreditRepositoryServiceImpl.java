package com.vishva.Payapp.repositoryservice;


import com.vishva.Payapp.model.AccountEntity;
import com.vishva.Payapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditRepositoryServiceImpl implements CreditRepositoryService {

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public List<AccountEntity> getAccountList(String accId) {

        List<AccountEntity> accountEntity = (List<AccountEntity>) accountRepository.findAll();
        return accountEntity;
    }
}
