package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.kng.medicalreports.model.ViewMrdPatDemo;

public interface ViewMrdPatDemoRepository extends JpaRepository<ViewMrdPatDemo, Integer>
{
	String sqlStmt="CALL ECLINIC.PROC_MRD_PAT_DEMOGRAPH_FETCH_ALL_V2(?)";
	@Query(value=sqlStmt,nativeQuery=true)
	public List<ViewMrdPatDemo> findByCivilId( @Param("civilId") String civilId);

	String sqlStmt2="CALL ECLINIC.PROC_MRDEID_PAT_DEMOGRAPH_FETCH_ALL_V2(?)";
	@Query(value=sqlStmt2,nativeQuery=true)
	public List<ViewMrdPatDemo> findByPatEmployeeId( String eid);
	
	
	
	
	/*
	 * String sqlStmt3="CALL ECLINIC.PROC_MRDEID_PAT_DEMOGRAPH_FETCH_ALL_V2(?)";
	 * 
	 * @Query(value=sqlStmt3,nativeQuery=true) public List<ViewMrdPatDemo>
	 * findByPatEmployeeId2(String eid);
	 */
	
}


