package io.github.http.signature.client;

import io.github.http.signature.*;
import io.github.http.signature.constants.DerivedComponents;
import io.github.http.signature.constants.SignatureMetadataParameters;
import io.github.http.signature.exception.SignatureException;
import org.greenbytes.http.sfv.InnerList;
import org.greenbytes.http.sfv.Item;
import org.greenbytes.http.sfv.Parameters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class HttpClientSignature {

    private static final Logger LOG = LoggerFactory.getLogger(HttpClientSignature.class);

    private final HttpSignatureConfiguration configuration;

    public HttpClientSignature(HttpSignatureConfiguration configuration) {
        this.configuration = configuration;
    }

    public void signRequest(RequestFacade requestFacade) {
        SignatureBase signatureBase = new SignatureBase();
        final CreationalContext creationalContext = CreationalContext.builder()
                .httpSignatureConfiguration(configuration)
                .requestFacade(requestFacade)
                .build();
        final InnerList signatureInput = configuration.getSignatureInput().get();
        for (Item<?> signatureComponent : signatureInput.get()) {
            final Optional<DerivedComponents> derivedComponent = DerivedComponents.findByName(signatureComponent.get().toString());
            if (derivedComponent.isPresent()) {
                signatureBase.put(signatureComponent, derivedComponent.get().createValue(creationalContext).get().toString());
            } else {
                signatureBase.put(signatureComponent, requestFacade.getRequestHeader(signatureComponent.get().toString()));
            }
        }
        // handle signature input parameter
        Map<String, Object> parameterMap = new LinkedHashMap<>();
        for (String signatureParameterName : signatureInput.getParams().keySet()) {
            final Optional<SignatureMetadataParameters> signatureMetadataParameter = SignatureMetadataParameters.findByName(signatureParameterName);
            if (signatureMetadataParameter.isPresent()) {
                parameterMap.put(signatureParameterName, signatureMetadataParameter.get().createValue(creationalContext).get());
            } else {
                throw new SignatureException("Unknown signature parameter " + signatureParameterName);
            }
        }
        signatureBase.put(DerivedComponents.SIGNATURE_PARAMS.getName(), configuration.getSignatureInput().get().withParams(Parameters.valueOf(parameterMap)).serialize());
        LOG.info("Signature base:\n" + signatureBase.asString());
    }

    public void verifyResponse(RequestFacade requestFacade, ResponseFacade responseFacade) {

    }

}
