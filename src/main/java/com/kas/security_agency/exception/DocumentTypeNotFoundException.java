package com.kas.security_agency.exception;

public class DocumentTypeNotFoundException extends RuntimeException {
    public DocumentTypeNotFoundException(String message) {
        super(message);
    }
}
