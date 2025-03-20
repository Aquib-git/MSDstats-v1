package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_VITALS_CLICK_ALL_V2",catalog="ECLINIC")
public class ViewVitalsInfoToday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8803120968764789549L;
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
//	@Column(name="DATA_TYPE")
//	private String DATA_TYPE;
	@Column(name="PATIENT_EMPLOYEE_ID")
	private String PATIENT_EMPLOYEE_ID;
	
	@Column(name="CONSULT_ID")
	private int CONSULT_ID;
	
	@Column(name="PATIENT_CIVILID")
	private String PATIENT_CIVILID;
	
	@Column(name="PATIENT_KWT_NKWT")
	private String PATIENT_KWT_NKWT;
	@Column(name="PATIENT_NAME")
	private String PATIENT_NAME;
	
	@Column(name="PATIENT_DESIGNATION")
	private String PATIENT_DESIGNATION;
	
	@Column(name="DOCTOR_NAME")
	private String DOCTOR_NAME;
	
	@Column(name="DEPARTMENT_NAME")
	private String DEPARTMENT_NAME;
	
	@Column(name="OFFICE_NAME")
	private String OFFICE_NAME;
	
	@Column(name="KNG_MOH")
	private String KNG_MOH;
	
	@Column(name="VITAL_DETAILS")
	private String VITAL_DETAILS;
	
//	@Column(name="ENTERED_BY")
//	private String ENTERED_BY;
//	@Column(name="ENTERED_TYPE")
//	private String ENTERED_TYPE;
	
	
//	@Column(name="DEPARTMENT_ID")
//	private int DEPARTMENT_ID;
//	@Column(name="DOCTORS_ID")
//	private int DOCTORS_ID;
	@Column(name="OFFICE_ID")
	private int OFFICE_ID;
	
//	@Column(name="DOCTOR_EMPLOYEE_ID")
//	private Long DOCTOR_EMPLOYEE_ID;
	
	@Column(name="VITALS_COUNT")
	private int VITALS_COUNT;
	
	@Column(name="CONSULT_DATE")
	private String CONSULT_DATE;
	

	/**
	 * 
	 */
	public ViewVitalsInfoToday() {
			}

	public int getRow_num() {
		return row_num;
	}

	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}

