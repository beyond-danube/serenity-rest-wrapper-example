package io.siniavtsev.examples.petstore.config;

import io.siniavtsev.serenity.rest.config.EnvironmentConfig;

public class PetStoreEnvironmentConfig implements EnvironmentConfig {
    @Override
    public String getBaseUri() {
        return "https://petstore.swagger.io";
    }

    @Override
    public String getBasePath() {
        return "v2";
    }
}
