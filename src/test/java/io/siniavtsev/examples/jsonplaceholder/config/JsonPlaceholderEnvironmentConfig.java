package io.siniavtsev.examples.jsonplaceholder.config;

import io.siniavtsev.serenity.rest.config.EnvironmentConfig;

public class JsonPlaceholderEnvironmentConfig implements EnvironmentConfig {
    @Override
    public String getBaseUri() {
        return "https://jsonplaceholder.typicode.com";
    }

    @Override
    public String getBasePath() {
        return "";
    }
}
