package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_PAT_CLICK_ALL_V2",catalog="ECLINIC")
public class ViewPatientInfoToday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -168196270441677899L;
	
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
	/**
	 * 
	 */
	public ViewPatientInfoToday() {
		
	}
	
	
	
	public int getRow_num() {
		return row_num;
	}
	
	
	
	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}
	
	
	
	
	public String getCONSULT_ID() {
		return CONSULT_ID;
	}



	public void setCONSULT_ID(String cONSULT_ID) {
		CONSULT_ID = cONSULT_ID;
	}

	
	public String getCONSULT_DATE() {
		return CONSULT_DATE;
	}
	public void setCONSULT_DATE(String cONSULT_DATE) {
		CONSULT_DATE = cONSULT_DATE;
	}
	public String getPATIENT_EMPLOYEE_ID() {
		return PATIENT_EMPLOYEE_ID;
	}
	public void setPATIENT_EMPLOYEE_ID(String pATIENT_EMPLOYEE_ID) {
		PATIENT_EMPLOYEE_ID = pATIENT_EMPLOYEE_ID;
	}
	
	

	public String getDATE_OF_BIRTH() {
		return DATE_OF_BIRTH;
	}



	public void setDATE_OF_BIRTH(String dATE_OF_BIRTH) {
		DATE_OF_BIRTH = dATE_OF_BIRTH;
	}



	public String getPATIENT_CIVILID() {
		return PATIENT_CIVILID;
	}



	public void setPATIENT_CIVILID(String pATIENT_CIVILID) {
		PATIENT_CIVILID = pATIENT_CIVILID;
	}



	public String getPATIENTNAME_AR() {
		return PATIENTNAME_AR;
	}



	public void setPATIENTNAME_AR(String pATIENTNAME_AR) {
		PATIENTNAME_AR = pATIENTNAME_AR;
	}



	public String getDOCTOR_NAME_AR() {
		return DOCTOR_NAME_AR;
	}



	public void setDOCTOR_NAME_AR(String dOCTOR_NAME_AR) {
		DOCTOR_NAME_AR = dOCTOR_NAME_AR;
	}



	public String getDEPTNAME_AR() {
		return DEPTNAME_AR;
	}



	public void setDEPTNAME_AR(String dEPTNAME_AR) {
		DEPTNAME_AR = dEPTNAME_AR;
	}



	public String getOFFICENAME_AR() {
		return OFFICENAME_AR;
	}



	public void setOFFICENAME_AR(String oFFICENAME_AR) {
		OFFICENAME_AR = oFFICENAME_AR;
	}



	public String getPATIENT_KWT_NKWT() {
		return PATIENT_KWT_NKWT;
	}
	public void setPATIENT_KWT_NKWT(String pATIENT_KWT_NKWT) {
		PATIENT_KWT_NKWT = pATIENT_KWT_NKWT;
	}
	public String getPATIENT_NAME() {
		return PATIENT_NAME;
	}
	public void setPATIENT_NAME(String pATIENT_NAME) {
		PATIENT_NAME = pATIENT_NAME;
	}
	public String getPATIENT_DESIGNATION() {
		return PATIENT_DESIGNATION;
	}
	public void setPATIENT_DESIGNATION(String pATIENT_DESIGNATION) {
		PATIENT_DESIGNATION = pATIENT_DESIGNATION;
	}
	public String getPATIENT_AGE_DETAILED() {
		return PATIENT_AGE_DETAILED;
	}
	public void setPATIENT_AGE_DETAILED(String pATIENT_AGE_DETAILED) {
		PATIENT_AGE_DETAILED = pATIENT_AGE_DETAILED;
	}
	public String getDOCTOR_NAME() {
		return DOCTOR_NAME;
	}
	public void setDOCTOR_NAME(String dOCTOR_NAME) {
		DOCTOR_NAME = dOCTOR_NAME;
	}
	public String getDOCTOR_DESIG() {
		return DOCTOR_DESIG;
	}
	public void setDOCTOR_DESIG(String dOCTOR_DESIG) {
		DOCTOR_DESIG = dOCTOR_DESIG;
	}
	public String getDOCTOR_SPEC() {
		return DOCTOR_SPEC;
	}
	public void setDOCTOR_SPEC(String dOCTOR_SPEC) {
		DOCTOR_SPEC = dOCTOR_SPEC;
	}
	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}
	public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}
	public String getOFFICE_NAME() {
		OFFICE_NAME=this.OFFICE_NAME.replace("-MultiSpeciality","");
		return OFFICE_NAME;
	}
	public void setOFFICE_NAME(String oFFICE_NAME) {
		OFFICE_NAME = oFFICE_NAME;
	}
	public int getDOCTORS_ID() {
		return DOCTORS_ID;
	}
	public void setDOCTORS_ID(int dOCTORS_ID) {
		DOCTORS_ID = dOCTORS_ID;
	}
	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	
	
	
	public String getDOCTOR_EMPLOYEE_ID() {
		return DOCTOR_EMPLOYEE_ID;
	}
	public void setDOCTOR_EMPLOYEE_ID(String dOCTOR_EMPLOYEE_ID) {
		DOCTOR_EMPLOYEE_ID = dOCTOR_EMPLOYEE_ID;
	}
	
	
	
	public int getOFFICE_ID() {
		return OFFICE_ID;
	}
	public void setOFFICE_ID(int oFFICE_ID) {
		OFFICE_ID = oFFICE_ID;
	}



	
	
	
	
	@Override
	public String toString() {
		return "ViewPatientInfoToday [row_num=" + row_num + ", CONSULT_ID=" + CONSULT_ID + ", CONSULT_DATE="
				+ CONSULT_DATE + ", PATIENT_EMPLOYEE_ID=" + PATIENT_EMPLOYEE_ID + ", DATE_OF_BIRTH=" + DATE_OF_BIRTH
				+ ", PATIENT_CIVILID=" + PATIENT_CIVILID + ", PATIENT_KWT_NKWT=" + PATIENT_KWT_NKWT + ", PATIENT_NAME="
				+ PATIENT_NAME + ", PATIENTNAME_AR=" + PATIENTNAME_AR + ", PATIENT_DESIGNATION=" + PATIENT_DESIGNATION
				+ ", PATIENT_AGE_DETAILED=" + PATIENT_AGE_DETAILED + ", DOCTOR_NAME=" + DOCTOR_NAME
				+ ", DOCTOR_NAME_AR=" + DOCTOR_NAME_AR + ", DOCTOR_DESIG=" + DOCTOR_DESIG + ", DOCTOR_SPEC="
				+ DOCTOR_SPEC + ", DEPARTMENT_NAME=" + DEPARTMENT_NAME + ", DEPTNAME_AR=" + DEPTNAME_AR
				+ ", OFFICE_NAME=" + OFFICE_NAME + ", OFFICENAME_AR=" + OFFICENAME_AR + ", DOCTOR_EMPLOYEE_ID="
				+ DOCTOR_EMPLOYEE_ID + ", DOCTORS_ID=" + DOCTORS_ID + ", DEPARTMENT_ID=" + DEPARTMENT_ID
				+ ", OFFICE_ID=" + OFFICE_ID + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(CONSULT_DATE, CONSULT_ID, DATE_OF_BIRTH, DEPARTMENT_ID, DEPARTMENT_NAME, DEPTNAME_AR,
				DOCTORS_ID, DOCTOR_DESIG, DOCTOR_EMPLOYEE_ID, DOCTOR_NAME, DOCTOR_NAME_AR, DOCTOR_SPEC, OFFICENAME_AR,
				OFFICE_ID, OFFICE_NAME, PATIENTNAME_AR, PATIENT_AGE_DETAILED, PATIENT_CIVILID, PATIENT_DESIGNATION,
				PATIENT_EMPLOYEE_ID, PATIENT_KWT_NKWT, PATIENT_NAME, row_num);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewPatientInfoToday other = (ViewPatientInfoToday) obj;
		return Objects.equals(CONSULT_DATE, other.CONSULT_DATE) && Objects.equals(CONSULT_ID, other.CONSULT_ID)
				&& Objects.equals(DATE_OF_BIRTH, other.DATE_OF_BIRTH) && DEPARTMENT_ID == other.DEPARTMENT_ID
				&& Objects.equals(DEPARTMENT_NAME, other.DEPARTMENT_NAME)
				&& Objects.equals(DEPTNAME_AR, other.DEPTNAME_AR) && DOCTORS_ID == other.DOCTORS_ID
				&& Objects.equals(DOCTOR_DESIG, other.DOCTOR_DESIG)
				&& Objects.equals(DOCTOR_EMPLOYEE_ID, other.DOCTOR_EMPLOYEE_ID)
				&& Objects.equals(DOCTOR_NAME, other.DOCTOR_NAME)
				&& Objects.equals(DOCTOR_NAME_AR, other.DOCTOR_NAME_AR)
				&& Objects.equals(DOCTOR_SPEC, other.DOCTOR_SPEC) && Objects.equals(OFFICENAME_AR, other.OFFICENAME_AR)
				&& OFFICE_ID == other.OFFICE_ID && Objects.equals(OFFICE_NAME, other.OFFICE_NAME)
				&& Objects.equals(PATIENTNAME_AR, other.PATIENTNAME_AR)
				&& Objects.equals(PATIENT_AGE_DETAILED, other.PATIENT_AGE_DETAILED)
				&& Objects.equals(PATIENT_CIVILID, other.PATIENT_CIVILID)
				&& Objects.equals(PATIENT_DESIGNATION, other.PATIENT_DESIGNATION)
				&& Objects.equals(PATIENT_EMPLOYEE_ID, other.PATIENT_EMPLOYEE_ID)
				&& Objects.equals(PATIENT_KWT_NKWT, other.PATIENT_KWT_NKWT)
				&& Objects.equals(PATIENT_NAME, other.PATIENT_NAME) && row_num == other.row_num;
	}



	
	
}
