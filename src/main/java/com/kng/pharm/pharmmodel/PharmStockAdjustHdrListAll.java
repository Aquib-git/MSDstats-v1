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
@Table(name="VIEW_PHA_SA_HDR_LIST_ALL",catalog="ECLINIC")
public class PharmStockAdjustHdrListAll 
{

	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="ENTRY_DATE")
	private String ENTRY_DATE;
	
	@Column(name="ADJUST_NO")
	private int ADJUST_NO;
	
	@Column(name="STK_ADJ_ID")
	private String STK_ADJ_ID;
	
	@Column(name="REMARKS")
	private String REMARKS;
	
	@Column(name="SUBMIT_STATUS")
	private String SUBMIT_STATUS;
	
	@Column(name="OFFICE_ID")
	private int OFFICE_ID;
	
	@Column(name="DEPARTMENT_ID")
	private int DEPARTMENT_ID;
	
	@Column(name="DEPARTMENT_NAME")
	private String DEPARTMENT_NAME;
	
	@Column(name="DEPTNAME_AR")
	private String DEPTNAME_AR;
	
	@Column(name="OFFICE_NAME")
	private String OFFICE_NAME;
	
	@Column(name="OFFICENAME_AR")
	private String OFFICENAME_AR;
	
	public String getOFFICE_NAME() {
		
		OFFICE_NAME=this.OFFICE_NAME.replace("-MultiSpeciality","");
		
		return OFFICE_NAME;
	}
}
