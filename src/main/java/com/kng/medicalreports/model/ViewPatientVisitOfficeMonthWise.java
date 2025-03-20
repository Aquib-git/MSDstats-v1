package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_PATIENT_VISIT_OFFICE_MONTHWISE_ALL",catalog="ECLINIC")
public class ViewPatientVisitOfficeMonthWise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2184249672033628248L;
	
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="YEAR_WISE")
	private int yearWise;
	
	@Column(name="MONTH_NO")
	private int monthNo;
	
	@Column(name="MONTH_WISE")
	private String monthName;
	
	@Column(name="OFFICE_ID")
	private int officeNo;
	
	@Column(name="OFFICE_NAME")
	private String officeName;

	@Column(name="TOTAL_COUNT")
	private int totalCount;

	/**
	 * 
	 */
	public ViewPatientVisitOfficeMonthWise() {
		
	}
	
	

	public int getRow_num() {
		return row_num;
	}



	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}



	public int getYearWise() {
		return yearWise;
	}



	public void setYearWise(int yearWise) {
		this.yearWise = yearWise;
	}



	public int getMonthNo() {
		return monthNo;
	}



	public void setMonthNo(int monthNo) {
		this.monthNo = monthNo;
	}



	public String getMonthName() {
		return monthName;
	}



	public void setMonthName(String monthName) {
		this.monthName = monthName;
	}



	public String getOfficeName() {
		return officeName;
	}



	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}



	public int getTotalCount() {
		return totalCount;
	}



	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}



	public int getOfficeNo() {
		return officeNo;
	}



	public void setOfficeNo(int officeNo) {
		this.officeNo = officeNo;
	}



	@Override
	public String toString() {
		return "ViewPatientVisitOfficeMonthWise [row_num=" + row_num + ", yearWise=" + yearWise + ", monthNo=" + monthNo
				+ ", monthName=" + monthName + ", officeName=" + officeName + ", totalCount=" + totalCount + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(monthName, monthNo, officeName, row_num, totalCount, yearWise);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewPatientVisitOfficeMonthWise other = (ViewPatientVisitOfficeMonthWise) obj;
		return Objects.equals(monthName, other.monthName) && monthNo == other.monthNo
				&& Objects.equals(officeName, other.officeName) && row_num == other.row_num
				&& totalCount == other.totalCount && yearWise == other.yearWise;
	}
	
	

}
