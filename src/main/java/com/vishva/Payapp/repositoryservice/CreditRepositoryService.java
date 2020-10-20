package com.vishva.Payapp.repositoryservice;

import com.vishva.Payapp.dto.Credit;
import java.util.List;

public interface CreditRepositoryService {

    List<Credit> getAccountList(String accId);
}
