package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.kng.medicalreports.model.ViewLabResultAttr_Dup1;

public interface ViewLabResultAttrRepository_dup1 extends JpaRepository<ViewLabResultAttr_Dup1, Integer> {
 
    @Query(value = "CALL ECLINIC.PROC_LAB_RSLT_ATTR_FETCH_DUP1(?,?)", nativeQuery = true)
    List<ViewLabResultAttr_Dup1> findLabResultAttrRepo_dup1( int consultid, String tid);

}
