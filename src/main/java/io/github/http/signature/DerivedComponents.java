package io.github.http.signature;

public enum DerivedComponents {

    METHOD("@method"),
    TARGET_URI("@target-uri"),
    AUTHORITY("@authority"),
    SCHEME("@scheme"),
    REQUEST_TARGET("@request-target"),
    PATH("@path"),
    QUERY("@query"),
    QUERY_PARAM("@query-param"),
    STATUS("@status"),
    SIGNATURE_PARAMS("@signature-params");

    private final String name;

    DerivedComponents(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
