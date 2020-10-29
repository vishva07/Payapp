package com.vishva.Payapp.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.model.AccountEntity;
import com.vishva.Payapp.repository.AccountRepository;
import com.vishva.Payapp.service.impl.CreditServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;


public class CreditServiceTest {

    private ObjectMapper objectMapper;
    private MockMvc mvc;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private CreditServiceImpl creditService;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void amountCreditedNullRequest() {

        try {
            creditService.amountCredited(null);
            fail();
        } catch (IllegalArgumentException e) {
            assertNotNull(e);
            assertNotNull(e.getMessage());
        }
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
    public void amountCredited() {
        CreditRequest creditRequest = new CreditRequest("102", new BigDecimal("10"));
        //AccountEntity accountEntity = new AccountEntity("123", "vishva", BigDecimal.ONE);
        creditService.amountCredited(creditRequest);
        //doReturn(Optional.of(accountEntity)).when(accountRepository).findById(any());
        //creditService.amountCredited(creditRequest);
        //verify(accountRepository).save(any());
        assertEquals("1010", accountRepository.findById(creditRequest.getAccId()).get().balance);
    }

}
