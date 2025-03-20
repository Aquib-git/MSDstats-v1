package com.kng.pharm.pharmrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.pharm.pharmmodel.PharmDirectTransferHdrOfficeCountAll;

public interface PharmDirectTransferHdrOfficeCountRepo extends JpaRepository<PharmDirectTransferHdrOfficeCountAll, Integer> 
{
	String sqlStmt="CALL ECLINIC.PROC_PHA_DT_HDR_OFFICE_COUNT_ALL(?,?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<PharmDirectTransferHdrOfficeCountAll> getPharmDirectTransferHdrOfficeCountAll(String Form ,String To);
	
	
	String sqlStmt1="CALL ECLINIC.PROC_PHA_DT_HDR_OFFICE_COUNT_OID(?,?,?)";
	@Query(value=sqlStmt1,nativeQuery=true)
	public List<PharmDirectTransferHdrOfficeCountAll> getPharmDirectTransferHdrOfficeCountId(String Form ,String To,int ofcId);


}
