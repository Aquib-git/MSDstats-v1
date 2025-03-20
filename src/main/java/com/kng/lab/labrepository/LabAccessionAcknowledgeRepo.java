package com.kng.lab.labrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.lab.labmodel.LabAccessionAcknowledgeListAll;

public interface LabAccessionAcknowledgeRepo extends JpaRepository<LabAccessionAcknowledgeListAll, Integer> 
{

	String sqlStmt="CALL ECLINIC.PROC_LAB_AA_LIST_ALL(?,?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<LabAccessionAcknowledgeListAll> getLabAccessionAcknowledgeListAll(String Form ,String To);
	
	String sqlStmt1="CALL ECLINIC.PROC_LAB_AA_LIST_OID(?,?,?)";
	@Query(value=sqlStmt1,nativeQuery=true)
	public List<LabAccessionAcknowledgeListAll> getLabAccessionAcknowledgeListAllByOfficeId(String Form ,String To,int ofcId);
	
}
