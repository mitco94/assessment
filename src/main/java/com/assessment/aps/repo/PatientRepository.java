package com.assessment.aps.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assessment.aps.Modal.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>{

}
