package com.kng.pharm.pharmmodel;

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
@Table(name="VIEW_PHA_DT_HDR_LIST_ALL",catalog="ECLINIC")
public class PharmDirectTransferHdrListAll 
{

	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="SALE_ID")
	private int SALE_ID;
	
	@Column(name="INVOICE_NO")
	private int INVOICE_NO;
	
	@Column(name="REQUEST_ID")
	private int REQUEST_ID;
	
	@Column(name="DIRECT_TRANSFER")
	private String DIRECT_TRANSFER;
	
	@Column(name="REQUEST_TOOFFICE")
	private int REQUEST_TOOFFICE;
	
	@Column(name="ISSUED_FROM_DEPARTMENT_ID")
	private int ISSUED_FROM_DEPARTMENT_ID;
	
	@Column(name="ISSUED_FROM_DEPARTMENT_NAME")
	private String ISSUED_FROM_DEPARTMENT_NAME;
	
	@Column(name="ISSUED_FROM_DEPARTMENT_NAME_AR")
	private String ISSUED_FROM_DEPARTMENT_NAME_AR;
	
	@Column(name="ISSUED_TO_DEPARTMENT_NAME")
	private String ISSUED_TO_DEPARTMENT_NAME;
	
	@Column(name="ISSUED_TO_DEPARTMENT_NAME_AR")
	private String ISSUED_TO_DEPARTMENT_NAME_AR;
	
	@Column(name="ISSUED_FROM_OFFICE_ID")
	private int ISSUED_FROM_OFFICE_ID;

	@Column(name="ISSUED_FROM_OFFICE_NAME")
	private String ISSUED_FROM_OFFICE_NAME;
	
	@Column(name="ISSUED_FROM_OFFICE_NAME_AR")
	private String ISSUED_FROM_OFFICE_NAME_AR;
	
	@Column(name="SUBMIT_STATUS")
	private String SUBMIT_STATUS;
	
	@Column(name="ISS_VOUC_ID")
	private String ISS_VOUC_ID;
	
	@Column(name="USER_ID")
	private int USER_ID;
	
	@Column(name="USER_LABEL")
	private String USER_LABEL;
	
	@Column(name="USERLABEL_ar")
	private String USERLABEL_ar;

	@Column(name="ENTRY_DATE")
	private String ENTRY_DATE;
	
	@Column(name="NARRATION")
	private String NARRATION;
	
	
	public String getISSUED_FROM_OFFICE_NAME() {
		
		ISSUED_FROM_OFFICE_NAME=this.ISSUED_FROM_OFFICE_NAME.replace("-MultiSpeciality","");
		
		return ISSUED_FROM_OFFICE_NAME;
	}
	
	
	
	
	
	
	
	
	
	
}
