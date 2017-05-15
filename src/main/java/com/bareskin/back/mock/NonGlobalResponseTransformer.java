package com.bareskin.back.mock;

import com.github.tomakehurst.wiremock.extension.ResponseTransformer;

public abstract class NonGlobalResponseTransformer extends ResponseTransformer {
    @Override
    public boolean applyGlobally() {
        return false;
    }
}
