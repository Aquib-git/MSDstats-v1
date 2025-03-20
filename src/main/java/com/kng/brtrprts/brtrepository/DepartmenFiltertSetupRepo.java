package com.kng.brtrprts.brtrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.brtrprts.brtmodel.DepartmentFilterSetup;
import com.kng.brtrprts.brtmodel.OfficeFilterDetails;

public interface DepartmenFiltertSetupRepo extends JpaRepository<DepartmentFilterSetup, Integer>
{
	/*
	 * public DepartmentFilterSetup getDepartmentById(int id); public
	 * List<DepartmentFilterSetup> getAllDepartment();
	 */

	String sqlStmt="\r\n"
			+ "SELECT ds.* \r\n"
			+ "FROM ECLINIC_KNG.DEPARTMENT_SETUP ds \r\n"
			+ "INNER JOIN ECLINIC_KNG.DEPARTMENT_OFFICE do \r\n"
			+ "	on(ds.DEPARTMENT_ID=do.DEPARTMENT_ID)\r\n"
			+ "INNER JOIN ECLINIC_KNG.OFFICE_DETAILS od \r\n"
			+ "	on(do.OFFICE_ID=od.OFFICE_ID)\r\n"
			+ "WHERE od.office_id=?\r\n"
			+ "ORDER BY ds.DEPARTMENT_NAME asc";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<DepartmentFilterSetup> getDepartmentListByOfficeId(int officeId);
	
	String sqlStmt2=" SELECT * FROM ECLINIC_KNG.DEPARTMENT_SETUP ds where ds.ACTIVE_STATUS='Y' ";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<DepartmentFilterSetup> getAllDepartmentList();

}
