package io.github.http.signature.algorithm.exception;

public class MacInitializationException extends RuntimeException {

    public MacInitializationException(String message, Exception exception) {
        super(message, exception);
    }

}
