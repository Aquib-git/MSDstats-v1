package com.kng.brtrprts.brtrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.brtrprts.brtmodel.OfficeFilterDetails;

public interface OfficeFilterDetailsRepo extends JpaRepository<OfficeFilterDetails, Integer> 
{
	
	String sqlStmt="SELECT * FROM ECLINIC_KNG.OFFICE_DETAILS od \r\n"
			+ "where od.ACTIVE_STATUS LIKE 'Y' \r\n"
			+ "ORDER BY od.OFFICE_NAME ASC ";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<OfficeFilterDetails> getOfficeDetailsFilter();
	
	
	
	
	
	

}
