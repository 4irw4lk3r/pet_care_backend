package org.airw4lk3r.petcare.service;

import java.util.ArrayList;
import java.util.List;

import org.airw4lk3r.petcare.model.pet.Pet;
import org.airw4lk3r.petcare.repository.PetRepository;
import org.springframework.stereotype.Service;

/**
 * PetService
 */

@Service
public class PetService implements IService<Pet, Long> {

    PetRepository pRepository;

    public PetService(final PetRepository pRepository) {
        this.pRepository = pRepository;
    }

    @Override
    public List<Pet> getAll() {
        final List<Pet> pets = new ArrayList<Pet>();
        pRepository.findAll().forEach(pets::add);

        return pets;
    }

    @Override
    public Pet getById(final Long id) {
        return pRepository.findById(id).get();
    }

    @Override
    public void createOrModify(final Pet pet) {
        pRepository.save(pet);
    }
}