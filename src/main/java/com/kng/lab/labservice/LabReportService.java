package com.kng.lab.labservice;

import java.util.List;

import com.kng.lab.labmodel.LabOfficeFilterDetails;
import com.kng.medicalreports.model.ViewLabtestInfoToday;

public interface LabReportService 
{
	public List<LabOfficeFilterDetails> getLabOfficeDetailsFilter();
	
	
	

}
