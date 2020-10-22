package com.vishva.Payapp.repositoryservice;

import com.vishva.Payapp.model.AccountEntity;
import com.vishva.Payapp.repository.AccountRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CreditRepositoryServiceImpl implements CreditRepositoryService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountEntity> getAccountList(String accId) {

        List<AccountEntity> creditList = new ArrayList<>();
        List<AccountEntity> accountEntity = (List<AccountEntity>) accountRepository.findAll();

        for(AccountEntity acc : accountEntity) {
            creditList.add(modelMapper.map(acc, AccountEntity.class));
        }
        return creditList;
    }
}
