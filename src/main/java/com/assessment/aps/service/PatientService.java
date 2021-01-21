package com.assessment.aps.service;

import com.assessment.aps.Modal.Patient;

public interface PatientService {

	public boolean isRegisteredPatient(int patientId);

	public Patient registerPatient(Patient patient);
	
}
