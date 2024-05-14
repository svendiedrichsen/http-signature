package io.github.http.signature.algorithm;

import io.github.http.signature.algorithm.components.HashFunctions;
import io.github.http.signature.algorithm.components.MacSupplier;
import io.github.http.signature.algorithm.components.SignatureSupplier;

import java.util.Optional;
import java.util.stream.Stream;

public class HttpSignatureAlgorithms {

    public static final HttpSignatureAlgorithm RSA_PSS_SHA512 = new AsymmetricHttpSignatureAlgorithm("rsa-pss-sha512", SignatureSupplier.RSA_PSS_SHA512, HashFunctions.SHA_512);
    public static final HttpSignatureAlgorithm RSA_V1_5_SHA256 = new AsymmetricHttpSignatureAlgorithm("rsa-v1_5-sha256", SignatureSupplier.RSA_V1_5_SHA256, HashFunctions.SHA_256);
    public static final HttpSignatureAlgorithm HMAC_SHA256 = new SymmetricHttpSignatureAlgorithm("hmac-sha256", MacSupplier.HMAC_SHA256, false);
    public static final HttpSignatureAlgorithm ECDSA_P256_SHA256 = new AsymmetricHttpSignatureAlgorithm("ecdsa-p256-sha256", SignatureSupplier.ECDSA_P256_SHA256, HashFunctions.SHA_256);
    public static final HttpSignatureAlgorithm ECDSA_P384_SHA384 = new AsymmetricHttpSignatureAlgorithm("ecdsa-p384-sha384", SignatureSupplier.ECDSA_P384_SHA384, HashFunctions.SHA_384);
    public static final HttpSignatureAlgorithm ED25519 = new AsymmetricHttpSignatureAlgorithm("ed25519", SignatureSupplier.ED25519, HashFunctions.NOOP);
    public static final HttpSignatureAlgorithm HS256 = new SymmetricHttpSignatureAlgorithm("HS256", MacSupplier.HMAC_SHA256, true);
    public static final HttpSignatureAlgorithm HS384 = new SymmetricHttpSignatureAlgorithm("HS384", MacSupplier.HMAC_SHA384, true);
    public static final HttpSignatureAlgorithm HS512 = new SymmetricHttpSignatureAlgorithm("HS512", MacSupplier.HMAC_SHA512, true);

    public Optional<HttpSignatureAlgorithm> findByName(String name) {
        return Stream.of(RSA_PSS_SHA512, RSA_V1_5_SHA256,
                        HMAC_SHA256, ECDSA_P256_SHA256,
                        ECDSA_P384_SHA384, ED25519,
                        HS256, HS384, HS512)
                .filter(httpSignatureAlgorithm -> httpSignatureAlgorithm.getName().equals(name))
                .findFirst();
    }

}
