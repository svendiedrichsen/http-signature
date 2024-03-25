package io.github.http.signature;

import lombok.Builder;
import lombok.Data;
import lombok.Singular;

import java.util.List;

@Data
@Builder
public class TestSignatureConfiguration implements SignatureConfiguration {

    private List<String> requestSignatureComponentNames;
    private List<String> requestSignatureParameterNames;

}
