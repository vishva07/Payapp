package com.vishva.Payapp.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "TBL_ACCOUNTS")
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {

    @Id
    public String accId;

    @NotNull
    private String userName;

    public BigDecimal balance;

}
