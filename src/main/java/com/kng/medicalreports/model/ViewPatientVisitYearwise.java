package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_PATIENT_VISIT_YEAR_WISE",catalog="ECLINIC")
public class ViewPatientVisitYearwise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="YEAR_WISE")
	private String yearWise;
	

	@Column(name="PATIENT_YEAR_COUNT")
	private int totalCount;


	/**
	 * 
	 */
	public ViewPatientVisitYearwise() {
		
	}


	public int getRow_num() {
		return row_num;
	}


	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}


	public String getYearWise() {
		return yearWise;
	}


	public void setYearWise(String yearWise) {
		this.yearWise = yearWise;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	@Override
	public int hashCode() {
		return Objects.hash(row_num, totalCount, yearWise);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewPatientVisitYearwise other = (ViewPatientVisitYearwise) obj;
		return row_num == other.row_num && totalCount == other.totalCount && Objects.equals(yearWise, other.yearWise);
	}


	@Override
	public String toString() {
		return "ViewPatientVisitYearwise [row_num=" + row_num + ", yearWise=" + yearWise + ", totalCount=" + totalCount
				+ "]";
	}
	

}
