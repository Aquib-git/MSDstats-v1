package com.kng.medicalreports.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="VIEW_MRD_PAT_DEMOGRAPH_FETCH_ALL_V2",catalog="ECLINIC")
public class ViewMrdPatDemo 
{
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="OP_NUMBER")
	private String OP_NUMBER;
	
	@Column(name="PATIENT_NAME")
	private String PATIENT_NAME;
	
	@Column(name="PATIENTNAME_AR")
	private String PATIENTNAME_AR;
	
	@Column(name="DATE_OF_BIRTH")
	private String DATE_OF_BIRTH;
	
	@Column(name="PATIENT_AGE_DETAILED")
	private String PATIENT_AGE_DETAILED;
	
	@Column(name="PATIENT_DESIGNATION")
	private String PATIENT_DESIGNATION;
	
	@Column(name="PATIENT_EMPLOYEE_ID")
	private String PATIENT_EMPLOYEE_ID;
	
	@Column(name="PATIENT_CIVILID")
	private String PATIENT_CIVILID;
	
	@Column(name="PATIENT_KWT_NKWT")
	private String PATIENT_KWT_NKWT;
}
