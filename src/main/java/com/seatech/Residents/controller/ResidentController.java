package com.seatech.Residents.controller;

import com.seatech.Residents.model.Resident;
import com.seatech.Residents.services.ResidentServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Allow localhost 3000 (ui) to make requests
@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("api/v1")
public class ResidentController {

    @Autowired
    private ResidentServiceInterface residentServiceInterface;
    //Dependency injection

    public ResidentController(ResidentServiceInterface residentServiceInterface) {
        this.residentServiceInterface = residentServiceInterface;
    }

    @PostMapping("/residents") // "api/v1/residents"
    public Resident createResident(@RequestBody Resident resident){
        return residentServiceInterface.createResident(resident);
    }

    @GetMapping("/residents" )
    public List<Resident> getResidents(){
        return residentServiceInterface.getAllResidents();
    }

}
