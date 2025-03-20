package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kng.medicalreports.model.*;

public interface ViewDoctorDashboardListKngRepository extends JpaRepository<ViewDoctorDashboardListKng,Integer> {

	
	/*
	 * String sqlStmt="CALL ECLINIC.PROC_DOC_DASHBOARD_YEAR_WISE_LIST_KNG_ALL(?)";
	 * 
	 * @Query(value=sqlStmt,nativeQuery=true) public
	 * List<ViewDoctorDashboardListKng> findAllByYear(int SelectedYear);
	 * 
	 */
	
	
		String sqlStmt = "CALL ECLINIC.PROC_DOC_DASHBOARD_DATE_WISE_LIST_KNG_ALL(?,?)";
	    @Query(value = sqlStmt, nativeQuery = true)
	    public List<ViewDoctorDashboardListKng> findAllByListDate(String fdate, String tdate);

	    String sqlStmt2 = "CALL ECLINIC.PROC_DOC_DASHBOARD_DOC_DATE_WISE_LIST_KNG_ALL(?,?,?)";
	    @Query(value = sqlStmt2, nativeQuery = true)
	    ViewDoctorDashboardListKng findByDateRange(Integer docId, String sdate, String edate);
	  
	    String sqlStmt3 = "CALL ECLINIC.PROC_DOC_DASHBOARD_DATE_WISE_DOCSONLY_LIST_KNG_ALL(?,?)";
	    @Query(value = sqlStmt3, nativeQuery = true)
	    public List<ViewDoctorDashboardListKng> findDoctorsOnlyListByDate(String fdate, String tdate);
	    
	    String sqlStmt4 = "CALL ECLINIC.PROC_DOC_DASHBOARD_DATE_WISE_DENTONLY_LIST_KNG_ALL(?,?)";
	    @Query(value = sqlStmt4, nativeQuery = true)
	    public List<ViewDoctorDashboardListKng> findDentistsOnlyListByDate(String fdate, String tdate);

}
