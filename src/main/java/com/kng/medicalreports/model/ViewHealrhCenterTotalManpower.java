package com.kng.medicalreports.model;

import java.io.Serializable;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="VIEW_HEALTH_CENTER_TOTAL_MANPOWER",catalog="ECLINIC")
public class ViewHealrhCenterTotalManpower implements Serializable {

	/**
	 * 
	 */ 
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="OFFICE_NAME")
	private String officeName;
	

	@Column(name="TOTAL_COUNT")
	private int totalCount;
	
	

  public ViewHealrhCenterTotalManpower() {
			
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
			ViewHealrhCenterTotalManpower other = (ViewHealrhCenterTotalManpower) obj;
			return Objects.equals(officeName, other.officeName) && row_num == other.row_num
					&& totalCount == other.totalCount;
		}


	
}
