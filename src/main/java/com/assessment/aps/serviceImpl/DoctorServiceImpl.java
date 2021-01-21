package com.assessment.aps.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.assessment.aps.Modal.Doctor;
import com.assessment.aps.repo.DoctorRepository;
import com.assessment.aps.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

	@Autowired
	private DoctorRepository doctorRepository;
	@Override
	public Page<Doctor> getDoctorDetails(Specification<Doctor> spec, Pageable pageable) {
		return doctorRepository.findAll(spec, pageable);
	}

}
