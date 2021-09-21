package org.airw4lk3r.petcare.service;

import java.util.ArrayList;
import java.util.List;

import org.airw4lk3r.petcare.model.appointment.Appointment;
import org.airw4lk3r.petcare.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * AppointmentService
 */
@Service
public class AppointmentService implements IService<Appointment, Long>, IAppointmentService {

    private final AppointmentRepository aRepository;

    @Autowired
    public AppointmentService(AppointmentRepository aRepository) {
        this.aRepository = aRepository;
    }

    @Override
    public List<Appointment> getAll() {
        final List<Appointment> appointments = new ArrayList<>();
        aRepository.findAll().forEach(appointments::add);

        return appointments;
    }

    @Override
    public Appointment getById(final Long id) {
        return aRepository.findById(id).get();
    }

    @Override
    public void createOrModify(final Appointment appointment) {       
        aRepository.save(appointment);
    }

    @Override
    public List<Appointment> getAllByPetId(final Long petId) {
        final List<Appointment> appointments = new ArrayList<>();
        aRepository.findAllByPetId(petId).forEach(appointments::add);

        return appointments;
    }

}