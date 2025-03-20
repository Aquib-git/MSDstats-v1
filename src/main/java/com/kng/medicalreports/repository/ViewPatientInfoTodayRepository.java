package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.*;

public interface ViewPatientInfoTodayRepository extends JpaRepository<ViewPatientInfoToday, Integer> {
	
//	@Query("SELECT u FROM ViewPatientInfoToday u WHERE u.CONSULT_DATE BETWEEN ?1 AND ?2 ")
//	public List<ViewPatientInfoToday> findAllByRangeDate(String Form ,String To);
	
	
	  String sqlStmt="CALL ECLINIC.PROC_PAT_CLICK_ALL_V2_COPY(?,?,?)";
	  
	  @Query(value=sqlStmt,nativeQuery=true) 
	  public List<ViewPatientInfoToday>  findAllByRangeDate(String Form ,String To,int ofcId);
	 
	
	String sqlStmt2="CALL ECLINIC.PROC_PAT_CLICK_ALL_V2(?,?)";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<ViewPatientInfoToday> findAllByRangeDate(String Form ,String To);
	
	
	String sqlStmt7="CALL ECLINIC.PROC_DOC_PATCOUNT_FETCH_ALL_V3(?,?,?)";
	@Query(value=sqlStmt7,nativeQuery=true)
	public List<ViewPatientInfoToday> findAllBydoctorIdV2(Integer doctorId, Integer departmentId, String consultDate);
	
	String sqlStmt4="CALL ECLINIC.PROC_MRDEID_PAT_FETCH_ALL_V2(?);";
	@Query(value=sqlStmt4,nativeQuery=true)
	public List<ViewPatientInfoToday> findMRDEID(String eid);
	
	String sqlStmt5="CALL  ECLINIC.PROC_MRDEID_DATE_PAT_FETCH_ALL_V2(?,?,?);";
	@Query(value=sqlStmt5,nativeQuery=true)
	public List<ViewPatientInfoToday> findMRDEID2(String eid, String fdate, String tdate);
	
	String sqlStmt6="CALL  ECLINIC.PROC_PAT_FETCH_ALL_V2(?);";
	@Query(value=sqlStmt6,nativeQuery=true)
	public List<ViewPatientInfoToday> findByConsultId(int consultid);
	
	
	
	/*
	 The below method will not work for if the scenarios are:
	 	SCENARIO 1: doctor visited more than one clinic a single day. (department id assigned to department is unique) 
	 	SCENARIO 2: doctor is assigned to more than one clinic a single day.
	 So the solution is to implement `findDocDemographDetailsV2` method.
	 */
	String sqlStmt3="CALL ECLINIC.PROC_DOC_PATCOUNT_FETCH_ALL_V2(?,?)";
	@Query(value=sqlStmt3,nativeQuery=true)
	public List<ViewPatientInfoToday> findAllBydoctorId(Integer doctorId, String consultDate);
	
	
}
