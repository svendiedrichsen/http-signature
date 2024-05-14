package io.github.http.signature;

import lombok.Builder;
import lombok.Data;

import java.time.Duration;

@Data
@Builder
public class HttpSignatureConfiguration {

    private final SignatureInput signatureInput;
    private final String algorithm;
    private final String keyId;
    private final String nonce;
    private final String tag;
    private final Duration signatureExpiration;

}
