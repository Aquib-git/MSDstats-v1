package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.*;

public interface ViewDoctorOfficeCountAllRepository extends JpaRepository<ViewDoctorOfficeCountAll, Integer> {
	
	
	
	 String sqlStmt = "CALL ECLINIC.PROC_DOC_DASHBOARD_OFFICE_LIST_KNG_ALL(?,?)";
	    
	    @Query(value = sqlStmt, nativeQuery = true)
	    public List<ViewDoctorOfficeCountAll> findAllbyDate(String fdate,String tdate);
	    
	
	

}
