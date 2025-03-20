package com.kng.pharm.pharmrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.pharm.pharmmodel.PharmStockAdjustHdrListAll;

public interface PharmStockAdjustHdrListAllRepo extends JpaRepository<PharmStockAdjustHdrListAll, Integer> 
{

	String sqlStmt="CALL ECLINIC.PROC_PHA_SA_HDR_LIST_ALL(?,?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<PharmStockAdjustHdrListAll> getPharmStockAdjustHdrListAll(String Form ,String To);
	
	String sqlStmt1="CALL ECLINIC.PROC_PHA_SA_HDR_LIST_OID(?,?,?)";
	@Query(value=sqlStmt1,nativeQuery=true)
	public List<PharmStockAdjustHdrListAll> getPharmStockAdjustHdrListOid(String Form ,String To,int ofcId);
	
}
