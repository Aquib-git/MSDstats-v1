package com.kng.medicalreports.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="VIEW_PATIENT_VISIT_RET_OFFICE_COUNT_ALL_V2",catalog="ECLINIC")
public class ViewPatientRetiredOfficeCountToday
{
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="OFFICE_NAME")
	private String officeName;
	
	
	@Column(name="OFFICE_ID")
	private int officeId;

	@Column(name="PATIENT_COUNT")
	private long totalCount;

	
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
		ViewPatientRetiredOfficeCountToday other = (ViewPatientRetiredOfficeCountToday) obj;
		return Objects.equals(officeName, other.officeName) && row_num == other.row_num
				&& totalCount == other.totalCount;
	}

	
}
