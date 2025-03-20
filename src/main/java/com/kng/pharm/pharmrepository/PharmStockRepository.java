package com.kng.pharm.pharmrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.pharm.pharmmodel.PharmacyStockList;

public interface PharmStockRepository extends JpaRepository<PharmacyStockList, Integer> 
{
	String sqlStmt="CALL ECLINIC.PROC_PHA_STCK_LIST_ALL_ITEMID(?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<PharmacyStockList> getPharmStockListByItemId(String itemId);

}
