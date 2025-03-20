package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.kng.medicalreports.model.ViewPatientRetInfoToday;

public interface ViewPatRetInfoTodayRepository extends JpaRepository<ViewPatientRetInfoToday, Integer>
{
	String sqlStmt="CALL ECLINIC.PROC_PAT_CLICK_ALL_RET_V2(?,?)";
	@Query(value=sqlStmt,nativeQuery=true) 
	public List<ViewPatientRetInfoToday>  getPatRetInfoTodayListAll(String Form ,String To);

	String sqlStmt1="CALL ECLINIC.PROC_PAT_CLICK_ALL_RET_V2_COPY(?,?,?)";
	@Query(value=sqlStmt1,nativeQuery=true) 
	public List<ViewPatientRetInfoToday>  getPatRetInfoTodayListByOfficeId(String Form ,String To,int ofcId);
	
}
