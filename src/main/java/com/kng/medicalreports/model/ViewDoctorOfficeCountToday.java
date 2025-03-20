package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name="VIEW_DOCTOR_OFFICE_COUNT_TODAY",catalog="ECLINIC")
@Table(name="VIEW_DOCTOR_OFFICE_COUNT_ALL_V2",catalog="ECLINIC")
public class ViewDoctorOfficeCountToday implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="OFFICE_NAME")
	private String officeName;
	
	
	@Column(name="OFFICE_ID")
	private int officeId;

	@Column(name="DOCTOR_COUNT")
	private long totalCount;
	
	@Column(name="CONSULT_DATE")
	private String CONSULT_DATE;
	
	public ViewDoctorOfficeCountToday() {
		
	}
	
	public ViewDoctorOfficeCountToday(String officeName, int officeId,long totalCount) {
		this.officeName = officeName;
		this.totalCount = totalCount;
		this.officeId = officeId;
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
		
			public long getTotalCount() {
				return totalCount;
			}
		
		
		
			public void setTotalCount(long totalCount) {
				this.totalCount = totalCount;
			}
		
		
		
			public int getOfficeId() {
				return officeId;
			}

			public void setOfficeId(int officeId) {
				this.officeId = officeId;
			}

			public String getCONSULT_DATE() {
				return CONSULT_DATE;
			}

			public void setCONSULT_DATE(String cONSULT_DATE) {
				CONSULT_DATE = cONSULT_DATE;
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
				ViewDoctorOfficeCountToday other = (ViewDoctorOfficeCountToday) obj;
				return Objects.equals(officeName, other.officeName) && row_num == other.row_num
						&& totalCount == other.totalCount;
			}
}

