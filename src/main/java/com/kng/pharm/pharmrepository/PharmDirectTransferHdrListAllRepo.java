package com.kng.pharm.pharmrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.pharm.pharmmodel.PharmDirectTransferHdrListAll;
import com.kng.pharm.pharmmodel.PharmStockAdjustHdrOfficeCountAll;

public interface PharmDirectTransferHdrListAllRepo extends JpaRepository<PharmDirectTransferHdrListAll, Integer>
{
	
	String sqlStmt="CALL ECLINIC.PROC_PHA_DT_HDR_LIST_ALL(?,?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<PharmDirectTransferHdrListAll> getPharmDirectTransferHdrListAll(String Form ,String To);
	
	String sqlStmt2="CALL ECLINIC.PROC_PHA_DT_HDR_LIST_OID(?,?,?)";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<PharmDirectTransferHdrListAll> getPharmDirectTransferHdrListOid(String Form ,String To,int ofcId);

}
