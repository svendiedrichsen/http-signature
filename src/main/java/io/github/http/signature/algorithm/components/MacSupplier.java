package io.github.http.signature.algorithm.components;

import io.github.http.signature.algorithm.exception.MacInitializationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.crypto.Mac;
import java.security.NoSuchAlgorithmException;
import java.util.function.Function;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MacSupplier {
    private static final Function<String, Mac> MAC = macName -> {
        try {
            return Mac.getInstance(macName);
        } catch (NoSuchAlgorithmException e) {
            throw new MacInitializationException("Failed to initialize Mac.", e);
        }
    };
    public static final Supplier<Mac> HMAC_SHA256 = () -> MAC.apply("HmacSHA256");
    public static final Supplier<Mac> HMAC_SHA384 = () -> MAC.apply("HmacSHA384");
    public static final Supplier<Mac> HMAC_SHA512 = () -> MAC.apply("HmacSHA512");

}
