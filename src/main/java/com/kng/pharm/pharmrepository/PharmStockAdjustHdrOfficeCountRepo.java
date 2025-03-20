package com.kng.pharm.pharmrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.pharm.pharmmodel.PharmStockAdjustHdrOfficeCountAll;

public interface PharmStockAdjustHdrOfficeCountRepo extends JpaRepository<PharmStockAdjustHdrOfficeCountAll, Integer> 
{
	String sqlStmt="CALL ECLINIC.PROC_PHA_SA_HDR_OFFICE_COUNT_ALL(?,?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<PharmStockAdjustHdrOfficeCountAll> getPharmStockAdjustHdrOfficeCountAll(String Form ,String To);
	
	
	String sqlStmt1="CALL ECLINIC.PROC_PHA_SA_HDR_OFFICE_COUNT_OID(?,?,?)";
	@Query(value=sqlStmt1,nativeQuery=true)
	public List<PharmStockAdjustHdrOfficeCountAll> getPharmStockAdjustHdrOfficeCountId(String Form ,String To,int ofcId);


}
