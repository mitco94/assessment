package com.assessment.aps.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.aps.Modal.Patient;
import com.assessment.aps.repo.PatientRepository;
import com.assessment.aps.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

	@Autowired
	private PatientRepository patientRepository;
	
	@Override
	public boolean isRegisteredPatient(int patientId) {
		boolean patient = patientRepository.existsById(patientId);
		if(!patient){
			return false;
		}else{
			return true;
		}
	}

	@Override
	public Patient registerPatient(Patient patient) {
		Patient savedPatientDetails = patientRepository.save(patient);
		System.out.println("--------------------------> "+ savedPatientDetails.getName() );
		return savedPatientDetails;
	}

}
