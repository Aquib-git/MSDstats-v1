package com.kng.medicalreports.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kng.medicalreports.model.ViewPatientVisitOfficeCurrSummary;

public interface ViewPatientVisitOfficeRepository extends JpaRepository<ViewPatientVisitOfficeCurrSummary, Integer> {

}
