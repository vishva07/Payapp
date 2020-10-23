package com.vishva.Payapp.exchange;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditRequest {

    @NotNull
    @Pattern(regexp = "[0-9]+")
    private String accId;

    @NotNull
    @DecimalMin(value = "0.0")
    @DecimalMax(value = "10000.0")
    private BigDecimal amount;
}
