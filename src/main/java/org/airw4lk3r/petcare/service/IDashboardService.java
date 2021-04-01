package org.airw4lk3r.petcare.service;

import java.util.List;

public interface IDashboardService<T,ID> {
    
    public List<T> getSumaryPetInfo(final ID ownerId);
}
