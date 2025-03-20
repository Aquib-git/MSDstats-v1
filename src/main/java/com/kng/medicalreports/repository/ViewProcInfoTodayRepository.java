package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.*;


public interface ViewProcInfoTodayRepository extends JpaRepository<ViewProcInfoToday, Integer>{
	
//	@Query("SELECT u FROM ViewProcInfoToday u WHERE u.CONSULT_DATE BETWEEN ?1 AND ?2 ")
//	public List<ViewProcInfoToday> findAllByRangeDate(String Form ,String To);

	String sqlStmt="CALL ECLINIC.PROC_PROCEDU_CLICK_ALL_V2(?,?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<ViewProcInfoToday> findAllByRangeDate(String Form ,String To);

	
	String sqlStmt2="CALL ECLINIC.PROC_PROCEDU_CLICK_ALL_V2_COPY(?,?,?)";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<ViewProcInfoToday> findAllByRangeDate(String Form ,String To,int ofcId);
	
	String sqlStmt3="CALL ECLINIC.PROC_PAT_PROC_FETCH_ALL_V2(?)";
	@Query(value=sqlStmt3,nativeQuery=true)
	public List<ViewProcInfoToday> findByConsultId(int consultId);
	
	String sqlStmt4="CALL ECLINIC.PROC_MRD_PROC_FETCH_ALL_V2(?)";
	@Query(value=sqlStmt4,nativeQuery=true)
	public List<ViewProcInfoToday> findByCivilId(String civilId);
	
	String sqlStmt5="CALL ECLINIC.PROC_MRDEID_PROC_FETCH_ALL_V2(?)";
	@Query(value=sqlStmt5,nativeQuery=true)
	public List<ViewProcInfoToday> findByPatEmployeeId(String eid);
}
