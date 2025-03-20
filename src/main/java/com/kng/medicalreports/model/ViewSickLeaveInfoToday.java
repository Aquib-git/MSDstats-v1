package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_SICKLEAVE_CLICK_ALL_V2",catalog="ECLINIC")
public class ViewSickLeaveInfoToday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2110200867370528386L;
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="CONSULT_DATE")
	private String CONSULT_DATE;
	
	@Column(name="CONSULT_ID")
	private String CONSULT_ID;
	
	
	@Column(name="PATIENT_EMPLOYEE_ID")
	private String PATIENT_EMPLOYEE_ID;
	
	@Column(name="PATIENT_CIVILID")
	private String PATIENT_CIVILID;
	
//	@Column(name="PATIENT_KWT_NKWT")
//	private String PATIENT_KWT_NKWT;
	
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
	
//	@Column(name="SICK_LEAVE_TYPE")
//	private String SICK_LEAVE_TYPE;
	
//	@Column(name="REMARKS")
//	private String REMARKS;
	
//	@Column(name="DEPARTMENT_ID")
//	private int DEPARTMENT_ID;
//	@Column(name="DOCTORS_ID")
//	private int DOCTORS_ID;
	@Column(name="OFFICE_ID")
	private int OFFICE_ID;
	@Column(name="NO_OF_DAYS")
	private int NO_OF_DAYS;
	
	@Column(name="LEAVE_FROM")
	private Date LEAVE_FROM;
	
	@Column(name="LEAVE_TO")
	private Date LEAVE_TO;
	
	

	/**
	 * 
	 */
	public ViewSickLeaveInfoToday() {
		
	}

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

	public String getPATIENT_EMPLOYEE_ID() {
		return PATIENT_EMPLOYEE_ID;
	}

	public void setPATIENT_EMPLOYEE_ID(String pATIENT_EMPLOYEE_ID) {
		PATIENT_EMPLOYEE_ID = pATIENT_EMPLOYEE_ID;
	}
	
	

//	public String getPATIENT_KWT_NKWT() {
//		return PATIENT_KWT_NKWT;
//	}
//
//	public void setPATIENT_KWT_NKWT(String pATIENT_KWT_NKWT) {
//		PATIENT_KWT_NKWT = pATIENT_KWT_NKWT;
//	}

	public String getCONSULT_ID() {
		return CONSULT_ID;
	}

	public void setCONSULT_ID(String cONSULT_ID) {
		CONSULT_ID = cONSULT_ID;
	}

	public String getPATIENT_DESIGNATION() {
		return PATIENT_DESIGNATION;
	}

	public void setPATIENT_DESIGNATION(String pATIENT_DESIGNATION) {
		PATIENT_DESIGNATION = pATIENT_DESIGNATION;
	}

	public String getPATIENT_CIVILID() {
		return PATIENT_CIVILID;
	}

	public void setPATIENT_CIVILID(String pATIENT_CIVILID) {
		PATIENT_CIVILID = pATIENT_CIVILID;
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

//	public String getSICK_LEAVE_TYPE() {
//		return SICK_LEAVE_TYPE;
//	}
//
//	public void setSICK_LEAVE_TYPE(String sICK_LEAVE_TYPE) {
//		SICK_LEAVE_TYPE = sICK_LEAVE_TYPE;
//	}
//
//	public String getREMARKS() {
//		return REMARKS;
//	}
//
//	public void setREMARKS(String rEMARKS) {
//		REMARKS = rEMARKS;
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

	public int getNO_OF_DAYS() {
		return NO_OF_DAYS;
	}

	public void setNO_OF_DAYS(int nO_OF_DAYS) {
		NO_OF_DAYS = nO_OF_DAYS;
	}

	public Date getLEAVE_FROM() {
		return LEAVE_FROM;
	}

	public void setLEAVE_FROM(Date lEAVE_FROM) {
		LEAVE_FROM = lEAVE_FROM;
	}

	public Date getLEAVE_TO() {
		return LEAVE_TO;
	}

	public void setLEAVE_TO(Date lEAVE_TO) {
		LEAVE_TO = lEAVE_TO;
	}

	@Override
	public String toString() {
		return "ViewSickLeaveInfoToday [row_num=" + row_num + ", CONSULT_DATE=" + CONSULT_DATE
				+ ", PATIENT_EMPLOYEE_ID=" + PATIENT_EMPLOYEE_ID + ", PATIENT_CIVILID=" + PATIENT_CIVILID
				+ ", PATIENT_NAME=" + PATIENT_NAME + ", DOCTOR_NAME=" + DOCTOR_NAME + ", DEPARTMENT_NAME="
				+ DEPARTMENT_NAME + ", OFFICE_NAME=" + OFFICE_NAME + ", OFFICE_ID=" + OFFICE_ID + ", NO_OF_DAYS="
				+ NO_OF_DAYS + ", LEAVE_FROM=" + LEAVE_FROM + ", LEAVE_TO=" + LEAVE_TO + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CONSULT_DATE, DEPARTMENT_NAME, DOCTOR_NAME, LEAVE_FROM, LEAVE_TO, NO_OF_DAYS, OFFICE_ID,
				OFFICE_NAME, PATIENT_CIVILID, PATIENT_EMPLOYEE_ID, PATIENT_NAME, row_num);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewSickLeaveInfoToday other = (ViewSickLeaveInfoToday) obj;
		return Objects.equals(CONSULT_DATE, other.CONSULT_DATE)
				&& Objects.equals(DEPARTMENT_NAME, other.DEPARTMENT_NAME)
				&& Objects.equals(DOCTOR_NAME, other.DOCTOR_NAME) && Objects.equals(LEAVE_FROM, other.LEAVE_FROM)
				&& Objects.equals(LEAVE_TO, other.LEAVE_TO) && NO_OF_DAYS == other.NO_OF_DAYS
				&& OFFICE_ID == other.OFFICE_ID && Objects.equals(OFFICE_NAME, other.OFFICE_NAME)
				&& Objects.equals(PATIENT_CIVILID, other.PATIENT_CIVILID)
				&& Objects.equals(PATIENT_EMPLOYEE_ID, other.PATIENT_EMPLOYEE_ID)
				&& Objects.equals(PATIENT_NAME, other.PATIENT_NAME) && row_num == other.row_num;
	}

	

	
	
