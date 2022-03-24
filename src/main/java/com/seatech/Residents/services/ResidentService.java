package com.seatech.Residents.services;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.seatech.Residents.entity.ResidentEntity;
import com.seatech.Residents.model.Resident;
import com.seatech.Residents.repositories.ResidentRepositoryInterface;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//@Component
@Service
public class ResidentService implements ResidentServiceInterface{

    private ResidentRepositoryInterface residentRepositoryInterface;

    public ResidentService(ResidentRepositoryInterface residentRepositoryInterface) {
        this.residentRepositoryInterface = residentRepositoryInterface;
    }

    @Override
    public Resident createResident(Resident resident) {
        ResidentEntity residentEntity = new ResidentEntity();
        //creates a residentEntity object

        BeanUtils.copyProperties(resident,residentEntity);
        //copies the properties of the resident object to the residentEntity object

        residentRepositoryInterface.save(residentEntity);
        //Makes use the JPA repository to save residentEntity data

        return resident;
    }

    @Override
    public List<Resident> getAllResidents() {
        List<ResidentEntity> residentEntities = residentRepositoryInterface.findAll();

        List<Resident> residents = residentEntities
                .stream()
                .map(res -> new Resident(
                        res.getId(),
                        res.getResidentId(),
                        res.getEmail(),
                        res.getResidentName()))
                .collect(Collectors.toList());

        return residents;
    }


}
