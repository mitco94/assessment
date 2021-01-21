package com.assessment.aps.Modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;


@ApiModel(description="All the appointment details of Doctor")
@Entity
public class Appointment {

	@Id
	private int doctorId;
	private Date appointmentDate;
	private String slotStatus;

	protected Appointment() {

	}

	public Appointment(int doctorId, Date appointmentDate, String slotStatus) {
		super();
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.slotStatus = slotStatus;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getSlotStatus() {
		return slotStatus;
	}

	public void setSlotStatus(String slotStatus) {
		this.slotStatus = slotStatus;
	}

	@Override
	public String toString() {
		return "Appointment [doctorId=" + doctorId + ", appointmentDate=" + appointmentDate + ", slotStatus="
				+ slotStatus + "]";
	}

}
