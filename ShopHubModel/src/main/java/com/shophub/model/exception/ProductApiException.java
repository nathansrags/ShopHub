package com.shophub.model.exception;

public class ProductApiException extends RuntimeException {

    public ProductApiException() {
    }

    public ProductApiException(String message) {
        super(message);
    }

    public ProductApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public ProductApiException(Throwable cause) {
        super(cause);
    }
}
