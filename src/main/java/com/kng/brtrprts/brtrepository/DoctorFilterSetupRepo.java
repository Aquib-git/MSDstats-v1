package com.kng.brtrprts.brtrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.brtrprts.brtmodel.DoctorsFilterSetup;

public interface DoctorFilterSetupRepo extends JpaRepository<DoctorsFilterSetup, Integer> 
{
	String sqlStmt="SELECT us.*\r\n"
			+ "FROM ECLINIC_KNG.USER_SETUP us \r\n"
			+ "INNER JOIN ECLINIC_KNG.USERS_DEPARTMENTS ud \r\n"
			+ "ON(us.USER_ID=ud.USER_ID)\r\n"
			+ "INNER JOIN ECLINIC_KNG.DEPARTMENT_SETUP ds \r\n"
			+ "on(ud.DEPARTMENT_ID=ds.DEPARTMENT_ID)\r\n"
			+ "WHERE ds.DEPARTMENT_ID=?\r\n"
			+ "AND us.USER_TYPE='D'\r\n"
			+ "ORDER BY us.USER_LABEL ASC;";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<DoctorsFilterSetup> getDoctorListByOfficeId(int departmentId);
	

}
