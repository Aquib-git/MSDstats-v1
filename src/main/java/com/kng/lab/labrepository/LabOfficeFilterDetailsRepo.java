package com.kng.lab.labrepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.lab.labmodel.LabOfficeFilterDetails;

public interface LabOfficeFilterDetailsRepo extends JpaRepository<LabOfficeFilterDetails, Integer>
{
	String sqlStmt="SELECT * FROM ECLINIC_KNG.OFFICE_DETAILS od \r\n"
			+ "where od.ACTIVE_STATUS LIKE 'Y' \r\n"
			+ "ORDER BY od.OFFICE_NAME ASC ";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<LabOfficeFilterDetails> getLabOfficeDetailsFilter();
}
