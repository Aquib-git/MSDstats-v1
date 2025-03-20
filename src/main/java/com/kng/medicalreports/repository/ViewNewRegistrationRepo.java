package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.ViewNewRegistration;

public interface ViewNewRegistrationRepo extends JpaRepository<ViewNewRegistration, Integer>
{
	//String sqlStmt="SELECT * FROM ECLINIC.VIEW_NR vn";
	/*String sqlStmt="SELECT \r\n"
			+ "nr.OP_ID,\r\n"
			+ "nr.EMPLOYEE_ID AS \"PATIENT_EMPLOYEE_ID\",\r\n"
			+ "nr.PATIENT_NAME ||'_'|| nr.EMPLOYEE_ID AS \"PATIENT_NAME\"\r\n"
			+ "FROM ECLINIC_KNG.NEW_REGISTRATION nr";*/
	
	
	String sqlStmt="CALL ECLINIC.PROC_NR(?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<ViewNewRegistration> getNewRegistrationDetails(String srchtrm);

}
