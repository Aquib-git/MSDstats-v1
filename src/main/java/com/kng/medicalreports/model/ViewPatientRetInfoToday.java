package com.kng.medicalreports.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="VIEW_PAT_CLICK_ALL_RET",catalog="ECLINIC")
public class ViewPatientRetInfoToday 
{
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
	
	@Column(name="CONSULT_ID")
	private String CONSULT_ID;
	
	@Column(name="CONSULT_DATE")
	private String CONSULT_DATE;
	
	@Column(name="PATIENT_EMPLOYEE_ID")
	private String PATIENT_EMPLOYEE_ID;
	
	@Column(name="DATE_OF_BIRTH")
	private String DATE_OF_BIRTH;
	
	@Column(name="PATIENT_CIVILID")
	private String PATIENT_CIVILID;
	
	@Column(name="PATIENT_KWT_NKWT")
	private String PATIENT_KWT_NKWT;
	
	@Column(name="PATIENT_NAME")
	private String PATIENT_NAME;
	

	@Column(name="PATIENTNAME_AR")
	private String PATIENTNAME_AR;
	
	@Column(name="PATIENT_DESIGNATION")
	private String PATIENT_DESIGNATION;
	
	@Column(name="PATIENT_AGE_DETAILED")
	private String PATIENT_AGE_DETAILED;
	
	@Column(name="DOCTOR_NAME")
	private String DOCTOR_NAME;
	
	
	@Column(name="DOCTOR_NAME_AR")
	private String DOCTOR_NAME_AR;

	
	@Column(name="DOCTOR_DESIG")
	private String DOCTOR_DESIG;

	
	@Column(name="DOCTOR_SPEC")
	private String DOCTOR_SPEC;
	
	@Column(name="DEPARTMENT_NAME")
	private String DEPARTMENT_NAME;
	
	@Column(name="DEPTNAME_AR")
	private String DEPTNAME_AR;
	
	@Column(name="OFFICE_NAME")
	private String OFFICE_NAME;
	
	@Column(name="OFFICENAME_AR")
	private String OFFICENAME_AR;
	
	
	@Column(name="DOCTOR_EMPLOYEE_ID")
	private String DOCTOR_EMPLOYEE_ID;
	
	
	@Column(name="DOCTORS_ID")
	private int DOCTORS_ID;
	
	@Column(name="DEPARTMENT_ID")
	private int DEPARTMENT_ID;
	
	
	@Column(name="OFFICE_ID")
	private int OFFICE_ID;
	
	@Column(name="RET_NOTRET")
	private String RET_NOTRET;
	
	public String getOFFICE_NAME() {
		
		OFFICE_NAME=this.OFFICE_NAME.replace("-MultiSpeciality","");
		
		return OFFICE_NAME;
	}

}
