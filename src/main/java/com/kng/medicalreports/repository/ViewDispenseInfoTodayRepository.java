package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.*;

public interface ViewDispenseInfoTodayRepository extends JpaRepository<ViewDispenseInfoToday,Integer> {
	
	
//	@Query("SELECT u FROM ViewDispenseInfoToday u WHERE u.INVOICE_DATE BETWEEN ?1 AND ?2  Order BY u.INVCUSTNAME ")
//	public List<ViewDispenseInfoToday> findAllByRangeDate(String Form ,String To);
	
	
	String sqlStmt="CALL ECLINIC.PROC_DISPENSE_CLICK_ALL_V2_COPY(?,?,?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<ViewDispenseInfoToday> findAllByRangeDate(String Form ,String To,int ofcId);
	
	String sqlStmt2="CALL ECLINIC.PROC_DISPENSE_CLICK_ALL_V2(?,?)";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<ViewDispenseInfoToday> findAllByRangeDate(String Form ,String To);
	
	String sqlStmt3="CALL ECLINIC.PROC_PAT_DISPENSE_FETCH_ALL_V2(?)";
	@Query(value=sqlStmt3,nativeQuery=true)
	public List<ViewDispenseInfoToday> findByConsultId(int consultId);
	
	String sqlStmt4="CALL ECLINIC.PROC_MRD_DISPENSE_FETCH_ALL_V2(?)";
	@Query(value=sqlStmt4,nativeQuery=true)
	public List<ViewDispenseInfoToday> findByCivilId(String civilId);
	
	
	String sqlStmt5="CALL ECLINIC.PROC_MRDEID_DISPENSE_FETCH_ALL_V2(?)";
	@Query(value=sqlStmt5,nativeQuery=true)
	public List<ViewDispenseInfoToday> findByPatEmployeeId(String eid);
	
}
