package com.bareskin.back.mock.transformers;

import com.bareskin.back.mock.NonGlobalResponseTransformer;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.extension.Parameters;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;
import org.json.JSONObject;

public class SubmitOrderResponseTransformer extends NonGlobalResponseTransformer {
    public Response transform(Request request, Response response, FileSource fileSource, Parameters parameters) {
        ClasspathFileSource classpathFileSource = new ClasspathFileSource("responses/");

        try {
            JSONObject jsonRequest = new JSONObject(request.getBodyAsString());
            //jsonRequest.get("id");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Response.Builder.like(response)
                .body(classpathFileSource.getTextFileNamed("submit-order-success.json").readContents())
                .build();
    }

    public String getName() {
        return "submit-order-transformer";
    }
}
