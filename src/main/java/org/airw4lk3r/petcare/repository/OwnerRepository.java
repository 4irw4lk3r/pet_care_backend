package org.airw4lk3r.petcare.repository;

import org.airw4lk3r.petcare.model.pet.Owner;
import org.springframework.data.repository.CrudRepository;


/**
 * OwnerRepository
 */
public interface OwnerRepository extends CrudRepository <Owner, Long>{

    
}