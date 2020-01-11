package org.airw4lk3r.petcare.service;

import java.util.ArrayList;
import java.util.List;

import org.airw4lk3r.petcare.model.pet.Owner;
import org.airw4lk3r.petcare.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * OwnerService
 */
@Service
public class OwnerService {

    @Autowired
    OwnerRepository oRepository;

    public List<Owner> getAll() {
        final List<Owner> owners = new ArrayList<Owner>();
        oRepository.findAll().forEach(r -> owners.add(r));

        return owners;
    }

    public Owner getById(final Long id) {
        return oRepository.findById(id).get();
    }

    public void createOrModifyOwner(final Owner owner) {
        oRepository.save(owner);
    }
}