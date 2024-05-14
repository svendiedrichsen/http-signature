package io.github.http.signature;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreationalContext {

    private final HttpSignatureConfiguration httpSignatureConfiguration;
    private final RequestFacade requestFacade;
    private final ResponseFacade responseFacade;

}
