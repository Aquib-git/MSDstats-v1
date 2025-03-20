package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.ViewDispenseOfficeCountToday;

public interface ViewDispenseOfficeCountTodayRepository extends JpaRepository<ViewDispenseOfficeCountToday, Integer> 
{

	String sqlStmt="CALL ECLINIC.PROC_DISPENSE_OFFICE_COUNT_ALL_V2(?,?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<ViewDispenseOfficeCountToday> findViewDispenseOfficeCountTodayByRangeDate(String Form ,String To);
	
	String sqlStmt2="CALL ECLINIC.PROC_DISPENSE_OFFICE_COUNT_ALL_V2_COPY(?,?,?)";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<ViewDispenseOfficeCountToday> findViewDispenseOfficeCountTodayByRangeDate(String Form ,String To,int ofcId);
	
	
}

