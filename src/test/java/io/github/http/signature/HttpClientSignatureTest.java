package io.github.http.signature;

import org.junit.jupiter.api.Test;

import java.util.List;

class HttpClientSignatureTest {

    @Test
    void testHttpClientSignature() {
        TestSignatureConfiguration signatureConfiguration = TestSignatureConfiguration.builder()
                .requestSignatureComponentNames(List.of("@target-uri", "@authority", "date", "cache-control"))
                .requestSignatureParameterNames(List.of("keyid", "alg", "created", "expires"))
                .build();
        TestRequestFacade requestFacade = new TestRequestFacade();

        HttpClientSignature httpClientSignature = new HttpClientSignature(signatureConfiguration);
        httpClientSignature.signRequest(requestFacade);



    }
}
