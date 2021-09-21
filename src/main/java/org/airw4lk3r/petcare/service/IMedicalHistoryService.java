package org.airw4lk3r.petcare.service;

import java.util.List;

import org.airw4lk3r.petcare.model.medicalhistory.MedicalHistory;
import org.airw4lk3r.petcare.model.pet.Pet;
import org.airw4lk3r.petcare.repository.MedicalHistoryRepository;

public interface IMedicalHistoryService {
    public MedicalHistory createMedicalHistory(final Pet pet);
    public List<MedicalHistoryRepository> findAllMedicalRecords(final Long id);
}
