package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.ViewProceduOfficeCountToday;


public interface ViewProceduOfficeCountTodayRepository  extends JpaRepository<ViewProceduOfficeCountToday, Integer>{
	
	
//	@Query("SELECT u FROM ViewProceduOfficeCountToday u WHERE u.CONSULT_DATE BETWEEN ?1 AND ?2 ")
//	public List<ViewProceduOfficeCountToday> findViewProceduOfficeCountTodayByRangeDate(String Form ,String To);
	
	
	//ESLAMS CODE BEFORE HE LEFT
//	@Query("SELECT new com.kng.medicalreports.model.ViewProceduOfficeCountToday(u.officeName,u.officeId,sum(u.totalCount)) \r\n"
//			+ "FROM ViewProceduOfficeCountToday u WHERE u.CONSULT_DATE BETWEEN ?1 AND ?2  \r\n"
//			+ "GROUP BY \r\n"
//			+ "u.officeName,u.officeId Order by u.officeName ")
//	public List<ViewProceduOfficeCountToday> findViewProceduOfficeCountTodayByRangeDate(String Form ,String To);
//	
	
	
	String sqlStmt="CALL ECLINIC.PROC_PROCEDU_OFFICE_COUNT_ALL_V2(?,?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<ViewProceduOfficeCountToday> findViewProceduOfficeCountTodayByRangeDate(String Form ,String To);
	
	String sqlStmt2="CALL ECLINIC.PROC_PROCEDU_OFFICE_COUNT_ALL_V2_COPY(?,?,?)";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<ViewProceduOfficeCountToday> findViewProceduOfficeCountTodayByRangeDate(String Form ,String To,int ofcId);
	

}

