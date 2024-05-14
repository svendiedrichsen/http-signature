package io.github.http.signature.algorithm.components;

import io.github.http.signature.algorithm.exception.SignatureInitializationException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.spec.MGF1ParameterSpec;
import java.security.spec.PSSParameterSpec;
import java.util.function.Supplier;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SignatureSupplier {

    public static final Supplier<Signature> RSA_PSS_SHA512 = () -> {
        try {
            Signature signer = Signature.getInstance("RSASSA-PSS");
            signer.setParameter(
                    new PSSParameterSpec("SHA-512", "MGF1", MGF1ParameterSpec.SHA512, 64, 1)
            );
            return signer;
        } catch (NoSuchAlgorithmException | InvalidAlgorithmParameterException e) {
            throw new SignatureInitializationException("Failed to initialize signature.", e);
        }
    };

    public static final Supplier<Signature> RSA_V1_5_SHA256 = () -> {
        try {
            return Signature.getInstance("SHA256withRSA");
        } catch (NoSuchAlgorithmException e) {
            throw new SignatureInitializationException("Failed to initialize signature.", e);
        }
    };

    public static final Supplier<Signature> ECDSA_P256_SHA256 = () -> {
        try {
            return Signature.getInstance("SHA256withECDSA");
        } catch (NoSuchAlgorithmException e) {
            throw new SignatureInitializationException("Failed to initialize signature.", e);
        }
    };

    public static final Supplier<Signature> ECDSA_P384_SHA384 = () -> {
        try {
            return Signature.getInstance("SHA384withECDSA");
        } catch (NoSuchAlgorithmException e) {
            throw new SignatureInitializationException("Failed to initialize signature.", e);
        }
    };

    public static final Supplier<Signature> ED25519 = () -> {
        try {
            return Signature.getInstance("Ed25519");
        } catch (NoSuchAlgorithmException e) {
            throw new SignatureInitializationException("Failed to initialize signature.", e);
        }
    };

}
