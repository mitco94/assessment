package com.assessment.aps.service;

import java.util.Optional;

import com.assessment.aps.Modal.Appointment;

public interface AppointmentService {

	Optional<Appointment> getDoctorAppointmentDetails(int doctorId);
}
