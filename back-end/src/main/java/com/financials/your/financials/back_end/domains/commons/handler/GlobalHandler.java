package com.financials.your.financials.back_end.domains.commons.handler;

import com.financials.your.financials.back_end.domains.commons.exception.BusinessException;
import com.financials.your.financials.back_end.domains.commons.exception.NotFoundException;
import com.financials.your.financials.back_end.domains.commons.response.FinancialApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<FinancialApiResponse<Void>> handleBusinessException(BusinessException ex) {
        log.error("BusinessException: {}", ex.getMessage());
        return ResponseEntity.status(ex.getStatus()).body(FinancialApiResponse.error(ex.getMessage()));
    }


    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<FinancialApiResponse<Void>> handleNotFound(NotFoundException ex) {
        log.error("NotFoundException: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(FinancialApiResponse.error(ex.getMessage()));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<FinancialApiResponse<Map<String, String>>> handleValidation(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String field = ((FieldError) error).getField();
            errors.put(field, error.getDefaultMessage());
        });
        log.error("Validation failed: {}", errors);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new FinancialApiResponse<>(false, "Erro de validação", errors, java.time.LocalDateTime.now()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<FinancialApiResponse<Void>> handleGeneric(Exception ex) {
        log.error("Unexpected error: {}", ex.getMessage(), ex);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(FinancialApiResponse.error("Erro interno do servidor"));
    }


}
