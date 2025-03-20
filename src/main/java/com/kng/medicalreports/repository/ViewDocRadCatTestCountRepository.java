package com.kng.medicalreports.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.kng.medicalreports.dao.ViewDocRadCatTestCountImp;
import com.kng.medicalreports.model.*;

public interface ViewDocRadCatTestCountRepository extends JpaRepository<ViewDocRadCatTestCount, Integer> {
	


}
