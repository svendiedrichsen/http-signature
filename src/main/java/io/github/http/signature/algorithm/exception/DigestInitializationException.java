package io.github.http.signature.algorithm.exception;

public class DigestInitializationException extends RuntimeException {

    public DigestInitializationException(String message, Exception exception) {
        super(message, exception);
    }

}
