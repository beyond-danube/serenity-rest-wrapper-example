package io.siniavtsev.examples.tests.jsonplaceholder;

import io.siniavtsev.examples.jsonplaceholder.config.JsonPlaceholderEnvironmentConfig;
import io.siniavtsev.serenity.rest.steps.RestSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
abstract class JsonPlaceholderBaseTest {

    @Steps
    protected RestSteps restSteps;
    JsonPlaceholderEnvironmentConfig envConfig = new JsonPlaceholderEnvironmentConfig();

    @BeforeEach
    void commonSetup() {
        restSteps.setDefaultsFromEnvironmentConfig(envConfig);
    }
}
