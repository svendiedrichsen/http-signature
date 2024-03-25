package io.github.http.signature;

public class HttpServerSignature {

    private final SignatureConfiguration configuration;

    public HttpServerSignature(SignatureConfiguration configuration) {
        this.configuration = configuration;
    }

    public void signResponse(RequestFacade requestFacade, ResponseFacade responseFacade) {

    }

    public void verifyRequest(RequestFacade requestFacade) {

    }

}
