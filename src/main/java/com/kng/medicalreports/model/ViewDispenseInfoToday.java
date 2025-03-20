package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="VIEW_DISPENSE_CLICK_ALL_V2",catalog="ECLINIC")
public class ViewDispenseInfoToday implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2878649765542690835L;
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
//	@Column(name="INVOICE_NO")
//	private Integer INVOICE_NO;
	@Column(name="INV_CONSULT_ID")
	private Integer INV_CONSULT_ID;
	
	@Column(name="ITEM_COUNT")
	private int ITEM_COUNT;
//	@Column(name="DEPARTMENT_ID")
//	private Integer DEPARTMENT_ID;
//	@Column(name="DOCTORS_ID")
//	private Integer DOCTORS_ID;
	
	
	@Column(name="OFFICE_ID")
	private Integer OFFICE_ID;
	
	@Column(name="PATIENT_DESIGNATION")
	private String PATIENT_DESIGNATION;
	
	
	@Column(name="PATIENT_EMPLOYEE_ID")
	private String PATIENT_EMPLOYEE_ID;
	
	@Column(name="INV_CUSTNAME")
	private String INVCUSTNAME;
	@Column(name="PATIENT_KWT_NKWT")
	private String PATIENT_KWT_NKWT;
	@Column(name="PATIENT_CIVILID")
	private String PATIENT_CIVILID;
//	@Column(name="PATIENT_AGE_DETAILED")
//	private String PATIENT_AGE_DETAILED;
//	@Column(name="INV_CUST_AGE")
//	private String INV_CUST_AGE;
//	@Column(name="ITEM_PDT_ID")
//	private String ITEM_PDT_ID;
//	@Column(name="ITEM_PDTCODE")
//	private String ITEM_PDTCODE;
	@Column(name="ITEM_NAME")
	private String ITEM_NAME;
//	@Column(name="ITEM_QTYSOLD")
//	private String ITEM_QTYSOLD;
//	@Column(name="ITEM_UNIT")
//	private String ITEM_UNIT;
//	@Column(name="EXPIRY_DATE_STG")
//	private String EXPIRY_DATE_STG;
	
//	@Column(name="batch_no")
//	private String batch_no;
	
	
	@Column(name="INV_STATUS")
	private String INV_STATUS;
//	@Column(name="KNG_MOH")
//	private String KNG_MOH;
	@Column(name="DEPARTMENT_NAME")
	private String DEPARTMENT_NAME;
	@Column(name="DOCTOR_NAME")
	private String DOCTOR_NAME;
	@Column(name="OFFICE_NAME")
	private String OFFICE_NAME;
	
	@Column(name="INVOICE_DATE")
	private String INVOICE_DATE;
//	@Column(name="INV_CUST_DOB")
//	private Date INV_CUST_DOB;
	/**
	 * 
	 */
	
//	@Transient
//	private String itemUnitList;
//	
	
	
	public ViewDispenseInfoToday() {
		
	}
	public int getRow_num() {
		return row_num;
	}
	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}
//	public Integer getINVOICE_NO() {
//		return INVOICE_NO;
//	}
//	public void setINVOICE_NO(Integer iNVOICE_NO) {
//		INVOICE_NO = iNVOICE_NO;
//	}
	public Integer getINV_CONSULT_ID() {
		return INV_CONSULT_ID;
	}
	public void setINV_CONSULT_ID(Integer iNV_CONSULT_ID) {
		INV_CONSULT_ID = iNV_CONSULT_ID;
	}
	public int getITEM_COUNT() {
		return ITEM_COUNT;
	}
	public void setITEM_COUNT(int iTEM_COUNT) {
		ITEM_COUNT = iTEM_COUNT;
	}
