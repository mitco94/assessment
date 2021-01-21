package com.assessment.aps.Modal;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="Patient should give their details for booking a appointment with doctor")
@Entity
public class Patient {

	@Id
	private Integer patientId;
	
	@Size(min=2)
	@ApiModelProperty(notes="Name should have atleast two characters")
	private String name;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	@Past
	@ApiModelProperty(notes="Birth date should be in past")
	private Date birthDate;

	protected Patient(){
		
	}
	public Patient(int patientId, String name, Date birthDate) {
		super();
		this.patientId = patientId;
		this.name = name;
		this.birthDate = birthDate;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", name=" + name + ", birthDate=" + birthDate + "]";
	}
	
	
}
