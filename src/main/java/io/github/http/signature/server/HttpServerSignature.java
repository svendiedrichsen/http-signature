package io.github.http.signature.server;

import io.github.http.signature.HttpSignatureConfiguration;
import io.github.http.signature.RequestFacade;
import io.github.http.signature.ResponseFacade;

public class HttpServerSignature {

    private final HttpSignatureConfiguration configuration;

    public HttpServerSignature(HttpSignatureConfiguration configuration) {
        this.configuration = configuration;
    }

    public void signResponse(RequestFacade requestFacade, ResponseFacade responseFacade) {

    }

    public void verifyRequest(RequestFacade requestFacade) {

    }

}
