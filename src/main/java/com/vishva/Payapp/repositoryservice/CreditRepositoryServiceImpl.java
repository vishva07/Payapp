package com.vishva.Payapp.repositoryservice;

import com.vishva.Payapp.dto.Credit;
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
    ModelMapper modelMapper;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<Credit> getAccountList(String accId) {

        List<Credit> creditList = new ArrayList<>();
        List<AccountEntity> accountEntity = accountRepository.findAll();

        for(AccountEntity acc : accountEntity) {
            creditList.add(modelMapper.map(acc, Credit.class));
        }
        return creditList;
    }
}
