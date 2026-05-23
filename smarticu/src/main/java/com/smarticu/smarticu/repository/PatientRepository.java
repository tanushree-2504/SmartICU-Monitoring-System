package com.smarticu.smarticu.repository;

import com.smarticu.smarticu.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}