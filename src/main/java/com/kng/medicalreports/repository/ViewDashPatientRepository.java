package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.kng.medicalreports.model.ViewPatientInfoToday;

public interface ViewDashPatientRepository extends JpaRepository<ViewPatientInfoToday,Integer> {
	
	
	String sqlStmt2="CALL ECLINIC.PROC_DOC_DASHBOARD_PAT_CLICK_ALL_V2(?,?,?)";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<ViewPatientInfoToday> findAllByRangeDate(int doctorId ,String sdate ,String edate);

	
}
