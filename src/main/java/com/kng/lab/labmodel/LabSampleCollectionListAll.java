package com.kng.lab.labmodel;

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
@Table(name="VIEW_LAB_SC_LIST_ALL",catalog="ECLINIC")
public class LabSampleCollectionListAll 
{
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="CONSULT_ID")
	private String CONSULT_ID;
	
	@Column(name="TEST_DETAILSID")
	private String TEST_DETAILSID;
	
	@Column(name="TEST_DATE")
	private String TEST_DATE;
	
	@Column(name="LAB_IDNO")
	private String LAB_IDNO;
	
	@Column(name="CONTAINER_ID")
	private int CONTAINER_ID;
	
	@Column(name="CONTAINER")
	private String CONTAINER;
	
	@Column(name="COLOR")
	private String COLOR;
	
	@Column(name="TEST_ID")
	private int TEST_ID;
	
	@Column(name="TEST_NAME")
	private String TEST_NAME;
	
	@Column(name="CATEGORY_ID")
	private int CATEGORY_ID;
	
	@Column(name="CATEGORY_NAME")
	private String CATEGORY_NAME;
	
	@Column(name="PATIENT_EMPLOYEE_ID")
	private String PATIENT_EMPLOYEE_ID;
	
	@Column(name="PATIENT_NAME")
	private String PATIENT_NAME;
	
	@Column(name="PATIENTNAME_AR")
	private String PATIENTNAME_AR;
	
	@Column(name="DOCTORS_ID")
	private int DOCTORS_ID;
	
	@Column(name="DOCTOR_NAME")
	private String DOCTOR_NAME;
	
	@Column(name="DOCTOR_NAME_AR")
	private String DOCTOR_NAME_AR;

	@Column(name="DEPARTMENT_ID")
	private int DEPARTMENT_ID;
	
	@Column(name="DEPARTMENT_NAME")
	private String DEPARTMENT_NAME;
	
	@Column(name="DEPTNAME_AR")
	private String DEPTNAME_AR;
	
	@Column(name="OFFICE_ID")
	private int OFFICE_ID;
	
	@Column(name="OFFICE_NAME")
	private String OFFICE_NAME;
	
	@Column(name="OFFICENAME_AR")
	private String OFFICENAME_AR;
	
	@Column(name="ENTEREDBY")
	private int ENTEREDBY;
	
	@Column(name="USER_LABEL")
	private String USER_LABEL;
	
	@Column(name="SAMPLE_COLLECT_DATE")
	private String SAMPLE_COLLECT_DATE;
	
	@Column(name="SAMPLE_COLLECT_TIME")
	private String SAMPLE_COLLECT_TIME;
	
	@Column(name="SAMPLE_COLLECT_BY")
	private int SAMPLE_COLLECT_BY;
	
	@Column(name="SAMPLE_PERSON_NAME")
	private String SAMPLE_PERSON_NAME;
	
	public String getOFFICE_NAME() {
		
		OFFICE_NAME=this.OFFICE_NAME.replace("-MultiSpeciality","");
		
		return OFFICE_NAME;
	}
}















