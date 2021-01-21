package com.assessment.aps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.assessment.aps.Modal.Appointment;
import com.assessment.aps.service.AppointmentService;
import com.sun.el.stream.Optional;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	AppointmentService appointmentService;

	@ResponseBody
	@GetMapping("/doctors/{doctorId}")
	public ResponseEntity<?> getPredefinedAppointments(@PathVariable int doctorId) {
		java.util.Optional<Appointment> doctorAppointmentList = appointmentService
				.getDoctorAppointmentDetails(doctorId);
		return new ResponseEntity<>(doctorAppointmentList, HttpStatus.OK);

	}
}
