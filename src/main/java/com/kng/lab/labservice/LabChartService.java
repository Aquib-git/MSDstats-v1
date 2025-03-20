package com.kng.lab.labservice;

import java.util.HashMap;
import java.util.List;

import com.kng.lab.labmodel.LabAccessionAcknowledgeListAll;
import com.kng.lab.labmodel.LabSampleCollectionListAll;


public interface LabChartService
{
	/* ------------------------------------------------- SAMPLE COLLECTION SERVICE LOGIC START ------------------------------------------------- */	

	 public HashMap<String, Object> getLabSampleCollectionOfficeCountRange(String SDate, String EDate, int ofcId);
	 public List<LabSampleCollectionListAll> getSampleCollectDetails(String SDate,String EDate,int ofcId);
   
	/* ------------------------------------------------- SAMPLE COLLECTION SERVICE LOGIC END ------------------------------------------------- */	

	 
	/* ------------------------------------------------- ACCESSION/ACKNWLDG SERVICE LOGIC START ------------------------------------------------- */	

	 HashMap<String, Object> getLabAccessionAcknwldgOfficeCountRange(String SDate, String EDate, int ofcId);
	 public List<LabAccessionAcknowledgeListAll> getAccessionAcknowledgeDetails(String SDate, String EDate, int ofcId);
	 
	 
	/* ------------------------------------------------- ACCESSION/ACKNWLDG SERVICE LOGIC END ------------------------------------------------- */	

	 
	 
}
