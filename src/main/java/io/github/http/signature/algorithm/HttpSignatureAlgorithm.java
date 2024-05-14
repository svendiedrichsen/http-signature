package io.github.http.signature.algorithm;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract sealed class HttpSignatureAlgorithm
        permits SymmetricHttpSignatureAlgorithm, AsymmetricHttpSignatureAlgorithm {

    private final String name;
    private final boolean joseAlgorithm;

}
