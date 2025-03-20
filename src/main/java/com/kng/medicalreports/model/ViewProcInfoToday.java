package com.kng.medicalreports.model;

import java.io.Serializable;

//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_PROC_CLICK_ALL_V2",catalog="ECLINIC")
public class ViewProcInfoToday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5528355039329149803L;
	
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="CONSULT_DATE")
	private String CONSULT_DATE;
	
//	@Column(name="DONE_DATE")
//	private Date DONE_DATE;
	
//	@Column(name="ENTERED_DATE")
//	private Date ENTERED_DATE;
	
	@Column(name="PATIENT_EMPLOYEE_ID")
	private String PATIENT_EMPLOYEE_ID;
	
	@Column(name="PATIENT_CIVILID")
	private String PATIENT_CIVILID;
	
//	@Column(name="PATIENT_KWT_NKWT")
//	private String PATIENT_KWT_NKWT;
//	
	@Column(name="PATIENT_NAME")
	private String PATIENT_NAME;
	
	@Column(name="PATIENT_DESIGNATION")
	private String PATIENT_DESIGNATION;
	
	@Column(name="DEPARTMENT_NAME")
	private String DEPARTMENT_NAME;
	
	@Column(name="DOCTOR_NAME")
	private String DOCTOR_NAME;
	
	@Column(name="OFFICE_NAME")
	private String OFFICE_NAME;
	
	
	
	
	@Column(name="PROCEDURE_CAT")
	private String PROCEDURE_CAT;
//	@Column(name="CATEGORY_ID")
//	private String CATEGORY_ID;
	
//	@Column(name="KNG_MOH")
//	private String KNG_MOH;
	
	@Column(name="PROCEDURE_NAME")
	private String PROCEDURE_NAME;
	
//	@Column(name="ENTEREDBY_NAME")
//	private String ENTEREDBY_NAME;
	
	@Column(name="DONE_STATUS")
	private String DONE_STATUS;
	
//	@Column(name="DONE_BY_NAME")
//	private String DONE_BY_NAME;
	
//	@Column(name="DEPARTMENT_ID")
//	private int DEPARTMENT_ID;
//	@Column(name="DOCTORS_ID")
//	private int DOCTORS_ID;
	@Column(name="OFFICE_ID")
	private int OFFICE_ID;
	
	@Column(name="CONSULT_ID")
	private int CONSULT_ID;
	
//	@Column(name="PROCEDURE_ID")
//	private Integer PROCEDURE_ID;
	
//	@Column(name="ENTEREDBY")
//	private int ENTEREDBY;
	
//	@Column(name="DONE_BY")
//	private int DONE_BY;
	
	
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
	
	public String getPATIENT_CIVILID() {
		return PATIENT_CIVILID;
	}

	public void setPATIENT_CIVILID(String pATIENT_CIVILID) {
		PATIENT_CIVILID = pATIENT_CIVILID;
	}

	
	
//	public String getPATIENT_KWT_NKWT() {
//		return PATIENT_KWT_NKWT;
//	}
//
//	public void setPATIENT_KWT_NKWT(String pATIENT_KWT_NKWT) {
//		PATIENT_KWT_NKWT = pATIENT_KWT_NKWT;
//	}


	public String getPATIENT_NAME() {
		return PATIENT_NAME;
	}

	public String getPATIENT_DESIGNATION() {
		return PATIENT_DESIGNATION;
	}

	public void setPATIENT_DESIGNATION(String pATIENT_DESIGNATION) {
		PATIENT_DESIGNATION = pATIENT_DESIGNATION;
	}

	public void setCONSULT_ID(int cONSULT_ID) {
		CONSULT_ID = cONSULT_ID;
	}

	public void setPATIENT_NAME(String pATIENT_NAME) {
		PATIENT_NAME = pATIENT_NAME;
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

	public String getOFFICE_NAME() {
		
		OFFICE_NAME=this.OFFICE_NAME.replace("-MultiSpeciality","");
		
		return OFFICE_NAME;
	}

	public void setOFFICE_NAME(String oFFICE_NAME) {
		OFFICE_NAME = oFFICE_NAME;
	}

	
	

	

//	public String getCATEGORY_ID() {
//		return CATEGORY_ID;
//	}
//
//	public void setCATEGORY_ID(String cATEGORY_ID) {
//		CATEGORY_ID = cATEGORY_ID;
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

//	public Date getDONE_DATE() {
//		return DONE_DATE;
//	}
//
//	public void setDONE_DATE(Date dONE_DATE) {
//		DONE_DATE = dONE_DATE;
//	}

//	public Date getENTERED_DATE() {
//		return ENTERED_DATE;
//	}
//
//	public void setENTERED_DATE(Date eNTERED_DATE) {
//		ENTERED_DATE = eNTERED_DATE;
//	}

	public String getPROCEDURE_CAT() {
		return PROCEDURE_CAT;
	}

	public void setPROCEDURE_CAT(String pROCEDURE_CAT) {
		PROCEDURE_CAT = pROCEDURE_CAT;
	}

//	public String getKNG_MOH() {
//		return KNG_MOH;
//	}
//
//	public void setKNG_MOH(String kNG_MOH) {
//		KNG_MOH = kNG_MOH;
//	}

	public String getPROCEDURE_NAME() {
		return PROCEDURE_NAME;
	}

	public void setPROCEDURE_NAME(String pROCEDURE_NAME) {
		PROCEDURE_NAME = pROCEDURE_NAME;
	}

	public String getDONE_STATUS() {
		return DONE_STATUS;
	}

	public void setDONE_STATUS(String dONE_STATUS) {
		DONE_STATUS = dONE_STATUS;
	}

//	public String getDONE_BY_NAME() {
//		return DONE_BY_NAME;
//	}
//
//	public void setDONE_BY_NAME(String dONE_BY_NAME) {
//		DONE_BY_NAME = dONE_BY_NAME;
//	}

	public Integer getCONSULT_ID() {
		return CONSULT_ID;
	}

	public void setCONSULT_ID(Integer cONSULT_ID) {
		CONSULT_ID = cONSULT_ID;
	}

//	public Integer getPROCEDURE_ID() {
//		return PROCEDURE_ID;
//	}
//
//	public void setPROCEDURE_ID(Integer pROCEDURE_ID) {
//		PROCEDURE_ID = pROCEDURE_ID;
//	}
//
//	public int getENTEREDBY() {
//		return ENTEREDBY;
//	}
//
//	public void setENTEREDBY(int eNTEREDBY) {
//		ENTEREDBY = eNTEREDBY;
//	}
//
//	public int getDONE_BY() {
//		return DONE_BY;
//	}
//
//	public void setDONE_BY(int dONE_BY) {
//		DONE_BY = dONE_BY;
//	}
//
//	
//	
//	public String getENTEREDBY_NAME() {
//		return ENTEREDBY_NAME;
//	}
//
//	public void setENTEREDBY_NAME(String eNTEREDBY_NAME) {
//		ENTEREDBY_NAME = eNTEREDBY_NAME;
//	}




	

}
