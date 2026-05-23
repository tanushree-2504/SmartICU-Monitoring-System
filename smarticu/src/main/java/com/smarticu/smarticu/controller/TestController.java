package com.smarticu.smarticu.controller;
import com.smarticu.smarticu.entity.Patient;
import com.smarticu.smarticu.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
public class TestController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/test")
    public String test() {
        return "SmartICU is running!";
    }

    @GetMapping("/all")
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient) {
        return patientRepository.save(patient);
    }

    @GetMapping("/addtest")
    public Patient addTestPatient() {

        Patient p = new Patient();

        p.setName("Sneha");
        p.setAge(30);
        p.setDisease("Asthma");

        return patientRepository.save(p);
    }
}