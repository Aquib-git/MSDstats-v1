package com.kng.medicalreports.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kng.medicalreports.model.ViewNewRegistration;
import com.kng.medicalreports.repository.ViewNewRegistrationRepo;

@Service
public class UtilsServiceImpl implements UtilsService 
{

	@Autowired
	private ViewNewRegistrationRepo vrepo;

	@Override
	public List<ViewNewRegistration> getPatientNameList(String searchTerm) 
	{
		List<ViewNewRegistration> nrList=vrepo.getNewRegistrationDetails(searchTerm);
		return nrList;
	}
	
	
}
