package io.siniavtsev.examples.tests.petstore.pets;

import io.siniavtsev.examples.tests.petstore.PetStoreBaseTest;
import net.serenitybdd.core.Serenity;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

class ModifyPetsInStore extends PetStoreBaseTest {

    @Test
    void addPetToStore() {
        petStoreSteps.createAndStoreRandomPetRequest();
        petStoreSteps.createPetWithStoredRequest();

        var expetedPet = petStoreSteps.getPetRequest();

        var pet = petStoreSteps.getPetFromStore(petStoreSteps.getPetRequest().getId());
        Serenity.reportThat(format("Check can get Pet from Store exactly as just created\n| ID | Name | Status |\n| %s | %s | %s |",
                expetedPet.getId(),
                expetedPet.getName(),
                expetedPet.getStatus()), () ->
                assertThat(pet)
                        .usingRecursiveComparison()
                        .isEqualTo(expetedPet)
        );
    }
}
