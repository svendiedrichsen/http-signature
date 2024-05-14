package io.github.http.signature.algorithm.exception;

public class SigningException extends RuntimeException {

    public SigningException(String message, Exception exception) {
        super(message, exception);
    }

}
