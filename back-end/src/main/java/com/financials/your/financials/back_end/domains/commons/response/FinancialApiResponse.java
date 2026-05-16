package com.financials.your.financials.back_end.domains.commons.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record FinancialApiResponse<T>(
        Boolean success,
        String message,
        T data,
        LocalDateTime timestamp
) {

    // Método para inicialiar resposta com sucesso e com body
    public static <T> FinancialApiResponse<T> success(T data, String message) {
        return new FinancialApiResponse<>(true, message, data, LocalDateTime.now());
    }

    // Método para inicialiar resposta com sucesso e sem body
    public static FinancialApiResponse success(String message) {
        return new FinancialApiResponse<>(true, message, null, LocalDateTime.now());
    }

    // Método para inicialiar resposta com erro
    public static <T> FinancialApiResponse<T> error(String message) {
        return new FinancialApiResponse<>(false, message, null, LocalDateTime.now());
    }

}
