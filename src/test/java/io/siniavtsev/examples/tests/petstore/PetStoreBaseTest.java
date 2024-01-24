package io.siniavtsev.examples.tests.petstore;

import io.siniavtsev.examples.petstore.steps.PetStoreSteps;
import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SerenityJUnit5Extension.class)
public abstract class PetStoreBaseTest {

    @Steps
    protected PetStoreSteps petStoreSteps;

    @BeforeEach
    void commonSetup() {
        petStoreSteps.applyEnvConfig();
    }

}
