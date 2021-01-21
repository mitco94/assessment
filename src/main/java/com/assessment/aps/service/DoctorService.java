package com.assessment.aps.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.assessment.aps.Modal.Doctor;

public interface DoctorService {

	Page<Doctor> getDoctorDetails(Specification<Doctor> spec, Pageable pageable);

}
