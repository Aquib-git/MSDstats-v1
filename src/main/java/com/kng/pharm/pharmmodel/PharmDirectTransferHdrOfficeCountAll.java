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
@Table(name="VIEW_PHA_DT_HDR_OFFICE_COUNT_ALL",catalog="ECLINIC")
public class PharmDirectTransferHdrOfficeCountAll 
{
	@Id
	@Column(name="ROW_NUM")
	private int ROW_NUM;
	
	@Column(name="OFFICE_ID")
	private int OFFICE_ID;
	
	@Column(name="OFFICE_NAME")
	private String OFFICE_NAME;
	
	@Column(name="OFFICENAME_AR")
	private String OFFICENAME_AR;
		
	@Column(name="PHA_COUNT")
	private long PHA_COUNT;
}
