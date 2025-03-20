package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Arrays;
//import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="VIEW_LABTEST_CLICK_ALL_V2",catalog="ECLINIC")
public class ViewLabtestInfoToday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4535350470101898162L;

	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="CONSULT_DATE")
	private String CONSULT_DATE;
	
	@Column(name="CONSULT_ID")
	private Integer CONSULT_ID;
	

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
	
	@Column(name="DEPARTMENT_NAME")
	private String DEPARTMENT_NAME;
	
	
	
	@Column(name="DOCTOR_NAME")
	private String DOCTOR_NAME;
	
	@Column(name="OFFICE_NAME")
	private String OFFICE_NAME;
	
	@Column(name="TEST_NAME")
	private String TEST_NAME;
	
	@Column(name="TEST_ID")
	private String TEST_ID;
	
//	@Column(name="LABTEST_ID")
//	private String LABTEST_ID;
	
	public String getTEST_ID() {
		return TEST_ID;
	}

	public void setTEST_ID(String tEST_ID) {
		TEST_ID = tEST_ID;
	}

	@Column(name="CATEGORY_NAME")
	private String CATEGORY_NAME;
	

	
//	@Column(name="DEPARTMENT_ID")
//	private int DEPARTMENT_ID;
//	@Column(name="DOCTORS_ID")
//	private int DOCTORS_ID;
	@Column(name="OFFICE_ID")
	private int OFFICE_ID;
	
	@Column(name="PATIENT_LABTEST_COUNT")
	private Integer PATIENT_LABTEST_COUNT;
	
	
	
	
	
	@Transient
	private String testNameList;
 

	@Transient
	private String categoryNameList;
	

	/**
	 * 
	 */
	public ViewLabtestInfoToday() {
		
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
	
	

	public Integer getCONSULT_ID() {
		return CONSULT_ID;
	}

	public void setCONSULT_ID(Integer cONSULT_ID) {
		CONSULT_ID = cONSULT_ID;
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

	public String getTEST_NAME() {
		return TEST_NAME;
	}

	public void setTEST_NAME(String tEST_NAME) {
		TEST_NAME = tEST_NAME;
	}

//	public String getLABTEST_ID() {
//		return LABTEST_ID;
//	}
//
//	public void setLABTEST_ID(String lABTEST_ID) {
//		LABTEST_ID = lABTEST_ID;
//	}

	public String getCATEGORY_NAME() {
		return CATEGORY_NAME;
	}

	public void setCATEGORY_NAME(String cATEGORY_NAME) {
		CATEGORY_NAME = cATEGORY_NAME;
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

	public Integer getPATIENT_LABTEST_COUNT() {
		return PATIENT_LABTEST_COUNT;
	}

	public void setPATIENT_LABTEST_COUNT(Integer pATIENT_LABTEST_COUNT) {
		PATIENT_LABTEST_COUNT = pATIENT_LABTEST_COUNT;
	}
	
	
	
 public String getTestNameList() {
		
		String [] name =this.TEST_NAME.split(",");
		name=Arrays.stream(name).distinct().toArray(String[]::new);
		testNameList=Arrays.toString(name).replace('[', ' ').replace(']',' ');
	
		return testNameList;
	}

	public void setTestNameList(String testNameList) {
		this.testNameList = testNameList;
	}

	public String getCategoryNameList() {
		String [] name =this.CATEGORY_NAME.split(",");
		name=Arrays.stream(name).distinct().toArray(String[]::new);
		categoryNameList=Arrays.toString(name).replace('[', ' ').replace(']',' ');
	
		return categoryNameList;
	}

	public void setCategoryNameList(String categoryNameList) {
		this.categoryNameList = categoryNameList;
	}

	@Override
	public String toString() {
		return "ViewLabtestInfoToday [row_num=" + row_num + ", CONSULT_DATE=" + CONSULT_DATE + ", PATIENT_EMPLOYEE_ID="
				+ PATIENT_EMPLOYEE_ID + ", PATIENT_CIVILID=" + PATIENT_CIVILID + ", PATIENT_NAME=" + PATIENT_NAME
				+ ", DEPARTMENT_NAME=" + DEPARTMENT_NAME + ", DOCTOR_NAME=" + DOCTOR_NAME + ", OFFICE_NAME="
				+ OFFICE_NAME + ", TEST_NAME=" + TEST_NAME + ", CATEGORY_NAME=" + CATEGORY_NAME + ", OFFICE_ID="
				+ OFFICE_ID + ", PATIENT_LABTEST_COUNT=" + PATIENT_LABTEST_COUNT + ", testNameList=" + testNameList
				+ ", categoryNameList=" + categoryNameList + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(CATEGORY_NAME, CONSULT_DATE, DEPARTMENT_NAME, DOCTOR_NAME, OFFICE_ID, OFFICE_NAME,
				PATIENT_CIVILID, PATIENT_EMPLOYEE_ID, PATIENT_LABTEST_COUNT, PATIENT_NAME, TEST_NAME, categoryNameList,
				row_num, testNameList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewLabtestInfoToday other = (ViewLabtestInfoToday) obj;
		return Objects.equals(CATEGORY_NAME, other.CATEGORY_NAME) && Objects.equals(CONSULT_DATE, other.CONSULT_DATE)
				&& Objects.equals(DEPARTMENT_NAME, other.DEPARTMENT_NAME)
				&& Objects.equals(DOCTOR_NAME, other.DOCTOR_NAME) && OFFICE_ID == other.OFFICE_ID
				&& Objects.equals(OFFICE_NAME, other.OFFICE_NAME)
				&& Objects.equals(PATIENT_CIVILID, other.PATIENT_CIVILID)
				&& Objects.equals(PATIENT_EMPLOYEE_ID, other.PATIENT_EMPLOYEE_ID)
				&& Objects.equals(PATIENT_LABTEST_COUNT, other.PATIENT_LABTEST_COUNT)
				&& Objects.equals(PATIENT_NAME, other.PATIENT_NAME) && Objects.equals(TEST_NAME, other.TEST_NAME)
				&& Objects.equals(categoryNameList, other.categoryNameList) && row_num == other.row_num
				&& Objects.equals(testNameList, other.testNameList);
	}


	
	
	
	
	
	
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(
//				/* CATEGORY_ID, */ CATEGORY_NAME, CONSULT_DATE,
//				/* DEPARTMENT_ID, */ DEPARTMENT_NAME, /* DOCTORS_ID, */
//				DOCTOR_NAME,
//				/* LABTEST_ID, */ OFFICE_ID, OFFICE_NAME,
//				PATIENT_EMPLOYEE_ID, /* PATIENT_KWT_NKWT, */
//				PATIENT_LABTEST_COUNT, PATIENT_NAME, TEST_NAME, row_num);
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
//		ViewLabtestInfoToday other = (ViewLabtestInfoToday) obj;
//		return /*Objects.equals(CATEGORY_ID, other.CATEGORY_ID)&&*/ Objects.equals(CATEGORY_NAME, other.CATEGORY_NAME)
//				&& Objects.equals(CONSULT_DATE,
//						other.CONSULT_DATE)/* && DEPARTMENT_ID == other.DEPARTMENT_ID */
//				&& Objects.equals(DEPARTMENT_NAME,
//						other.DEPARTMENT_NAME) /* && DOCTORS_ID == other.DOCTORS_ID */
//				&& Objects.equals(DOCTOR_NAME,
//						other.DOCTOR_NAME) /* && Objects.equals(LABTEST_ID, other.LABTEST_ID) */
//				&& OFFICE_ID == other.OFFICE_ID && Objects.equals(OFFICE_NAME, other.OFFICE_NAME)
//				&& Objects.equals(PATIENT_EMPLOYEE_ID, other.PATIENT_EMPLOYEE_ID)
//				/* && Objects.equals(PATIENT_KWT_NKWT, other.PATIENT_KWT_NKWT) */
//				&& Objects.equals(PATIENT_LABTEST_COUNT, other.PATIENT_LABTEST_COUNT)
//				&& Objects.equals(PATIENT_NAME, other.PATIENT_NAME) && Objects.equals(TEST_NAME, other.TEST_NAME)
//				&& row_num == other.row_num;
//	}
//
//	@Override
//	public String toString() {
//		return "ViewLabtestInfoToday [row_num=" + row_num + ", CONSULT_DATE=" + CONSULT_DATE + ", PATIENT_EMPLOYEE_ID="
//				+ PATIENT_EMPLOYEE_ID + ", PATIENT_NAME=" + PATIENT_NAME + ", DEPARTMENT_NAME=" + DEPARTMENT_NAME
//				+ ", DOCTOR_NAME=" + DOCTOR_NAME + ", OFFICE_NAME=" + OFFICE_NAME + ", TEST_NAME=" + TEST_NAME
//				+ ", CATEGORY_NAME=" + CATEGORY_NAME + ", OFFICE_ID=" + OFFICE_ID + ", PATIENT_LABTEST_COUNT="
//				+ PATIENT_LABTEST_COUNT + "]";
//	}
//

	

	
	
}
