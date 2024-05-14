package io.github.http.signature.constants;

import lombok.Getter;

@Getter
public enum DerivedComponentParameters {

    STRUCTURED_FIELD("sf"),
    SINGLE_KEY_VALUE("key"),
    BYTE_SEQUENCE("bs"),
    TRAILER("tr"),
    RELATED_REQUEST("req"),
    SINGLE_NAMED_QUERY_PARAMETER("name");

    private final String name;

    DerivedComponentParameters(String name) {
        this.name = name;
    }

}
