package com.kng.medicalreports.service;

import java.util.List;

import com.kng.medicalreports.model.ViewNewRegistration;

public interface UtilsService 
{
	List<ViewNewRegistration> getPatientNameList(String searchTerm);

}
