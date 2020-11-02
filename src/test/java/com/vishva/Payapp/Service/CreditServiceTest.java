package com.vishva.Payapp.Service;

import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.model.AccountEntity;
import com.vishva.Payapp.repository.AccountRepository;
import com.vishva.Payapp.repositoryservice.impl.CreditRepositoryServiceImpl;
import com.vishva.Payapp.service.impl.CreditServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.math.BigDecimal;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;


public class CreditServiceTest {

    @Mock
    private CreditRepositoryServiceImpl creditRepositoryService;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private CreditServiceImpl creditService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void accIdDoesNotExist() {
        CreditRequest creditRequest = new CreditRequest("256", new BigDecimal("34"));
        try {
            creditService.amountCredited(creditRequest);
            fail();
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
            assertNotNull(e.getMessage());
        }
    }

    @Test
    public void amountCreditedSuccessfully() {
        CreditRequest creditRequest = new CreditRequest("134", new BigDecimal("105"));
        AccountEntity accountEntity = new AccountEntity("134", "vishva", new BigDecimal("1500"));
        doReturn(Optional.of(accountEntity)).when(creditRepositoryService).getAccountEntities(creditRequest.getAccId());
        creditService.amountCredited(creditRequest);
        assertEquals(new BigDecimal("1605"), accountEntity.getBalance());
    }

}
