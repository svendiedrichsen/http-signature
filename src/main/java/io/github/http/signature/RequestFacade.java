package io.github.http.signature;

public interface RequestFacade {

    String getMethod();
    String getTargetUri();
    String getAuthority();
    String getScheme();
    String getRequestTarget();
    String getPath();
    String getQuery();
    String getQueryParam();

    String getRequestHeader(String name);

    void setRequestHeader(String name, String value);

}
