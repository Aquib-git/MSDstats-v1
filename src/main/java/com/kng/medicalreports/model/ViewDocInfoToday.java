package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_DOC_CLICK_ALL_V2",catalog="ECLINIC")
public class ViewDocInfoToday implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1265671745607875385L;
	

	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="CONSULT_DATE")
	private String CONSULT_DATE;
	
	/*
	 * @Column(name="CONSULT_ID") private int CONSULT_ID;
	 */

	@Column(name="DEPARTMENT_NAME")
	private String DEPARTMENT_NAME;
	
	@Column(name="DOCTOR_NAME")
	private String DOCTOR_NAME;
	
	@Column(name="DOCTOR_RANK")
	private String DOCTOR_RANK;
	
	@Column(name="OFFICE_NAME")
	private String OFFICE_NAME;
	
	@Column(name="KNG_MOH")
	private String KNG_MOH;
	
	@Column(name="DOCTOR_DESIG")
	private String DOCTOR_DESIG;
	
	@Column(name="DOCTOR_SPEC")
	private String DOCTOR_SPEC;

		
	@Column(name="DEPARTMENT_ID")
	private int DEPARTMENT_ID;
	
	@Column(name="DOCTOR_EMPLOYEE_ID")
	private int DOCTOR_EMPLOYEE_ID;
	
	@Column(name="DOCTORS_ID")
	private int DOCTORS_ID;
	
	
	
	@Column(name="OFFICE_ID")
	private int OFFICE_ID;
	
	@Column(name="PATIENT_COUNT")
	private int PATIENT_COUNT;

	public int getRow_num() {
		return row_num;
	}

	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}

	public String getCONSULT_DATE() {
		return CONSULT_DATE;
	}

	public void setCONSULT_DATE(String cONSULT_DATE) {
		CONSULT_DATE = cONSULT_DATE;
	}

	public String getDEPARTMENT_NAME() {
		return DEPARTMENT_NAME;
	}

	public void setDEPARTMENT_NAME(String dEPARTMENT_NAME) {
		DEPARTMENT_NAME = dEPARTMENT_NAME;
	}

	public String getDOCTOR_NAME() {
		return DOCTOR_NAME;
	}

	public void setDOCTOR_NAME(String dOCTOR_NAME) {
		DOCTOR_NAME = dOCTOR_NAME;
	}
	

	public String getDOCTOR_RANK() {
		return DOCTOR_RANK;
	}

	public void setDOCTOR_RANK(String dOCTOR_RANK) {
		DOCTOR_RANK = dOCTOR_RANK;
	}

	public String getOFFICE_NAME() {
		OFFICE_NAME=this.OFFICE_NAME.replace("-MultiSpeciality","");
		return OFFICE_NAME;
	}

	public void setOFFICE_NAME(String oFFICE_NAME) {
		OFFICE_NAME = oFFICE_NAME;
	}

	public String getKNG_MOH() {
		return KNG_MOH;
	}

	public void setKNG_MOH(String kNG_MOH) {
		KNG_MOH = kNG_MOH;
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


	public int getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}

	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}

	public int getDOCTORS_ID() {
		return DOCTORS_ID;
	}

	
	
	public int getDOCTOR_EMPLOYEE_ID() {
		return DOCTOR_EMPLOYEE_ID;
	}

	public void setDOCTOR_EMPLOYEE_ID(int dOCTOR_EMPLOYEE_ID) {
		DOCTOR_EMPLOYEE_ID = dOCTOR_EMPLOYEE_ID;
	}

	public void setDOCTORS_ID(int dOCTORS_ID) {
		DOCTORS_ID = dOCTORS_ID;
	}

	public int getOFFICE_ID() {
		return OFFICE_ID;
	}

	public void setOFFICE_ID(int oFFICE_ID) {
		OFFICE_ID = oFFICE_ID;
	}

	public int getPATIENT_COUNT() {
		return PATIENT_COUNT;
	}

	public void setPATIENT_COUNT(int pATIENT_COUNT) {
		PATIENT_COUNT = pATIENT_COUNT;
	}
	
	
	/*
	 * public int getCONSULT_ID() { return CONSULT_ID; }
	 * 
	 * public void setCONSULT_ID(int cONSULT_ID) { CONSULT_ID = cONSULT_ID; }
	 */

	@Override
	public String toString() {
		return "ViewDocInfoToday [row_num=" + row_num + ", CONSULT_DATE=" + CONSULT_DATE + ", DEPARTMENT_NAME="
				+ DEPARTMENT_NAME + ", DOCTOR_NAME=" + DOCTOR_NAME + ", DOCTOR_RANK=" + DOCTOR_RANK + ", OFFICE_NAME="
				+ OFFICE_NAME + ", KNG_MOH=" + KNG_MOH + ", DOCTOR_DESIG=" + DOCTOR_DESIG + ", DOCTOR_SPEC="
				+ DOCTOR_SPEC + ", DEPARTMENT_ID=" + DEPARTMENT_ID + ", DOCTOR_EMPLOYEE_ID=" + DOCTOR_EMPLOYEE_ID
				+ ", DOCTORS_ID=" + DOCTORS_ID + ", OFFICE_ID=" + OFFICE_ID + ", PATIENT_COUNT=" + PATIENT_COUNT + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CONSULT_DATE, DEPARTMENT_ID, DEPARTMENT_NAME, DOCTORS_ID, DOCTOR_DESIG, DOCTOR_EMPLOYEE_ID,
				DOCTOR_NAME, DOCTOR_RANK, DOCTOR_SPEC, KNG_MOH, OFFICE_ID, OFFICE_NAME, PATIENT_COUNT, row_num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewDocInfoToday other = (ViewDocInfoToday) obj;
		return Objects.equals(CONSULT_DATE, other.CONSULT_DATE) && DEPARTMENT_ID == other.DEPARTMENT_ID
				&& Objects.equals(DEPARTMENT_NAME, other.DEPARTMENT_NAME) && DOCTORS_ID == other.DOCTORS_ID
				&& Objects.equals(DOCTOR_DESIG, other.DOCTOR_DESIG) && DOCTOR_EMPLOYEE_ID == other.DOCTOR_EMPLOYEE_ID
				&& Objects.equals(DOCTOR_NAME, other.DOCTOR_NAME) && Objects.equals(DOCTOR_RANK, other.DOCTOR_RANK)
				&& Objects.equals(DOCTOR_SPEC, other.DOCTOR_SPEC) && Objects.equals(KNG_MOH, other.KNG_MOH)
				&& OFFICE_ID == other.OFFICE_ID && Objects.equals(OFFICE_NAME, other.OFFICE_NAME)
				&& PATIENT_COUNT == other.PATIENT_COUNT && row_num == other.row_num;
	}

	
	
	
	
	
	
	
}
