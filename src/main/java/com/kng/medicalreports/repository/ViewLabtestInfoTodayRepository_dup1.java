package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.*;

public interface ViewLabtestInfoTodayRepository_dup1 extends JpaRepository<ViewLabtestInfoToday_dup1, Integer>{
	
//	@Query("SELECT u FROM ViewLabtestInfoToday u WHERE u.CONSULT_DATE BETWEEN ?1 AND ?2 ")
//	public List<ViewLabtestInfoToday> findAllByRangeDate(String Form ,String To);
	
	  String sqlStmt="CALL ECLINIC.PROC_LABTEST_CLICK_ALL_V2_COPY(?,?,?)";
	  
	  @Query(value=sqlStmt,nativeQuery=true) public List<ViewLabtestInfoToday>
	  findAllByRangeDate(String Form ,String To,int ofcId);
	  
	  String sqlStmt2="CALL ECLINIC.PROC_LABTEST_CLICK_ALL_V2(?,?)";
	  
	  @Query(value=sqlStmt2,nativeQuery=true) public List<ViewLabtestInfoToday>
	  findAllByRangeDate(String Form ,String To);
	  
	  
	  
	  
	  
	  String sqlStmt3="CALL ECLINIC.PROC_PAT_LAB_FETCH_ALL_V2(?)";
	  
	  @Query(value=sqlStmt3,nativeQuery=true) public List<ViewLabtestInfoToday>
	  findByConsultId(int consultId);
	  
	  String sqlStmt4="CALL ECLINIC.PROC_MRD_LAB_FETCH_ALL_V2(?)";
	  
	  @Query(value=sqlStmt4,nativeQuery=true) public List<ViewLabtestInfoToday>
	  findByCivilId(String civilId);
	  
	  String sqlStmt5="CALL ECLINIC.PROC_MRDEID_LAB_FETCH_ALL_V2(?)";
	  
	  @Query(value=sqlStmt5,nativeQuery=true) public List<ViewLabtestInfoToday>
	  findByPatEmployeeId(String eid);
	  
	  String sqlStmt6="CALL ECLINIC.PROC_MRDEID_LAB_FETCH_ALL_V2(?)";
	  
	  @Query(value=sqlStmt6,nativeQuery=true) public List<ViewLabtestInfoToday>
	  findByPatEmployeeId2(String eid, String fdate, String tdate);
	 
	

	String sqlStmt7="CALL ECLINIC.PROC_PAT_LAB_FETCH_ALL_V3copy(?)";
	@Query(value=sqlStmt7,nativeQuery=true)
	public List<ViewLabtestInfoToday_dup1> findByConsultId_dup1(Integer consultId);
	
}




