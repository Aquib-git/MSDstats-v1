package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VIEW_DOC_RAD_CAT_TESTCOUNT_ALL",catalog="ECLINIC")
public class ViewDocRadCatTestCount implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="CATEGORY_NAME")
	private String Name;
	
	
	@Column(name="TEST_COUNT")
	private int totalCount;
	
  public ViewDocRadCatTestCount() {
		
	}
	
	public int getRow_num() {
		return row_num;
	}


	public void setRow_num(int row_num) {
		this.row_num = row_num;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	public int getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}




	@Override
	public int hashCode() {
		return Objects.hash(Name, row_num, totalCount);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewDocRadCatTestCount other = (ViewDocRadCatTestCount) obj;
		return Objects.equals(Name, other.Name) && row_num == other.row_num && totalCount == other.totalCount;
	}
	
}
	