package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="VIEW_OFFICE_DETAIL",catalog="ECLINIC")
public class ViewOfficeDetails  {
	
	
	@Id
	@Column(name="OFFICE_ID")
	private int officeId;
	
	@Column(name="OFFICE_NAME")
	private String officeName;
	
	
	
	
	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	
	/**
	 * @param officeId
	 * @param officeName
	 */
	public ViewOfficeDetails(int officeId, String officeName) {
		super();
		this.officeId = officeId;
		this.officeName = officeName;
	}

	/**
	 * 
	 */
	public ViewOfficeDetails() {
		super();
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(officeId, officeName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewOfficeDetails other = (ViewOfficeDetails) obj;
		return officeId == other.officeId && Objects.equals(officeName, other.officeName);
	}

	
	

}
