package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.dao.ViewLabRadTestsOfficeCountTodayImp;
import com.kng.medicalreports.model.*;

public interface ViewLabRadTestsOfficeCountTodayRepository  extends JpaRepository<ViewLabRadTestsOfficeCountToday, Integer> {
	
	
	
	/*  String sqlStmt="SELECT \r\n" + "	od.office_id OfficeId,\r\n" +
	  "			   od.office_name OfficeName,\r\n" +
	  "			   (CASE WHEN v1.LAB_TEST_COUNT IS NULL THEN 0 ELSE v1.LAB_TEST_COUNT END) AS \"TotalLabCount\",\r\n"
	  +
	  "			   (CASE WHEN v1.RAD_TEST_COUNT IS NULL THEN 0 ELSE v1.RAD_TEST_COUNT END) AS \"TotalRadCount\"\r\n"
	  + "		FROM eclinic_kng.OFFICE_DETAILS od \r\n" + "		LEFT JOIN \r\n"
	  + "		(		\r\n" + "			SELECT	\r\n" +
	  "					v.OFFICE_ID,\r\n" +
	  "					v.OFFICE_NAME,\r\n" +
	  "					sum(v.LAB_TEST_COUNT) AS \"LAB_TEST_COUNT\",\r\n" +
	  "					sum(v.RAD_TEST_COUNT) AS \"RAD_TEST_COUNT\"\r\n" +
	  "			FROM ECLINIC.VIEW_LABRADTESTS_OFFICE_COUNT_ALL_V2 v\r\n" +
	  "			WHERE v.CONSULT_DATE BETWEEN ? AND ? \r\n" +
	  "			GROUP BY\r\n" + "		       	v.OFFICE_NAME,\r\n" +
	  "					v.OFFICE_id			\r\n" +
	  "			ORDER BY v.OFFICE_NAME \r\n" + "		)AS v1\r\n" +
	  "		on(od.office_id=v1.office_id)\r\n" +
	  "		WHERE od.ACTIVE_STATUS LIKE 'Y'\r\n" +
	  "		ORDER BY od.OFFICE_NAME ";*/
	 
	  
		/*
		 * @Query(value=sqlStmt,nativeQuery=true) public
		 * List<ViewLabRadTestsOfficeCountTodayImp>
		 * findViewLabRadTestsOfficeCountByRangeDate(String Form ,String To,int ofcId);
		 */
	

		
		  String sqlStmt2="CALL ECLINIC.PROC_LABRADTESTS_OFFICE_COUNT_ALL_V2_COPY(?,?,?)";
		  
		  
		  @Query(value=sqlStmt2,nativeQuery=true) 
		  public List<ViewLabRadTestsOfficeCountTodayImp> findViewLabRadTestsOfficeCountByRangeDate(String Form ,String To,int ofcId);
		 
	
		 String sqlStmt="CALL ECLINIC.PROC_LABRADTESTS_OFFICE_COUNT_ALL_V2_DUP(?,?)";   
			 @Query(value=sqlStmt,nativeQuery=true)
			   public List<ViewLabRadTestsOfficeCountTodayImp>findViewLabRadTestsOfficeCountByRangeDate(String Form ,String To);
}
