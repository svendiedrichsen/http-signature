package io.github.http.signature;

import org.greenbytes.http.sfv.Item;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SignatureBase {

    private final Map<Item<?>, String> signatureBaseComponents = new LinkedHashMap<>();

    public void put(Item<?> key, String value) {
        this.signatureBaseComponents.put(key, value);
    }

    public String asString() {
        return signatureBaseComponents.entrySet().stream()
                .map(entry -> entry.getKey().serialize() + ": " + entry.getValue())
                .collect(Collectors.joining("\n", "", "\n"));
    }

}
