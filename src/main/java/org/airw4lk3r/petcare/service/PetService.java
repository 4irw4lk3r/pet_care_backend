package org.airw4lk3r.petcare.service;

import java.util.ArrayList;
import java.util.List;

import org.airw4lk3r.petcare.model.pet.Pet;
import org.airw4lk3r.petcare.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PetService
 */

@Service
public class PetService {

    @Autowired
    PetRepository pRepository;

    public List<Pet> getAll() {
        final List<Pet> pets = new ArrayList<Pet>();
        pRepository.findAll().forEach(r -> pets.add(r));

        return pets;
    }

    public Pet getById(final Long id) {
        return pRepository.findById(id).get();
    }

    public void createOrmodifyPet(final Pet pet) {
        pRepository.save(pet);
    }
}