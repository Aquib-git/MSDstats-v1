package com.kng.medicalreports.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="VIEW_DOC_DASHBOARD_LIST_KNG_ALL",catalog="ECLINIC")
public class ViewDoctorDashboardListKng implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5501471708241829902L;
	
	@Id
	@Column(name="DOCTORS_ID")
	private Integer doctorId;
	
	@Column(name="EMPLOYEE_ID")
	private Integer empId;
	
	@Column(name="NO_OF_DAYS")
	private Integer noOfDays;
	
	@Column(name="DAYS_WORKED")
	private Integer daysWorked;
	
	@Column(name="DOCTOR_DESIG")
	private String DOCTOR_DESIG;
	
	
	/*
	 * @Column(name="Listof_Years") private Integer Listof_Years;
	 */
	
	@Column(name="PATIENT_COUNT")
	private Integer patientCount;
	
	@Column(name="OFFICE_COUNT")
	private Integer officeCount;
	
	
	@Column(name="KWT_NKWT")
	private String kwtAndNkwt;
	
	@Column(name="USER_LABEL")
	private String uaserLabel;
	
	
	@Column(name="USERLABEL_AR")
	private String USERLABEL_AR;
	
	
	
	@Column(name="DOCTOR_TYPE")
	private String doctorType;
	
	@Column(name="DEPT_ID_DOCTOR_WORKED_LIST")
	private String deptIdDoctorWorkedList;
	
	@Column(name="DEPT_NAME_DOCTOR_WORKED_LIST")
	private String deptNameDoctorWorkedList;
	
	@Column(name="DEPT_NAME_DOCTOR_WORKED_LIST_AR")
	private String DEPT_NAME_DOCTOR_WORKED_LIST_AR;
	
	
	@Column(name="OFFICES_DOCTOR_WORKED_LIST")
	private String officeNameDoctorWorkedList;
	
	
	
	@Column(name="OFFICES_DOCTOR_WORKED_LIST_AR")
	private String OFFICES_DOCTOR_WORKED_LIST_AR;
	
	
	@Column(name="DOCTOR_RANK")
	private String DOCTOR_RANK;
	
	@Column(name="KNG_MOH")
    private String KNG_MOH;	
	
	@Transient
	private String officeName;
	
	@Transient
	private String deptname;
	
	@Transient
	private String deptnameList;
 

	@Transient
	private String officeNameList;
	
	
	@Transient
	private String officeName_ar;
	
	@Transient
	private String deptname_ar;
	
	@Transient
	private String deptnameList_ar;
 

	@Transient
	private String officeNameList_ar;
	
	
	
	/**
	 * 
	 */
	public ViewDoctorDashboardListKng() {
		
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public Integer getNoOfDays() {
		return noOfDays;
	}

	public void setNoOfDays(Integer noOfDays) {
		this.noOfDays = noOfDays;
	}

	public Integer getDaysWorked() {
		return daysWorked;
	}

	public void setDaysWorked(Integer daysWorked) {
		this.daysWorked = daysWorked;
	}
	
	
	

	/*
	 * public Integer getListof_Years() { return Listof_Years; }
	 * 
	 * public void setListof_Years(Integer listof_Years) { Listof_Years =
	 * listof_Years; }
	 */
	public Integer getPatientCount() {
		return patientCount;
	}

	public void setPatientCount(Integer patientCount) {
		this.patientCount = patientCount;
	}

	public Integer getOfficeCount() {
		return officeCount;
	}

	public void setOfficeCount(Integer officeCount) {
		this.officeCount = officeCount;
	}

	public String getKwtAndNkwt() {
		return kwtAndNkwt;
	}

	public void setKwtAndNkwt(String kwtAndNkwt) {
		this.kwtAndNkwt = kwtAndNkwt;
	}

	public String getUaserLabel() {
		return uaserLabel;
	}

	public void setUaserLabel(String uaserLabel) {
		this.uaserLabel = uaserLabel;
	}
	
	

	public String getUSERLABEL_AR() {
		return USERLABEL_AR;
	}

	
	public void setUSERLABEL_AR(String uSERLABEL_AR) {
		USERLABEL_AR = uSERLABEL_AR;
	}

	

	public String getDoctorType() {
		return doctorType;
	}

	public void setDoctorType(String doctorType) {
		this.doctorType = doctorType;
	}

	public String getDeptIdDoctorWorkedList() {
		return deptIdDoctorWorkedList;
	}

	public void setDeptIdDoctorWorkedList(String deptIdDoctorWorkedList) {
		this.deptIdDoctorWorkedList = deptIdDoctorWorkedList;
	}

	public String getDeptNameDoctorWorkedList() {
		return deptNameDoctorWorkedList;
	}

	public void setDeptNameDoctorWorkedList(String deptNameDoctorWorkedList) {
		this.deptNameDoctorWorkedList = deptNameDoctorWorkedList;
	}

	public String getOfficeNameDoctorWorkedList() {
		return officeNameDoctorWorkedList;
	}

	public void setOfficeNameDoctorWorkedList(String officeNameDoctorWorkedList) {
		this.officeNameDoctorWorkedList = officeNameDoctorWorkedList;
	}
	
	//----------------------------------------------------------------------

	public String getOfficeName() {
		String [] name =this.officeNameDoctorWorkedList.split(",");
		officeName=name[0];
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	

	public String getDeptname() {
		String [] name =this.deptNameDoctorWorkedList.split(",");
		deptname=name[0];
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	


	public String getDeptnameList() {
		String [] name =this.deptNameDoctorWorkedList.split(",");
		name=Arrays.stream(name).distinct().toArray(String[]::new);
		deptnameList=Arrays.toString(name).replace('[', ' ').replace(']',' ');
		return deptnameList;
	}

	public void setDeptnameList(String deptnameList) {
		this.deptnameList = deptnameList;
	}


	public String getOfficeNameList() {
		String [] name =this.officeNameDoctorWorkedList.split(",");
		name=Arrays.stream(name).distinct().toArray(String[]::new);
		officeNameList=Arrays.toString(name).replace('[', ' ').replace(']',' ');
		return officeNameList;
	}

	public void setOfficeNameList(String officeNameList) {
		this.officeNameList = officeNameList;
	}

	

//-------------------------------------------Arabic start-----------------------
	
	public String getOfficeName_ar() {
		
		
		String [] name =this.OFFICES_DOCTOR_WORKED_LIST_AR.split(",");
		officeName_ar=name[0];
		
		
		return officeName_ar;
	}

	public void setOfficeName_ar(String officeName_ar) {
		this.officeName_ar = officeName_ar;
	}
	
	
	
	

	public String getDeptname_ar() {
		
		String [] name =this.DEPT_NAME_DOCTOR_WORKED_LIST_AR.split(",");
		deptname_ar=name[0];
		return deptname_ar;
	}

	public void setDeptname_ar(String deptname_ar) {
		this.deptname_ar = deptname_ar;
	}

	
	
	
	public String getDeptnameList_ar() {
		
		String [] name =this.DEPT_NAME_DOCTOR_WORKED_LIST_AR.split(",");
		name=Arrays.stream(name).distinct().toArray(String[]::new);
		deptnameList_ar=Arrays.toString(name).replace('[', ' ').replace(']',' ');
		
		
		return deptnameList_ar;
	}

	public void setDeptnameList_ar(String deptnameList_ar) {
		this.deptnameList_ar = deptnameList_ar;
	}

	
	
	
	public String getOfficeNameList_ar() {
		
		String [] name =this.OFFICES_DOCTOR_WORKED_LIST_AR.split(",");
		name=Arrays.stream(name).distinct().toArray(String[]::new);
		officeNameList_ar=Arrays.toString(name).replace('[', ' ').replace(']',' ');
	
		return officeNameList_ar;
		
	}

	public void setOfficeNameList_ar(String officeNameList_ar) {
		this.officeNameList_ar = officeNameList_ar;
	}

	
	//====================================================================
	
	
	public String getDEPT_NAME_DOCTOR_WORKED_LIST_AR() {
		return DEPT_NAME_DOCTOR_WORKED_LIST_AR;
	}

	public void setDEPT_NAME_DOCTOR_WORKED_LIST_AR(String dEPT_NAME_DOCTOR_WORKED_LIST_AR) {
		DEPT_NAME_DOCTOR_WORKED_LIST_AR = dEPT_NAME_DOCTOR_WORKED_LIST_AR;
	}

	public String getOFFICES_DOCTOR_WORKED_LIST_AR() {
		return OFFICES_DOCTOR_WORKED_LIST_AR;
	}

	public void setOFFICES_DOCTOR_WORKED_LIST_AR(String oFFICES_DOCTOR_WORKED_LIST_AR) {
		OFFICES_DOCTOR_WORKED_LIST_AR = oFFICES_DOCTOR_WORKED_LIST_AR;
	}

	public String getDOCTOR_RANK() {
		return DOCTOR_RANK;
	}

	public void setDOCTOR_RANK(String dOCTOR_RANK) {
		DOCTOR_RANK = dOCTOR_RANK;
	}

	public String getKNG_MOH() {
		return KNG_MOH;
	}

	public void setKNG_MOH(String kNG_MOH) {
		KNG_MOH = kNG_MOH;
	}
	

	public String getDOCTOR_DESIG() {
		return DOCTOR_DESIG;
	}

	public void setDOCTOR_DESIG(String dOCTOR_DESIG) {
		DOCTOR_DESIG = dOCTOR_DESIG;
	}

	@Override
	public int hashCode() {
		return Objects.hash(DEPT_NAME_DOCTOR_WORKED_LIST_AR, DOCTOR_DESIG, DOCTOR_RANK, KNG_MOH,
				OFFICES_DOCTOR_WORKED_LIST_AR, USERLABEL_AR, daysWorked, deptIdDoctorWorkedList,
				deptNameDoctorWorkedList, deptname, deptnameList, doctorId, doctorType, empId, kwtAndNkwt, noOfDays,
				officeCount, officeName, officeNameDoctorWorkedList, officeNameList, patientCount, uaserLabel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ViewDoctorDashboardListKng other = (ViewDoctorDashboardListKng) obj;
		return Objects.equals(DEPT_NAME_DOCTOR_WORKED_LIST_AR, other.DEPT_NAME_DOCTOR_WORKED_LIST_AR)
				&& Objects.equals(DOCTOR_DESIG, other.DOCTOR_DESIG) && Objects.equals(DOCTOR_RANK, other.DOCTOR_RANK)
				&& Objects.equals(KNG_MOH, other.KNG_MOH)
				&& Objects.equals(OFFICES_DOCTOR_WORKED_LIST_AR, other.OFFICES_DOCTOR_WORKED_LIST_AR)
				&& Objects.equals(USERLABEL_AR, other.USERLABEL_AR) && Objects.equals(daysWorked, other.daysWorked)
				&& Objects.equals(deptIdDoctorWorkedList, other.deptIdDoctorWorkedList)
				&& Objects.equals(deptNameDoctorWorkedList, other.deptNameDoctorWorkedList)
				&& Objects.equals(deptname, other.deptname) && Objects.equals(deptnameList, other.deptnameList)
				&& Objects.equals(doctorId, other.doctorId) && Objects.equals(doctorType, other.doctorType)
				&& Objects.equals(empId, other.empId) && Objects.equals(kwtAndNkwt, other.kwtAndNkwt)
				&& Objects.equals(noOfDays, other.noOfDays) && Objects.equals(officeCount, other.officeCount)
				&& Objects.equals(officeName, other.officeName)
				&& Objects.equals(officeNameDoctorWorkedList, other.officeNameDoctorWorkedList)
				&& Objects.equals(officeNameList, other.officeNameList)
				&& Objects.equals(patientCount, other.patientCount) && Objects.equals(uaserLabel, other.uaserLabel);
	}

	@Override
	public String toString() {
		return "ViewDoctorDashboardListKng [doctorId=" + doctorId + ", empId=" + empId + ", noOfDays=" + noOfDays
				+ ", daysWorked=" + daysWorked + ", DOCTOR_DESIG=" + DOCTOR_DESIG + ", patientCount=" + patientCount
				+ ", officeCount=" + officeCount + ", kwtAndNkwt=" + kwtAndNkwt + ", uaserLabel=" + uaserLabel
				+ ", USERLABEL_AR=" + USERLABEL_AR + ", doctorType=" + doctorType + ", deptIdDoctorWorkedList="
				+ deptIdDoctorWorkedList + ", deptNameDoctorWorkedList=" + deptNameDoctorWorkedList
				+ ", DEPT_NAME_DOCTOR_WORKED_LIST_AR=" + DEPT_NAME_DOCTOR_WORKED_LIST_AR
				+ ", officeNameDoctorWorkedList=" + officeNameDoctorWorkedList + ", OFFICES_DOCTOR_WORKED_LIST_AR="
				+ OFFICES_DOCTOR_WORKED_LIST_AR + ", DOCTOR_RANK=" + DOCTOR_RANK + ", KNG_MOH=" + KNG_MOH
				+ ", officeName=" + officeName + ", deptname=" + deptname + ", deptnameList=" + deptnameList
				+ ", officeNameList=" + officeNameList + "]";
	}



}
