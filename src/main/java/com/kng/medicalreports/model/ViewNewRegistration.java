package com.kng.medicalreports.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kng.lab.labmodel.LabSampleCollectionListAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="VIEW_NR",catalog="ECLINIC_KNG")
public class ViewNewRegistration 
{
	@Id
	@Column(name="OP_ID")
	private Integer opId;
	
	@Column(name="PATIENT_EMPLOYEE_ID")
	private String patientEmployeeId;
	
	@Column(name="PATIENT_NAME")
	private String patientName;
	
}
