package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kng.medicalreports.model.*;

public interface ViewPatientVisitOfficeMonthWiseRepository extends JpaRepository<ViewPatientVisitOfficeMonthWise, Integer> {
	
	List<ViewPatientVisitOfficeMonthWise> findByYearWise(Integer Year);

}
