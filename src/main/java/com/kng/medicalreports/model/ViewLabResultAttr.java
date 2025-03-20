package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
//import java.util.Date;
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
@Table(name="VIEW_LAB_RSLT_ATTR_FETCH",catalog="ECLINIC")
public class ViewLabResultAttr implements Serializable {
	
	
	public ViewLabResultAttr() {
		
		
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4535350470101898162L;

	@Id
	@Column(name="row_num")
	private int row_num;
	

	
	@Column(name="CONSULT_ID")
	private  Integer  CONSULT_ID;
	
	@Column(name="TEST_ID")
	private  Integer TEST_ID;
	
//	@Column(name="TEST_NAME")
//	private String TEST_NAME;
//	
//	@Column(name="TEST_RESULT")
//	private String TEST_RESULT;
//	
	
	@Column(name="TEST_DETAILSID")
	private  Integer TEST_DETAILSID;
	
	@Column(name="OP_NUMBER")
	private String OP_NUMBER;

	
	@Column(name="LAB_IDNO")
	private  Integer LAB_IDNO;

	/*
	 * @Column(name="CATEGORY_ID") private String CATEGORY_ID;
	 */
	

	//
	
	

	
}
