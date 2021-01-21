package com.assessment.aps.Modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description="You can find doctor details here")
@Entity
public class Doctor {

	@Id
	@GeneratedValue
	private String doctorId;
	
	@Size(min=2)
	@ApiModelProperty(notes="Name should have atleast two characters")
	private String doctorName;
	
	private String speciality;
	
	private String qualification;
	
	protected Doctor(){
		
	}
	
	public Doctor(String doctorId, String doctorName, String speciality, String qualification) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.speciality = speciality;
		this.qualification = qualification;
	}
	public String getDoctorId(){
		return doctorId;
	}
	public void setDoctorId(String doctorId){
		this.doctorId = doctorId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Override
	public String toString() {
		return "Doctor [doctorId=" + doctorId + ", doctorName=" + doctorName + ", speciality=" + speciality
				+ ", qualification=" + qualification + "]";
	}
	
}
