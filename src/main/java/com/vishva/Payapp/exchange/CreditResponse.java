package com.vishva.Payapp.exchange;

import com.vishva.Payapp.dto.Credit;
import com.vishva.Payapp.model.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreditResponse {

    List<AccountEntity> creditList;
}
