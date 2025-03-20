package com.kng.medicalreports.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.*;

public interface ViewDocInfoTodayRepository extends JpaRepository<ViewDocInfoToday,Integer> {
	
	
//	@Query("SELECT u FROM ViewDocInfoToday u WHERE u.CONSULT_DATE BETWEEN ?1 AND ?2 ")
//	public List<ViewDocInfoToday> findAllByRangeDate(String Form ,String To);
	
	String sqlStmt="CALL ECLINIC.PROC_DOC_CLICK_ALL_V2(?,?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<ViewDocInfoToday> findAllByRangeDate(String Form ,String To);
	
	String sqlStmt2="CALL ECLINIC.PROC_DOC_CLICK_ALL_V2_COPY(?,?,?)";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<ViewDocInfoToday> findAllByRangeDate(String Form ,String To,int ofcId);
	
	String sqlStmt4="CALL ECLINIC.PROC_DOC_DEMO_PATCOUNT_FETCH_ALL_V3(?,?,?)";
	@Query(value=sqlStmt4,nativeQuery=true)
	public List<ViewDocInfoToday> findDocDemographDetailsV2(Integer doctorId, Integer departmentId, String consultDate);
	
	
	
	
	/*
	 The below method will not work for if the scenarios are:
	 	SCENARIO 1: doctor visited more than one clinic a single day. (department id assigned to department is unique) 
	 	SCENARIO 2: doctor is assigned to more than one clinic a single day.
	 So the solution is to implement `findDocDemographDetailsV2` method.
	 */
	String sqlStmt3="CALL ECLINIC.PROC_DOC_DEMO_PATCOUNT_FETCH_ALL_V2(?,?)";
	@Query(value=sqlStmt3,nativeQuery=true)
	public List<ViewDocInfoToday> findDocDemographDetails(Integer doctorId, String consultDate);
}
