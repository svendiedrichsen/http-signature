package io.github.http.signature;

import java.util.HashMap;
import java.util.Map;

public class TestRequestFacade implements RequestFacade {

    private final Map<String, String> headerParameter = new HashMap<>();

    @Override
    public void setRequestHeader(String name, String value) {
        this.headerParameter.put(name, value);
    }

    public String getHeaderParameter(String name) {
        return this.headerParameter.get(name);
    }

}