//	@Override
//	public String toString() {
//		return "ViewSickLeaveInfoToday [row_num=" + row_num + ", CONSULT_DATE=" + CONSULT_DATE
//				+ ", PATIENT_EMPLOYEE_ID=" + PATIENT_EMPLOYEE_ID + ", PATIENT_NAME=" + PATIENT_NAME + ", DOCTOR_NAME="
//				+ DOCTOR_NAME + ", DEPARTMENT_NAME=" + DEPARTMENT_NAME + ", OFFICE_NAME=" + OFFICE_NAME + ", OFFICE_ID="
//				+ OFFICE_ID + ", NO_OF_DAYS=" + NO_OF_DAYS + ", LEAVE_FROM=" + LEAVE_FROM + ", LEAVE_TO=" + LEAVE_TO
//				+ "]";
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(CONSULT_DATE,
//				/* DEPARTMENT_ID, */ DEPARTMENT_NAME,
//				/* DOCTORS_ID, */ DOCTOR_NAME, LEAVE_FROM, LEAVE_TO,
//				NO_OF_DAYS, OFFICE_ID, OFFICE_NAME, PATIENT_EMPLOYEE_ID,
//				/* PATIENT_KWT_NKWT, */ PATIENT_NAME, /* REMARKS, */
//				/* SICK_LEAVE_TYPE, */ row_num);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		ViewSickLeaveInfoToday other = (ViewSickLeaveInfoToday) obj;
//		return Objects.equals(CONSULT_DATE,
//				other.CONSULT_DATE) /* && DEPARTMENT_ID == other.DEPARTMENT_ID */
//				&& Objects.equals(DEPARTMENT_NAME,
//						other.DEPARTMENT_NAME)/* && DOCTORS_ID == other.DOCTORS_ID */
//				&& Objects.equals(DOCTOR_NAME, other.DOCTOR_NAME) && Objects.equals(LEAVE_FROM, other.LEAVE_FROM)
//				&& Objects.equals(LEAVE_TO, other.LEAVE_TO) && NO_OF_DAYS == other.NO_OF_DAYS
//				&& OFFICE_ID == other.OFFICE_ID && Objects.equals(OFFICE_NAME, other.OFFICE_NAME)
//				&& Objects.equals(PATIENT_EMPLOYEE_ID, other.PATIENT_EMPLOYEE_ID)
//				/* && Objects.equals(PATIENT_KWT_NKWT, other.PATIENT_KWT_NKWT) */
//				&& Objects.equals(PATIENT_NAME,
//						other.PATIENT_NAME) /* && Objects.equals(REMARKS, other.REMARKS) */
//				/* && Objects.equals(SICK_LEAVE_TYPE, other.SICK_LEAVE_TYPE) */ && row_num == other.row_num;
//	}
//	
	
	

}
