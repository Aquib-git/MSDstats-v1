package com.kng.lab.labrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.kng.lab.labmodel.LabAccessionAcknowledgeOfficeCountAll;

public interface LabAccessionAcknowledgeOfficeCountRepo extends JpaRepository<LabAccessionAcknowledgeOfficeCountAll, Integer>
{
	
	String sqlStmt="CALL ECLINIC.PROC_LAB_AA_OFFICE_COUNT_ALL(?,?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<LabAccessionAcknowledgeOfficeCountAll> getLabAccessionAcknowledgeOfficeCountAll(String Form ,String To);
	
	
	String sqlStmt1="CALL ECLINIC.PROC_LAB_AA_OFFICE_COUNT_OID(?,?,?)";
	@Query(value=sqlStmt1,nativeQuery=true)
	public List<LabAccessionAcknowledgeOfficeCountAll> getLabAccessionAcknowledgeOfficeCountByOfficeId(String Form ,String To,int ofcId);

}
