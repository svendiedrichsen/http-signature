package io.github.http.signature;

public class HttpClientSignature {

    private final SignatureConfiguration configuration;

    public HttpClientSignature(SignatureConfiguration configuration) {
        this.configuration = configuration;
    }

    public void signRequest(RequestFacade requestFacade) {

    }

    public void verifyResponse(RequestFacade requestFacade, ResponseFacade responseFacade) {

    }

}
