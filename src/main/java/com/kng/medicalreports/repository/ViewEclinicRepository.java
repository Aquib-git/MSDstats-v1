package com.kng.medicalreports.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.kng.medicalreports.model.ViewOfficeDetails;


public interface ViewEclinicRepository extends JpaRepository<ViewOfficeDetails,Integer> {

}
