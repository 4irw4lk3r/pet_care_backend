package org.airw4lk3r.petcare.service;

import java.time.LocalDate;
import java.util.List;

import org.airw4lk3r.petcare.model.medicalhistory.MedicalHistory;
import org.airw4lk3r.petcare.model.pet.Pet;
import org.airw4lk3r.petcare.repository.MedicalHistoryRepository;
import org.airw4lk3r.petcare.repository.MedicalRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalHistoryService implements IMedicalHistoryService {

    MedicalHistoryRepository mhRepository;
    MedicalRecordRepository mrRepository;

    @Autowired
    public MedicalHistoryService(MedicalHistoryRepository mhRepository, MedicalRecordRepository mrRepository) {
        this.mhRepository = mhRepository;
        this.mrRepository = mrRepository;
    }

    @Override
    public MedicalHistory createMedicalHistory(Pet pet) {
        MedicalHistory nMedicalHistory = mhRepository.findByPetId(pet.getId());

        if (nMedicalHistory == null) {

            nMedicalHistory = new MedicalHistory();
            nMedicalHistory.setCreateDate(LocalDate.now());
            nMedicalHistory.setPet(pet);

            mhRepository.save(nMedicalHistory);
        }

        return nMedicalHistory;
    }

    @Override
    public List<MedicalHistoryRepository> findAllMedicalRecords(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
