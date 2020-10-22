package com.vishva.Payapp.exchange;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditRequest {

    @NotNull
    private String accId;
    @NotNull
    private BigDecimal amount;
}
