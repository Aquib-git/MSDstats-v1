package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_DOCTOR_OFFICE_COUNT_ALL",catalog="ECLINIC")
public class ViewDoctorOfficeCountAll implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
	
	@Column(name="OFFICE_ID")
	private String OFFICE_ID;
	
	
	@Column(name="OFFICE_NAME")
	private String officeName;
	
	@Column(name="OFFICENAME_AR")
	private String OFFICENAME_AR;
	
	

	@Column(name="DOCTOR_COUNT")
	private int totalCount;
	
	public ViewDoctorOfficeCountAll() {
		
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
		 
		 
		 
		
			public String getOFFICE_ID() {
			return OFFICE_ID;
		}

		public void setOFFICE_ID(String oFFICE_ID) {
			OFFICE_ID = oFFICE_ID;
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
				return Objects.hash(OFFICENAME_AR, OFFICE_ID, officeName, row_num, totalCount);
			}

			@Override
			public boolean equals(Object obj) {
				if (this == obj)
					return true;
				if (obj == null)
					return false;
				if (getClass() != obj.getClass())
					return false;
				ViewDoctorOfficeCountAll other = (ViewDoctorOfficeCountAll) obj;
				return Objects.equals(OFFICENAME_AR, other.OFFICENAME_AR) && Objects.equals(OFFICE_ID, other.OFFICE_ID)
						&& Objects.equals(officeName, other.officeName) && row_num == other.row_num
						&& totalCount == other.totalCount;
			}
		
		
		
			
}
