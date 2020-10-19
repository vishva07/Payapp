package com.vishva.Payapp.repository;

import com.vishva.Payapp.model.AccountEntity;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<AccountEntity, String> {

}
