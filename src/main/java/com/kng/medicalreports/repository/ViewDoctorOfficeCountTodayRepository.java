package com.kng.medicalreports.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.dao.ViewDoctorOfficeCountTodayImp;
import com.kng.medicalreports.model.*;

public interface ViewDoctorOfficeCountTodayRepository extends JpaRepository<ViewDoctorOfficeCountToday, Integer> {
	
	
//	@Query("SELECT u FROM ViewDoctorOfficeCountToday u WHERE u.CONSULT_DATE BETWEEN ?1 AND ?2 ")
//	public List<ViewDoctorOfficeCountToday> findViewDoctorOfficeCountByRangeDate(String Form ,String To);


	/*String sqlStmt="SELECT od.office_id OfficeId,\r\n"
			+ "	   od.office_name OfficeName ,\r\n"
			+ "	   (CASE WHEN v1.doctor_count IS NULL THEN 0 ELSE v1.doctor_count END) AS \"TotalCount\"\r\n"
			+ "FROM eclinic_kng.OFFICE_DETAILS od \r\n"
			+ "LEFT JOIN \r\n"
			+ "(\r\n"
			+ "	SELECT 	v.office_id,\r\n"
			+ "			v.OFFICE_NAME,\r\n"
			+ "			sum(v.doctor_count) AS \"DOCTOR_COUNT\"\r\n"
			+ "	FROM ECLINIC.VIEW_DOCTOR_OFFICE_COUNT_ALL_V2 v\r\n"
			+ "	WHERE v.CONSULT_DATE BETWEEN ? AND ? \r\n"
			+ "	GROUP BY \r\n"
			+ "			v.OFFICE_ID,\r\n"
			+ "			v.OFFICE_NAME\r\n"
			+ "	ORDER BY\r\n"
			+ "			v.OFFICE_NAME ASC\r\n"
			+ ")AS v1\r\n"
			+ "on(od.office_id=v1.office_id)\r\n"
			+ "WHERE od.ACTIVE_STATUS LIKE 'Y'\r\n"
			+ "ORDER BY od.office_name asc;";*/
			
	// @Query(value=sqlStmt,nativeQuery=true) 
//	public List<ViewDoctorOfficeCountTodayImp> findViewDoctorOfficeCountByRangeDate(String Form ,String To);
	  
	
	  String sqlStmt="CALL ECLINIC.PROC_DOCTOR_OFFICE_COUNT_ALL_V2_DUP(?,?)";
	  
	  @Query(value=sqlStmt,nativeQuery=true) 
	  public List<ViewDoctorOfficeCountTodayImp> findViewDoctorOfficeCountByRangeDate(String Form ,String To);
	 
		
		
		
		
		
		  String sqlStmt2="CALL ECLINIC.PROC_DOCTOR_OFFICE_COUNT_ALL_V2_COPY(?,?,?)";
		  
		  @Query(value=sqlStmt2,nativeQuery=true) 
		  public List<ViewDoctorOfficeCountTodayImp>findViewDoctorOfficeCountByRangeDate(String Form ,String To,int ofcId);
		 
		 
		 
	}
	
