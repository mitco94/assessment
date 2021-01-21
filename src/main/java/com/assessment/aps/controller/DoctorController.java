package com.assessment.aps.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.aps.Modal.Doctor;
import com.assessment.aps.service.DoctorService;

import net.kaczmarzyk.spring.data.jpa.domain.Like;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Or;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
	
	@Autowired
	DoctorService doctorService;

	@ResponseBody
	@GetMapping
	public ResponseEntity<?> searchDoctor(
			@Or({
				@Spec(path = "doctorName", params = "doctorName", spec = Like.class),
				@Spec(path = "speciality", params = "speciality", spec = Like.class),
				@Spec(path = "qualification", params = "qualification", spec = Like.class)
			}) 
			Specification<Doctor> spec, 
			Pageable pageable) throws IOException{
			
		Page<Doctor> response = doctorService.getDoctorDetails(spec, pageable);
				return new ResponseEntity<>(response.getContent(), HttpStatus.OK);
		
	}
		
}
