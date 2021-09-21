package org.airw4lk3r.petcare.service;

import java.util.List;

import org.airw4lk3r.petcare.model.dto.DashboardDTO;

public interface IDashboardService {
    
    public List<DashboardDTO> getSumaryPetInfo(final Long ownerId);
}
