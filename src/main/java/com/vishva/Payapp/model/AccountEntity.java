package com.vishva.Payapp.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "TBL_ACCOUNTS")
@NoArgsConstructor
@AllArgsConstructor
public class AccountEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    public String accId;

    @NotNull
    private String userName;

    public BigDecimal balance;

}
