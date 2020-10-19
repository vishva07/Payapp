package com.vishva.Payapp.service;

import com.vishva.Payapp.dto.Response;
import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.exchange.CreditResponse;
import com.vishva.Payapp.model.AccountEntity;
import com.vishva.Payapp.repository.AccountRepository;
import com.vishva.Payapp.repositoryservice.CreditRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreditServiceImpl implements CreditService {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private CreditRepositoryService creditRepositoryService;

    @Override
    /*public CreditResponse amountCredited(CreditRequest creditRequest, String accId) {

        List<AccountEntity> accountEntityList = creditRepositoryService.getAccountList(accId);
        List<Response> responseList = creditRequest.getResponse();

        for (AccountEntity acc : accountEntityList) {
            if(acc.accountId.equals(accId)) {
                acc.balance = acc.balance + ;
            }
        }
    }*/
    public CreditResponse amountCredited(String accId, Double amt) {

        List<AccountEntity> accountEntityList = creditRepositoryService.getAccountList(accId);
        //List<Response> responseList = creditRequest.getResponse();
        //Double updatedBal = 0.0;
        for (AccountEntity acc : accountEntityList) {
            if(acc.accountId.equals(accId)) {
                acc.balance = acc.balance +amt;
                //updatedBal = acc.balance +amt;
                //acc.setBalance();
                break;
            }
        }


    }
}
