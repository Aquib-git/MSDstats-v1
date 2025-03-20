package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.model.ViewLabResultAttr;
import com.kng.medicalreports.model.ViewLabtestInfoToday;

public interface ViewLabResultAttrRepository extends JpaRepository<ViewLabResultAttr, Integer>{
	
	
	String sqlStmt1="CALL ECLINIC.PROC_LAB_RSLT_ATTR_FETCH(?,?)";
	@Query(value=sqlStmt1,nativeQuery=true)
	public List<ViewLabResultAttr> findLabResultAttrRepo( int  cid, int  tid);
	
//	
//	String sqlStmt2="CALL ECLINIC.PROC_LAB_RSLT_ATTR_FETCH_DUP1(?,?,?,?,?)";
//	@Query(value=sqlStmt1,nativeQuery=true)
//	public List<ViewLabResultAttr_Dup1> findLabResultAttrRepo_dup1(String consultId,String tdsid,String lid,String tid,String opn);
	
	

}