//	public Integer getDEPARTMENT_ID() {
//		return DEPARTMENT_ID;
//	}
//	public void setDEPARTMENT_ID(Integer dEPARTMENT_ID) {
//		DEPARTMENT_ID = dEPARTMENT_ID;
//	}
//	public Integer getDOCTORS_ID() {
//		return DOCTORS_ID;
//	}
//	public void setDOCTORS_ID(Integer dOCTORS_ID) {
//		DOCTORS_ID = dOCTORS_ID;
//	}
	public Integer getOFFICE_ID() {
		return OFFICE_ID;
	}
	public void setOFFICE_ID(Integer oFFICE_ID) {
		OFFICE_ID = oFFICE_ID;
	}
	
	public String getPATIENT_EMPLOYEE_ID() {
		return PATIENT_EMPLOYEE_ID;
	}
	public void setPATIENT_EMPLOYEE_ID(String pATIENT_EMPLOYEE_ID) {
		PATIENT_EMPLOYEE_ID = pATIENT_EMPLOYEE_ID;
	}
	
	
	public String getINVCUSTNAME() {
		return INVCUSTNAME;
	}
	public void setINVCUSTNAME(String iNVCUSTNAME) {
		INVCUSTNAME = iNVCUSTNAME;
	}
	public String getPATIENT_KWT_NKWT() {
		return PATIENT_KWT_NKWT;
	}
	public void setPATIENT_KWT_NKWT(String pATIENT_KWT_NKWT) {
		PATIENT_KWT_NKWT = pATIENT_KWT_NKWT;
	}
	

	public String getPATIENT_CIVILID() {
		return PATIENT_CIVILID;
	}
	public void setPATIENT_CIVILID(String pATIENT_CIVILID) {
		PATIENT_CIVILID = pATIENT_CIVILID;
	}
	
	
	public String getPATIENT_DESIGNATION() {
		return PATIENT_DESIGNATION;
	}
	public void setPATIENT_DESIGNATION(String pATIENT_DESIGNATION) {
		PATIENT_DESIGNATION = pATIENT_DESIGNATION;
	}
	//	public String getPATIENT_AGE_DETAILED() {
//		return PATIENT_AGE_DETAILED;
//	}
//	public void setPATIENT_AGE_DETAILED(String pATIENT_AGE_DETAILED) {
//		PATIENT_AGE_DETAILED = pATIENT_AGE_DETAILED;
//	}
//	public String getINV_CUST_AGE() {
//		return INV_CUST_AGE;
//	}
//	public void setINV_CUST_AGE(String iNV_CUST_AGE) {
//		INV_CUST_AGE = iNV_CUST_AGE;
//	}
//	public String getITEM_PDT_ID() {
//		return ITEM_PDT_ID;
//	}
//	public void setITEM_PDT_ID(String iTEM_PDT_ID) {
//		ITEM_PDT_ID = iTEM_PDT_ID;
//	}
//	public String getITEM_PDTCODE() {
//		return ITEM_PDTCODE;
//	}
//	public void setITEM_PDTCODE(String iTEM_PDTCODE) {
//		ITEM_PDTCODE = iTEM_PDTCODE;
//	}
	public String getITEM_NAME() {
		return ITEM_NAME;
	}
	public void setITEM_NAME(String iTEM_NAME) {
		ITEM_NAME = iTEM_NAME;
	}
//	public String getITEM_QTYSOLD() {
//		return ITEM_QTYSOLD;
//	}
//	public void setITEM_QTYSOLD(String iTEM_QTYSOLD) {
//		ITEM_QTYSOLD = iTEM_QTYSOLD;
//	}
//	public String getITEM_UNIT() {
//		return ITEM_UNIT;
//	}
//	public void setITEM_UNIT(String iTEM_UNIT) {
//		ITEM_UNIT = iTEM_UNIT;
//	}
//	public String getEXPIRY_DATE_STG() {
//		return EXPIRY_DATE_STG;
//	}
//	public void setEXPIRY_DATE_STG(String eXPIRY_DATE_STG) {
//		EXPIRY_DATE_STG = eXPIRY_DATE_STG;
//	}
//	public String getBatch_no() {
//		return batch_no;
//	}
//	public void setBatch_no(String batch_no) {
//		this.batch_no = batch_no;
//	}
	public String getINV_STATUS() {
		return INV_STATUS;
	}
	public void setINV_STATUS(String iNV_STATUS) {
		INV_STATUS = iNV_STATUS;
	}
