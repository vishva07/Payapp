package com.vishva.Payapp.exception;

import com.vishva.Payapp.exchange.CreditResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<CreditResponse> handleAccountNotFoundException(Exception ex) {
        CreditResponse creditResponse = new CreditResponse();
        creditResponse.setCreditStatus(ex.getMessage());
        return ResponseEntity.badRequest().body(creditResponse);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        CreditResponse creditResponse = new CreditResponse();
        creditResponse.setCreditStatus(ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
        return ResponseEntity.badRequest().body(creditResponse);
    }
}
