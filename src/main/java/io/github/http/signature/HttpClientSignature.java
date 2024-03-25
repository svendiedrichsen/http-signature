package io.github.http.signature;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpClientSignature {

    private static final Logger LOG = LoggerFactory.getLogger(HttpClientSignature.class);

    private final SignatureConfiguration configuration;

    public HttpClientSignature(SignatureConfiguration configuration) {
        this.configuration = configuration;
    }

    public void signRequest(RequestFacade requestFacade) {

    }

    public void verifyResponse(RequestFacade requestFacade, ResponseFacade responseFacade) {

    }

}
