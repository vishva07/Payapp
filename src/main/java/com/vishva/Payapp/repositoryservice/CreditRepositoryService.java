package com.vishva.Payapp.repositoryservice;

import com.vishva.Payapp.model.AccountEntity;
import java.util.Optional;

public interface CreditRepositoryService {

    Optional<AccountEntity> getAccountEntities(String accId);
}

