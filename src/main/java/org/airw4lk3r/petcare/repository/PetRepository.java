package org.airw4lk3r.petcare.repository;

import org.airw4lk3r.petcare.model.pet.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * PetRepository
 */
public interface PetRepository extends CrudRepository<Pet, Long>   {
    
}