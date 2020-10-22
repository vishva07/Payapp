package com.vishva.Payapp.repositoryservice;

import com.vishva.Payapp.model.AccountEntity;
import java.util.List;

public interface CreditRepositoryService {

    List<AccountEntity> getAccountList(String accId);
}
