package io.github.http.signature.algorithm.exception;

public class SignatureInitializationException extends RuntimeException {

    public SignatureInitializationException(String message, Exception exception) {
        super(message, exception);
    }

}
