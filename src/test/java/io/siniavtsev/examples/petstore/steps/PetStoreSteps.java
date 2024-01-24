package io.siniavtsev.examples.petstore.steps;

import com.github.javafaker.Faker;
import io.siniavtsev.examples.petstore.config.PetStoreEnvironmentConfig;
import io.siniavtsev.serenity.rest.steps.RestSteps;
import io.swagger.petstore.model.Pet;
import lombok.Getter;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.annotations.Steps;

import java.util.HashMap;
import java.util.List;

import static io.siniavtsev.examples.utils.RandomEnumValue.randomEnumValue;
import static io.siniavtsev.examples.utils.RandomUnsignedLong.randomUnsignedLong;

public class PetStoreSteps {

    @Steps
    RestSteps getRestSteps;

    @Steps
    RestSteps editRestSteps;

    Faker faker = new Faker();

    @Getter
    Pet petRequest = new Pet();

    static final String PET_BASE_ENDPOINT = "pet";

    static final PetStoreEnvironmentConfig envConfig = new PetStoreEnvironmentConfig();

    public void applyEnvConfig() {
        getRestSteps.setDefaultsFromEnvironmentConfig(envConfig);
        editRestSteps.setDefaultsFromEnvironmentConfig(envConfig);
    }

    @Step
    public Pet getPetFromStore(Long petId) {
        getRestSteps.setEndpoint(PET_BASE_ENDPOINT + "/" + petId);
        return getRestSteps.getResponseObject(Pet.class);
    }

    @Step
    public List<Pet> getPetsByStatus(String status) {
        getRestSteps.setEndpoint(PET_BASE_ENDPOINT + "/findByStatus");
        getRestSteps.setQueryParameters(new HashMap<>() {{ put("status", status); }});

        return getRestSteps.getResponseObjectsList(Pet.class);
    }

    @Step
    public void createAndStoreRandomPetRequest() {
        petRequest.name(faker.funnyName().name()).id(randomUnsignedLong()).status(randomEnumValue(Pet.StatusEnum.class));
    }

    @Step
    public Pet createPetWithStoredRequest() {
        editRestSteps.setEndpoint(PET_BASE_ENDPOINT);
        editRestSteps.setRequestBodyDecorated(petRequest);

        return editRestSteps.getPostResponseObject(Pet.class);
    }

    @Step
    public Pet updatePetWithStoredRequest(Long petIdToUpdate) {
        petRequest.id(petIdToUpdate);
        editRestSteps.setRequestBodyDecorated(petRequest);

        return editRestSteps.getPutResponseObject(Pet.class);
    }
}
