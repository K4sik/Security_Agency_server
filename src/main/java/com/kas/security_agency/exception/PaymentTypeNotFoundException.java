package com.kas.security_agency.exception;

public class PaymentTypeNotFoundException extends RuntimeException {
    public PaymentTypeNotFoundException(String message) {
        super(message);
    }
}
