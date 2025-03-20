package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.*;

public interface ViewPatientVisitDeptTodayRepository extends JpaRepository<ViewPatientVisitDeptToday, Integer> {
	
//	@Query("SELECT u FROM ViewPatientVisitDeptToday u WHERE u.CONSULT_DATE BETWEEN ?1 AND ?2 ")
//	public List<ViewPatientVisitDeptToday> findViewPatientVisitDeptByRangeDate(String Form ,String To);
//	

	//ESLAMS CODE BEFORE HE LEFT
//	@Query("SELECT new com.kng.medicalreports.model.ViewPatientVisitDeptToday(u.Name,u.flagFilter,sum(u.totalCount)) \r\n"
//			+ "FROM ViewPatientVisitDeptToday u WHERE u.CONSULT_DATE BETWEEN ?1 AND ?2  \r\n"
//			+ "GROUP BY \r\n"
//			+ "u.Name,u.flagFilter Order by u.Name ")
//	public List<ViewPatientVisitDeptToday> findViewPatientVisitDeptByRangeDate(String Form ,String To);
//	
	
	
	  String sqlStmt="CALL ECLINIC.PROC_PATIENT_VISIT_DEPT_COUNT_ALL_V2_COPY(?,?,?)";
	  
	  
	  @Query(value=sqlStmt,nativeQuery=true) public List<ViewPatientVisitDeptToday>
	  findViewPatientVisitDeptByRangeDate(String Form ,String To,int ofcId);
	  

	String sqlStmt2="CALL ECLINIC.PROC_PATIENT_VISIT_DEPT_COUNT_ALL_V2_DUP(?,?)";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<ViewPatientVisitDeptToday> findViewPatientVisitDeptByRangeDate(String Form ,String To);
	
	
}
