package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.dao.ViewPatientVisitOfficeCountTodayImp;
import com.kng.medicalreports.model.*;

public interface ViewPatientVisitOfficeCountTodayRepository extends JpaRepository<ViewPatientVisitOfficeCountToday, Integer> {
	
	
	/* String sqlStmt="SELECT "
	 		+ "			od.office_id OfficeId, \r\n"
	 		+ "			od.office_name OfficeName, \r\n"
	 		+ "			(CASE WHEN v1.PATIENT_COUNT IS NULL THEN 0 ELSE v1.PATIENT_COUNT END) AS \"TotalCount\"\r\n"
	 		+ "	FROM ECLINIC_KNG.OFFICE_DETAILS od\r\n"
	 		+ "	LEFT JOIN \r\n"
	 		+ "	(\r\n"
	 		+ "		SELECT \r\n"
	 		+ "				v.office_id,\r\n"
	 		+ "				v.OFFICE_NAME,\r\n"
	 		+ "				sum(v.PATIENT_COUNT) AS \"PATIENT_COUNT\"\r\n"
	 		+ "		FROM ECLINIC.VIEW_PATIENT_VISIT_OFFICE_COUNT_ALL_V2 v\r\n"
	 		+ "		WHERE v.CONSULT_DATE BETWEEN ? AND ? \r\n"
	 		+ "		GROUP BY\r\n"
	 		+ "				v.OFFICE_ID,\r\n"
	 		+ "				v.OFFICE_NAME\r\n"
	 		+ "		ORDER BY v.OFFICE_NAME ASC\r\n"
	 		+ "	) AS v1\r\n"
	 		+ "	ON (od.office_id=v1.office_id)\r\n"
	 		+ "	WHERE od.active_status LIKE 'Y' ORDER BY od.OFFICE_NAME ASC";*/
	 
	
	  String sqlStmt="CALL ECLINIC.PROC_PATIENT_VISIT_OFFICE_COUNT_ALL_V2_COPY(?,?,?)";
	  
	  @Query(value=sqlStmt,nativeQuery=true) 
	  public List<ViewPatientVisitOfficeCountTodayImp> findViewPatientVisitOfficeCountByRangeDate(String Form ,String To,int ofcId);
	 
		
		
		
		
		  String sqlStmt2="CALL ECLINIC.PROC_PATIENT_VISIT_OFFICE_COUNT_ALL_V2_DUP(?,?)";
		 
     @Query(value=sqlStmt2,nativeQuery=true) 
     public List<ViewPatientVisitOfficeCountTodayImp> findViewPatientVisitOfficeCountByRangeDate(String Form ,String To);

}
