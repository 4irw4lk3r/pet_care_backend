package org.airw4lk3r.petcare;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.airw4lk3r.petcare.model.pet.Pet;
import org.airw4lk3r.petcare.model.pet.Species;
import org.airw4lk3r.petcare.service.PetService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest
public abstract class PetTest {
	
	@Autowired
    private MockMvc mockMvc;

	@MockBean
	private PetService petService;

	public void findAll() throws Exception{
		Pet pet = new Pet();

		pet.setId(1L);
		pet.setName("Valente");
		pet.setSpecies(Species.DOG);
		pet.setAge(6);

		List<Pet> pets = new ArrayList<>();
		pets.add(pet);

		given(petService.getAll()).willReturn(pets);

		// when + then
        this.mockMvc.perform(get("/pet"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'name': 'Valente';'species': 'DOG'; age:'6'}]"));
	}


}