//	public String getDATA_TYPE() {
//		return DATA_TYPE;
//	}
//
//	public void setDATA_TYPE(String dATA_TYPE) {
//		DATA_TYPE = dATA_TYPE;
//	}

	public String getPATIENT_EMPLOYEE_ID() {
		return PATIENT_EMPLOYEE_ID;
	}

	public void setPATIENT_EMPLOYEE_ID(String pATIENT_EMPLOYEE_ID) {
		PATIENT_EMPLOYEE_ID = pATIENT_EMPLOYEE_ID;
	}
	
	public String getPATIENT_CIVILID() {
		return PATIENT_CIVILID;
	}

	public void setPATIENT_CIVILID(String pATIENT_CIVILID) {
		PATIENT_CIVILID = pATIENT_CIVILID;
	}


	
	public int getCONSULT_ID() {
		return CONSULT_ID;
	}

	public void setCONSULT_ID(int cONSULT_ID) {
		CONSULT_ID = cONSULT_ID;
	}

	public String getPATIENT_DESIGNATION() {
		return PATIENT_DESIGNATION;
	}

	public void setPATIENT_DESIGNATION(String pATIENT_DESIGNATION) {
		PATIENT_DESIGNATION = pATIENT_DESIGNATION;
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

	public String getDOCTOR_NAME() {
		return DOCTOR_NAME;
	}

	public void setDOCTOR_NAME(String dOCTOR_NAME) {
		DOCTOR_NAME = dOCTOR_NAME;
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

	public String getKNG_MOH() {
		return KNG_MOH;
	}

	public void setKNG_MOH(String kNG_MOH) {
		KNG_MOH = kNG_MOH;
	}

	public String getVITAL_DETAILS() {
		return VITAL_DETAILS;
	}

	public void setVITAL_DETAILS(String vITAL_DETAILS) {
		VITAL_DETAILS = vITAL_DETAILS;
	}

//	public String getENTERED_BY() {
//		return ENTERED_BY;
//	}
//
//	public void setENTERED_BY(String eNTERED_BY) {
//		ENTERED_BY = eNTERED_BY;
//	}
//
//	public String getENTERED_TYPE() {
//		return ENTERED_TYPE;
//	}
//
//	public void setENTERED_TYPE(String eNTERED_TYPE) {
//		ENTERED_TYPE = eNTERED_TYPE;
//	}
//
//	public int getDEPARTMENT_ID() {
//		return DEPARTMENT_ID;
//	}
//
//	public void setDEPARTMENT_ID(int dEPARTMENT_ID) {
//		DEPARTMENT_ID = dEPARTMENT_ID;
//	}
//
//	public int getDOCTORS_ID() {
//		return DOCTORS_ID;
//	}
//
//	public void setDOCTORS_ID(int dOCTORS_ID) {
//		DOCTORS_ID = dOCTORS_ID;
//	}

	public int getOFFICE_ID() {
		return OFFICE_ID;
	}

	public void setOFFICE_ID(int oFFICE_ID) {
		OFFICE_ID = oFFICE_ID;
	}

//	public Long getDOCTOR_EMPLOYEE_ID() {
//		return DOCTOR_EMPLOYEE_ID;
//	}
//
//	public void setDOCTOR_EMPLOYEE_ID(Long dOCTOR_EMPLOYEE_ID) {
//		DOCTOR_EMPLOYEE_ID = dOCTOR_EMPLOYEE_ID;
//	}

	public int getVITALS_COUNT() {
		return VITALS_COUNT;
	}

	public void setVITALS_COUNT(int vITALS_COUNT) {
		VITALS_COUNT = vITALS_COUNT;
	}
	
	

	public String getCONSULT_DATE() {
		return CONSULT_DATE;
	}

	public void setCONSULT_DATE(String cONSULT_DATE) {
		CONSULT_DATE = cONSULT_DATE;
	}

	@Override
	public String toString() {
		return "ViewVitalsInfoToday [row_num=" + row_num + ", PATIENT_EMPLOYEE_ID=" + PATIENT_EMPLOYEE_ID
				+ ", PATIENT_CIVILID=" + PATIENT_CIVILID + ", PATIENT_KWT_NKWT=" + PATIENT_KWT_NKWT + ", PATIENT_NAME="
				+ PATIENT_NAME + ", DOCTOR_NAME=" + DOCTOR_NAME + ", DEPARTMENT_NAME=" + DEPARTMENT_NAME
				+ ", OFFICE_NAME=" + OFFICE_NAME + ", KNG_MOH=" + KNG_MOH + ", VITAL_DETAILS=" + VITAL_DETAILS
				+ ", OFFICE_ID=" + OFFICE_ID + ", VITALS_COUNT=" + VITALS_COUNT + ", CONSULT_DATE=" + CONSULT_DATE
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CONSULT_DATE, DEPARTMENT_NAME, DOCTOR_NAME, KNG_MOH, OFFICE_ID, OFFICE_NAME,
				PATIENT_CIVILID, PATIENT_EMPLOYEE_ID, PATIENT_KWT_NKWT, PATIENT_NAME, VITALS_COUNT, VITAL_DETAILS,
				row_num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewVitalsInfoToday other = (ViewVitalsInfoToday) obj;
		return Objects.equals(CONSULT_DATE, other.CONSULT_DATE)
				&& Objects.equals(DEPARTMENT_NAME, other.DEPARTMENT_NAME)
				&& Objects.equals(DOCTOR_NAME, other.DOCTOR_NAME) && Objects.equals(KNG_MOH, other.KNG_MOH)
				&& OFFICE_ID == other.OFFICE_ID && Objects.equals(OFFICE_NAME, other.OFFICE_NAME)
				&& Objects.equals(PATIENT_CIVILID, other.PATIENT_CIVILID)
				&& Objects.equals(PATIENT_EMPLOYEE_ID, other.PATIENT_EMPLOYEE_ID)
				&& Objects.equals(PATIENT_KWT_NKWT, other.PATIENT_KWT_NKWT)
				&& Objects.equals(PATIENT_NAME, other.PATIENT_NAME) && VITALS_COUNT == other.VITALS_COUNT
				&& Objects.equals(VITAL_DETAILS, other.VITAL_DETAILS) && row_num == other.row_num;
	}



	

	

	
	
}
