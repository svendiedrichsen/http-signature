package io.github.http.signature;

import io.github.http.signature.client.HttpClientSignature;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

class HttpClientSignatureTest {

    @Test
    void testHttpClientSignature() {
        String signatureInput = "(\"@target-uri\" \"@authority\" \"@scheme\" \"date\" \"cache-control\");keyid;alg;created;expires";
        final HttpSignatureConfiguration httpSignatureConfiguration = HttpSignatureConfiguration.builder()
                .signatureInput(new SignatureInput(signatureInput))
                .keyId("test-key")
                .algorithm("rsa")
                .signatureExpiration(Duration.ofMinutes(5))
                .build();

        TestRequestFacade requestFacade = new TestRequestFacade();
        requestFacade.setTargetUri("https://www.example.com/path?param=value");
        requestFacade.setAuthority("www.example.com");
        requestFacade.setScheme("https");
        requestFacade.setRequestHeader("date", LocalDateTime.now().toString());
        requestFacade.setRequestHeader("cache-control", "no-cache");

        HttpClientSignature httpClientSignature = new HttpClientSignature(httpSignatureConfiguration);
        httpClientSignature.signRequest(requestFacade);

    }
}
