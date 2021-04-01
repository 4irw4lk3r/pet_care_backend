package org.airw4lk3r.petcare.service;

import java.util.List;

public interface IAppointmentService<T,ID> {
    public List<T> getAllByPetId(final ID petId);
}
