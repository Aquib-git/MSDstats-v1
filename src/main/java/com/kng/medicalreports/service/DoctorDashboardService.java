package com.kng.medicalreports.service;

import java.util.List;


import com.kng.medicalreports.model.ViewDoctorDashboardListKng;

public interface DoctorDashboardService {
	
	/* List<ViewDoctorDashboardListKng> findDoctorConsultAll(); */
	
	/* ViewDoctorDashboardListKng findDoctorInfo(Integer Id); */
	
	ViewDoctorDashboardListKng findDoctorInfoByDate(Integer docId,String sdate,String edate);
	
	
	public List<ViewDoctorDashboardListKng> findDoctorConsultAllByDate(String fdate, String tdate);
	
	public List<ViewDoctorDashboardListKng> findDoctorsOnlyByDate(String fdate, String tdate);
	
	public List<ViewDoctorDashboardListKng> findDentistOnlyByDate(String fdate, String tdate);
	
	
	/* public List<Integer> getAvailableYears(); */
	

}
