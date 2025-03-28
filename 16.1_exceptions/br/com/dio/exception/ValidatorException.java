package br.com.dio.exception;

public class ValidatorException extends RuntimeException {
    public ValidatorException(final String message){
        super(message);
    }
}
