package com.kng.brtrprts.brtmodel;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="DOCTORS_SETUP",catalog="ECLINIC_KNG")
public class DoctorsFilterSetup {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USER_ID")
	private int doctorId;
	
	@Column(name="USER_LABEL")
	private String doctorName;
	
	@Column(name="USERLABEL_AR")
	private String doctorNameAr;
	
	@Column(name="USER_TYPE")
	private String doctorType;
	
	@Column(name="ACTIVE_STATUS")
	private String activeStatus;
}