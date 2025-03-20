package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_PATIENT_VISIT_OFFICE_COUNT_ALL",catalog="ECLINIC")
public class ViewPatientVisitOfficeCurrSummary implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="OFFICE_NAME")
	private String officeName;
	

	@Column(name="OFFICENAME_AR")
	private String OFFICENAME_AR;
	
	
	@Column(name="PATIENT_COUNT")
	private int totalCount;


    public ViewPatientVisitOfficeCurrSummary() {
		
	}

	

	public int getRow_num() {
		return row_num;
	}


	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}


	public String getOfficeName() {
		return officeName;
	}


	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}


	public String getOFFICENAME_AR() {
		return OFFICENAME_AR;
	}



	public void setOFFICENAME_AR(String oFFICENAME_AR) {
		OFFICENAME_AR = oFFICENAME_AR;
	}



	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	
	@Override
	public int hashCode() {
		return Objects.hash(officeName, row_num, totalCount);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewPatientVisitOfficeCurrSummary other = (ViewPatientVisitOfficeCurrSummary) obj;
		return Objects.equals(officeName, other.officeName) && row_num == other.row_num
				&& totalCount == other.totalCount;
	}
	

}
