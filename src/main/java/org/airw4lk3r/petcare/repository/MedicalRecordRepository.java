package org.airw4lk3r.petcare.repository;

import java.util.List;

import org.airw4lk3r.petcare.model.medicalhistory.MedicalRecord;
import org.springframework.data.repository.CrudRepository;

public interface MedicalRecordRepository extends CrudRepository<MedicalRecord, Long> {
    List<MedicalRecord> findAllById(Long id);
}
