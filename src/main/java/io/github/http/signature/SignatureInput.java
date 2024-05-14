package io.github.http.signature;

import org.greenbytes.http.sfv.InnerList;
import org.greenbytes.http.sfv.Parser;

import java.util.function.Supplier;

public class SignatureInput implements Supplier<InnerList> {

    private final InnerList signatureComponentList;

    public SignatureInput(String signatureInput) {
        this.signatureComponentList = Parser.parseInnerList(signatureInput);
    }

    @Override
    public InnerList get() {
        return this.signatureComponentList;
    }

}
