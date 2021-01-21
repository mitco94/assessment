package com.assessment.aps.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.assessment.aps.Modal.Patient;
import com.assessment.aps.exception.PatientNotFoundException;
import com.assessment.aps.service.PatientService;

@RestController
// @RequestMapping("/api")
public class PatientController {

	@Autowired
	PatientService patientService;

	@ResponseBody
	@GetMapping("/patients/{patientId}")
	public ResponseEntity<?> patient(@PathVariable int patientId) {
		boolean isExistingPatient = patientService.isRegisteredPatient(patientId);
		if (isExistingPatient) {
			return new ResponseEntity<String>("Patient details already in db",HttpStatus.OK);
		} else {
			throw new PatientNotFoundException("PatientId -" + patientId);
		}
	}

	@ResponseBody
	@PostMapping("/patients")
	public ResponseEntity<?> registerPatient(@RequestBody Patient patient) {
		Patient savedPatientDetails = patientService.registerPatient(patient);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{patientId}")
				.buildAndExpand(savedPatientDetails.getPatientId()).toUri();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setLocation(location);
		return new ResponseEntity<String>("Patient Details stored successfully", responseHeaders, HttpStatus.CREATED);

	}

}
