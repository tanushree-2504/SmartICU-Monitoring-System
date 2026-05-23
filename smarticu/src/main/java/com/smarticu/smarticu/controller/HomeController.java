package com.smarticu.smarticu.controller;

import com.smarticu.smarticu.entity.Patient;
import com.smarticu.smarticu.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private PatientRepository patientRepository;

    // =============================
    // DASHBOARD PAGE
    // =============================

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("patients",
                patientRepository.findAll());

        return "index";
    }

    // =============================
    // ADD PATIENT
    // =============================

    @PostMapping("/addPatient")
    public String addPatient(@RequestParam String name,
                             @RequestParam int age,
                             @RequestParam String disease,
                             @RequestParam int heartRate,
                             @RequestParam int oxygenLevel,
                             @RequestParam String bloodPressure) {

        Patient patient = new Patient();

        patient.setName(name);
        patient.setAge(age);
        patient.setDisease(disease);

        patient.setHeartRate(heartRate);
        patient.setOxygenLevel(oxygenLevel);
        patient.setBloodPressure(bloodPressure);

        // =============================
        // AI STATUS LOGIC
        // =============================

        if (oxygenLevel < 85 || heartRate > 130) {

            patient.setStatus("Critical");

        }
        else if (oxygenLevel < 95 || heartRate > 100) {

            patient.setStatus("Monitoring");

        }
        else {

            patient.setStatus("Stable");
        }

        // SAVE PATIENT

        patientRepository.save(patient);

        // Redirect prevents duplicate submission

        return "redirect:/";
    }

    // =============================
    // DELETE PATIENT
    // =============================

    @PostMapping("/deletePatient/{id}")
    public String deletePatient(@PathVariable Long id) {

        if (patientRepository.existsById(id)) {

            patientRepository.deleteById(id);
        }

        return "redirect:/";
    }
}