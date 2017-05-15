package com.bareskin.back.mock.transformers;

import com.bareskin.back.mock.NonGlobalResponseTransformer;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;

public class DummyResponseTransformer extends NonGlobalResponseTransformer {
    public Response transform(Request request, Response response, FileSource fileSource, Parameters parameters) {
        ClasspathFileSource classpathFileSource = new ClasspathFileSource("responses/");

        return Response.Builder.like(response)
                .body(classpathFileSource.getTextFileNamed("dummy-success.json").readContents())
                .build();
    }

    public String getName() {
        return "dummy-transformer";
    }
}
