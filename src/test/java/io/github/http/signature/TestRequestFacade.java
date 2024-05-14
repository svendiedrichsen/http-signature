package io.github.http.signature;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class TestRequestFacade implements RequestFacade {

    private final Map<String, String> headerParameter = new HashMap<>();

    private String method;
    private String targetUri;
    private String authority;
    private String scheme;
    private String requestTarget;
    private String path;
    private String query;
    private String queryParam;

    @Override
    public String getRequestHeader(String name) {
        return headerParameter.get(name);
    }

    @Override
    public void setRequestHeader(String name, String value) {
        this.headerParameter.put(name, value);
    }

}
