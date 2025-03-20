package com.kng.lab.labrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.lab.labmodel.LabSampleCollectionListAll;

public interface LabSampleCollectionRepo extends JpaRepository<LabSampleCollectionListAll, Integer> 
{

	String sqlStmt1="CALL ECLINIC.PROC_LAB_SC_LIST_ALL(?,?)";
	@Query(value=sqlStmt1,nativeQuery=true)
	public List<LabSampleCollectionListAll> getLabSampleCollectionListAll(String Form ,String To);
	
	
	String sqlStmt2="CALL ECLINIC.PROC_LAB_SC_LIST_OID(?,?,?)";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<LabSampleCollectionListAll> getLabSampleCollectionListByOfficeId(String Form ,String To,int ofcId);
}