//	public String getKNG_MOH() {
//		return KNG_MOH;
//	}
//	public void setKNG_MOH(String kNG_MOH) {
//		KNG_MOH = kNG_MOH;
//	}
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
	public String getINVOICE_DATE() {
		return INVOICE_DATE;
	}
	public void setINVOICE_DATE(String iNVOICE_DATE) {
		INVOICE_DATE = iNVOICE_DATE;
	}
//	public Date getINV_CUST_DOB() {
//		return INV_CUST_DOB;
//	}
//	public void setINV_CUST_DOB(Date iNV_CUST_DOB) {
//		INV_CUST_DOB = iNV_CUST_DOB; 
//	}
	@Override
	public String toString() {
		return "ViewDispenseInfoToday [row_num=" + row_num + ", INV_CONSULT_ID=" + INV_CONSULT_ID + ", ITEM_COUNT="
				+ ITEM_COUNT + ", OFFICE_ID=" + OFFICE_ID + ", PATIENT_EMPLOYEE_ID=" + PATIENT_EMPLOYEE_ID
				+ ", INVCUSTNAME=" + INVCUSTNAME + ", PATIENT_KWT_NKWT=" + PATIENT_KWT_NKWT + ", PATIENT_CIVILID="
				+ PATIENT_CIVILID + ", ITEM_NAME=" + ITEM_NAME + ", INV_STATUS=" + INV_STATUS + ", DEPARTMENT_NAME="
				+ DEPARTMENT_NAME + ", DOCTOR_NAME=" + DOCTOR_NAME + ", OFFICE_NAME=" + OFFICE_NAME + ", INVOICE_DATE="
				+ INVOICE_DATE + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(DEPARTMENT_NAME, DOCTOR_NAME, INVCUSTNAME, INVOICE_DATE, INV_CONSULT_ID, INV_STATUS,
				ITEM_COUNT, ITEM_NAME, OFFICE_ID, OFFICE_NAME, PATIENT_CIVILID, PATIENT_EMPLOYEE_ID, PATIENT_KWT_NKWT,
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
		ViewDispenseInfoToday other = (ViewDispenseInfoToday) obj;
		return Objects.equals(DEPARTMENT_NAME, other.DEPARTMENT_NAME) && Objects.equals(DOCTOR_NAME, other.DOCTOR_NAME)
				&& Objects.equals(INVCUSTNAME, other.INVCUSTNAME) && Objects.equals(INVOICE_DATE, other.INVOICE_DATE)
				&& Objects.equals(INV_CONSULT_ID, other.INV_CONSULT_ID) && Objects.equals(INV_STATUS, other.INV_STATUS)
				&& ITEM_COUNT == other.ITEM_COUNT && Objects.equals(ITEM_NAME, other.ITEM_NAME)
				&& Objects.equals(OFFICE_ID, other.OFFICE_ID) && Objects.equals(OFFICE_NAME, other.OFFICE_NAME)
				&& Objects.equals(PATIENT_CIVILID, other.PATIENT_CIVILID)
				&& Objects.equals(PATIENT_EMPLOYEE_ID, other.PATIENT_EMPLOYEE_ID)
				&& Objects.equals(PATIENT_KWT_NKWT, other.PATIENT_KWT_NKWT) && row_num == other.row_num;
	}
	

	
//  public String getItemUnitList() {
//		
//		String [] name =this.ITEM_UNIT.split(",");
//		name=Arrays.stream(name).map(String::trim) .distinct().toArray(String[]::new);	
//		itemUnitList=Arrays.toString(name).replace('[', ' ').replace(']',' ');
//		return itemUnitList;
//	}
//	public void setItemUnitList(String itemUnitList) {
//		this.itemUnitList = itemUnitList;
//	}
	

	
	
	
	
	
	
	
	
	

	
	

}
