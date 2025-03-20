package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kng.medicalreports.model.*;

public interface ViewKngDashCardDataRepository extends JpaRepository<ViewKngDashCardData,Integer> {
	
	
	
//	 @Query(value=sqlStmt,nativeQuery=true) 
//	 public List<ViewHealrhCenterTotalManpower> findViewKngDashCardDataByCatogary();

	
	 String sqlStmt = "CALL ECLINIC.PROC_DOC_DASHBOARD_TYPE_LIST_KNG_ALL(?,?)";
	    
	    @Query(value = sqlStmt, nativeQuery = true)
	    public List<ViewKngDashCardData> findAllByDate(String fdate, String tdate);
	    
	
	

}
