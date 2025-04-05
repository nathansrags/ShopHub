package com.shophub.model.exception;

public class RecordNotFoundException extends RuntimeException{

    public RecordNotFoundException(){

    }

    public RecordNotFoundException(String message){
        super(message);
    }

    public RecordNotFoundException(String message, Throwable cause){
        super(message,cause);
    }
    RecordNotFoundException(Throwable cause){
        super(cause);
    }
}
