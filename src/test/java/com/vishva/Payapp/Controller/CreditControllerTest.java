package com.vishva.Payapp.Controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vishva.Payapp.PayappApplication;
import com.vishva.Payapp.controller.CreditController;
import com.vishva.Payapp.exchange.CreditRequest;
import com.vishva.Payapp.repository.AccountRepository;
import com.vishva.Payapp.repositoryservice.impl.CreditRepositoryServiceImpl;
import com.vishva.Payapp.service.impl.CreditServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.math.BigDecimal;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = {PayappApplication.class})
public class CreditControllerTest {

    private ObjectMapper objectMapper;
    private MockMvc mvc;

    @Mock
    private CreditServiceImpl creditService;

    @Mock
    private CreditRepositoryServiceImpl creditRepositoryService;

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private CreditController creditController;


    @BeforeEach
    public void setup() {
        objectMapper = new ObjectMapper();
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(creditController).build();
    }

    @Test
    public void negativeAmountBadRequest() throws Exception {
        CreditRequest creditRequest = new CreditRequest("101", new BigDecimal("-99"));
        String jsonRequest = objectMapper.writeValueAsString(creditRequest);
        mvc.perform(post("/home/credit").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void maxAmountBadRequest() throws Exception {
        CreditRequest creditRequest = new CreditRequest("102", new BigDecimal("10012"));
        String jsonRequest = objectMapper.writeValueAsString(creditRequest);
        mvc.perform(post("/home/credit").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void nullAmountBadRequest() throws Exception {
        CreditRequest creditRequest = new CreditRequest("101", null);
        String jsonRequest = objectMapper.writeValueAsString(creditRequest);
        mvc.perform(post("/home/credit").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void nullAccIdBadRequest() throws Exception {
        CreditRequest creditRequest = new CreditRequest(null, new BigDecimal("118"));
        String jsonRequest = objectMapper.writeValueAsString(creditRequest);
        mvc.perform(post("/home/credit").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void invalidAccIdBadRequest() throws Exception {
        CreditRequest creditRequest = new CreditRequest("10v", new BigDecimal("4567"));
        String jsonRequest = objectMapper.writeValueAsString(creditRequest);
        mvc.perform(post("/home/credit").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void validArgumentOkRequest() throws Exception {
        CreditRequest creditRequest = new CreditRequest("101", new BigDecimal("1064"));
        String jsonRequest = objectMapper.writeValueAsString(creditRequest);
        mvc.perform(post("/home/credit").content(jsonRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
