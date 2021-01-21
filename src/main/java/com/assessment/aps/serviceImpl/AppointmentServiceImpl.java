package com.assessment.aps.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assessment.aps.Modal.Appointment;
import com.assessment.aps.repo.AppointmentRepository;
import com.assessment.aps.service.AppointmentService;
@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	AppointmentRepository appointmentRepository;
	
	@Override
	public Optional<Appointment> getDoctorAppointmentDetails(int doctorId) {
		Optional<Appointment> doctorAppointmentList= appointmentRepository.findById(doctorId);
		return doctorAppointmentList;
	}

}
