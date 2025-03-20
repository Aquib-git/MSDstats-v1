package com.kng.medicalreports.service;

import java.util.List;

import com.kng.medicalreports.model.ViewDispenseInfoToday;
import com.kng.medicalreports.model.ViewLabtestInfoToday;
import com.kng.medicalreports.model.ViewMrdPatDemo;
import com.kng.medicalreports.model.ViewPatientInfoToday;
import com.kng.medicalreports.model.ViewProcInfoToday;
import com.kng.medicalreports.model.ViewRadTestInfoToday;
import com.kng.medicalreports.model.ViewSickLeaveInfoToday;
import com.kng.medicalreports.model.ViewVitalsInfoToday;

public interface MrdService 
{
	
    //========================================== MRD details START================================

	public List<ViewMrdPatDemo> getPatMrdDemographicDetails(String civilId);
	public List<ViewLabtestInfoToday> getPatMrdLabDetails(String civilId);
	public List<ViewRadTestInfoToday> getPatMrdRadDetails(String civilId);
	public List<ViewProcInfoToday> getPatMrdProcDetails(String civilId);
	public List<ViewVitalsInfoToday> getPatMrdVitalDetails(String civilId);
	public List<ViewSickLeaveInfoToday> getPatMrdSickLeaveDetails(String civilId);
	public List<ViewDispenseInfoToday> getPatMrdDispenceDetails(String civilId);
	
	//========================================== MRD details END================================

	//========================================== MRD by employee id details START================================

		public List<ViewMrdPatDemo> getPatMrdEIDDemographicDetails2(String eid); //used
	
		//with 2
		//public List<ViewMrdPatDemo> getPatMrdEIDDemographicDetails2(String eid,String fdate,String tdate); 
		
		
	//	public List<ViewPatientInfoToday> getMRDEID(String eid); //used
		
		
		//with 2
		public List<ViewPatientInfoToday> getMRDEID2(String eid,String fdate,String tdate); //used
		
		
		//the below code keep as reference
		/*
		 * public List<ViewLabtestInfoToday> getPatMrdEIDLabDetails(String sDate,String
		 * eDate,String eid);
		 */
		
		//with2
		/*
		 * public List<ViewLabtestInfoToday> getPatMrdEIDLabDetails2(String eid,String
		 * fdate,String tdate);
		 * 
		 * 
		 * public List<ViewRadTestInfoToday> getPatMrdEIDRadDetails(String eid); public
		 * List<ViewProcInfoToday> getPatMrdEIDProcDetails(String eid); public
		 * List<ViewVitalsInfoToday> getPatMrdEIDVitalDetails(String eid); public
		 * List<ViewSickLeaveInfoToday> getPatMrdEIDSickLeaveDetails(String eid); public
		 * List<ViewDispenseInfoToday> getPatMrdEIDDispenceDetails(String eid);
		 */
		
	//========================================== MRD by employee id details END================================

}
