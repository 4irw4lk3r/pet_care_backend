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
public class OwnerService implements IService<Owner, Long> {

    @Autowired
    OwnerRepository oRepository;

    @Override
    public List<Owner> getAll() {
        final List<Owner> owners = new ArrayList<Owner>();
        oRepository.findAll().forEach(r -> owners.add(r));

        return owners;
    }

    @Override
    public Owner getById(final Long id) {
        return oRepository.findById(id).get();
    }

    @Override
    public void createOrModify(final Owner owner) {
        oRepository.save(owner);
    }
}