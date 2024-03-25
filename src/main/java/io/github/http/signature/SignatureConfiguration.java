package io.github.http.signature;

import java.util.List;

public interface SignatureConfiguration {

    List<String> getRequestSignatureComponentNames();
    List<String> getRequestSignatureParameterNames();

}
