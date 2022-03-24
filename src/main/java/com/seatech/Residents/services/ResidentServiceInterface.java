package com.seatech.Residents.services;

import com.seatech.Residents.model.Resident;

import java.util.List;

public interface ResidentServiceInterface {
    Resident createResident(Resident resident);

    List<Resident> getAllResidents();
}
