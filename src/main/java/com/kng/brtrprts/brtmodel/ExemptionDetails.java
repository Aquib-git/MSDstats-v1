package com.kng.brtrprts.brtmodel;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExemptionDetails implements Serializable
{
	
	private static final long serialVersionUID = -4004441099552797980L;

	private int serNo;
	private int officeId;
	private String officeName;
	private int deptId;
	private String deptName;
	private String deptNameAr;
	private int doctorId;
	private String doctorName;
	private String doctorNameAr;	
	private Date visitDate;
	private String civilId;
	private String militaryId;
	private String patientNameAr;
	private Date exeFrom;
	private Date exeTo;
	private String leaveExemptions;
	private int numOfDays;

}
