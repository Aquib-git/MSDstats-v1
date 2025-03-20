package com.kng.brtrprts.brtmodel;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="OFFICE_DETAILS",catalog="ECLINIC_KNG")
public class OfficeFilterDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5741253638649681830L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="OFFICE_ID")
	private int officeId;
	
	@Column(name="OFFICE_NAME")
	private String officeName;
	
	@Column(name="OFFICE_SUB_NAME")
	private String officeSubName;
	
	@Column(name="ADDRESS1")
	private String address1;
	
	@Column(name="ADDRESS2")
	private String address2;
	
	@Column(name="ADDRESS3")
	private String address3;
	
	@Column(name="PHONE_NUMBERS")
	private String phoneNumber;
	
	@Column(name="FAX_NUMBERS")
	private String faxNumber;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="WEBSITE")
	private String website;
	
	@Column(name="ACTIVE_DATE")
	@Temporal(TemporalType.DATE)
	private Date activeDate;
	
	@Column(name="ACTIVE_STATUS")
	private String activeStatus;
	
	@Column(name="PLACE")
	private String place;
	
	@Column(name="OP_NUMBER_PREFIX")
	private String opNumPrefix;

}
