package org.airw4lk3r.petcare.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.airw4lk3r.petcare.model.medicalhistory.MedicalHistory;
import org.airw4lk3r.petcare.model.pet.Pet;
import org.airw4lk3r.petcare.repository.MedicalHistoryRepository;
import org.airw4lk3r.petcare.repository.PetRepository;
import org.springframework.stereotype.Service;

/**
 * PetService
 */

@Service
public class PetService implements IService<Pet, Long> {

    PetRepository pRepository;
    MedicalHistoryRepository mhRepository;

    public PetService(final PetRepository pRepository, final MedicalHistoryRepository mhRepository) {
        this.pRepository = pRepository;
        this.mhRepository = mhRepository;
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
        Pet nPet = pRepository.save(pet);

        MedicalHistory mh = new MedicalHistory();
        mh.setCreateDate(LocalDate.now());
        mh.setPet(nPet);

        mhRepository.save(mh);
    }
}