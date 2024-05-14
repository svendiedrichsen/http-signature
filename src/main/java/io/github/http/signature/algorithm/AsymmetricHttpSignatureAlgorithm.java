package io.github.http.signature.algorithm;

import io.github.http.signature.algorithm.exception.SigningException;

import java.security.*;
import java.util.Arrays;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public non-sealed class AsymmetricHttpSignatureAlgorithm extends HttpSignatureAlgorithm {

    private final Supplier<Signature> signatureSupplier;
    private final UnaryOperator<byte[]> hashFunction;

    protected AsymmetricHttpSignatureAlgorithm(String name, Supplier<Signature> signatureSupplier, UnaryOperator<byte[]> hashFunction) {
        super(name, false);
        this.signatureSupplier = signatureSupplier;
        this.hashFunction = hashFunction;
    }

    public byte[] sign(PrivateKey privateKey, byte[] data) {
        byte[] hashedData = hashFunction.apply(data);
        final Signature signature = signatureSupplier.get();
        try {
            signature.initSign(privateKey);
            signature.update(hashedData);
            return signature.sign();
        } catch (InvalidKeyException | SignatureException e) {
            throw new SigningException("Failed to sign data.", e);
        }
    }

    public boolean verify(byte[] data, byte[] signature) {
        return Arrays.equals(data, signature);
    }

}
