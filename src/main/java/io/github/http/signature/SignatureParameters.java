package io.github.http.signature;

public enum SignatureParameters {
    CREATED("created"),
    EXPIRES("expires"),
    NONCE("nonce"),
    ALG("alg"),
    KEY_ID("keyid"),
    TAG("tag");

    private final String name;

    SignatureParameters(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
