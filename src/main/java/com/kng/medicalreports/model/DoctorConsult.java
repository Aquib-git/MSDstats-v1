package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="DOCTOR_CONSULT",catalog="ECLINIC")
public class DoctorConsult implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CONSULT_ID")
	private int consultId;
	
	
	@Column(name="CONSULT_DATE")
	@Temporal(TemporalType.DATE)
	private Date consultDate;
	
	@Column(name="PATIENTNAME_AR")
	private String patientName_AR;
	

	@Column(name="PATIENT_NAME")
	private String patientName;


	
   public DoctorConsult() {
		
	}
	
	public DoctorConsult(int consultId, Date consultDate, String patientName_AR, String patientName) {
		super();
		this.consultId = consultId;
		this.consultDate = consultDate;
		this.patientName_AR = patientName_AR;
		this.patientName = patientName;
	}


	
	public int getConsultId() {
		return consultId;
	}


	public void setConsultId(int consultId) {
		this.consultId = consultId;
	}


	public Date getConsultDate() {
		return consultDate;
	}


	public void setConsultDate(Date consultDate) {
		this.consultDate = consultDate;
	}


	public String getPatientName_AR() {
		return patientName_AR;
	}


	public void setPatientName_AR(String patientName_AR) {
		this.patientName_AR = patientName_AR;
	}


	public String getPatientName() {
		return patientName;
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(consultDate, consultId, patientName, patientName_AR);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoctorConsult other = (DoctorConsult) obj;
		return Objects.equals(consultDate, other.consultDate) && consultId == other.consultId
				&& Objects.equals(patientName, other.patientName)
				&& Objects.equals(patientName_AR, other.patientName_AR);
	}
	
	
	
}
