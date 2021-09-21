package org.airw4lk3r.petcare.repository;

import org.airw4lk3r.petcare.model.medicalhistory.MedicalHistory;
import org.springframework.data.repository.CrudRepository;

public interface MedicalHistoryRepository extends CrudRepository<MedicalHistory, Long> {
    MedicalHistory findByPetId(Long id);
}
