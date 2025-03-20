package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_DISPENSE_OFFICE_COUNT_ALL_V2",catalog="ECLINIC")
public class ViewDispenseOfficeCountToday implements Serializable
{
	private static final long serialVersionUID = 2140515487293365394L;
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="OFFICE_NAME")
	private String officeName;
	
	@Column(name="ITEM_COUNT")
	private long totalCount;
	
	@Column(name="INVOICE_DATE")
	private String INVOICE_DATE;
	
//	@Column(name="OFFICE_ID", nullable=true)
//	private int officeId;


	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public String getINVOICE_DATE() {
		return INVOICE_DATE;
	}

	public void setINVOICE_DATE(String iNVOICE_DATE) {
		INVOICE_DATE = iNVOICE_DATE;
	}

	@Override
	public String toString() {
		return "ViewDispenseOfficeCountToday [officeName=" + officeName + ", totalCount=" + totalCount
				+ ", INVOICE_DATE=" + INVOICE_DATE + "]";
	}
	

	
	
}
