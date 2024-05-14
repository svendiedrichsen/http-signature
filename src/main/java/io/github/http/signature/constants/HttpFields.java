package io.github.http.signature.constants;

import lombok.Getter;

@Getter
public enum HttpFields {

    SIGNATURE_INPUT("Signature-Input"),
    SIGNATURE("Signature"),
    ACCEPT_SIGNATURE("Accept-Signature");

    private final String name;

    HttpFields(String name) {
        this.name = name;
    }

}
