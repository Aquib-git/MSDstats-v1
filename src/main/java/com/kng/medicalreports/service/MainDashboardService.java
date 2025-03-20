package com.kng.medicalreports.service;

import java.util.HashMap;
import java.util.List;

import com.kng.medicalreports.model.*;



public interface MainDashboardService {
	
	//-----Health Manpower by Branches
	public HashMap<String, Object> getAllHealthManpowerByBranches();
	public List<ViewHealrhCenterTotalManpower> findHealthManpowerByBranches();
	
	//-----Health Manpower by ByCatogary
	public HashMap<String, Object> getViewKngDashCardDataByCategory();
	
	
	//-----Health Manpower by ByCatogary date
		public HashMap<String, Object> getViewKngDashCardDataByCategoryDate(String fdate, String tdate);
		
	
	
	
	//-----Lab Test Count ByCatogary
	public HashMap<String, Object> getViewDocLabCatTestCountByCategory();
     
     
     //-----Rad Test Count ByCatogary
	public HashMap<String, Object> getViewDocRadCatTestCountByCategory();
	
   //-----View Patient Visit Office Curr Summary
	public HashMap<String, Object> getViewPatientVisitOfficeCurrSummary(); 
	
	
	   //-----View Doctor Office Count All
     public HashMap<String, Object> getViewDoctorOfficeCountAll();
     
     //-----View Doctor Office Count All by Dates 
     public HashMap<String, Object> getViewDoctorOfficeCountAllByDate(String fdate, String tdate);
     
     
     public List<ViewPatientInfoToday>  getViewDashPatientInfoTodayDetail(int doctorId,String sdate, String edate);
     
     //-----View Patient Visit Year wise
     public HashMap<String, Object> getViewPatientVisitYearwise();
     
   //-----View Patient Visit Dept All
     public HashMap<String, Object> getViewPatientVisitDeptAll();
     public HashMap<String, Object> getViewPatientVisitDeptData();
	
     
     // for doctordashborad data by Listyear 
     
 
     
		/*
		 * public HashMap<String, Object> getViewDoctorOfficeCountByListYear(int
		 * SelectedYear);
		 * 
		 * 
		 * public HashMap<String, Object> getViewKngDashCardDataByCategoryByListYear(int
		 * SelectedYear);
		 */
     
     
	//for view test
	//List<ReceIptList> findReceIptListBranches();

}
