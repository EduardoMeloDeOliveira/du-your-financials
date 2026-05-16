package com.financials.your.financials.back_end.domains.commons.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
