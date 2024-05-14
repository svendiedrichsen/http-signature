package io.github.http.signature.algorithm;

import io.github.http.signature.algorithm.exception.SigningException;
import lombok.Getter;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.function.Supplier;

@Getter
public non-sealed class SymmetricHttpSignatureAlgorithm extends HttpSignatureAlgorithm {

    private final Supplier<Mac> macSupplier;

    public SymmetricHttpSignatureAlgorithm(String name, Supplier<Mac> macSupplier, boolean joseAlgorithm) {
        super(name, joseAlgorithm);
        this.macSupplier = macSupplier;
    }

    public byte[] sign(SecretKey secretKey, byte[] data) {
        final Mac mac = macSupplier.get();
        try {
            mac.init(secretKey);
            mac.update(data);
            return mac.doFinal();
        } catch (InvalidKeyException e) {
            throw new SigningException("Signing data failed.", e);
        }
    }

    public boolean verify(byte[] data, byte[] signature) {
        return Arrays.equals(data, signature);
    }

}
