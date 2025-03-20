package com.kng.medicalreports.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DOCTORS_SETUP",catalog="ECLINIC")
public class DoctorsSetup implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DOCTORS_ID")
	private int doctorId;
	
	@Column(name="DOCTORS_NAME")
	private String doctorName;
	
	@Column(name="DOCTORSNAME_AR")
	private String doctorNameAr;
	
	@Column(name="DOCTOR_TYPE")
	private String doctorType;
	
	@Column(name="TYPE")
	private int type;
	
	@Column(name="ICD_CODE")
	private String icdCode;
	
	@Column(name="ACTIVE_STATUS")
	private String activeStatus;
	
	@Column(name="CLINICIAN_USER")
	private String clinicianUser;

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorNameAr() {
		return doctorNameAr;
	}

	public void setDoctorNameAr(String doctorNameAr) {
		this.doctorNameAr = doctorNameAr;
	}

	public String getDoctorType() {
		return doctorType;
	}

	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIcdCode() {
		return icdCode;
	}

	public void setIcdCode(String icdCode) {
		this.icdCode = icdCode;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getClinicianUser() {
		return clinicianUser;
	}

	public void setClinicianUser(String clinicianUser) {
		this.clinicianUser = clinicianUser;
	}
	
	
	
}
