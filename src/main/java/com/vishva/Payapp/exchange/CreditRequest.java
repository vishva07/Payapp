package com.vishva.Payapp.exchange;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditRequest {

    @NotNull(message = "Account number should not be null")
    @Pattern(regexp = "[0-9]+", message = "AccId should contains only digits")
    private String accId;

    @NotNull
    @DecimalMin(value = "0.0", message = "Amount should be greater than or equal to 0.0")
    @DecimalMax(value = "10000.0", message = "Amount should be less than or equal to 10000.0")
    private BigDecimal amount;
}
