package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.ViewPatientRetiredOfficeCountToday;

public interface ViewPatientRetiredOfficeCountTodayRepo extends JpaRepository<ViewPatientRetiredOfficeCountToday, Integer> 
{
	
	String sqlStmt="CALL ECLINIC.PROC_PATIENT_VISIT_RET_OFFICE_COUNT_ALL_V2(?,?)";
	@Query(value=sqlStmt,nativeQuery=true) 
	public List<ViewPatientRetiredOfficeCountToday> findViewPatientRetiredOfficeCountByRangeDate(String Form ,String To);
	 
	String sqlStmt2="CALL ECLINIC.PROC_PATIENT_VISIT_RET_OFFICE_COUNT_ALL_V2_COPY(?,?,?)";
	@Query(value=sqlStmt2,nativeQuery=true) 
	public List<ViewPatientRetiredOfficeCountToday>findViewPatientRetiredOfficeCountByRangeDateOid(String Form ,String To,int ofcId);

}


//ViewPatientVisitRetiredOfficeCountTodayImp