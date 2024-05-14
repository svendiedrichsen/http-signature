package io.github.http.signature.constants;

import io.github.http.signature.CreationalContext;
import lombok.Getter;
import org.greenbytes.http.sfv.IntegerItem;
import org.greenbytes.http.sfv.Item;
import org.greenbytes.http.sfv.StringItem;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

@Getter
public enum DerivedComponents {

    METHOD("@method", creationalContext -> StringItem.valueOf(creationalContext.getRequestFacade().getMethod())),
    TARGET_URI("@target-uri", creationalContext -> StringItem.valueOf(creationalContext.getRequestFacade().getTargetUri())),
    AUTHORITY("@authority", creationalContext -> StringItem.valueOf(creationalContext.getRequestFacade().getAuthority())),
    SCHEME("@scheme", creationalContext -> StringItem.valueOf(creationalContext.getRequestFacade().getScheme())),
    REQUEST_TARGET("@request-target", creationalContext -> StringItem.valueOf(creationalContext.getRequestFacade().getRequestTarget())),
    PATH("@path", creationalContext -> StringItem.valueOf(creationalContext.getRequestFacade().getPath())),
    QUERY("@query", creationalContext -> StringItem.valueOf(creationalContext.getRequestFacade().getQuery())),
    QUERY_PARAM("@query-param", creationalContext -> StringItem.valueOf(creationalContext.getRequestFacade().getQueryParam())),
    STATUS("@status", creationalContext -> IntegerItem.valueOf(creationalContext.getResponseFacade().getStatus())),
    SIGNATURE_PARAMS("@signature-params", creationalContext -> StringItem.valueOf(creationalContext.getHttpSignatureConfiguration().getSignatureInput().get().serialize()));

    private final StringItem name;
    private final Function<CreationalContext, Item<?>> creationalFunction;

    DerivedComponents(String name, Function<CreationalContext, Item<?>> creationalFunction) {
        this.name = StringItem.valueOf(name);
        this.creationalFunction = creationalFunction;
    }

    public static Optional<DerivedComponents> findByName(String name) {
        if (name == null || !name.startsWith("@")) {
            return Optional.empty();
        }
        return Arrays.stream(DerivedComponents.values())
                .filter(derivedComponents -> name.equals(derivedComponents.getName().get()))
                .findFirst();
    }

    public Item<?> createValue(CreationalContext creationalContext) {
        return creationalFunction.apply(creationalContext);
    }

}
