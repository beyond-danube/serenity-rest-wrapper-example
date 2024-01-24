package io.siniavtsev.examples.tests.petstore.pets;

import io.siniavtsev.examples.tests.petstore.PetStoreBaseTest;
import io.swagger.petstore.model.Pet;
import net.serenitybdd.core.Serenity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;

class ViewPetsFromStore extends PetStoreBaseTest {


    @Test
    void getPetFromStoreByID () {
        petStoreSteps.createAndStoreRandomPetRequest();
        petStoreSteps.createPetWithStoredRequest();

        var pet = petStoreSteps.getPetFromStore(petStoreSteps.getPetRequest().getId());
        Serenity.reportThat("Check got Pet from Store with ID as requested", () -> assertThat(pet.getId()).isEqualTo(petStoreSteps.getPetRequest().getId()));
        Serenity.reportThat("Check Pet's Status is returned as expected: " + petStoreSteps.getPetRequest().getStatus(), () -> assertThat(pet.getId()).isEqualTo(petStoreSteps.getPetRequest().getId()));
    }

    @ParameterizedTest
    @EnumSource(Pet.StatusEnum.class)
    void findPetByStatus(Pet.StatusEnum petStatus) {
        var pets = petStoreSteps.getPetsByStatus(petStatus.toString());

        Serenity.reportThat("Check every Pet returned with Status as requested: " + petStatus, () ->
                pets.forEach(pet -> Serenity.reportThat(format("Check Pet: %s, ID %s", pet.getName(), pet.getId()), () ->
                        assertThat(pet.getStatus()).isEqualTo(petStatus)
                ))
        );
    }
}
