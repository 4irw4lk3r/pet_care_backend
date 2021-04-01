/*package org.airw4lk3r.petcare.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.airw4lk3r.petcare.model.pet.Owner;
import org.airw4lk3r.petcare.model.pet.Pet;
import org.airw4lk3r.petcare.model.pet.Species;
import org.airw4lk3r.petcare.repository.PetRepository;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class PetServiceTest {

     private static List<Pet> pets;
    
     @Autowired
     private PetService service;

    // @BeforeEach
    // public void setup() {        
    //     pets = generateListPets();

    //     // repository = mock(PetRepository.class);
    //     // service = new PetService(repository);
    // }

    // @Test
    // public void getAllTest() {
    //     when(repository.findAll()).thenReturn(pets);

    //     assertNotNull(service.getAll());
    // }

    // private static List<Pet> generateListPets() {
    //     List<Pet> pets = new ArrayList<Pet>();

    //     for (int i = 1; i < 4; i++) {
    //         Pet pet = new Pet();
    //         pet.setId(Long.valueOf(i));
    //         pet.setAge(new Random().nextInt());
    //         pet.setName("Pet" + i);
    //         pet.setOwner(mock(Owner.class));
    //         pet.setSpecies(mock(Species.class));

    //         pets.add(pet);
    //     }

    //     return pets;
    // }

}//*/