package com.bareskin.back.mock;

import com.bareskin.back.mock.transformers.*;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.standalone.JsonFileMappingsSource;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.wireMockConfig;

public class Application {

    public static final int PORT = 8087;

    public static void main(String[] args) {
        WireMockServer server = new WireMockServer(
                wireMockConfig()
                        .port(PORT)
                        .mappingSource(
                                new JsonFileMappingsSource(
                                        new ClasspathFileSource("mappings")
                                ))
                        .notifier(new ConsoleNotifier(true))
                        .extensions(
                                LoginResponseTransformer.class,
                                ProductsResponseTransformer.class,
                                SubmitOrderResponseTransformer.class,
                                RegisterSaleResponseTransformer.class,
                                SalesHistoryResponseTransformer.class
                        ));
        server.start();
    }
}
