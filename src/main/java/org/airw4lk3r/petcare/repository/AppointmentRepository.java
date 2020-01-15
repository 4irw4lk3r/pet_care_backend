package org.airw4lk3r.petcare.repository;

import org.airw4lk3r.petcare.model.appointment.Appointment;
import org.springframework.data.repository.CrudRepository;

/**
 * AppointmentRepository
 */
public interface AppointmentRepository extends CrudRepository<Appointment, Long>{

    
}