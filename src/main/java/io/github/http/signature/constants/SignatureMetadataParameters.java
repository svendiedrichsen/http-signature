package io.github.http.signature.constants;

import io.github.http.signature.CreationalContext;
import lombok.Getter;
import org.greenbytes.http.sfv.IntegerItem;
import org.greenbytes.http.sfv.Item;
import org.greenbytes.http.sfv.StringItem;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Optional;
import java.util.function.Function;

@Getter
public enum SignatureMetadataParameters {

    ALG("alg", creationalContext -> StringItem.valueOf(creationalContext.getHttpSignatureConfiguration().getAlgorithm())),
    CREATED("created", creationalContext -> IntegerItem.valueOf(Instant.now().truncatedTo(ChronoUnit.SECONDS).getEpochSecond())),
    EXPIRES("expires", creationalContext -> IntegerItem.valueOf(Instant.now().truncatedTo(ChronoUnit.SECONDS).plus(creationalContext.getHttpSignatureConfiguration().getSignatureExpiration()).getEpochSecond())),
    KEY_ID("keyid", creationalContext -> StringItem.valueOf(creationalContext.getHttpSignatureConfiguration().getKeyId())),
    NONCE("nonce", creationalContext -> StringItem.valueOf(creationalContext.getHttpSignatureConfiguration().getNonce())),
    TAG("tag", creationalContext -> StringItem.valueOf(creationalContext.getHttpSignatureConfiguration().getNonce()));

    private final String name;
    private final Function<CreationalContext, Item<?>> creationalFunction;

    SignatureMetadataParameters(String name, Function<CreationalContext, Item<?>> creationalFunction) {
        this.name = name;
        this.creationalFunction = creationalFunction;
    }

    public static Optional<SignatureMetadataParameters> findByName(String name) {
        if (name == null) {
            return Optional.empty();
        }
        return Arrays.stream(SignatureMetadataParameters.values())
                .filter(signatureMetadataParameter -> name.equals(signatureMetadataParameter.getName()))
                .findFirst();
    }

    public Item<?> createValue(CreationalContext creationalContext) {
        return creationalFunction.apply(creationalContext);
    }

}
