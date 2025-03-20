package com.kng.lab.labmodel;

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
@Table(name="VIEW_LAB_AA_OFFICE_COUNT_ALL",catalog="ECLINIC")
public class LabAccessionAcknowledgeOfficeCountAll 
{
	@Id
	@Column(name="row_num")
	private int row_num;

	@Column(name="OFFICE_ID")
	private int OFFICE_ID;
	
	@Column(name="OFFICE_NAME")
	private String OFFICE_NAME;
	
	@Column(name="OFFICENAME_AR")
	private String OFFICENAME_AR;
	
	
	@Column(name="LAB_TEST_COUNT")
	private long LAB_TEST_COUNT;

}
