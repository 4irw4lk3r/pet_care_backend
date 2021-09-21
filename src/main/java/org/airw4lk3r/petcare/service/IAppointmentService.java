package org.airw4lk3r.petcare.service;

import java.util.List;

import org.airw4lk3r.petcare.model.appointment.Appointment;

public interface IAppointmentService {
    public List<Appointment> getAllByPetId(final Long id);
}
