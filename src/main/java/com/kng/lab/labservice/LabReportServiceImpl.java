package com.kng.lab.labservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kng.lab.labmodel.LabOfficeFilterDetails;
import com.kng.lab.labrepository.LabOfficeFilterDetailsRepo;
import com.kng.medicalreports.model.ViewLabtestInfoToday;
import com.kng.medicalreports.repository.ViewLabtestInfoTodayRepository;

@Service
public class LabReportServiceImpl implements LabReportService 
{

	@Autowired
	LabOfficeFilterDetailsRepo odrepo;
	
	
	
	@Override
	public List<LabOfficeFilterDetails> getLabOfficeDetailsFilter() 
	{
		List<LabOfficeFilterDetails> lofdrList = odrepo.getLabOfficeDetailsFilter();
		return lofdrList;
	}

	

	
}
