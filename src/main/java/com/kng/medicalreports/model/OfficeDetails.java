package com.kng.medicalreports.model;

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

@Entity
@Table(name="OFFICE_DETAILS",catalog="ECLINIC")
public class OfficeDetails implements Serializable {

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOfficeId() {
		return officeId;
	}

	public void setOfficeId(int officeId) {
		this.officeId = officeId;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public String getOfficeSubName() {
		return officeSubName;
	}

	public void setOfficeSubName(String officeSubName) {
		this.officeSubName = officeSubName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public Date getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(Date activeDate) {
		this.activeDate = activeDate;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getOpNumPrefix() {
		return opNumPrefix;
	}

	public void setOpNumPrefix(String opNumPrefix) {
		this.opNumPrefix = opNumPrefix;
	}
	
	
	
}
