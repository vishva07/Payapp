package com.vishva.Payapp.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import java.math.BigDecimal;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Credit {
    private String accId;
    private String userName;
    private BigDecimal balance;
}
