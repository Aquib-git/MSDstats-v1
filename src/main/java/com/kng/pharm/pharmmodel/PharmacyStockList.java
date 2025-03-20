package com.kng.pharm.pharmmodel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="VIEW_PHA_STCK_LIST_ALL",catalog="ECLINIC")
public class PharmacyStockList 
{
	@Id
	@Column(name="row_num")
	private int row_num;
	
	@Column(name="ITEM_ID")
	private String ITEM_ID;
	
	@Column(name="ITEM_NAME")
	private String ITEM_NAME;
	
	@Column(name="ITEM_CODE")
	private String ITEM_CODE;
	
	@Column(name="ITEM_UNIT")
	private String ITEM_UNIT;
	
	@Column(name="PACK_UNIT")
	private String PACK_UNIT;
	
	@Column(name="PHARMACY_STOCK")
	private Double PHARMACY_STOCK;
	
	@Column(name="OFFICE_ID")
	private Integer OFFICE_ID;
	
	@Column(name="OFFICE_NAME")
	private String OFFICE_NAME;
	
	@Column(name="OFFICENAME_AR")
	private String OFFICENAME_AR;

	public String getOFFICE_NAME() {
		
		OFFICE_NAME=this.OFFICE_NAME.replace("-MultiSpeciality","");
		
		return OFFICE_NAME;
	}
}
