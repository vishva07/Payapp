package com.vishva.Payapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;


@Data
//@Document(collection = "accounts")
@AllArgsConstructor
@RequiredArgsConstructor
public class AccountEntity {


    @Id
    private String id;

    public String accountId;

    private String userName;

    public Double balance;

}
