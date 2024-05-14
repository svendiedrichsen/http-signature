package io.github.http.signature.algorithm.components;

import io.github.http.signature.algorithm.exception.DigestInitializationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HashFunctions {
    private static final Function<String, MessageDigest> MESSAGE_DIGEST = algorithm -> {
        try {
            return MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new DigestInitializationException("Failed to initialize message digest " + algorithm, e);
        }
    };
    private static final BiFunction<String, byte[], byte[]> HASH =
            (algorithm, bytes) -> MESSAGE_DIGEST.apply(algorithm).digest(bytes);

    public static final UnaryOperator<byte[]> NOOP = bytes -> bytes;
    public static final UnaryOperator<byte[]> SHA_256 = bytes -> HASH.apply("SHA-256", bytes);
    public static final UnaryOperator<byte[]> SHA_384 = bytes -> HASH.apply("SHA-384", bytes);
    public static final UnaryOperator<byte[]> SHA_512 = bytes -> HASH.apply("SHA-512", bytes);
}
