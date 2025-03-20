package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="VIEW_LABRADTESTS_OFFICE_COUNT_TODAY",catalog="ECLINIC")
@Table(name="VIEW_LABRADTESTS_OFFICE_COUNT_ALL_V2",catalog="ECLINIC")
public class ViewLabRadTestsOfficeCountToday implements Serializable {
	
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 688904883495632035L;

	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="OFFICE_NAME")
	private String officeName;
	
	@Column(name="OFFICENAME_AR")
	private String OFFICENAME_AR;
	
	@Column(name="LAB_TEST_COUNT")
	private long totalLabCount;
	
	@Column(name="RAD_TEST_COUNT")
	private long totalRadCount;
	
	@Column(name="CONSULT_DATE")
	private String CONSULT_DATE;
	
	@Column(name="OFFICE_ID")
	private int officeId;

	

	/**
	 * 
	 */
	public ViewLabRadTestsOfficeCountToday() {
		
	}
	
	
	

	/**
	 * @param name
	 * @param officeId
	 * @param totalLabCount
	 * @param totalRadCount
	 */
	public ViewLabRadTestsOfficeCountToday(String officeName, int officeId, long totalLabCount, long totalRadCount) {
		super();
		this.officeName = officeName;
		this.officeId = officeId;
		this.totalLabCount = totalLabCount;
		this.totalRadCount = totalRadCount;
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




	public long getTotalLabCount() {
		return totalLabCount;
	}

	public void setTotalLabCount(long totalLabCount) {
		this.totalLabCount = totalLabCount;
	}

	public long getTotalRadCount() {
		return totalRadCount;
	}

	public void setTotalRadCount(long totalRadCount) {
		this.totalRadCount = totalRadCount;
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
	public String toString() {
		return "ViewLabRadTestsOfficeCountToday [row_num=" + row_num + ", officeName=" + officeName + ", OFFICENAME_AR="
				+ OFFICENAME_AR + ", totalLabCount=" + totalLabCount + ", totalRadCount=" + totalRadCount
				+ ", CONSULT_DATE=" + CONSULT_DATE + ", officeId=" + officeId + "]";
	}




	@Override
	public int hashCode() {
		return Objects.hash(CONSULT_DATE, OFFICENAME_AR, officeId, officeName, row_num, totalLabCount, totalRadCount);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewLabRadTestsOfficeCountToday other = (ViewLabRadTestsOfficeCountToday) obj;
		return Objects.equals(CONSULT_DATE, other.CONSULT_DATE) && Objects.equals(OFFICENAME_AR, other.OFFICENAME_AR)
				&& officeId == other.officeId && Objects.equals(officeName, other.officeName)
				&& row_num == other.row_num && totalLabCount == other.totalLabCount
				&& totalRadCount == other.totalRadCount;
	}

	
	
	

}
