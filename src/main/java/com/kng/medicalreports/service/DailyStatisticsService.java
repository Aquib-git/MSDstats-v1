package com.kng.medicalreports.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import com.kng.medicalreports.model.*;


public interface DailyStatisticsService {
	
	 //-----View Doctor Office Count Today
    public HashMap<String, Object> getViewDoctorOfficeCountToday();
    
  //-----View Patient Visit Dept Today
    public HashMap<String, Object> getViewPatientVisitOfficeToday();
    
  //-----View Lab and Rad Tests Office Count Today
    public HashMap<String, Object> getViewLabRadTestsOfficeCountToday();
    
  //-----View Sick Leave Office Count Today
    public HashMap<String, Object> getViewSickLeaveOfficeCountToday();
    
    
    //-----View Procedures Office Count Today
    public HashMap<String, Object> getViewProceduOfficeCountToday();
    
    
    //-----View Patient Visit Office Month Wise with param Year
    public HashMap<String, Object> getViewPatientVisitOfficeMonthWiseByYearByYear(Integer Year);
    
  //-----View Patient Visit Dept Today
    public HashMap<String, Object> getViewPatientVisitDeptToday();
    
   
    
    //----- View Lab test Info Today Details
    List<ViewLabtestInfoToday> getViewLabtestInfoTodayDetails(String SDate,String EDate,int ofcId);
    
  //----- View Sick LeaveInfo Today  Details
    List<ViewSickLeaveInfoToday> getViewSickLeaveInfoTodayDetails(String SDate,String EDate,int ofcId);
    
    //----- View Rad Test Info Today Details
    List<ViewRadTestInfoToday> getViewRadTestInfoTodayDetails(String SDate,String EDate,int ofcId);
    
    //----- View Proc Info Today  Details
    List<ViewProcInfoToday> getViewProcInfoTodayDetails(String SDate,String EDate,int ofcId);
    
    //----- View Doctor  Today  Details
    List<ViewDocInfoToday> getViewDocInfoTodayDetails(String SDate,String EDate,int ofcId);
    
    //----- View Patient Info Today   Details
    List<ViewPatientInfoToday> getViewPatientInfoTodayDetails(String SDate,String EDate,int ofcId);
    
  //----- View Dispense Info Today   Details
    List<ViewDispenseInfoToday> getViewDispenseInfoTodayDetails();
    
  //----- View Dispense Info Today   Details
    HashMap<String, Object> getViewDispenseInfoTodayDetails2();
    
//    
//  //----- View Vitals Info Today   Details
//    List<ViewVitalsInfoToday> getViewVitalsInfoTodayDetails();
//    
    
    //--------------------------------------------------------------------------
    
    //-----View Doctor Office Count Range Date
    public HashMap<String, Object> getViewDoctorOfficeCountRange(String SDate,String EDate,int ofcId);
    
    //-----View Doctor Office Count Range Date
    public HashMap<String, Object> getViewLabRadTestsOfficeCountRange(String SDate,String EDate,int ofcId);
    
    //-----View Patient Visit Dept Range Date
    public HashMap<String, Object> getViewPatientVisitOfficeRange(String SDate,String EDate,int ofcId);
    
  //-----View Sick Leave Office Count Range Date
    public HashMap<String, Object> getViewSickLeaveOfficeCountRange(String SDate,String EDate,int ofcId);
    
    //-----View Procedures Office Count Range Date
    public HashMap<String, Object> getViewProceduOfficeCountRange(String SDate,String EDate,int ofcId);
    
    
    
  //-----View Patient Visit Dept Range Date
    public HashMap<String, Object> getViewPatientVisitDeptRange(String SDate,String EDate,int ofcId);
    
  //----- View Dispense Info Today   Details
    public List<ViewDispenseInfoToday> getViewDispenseInfoRangeDetails(String SDate,String EDate,int ofcId);
    
  //----- View Dispense Info Today   Details
    public HashMap<String, Object> getViewDispenseInfoTodayDetailsRange(String SDate,String EDate,int ofcId);
    
    
  //----- View Vitals Info Range   Details
    List<ViewVitalsInfoToday> getViewVitalsInfoTodayDetailsRang(String SDate,String EDate,int ofcId);
   
    // Method created on: 12 March 2024, Method Edited on: 
 	public List<ViewPatientInfoToday> getViewPatientInfoTodayDetailByIdV2(Integer doctorId, Integer departmentId, String consultDate);
 	
 	// Method created on: 12 March 2024, Method Edited on: 
 	public List<ViewDocInfoToday> getViewDoctorDemographDetailsV2(Integer doctorId, Integer departmentId, String consultDate);
    
 	
 	
    public List<ViewPatientInfoToday> getViewPatientInfoTodayDetailById(Integer usrId, String consultDate);
    public List<ViewDocInfoToday> getViewDoctorDemographDetails(Integer usrId, String consultDate);
    

    
    public HashMap<String, Object> getViewDispenseOfficeCountRange(String SDate,String EDate,int ofcId);//here new 
    

    
    //----- View Office Details
    List<ViewOfficeDetails> getviewOfficeDetails();
    
    
    
    
    
//==========================================for Consultation details start================================
    
    // for consultation details
	public List<ViewPatientInfoToday> getPatConsultDetails(Integer consultId);
    public List<ViewLabtestInfoToday> getPatConsultLabDetails(Integer consultId);
   
    
    //new 
    public List<ViewLabtestInfoToday_dup1> getPatConsultLabDetails_dup1(Integer consultId);
    
    public List<ViewRadTestInfoToday> getPatConsultRadDetails(Integer consultId);
    
    public List<ViewProcInfoToday> getPatConsultProcDetails(Integer consultId);
    
    
    public List<ViewVitalsInfoToday> getPatConsultVitalDetails(Integer consultId);
    
    public List<ViewSickLeaveInfoToday> getPatConsultSickLeaveDetails(Integer consultId);
    
    public List<ViewDispenseInfoToday> getPatDispenceDetails(Integer consultId);
    
    
    
    
    public List<ViewLabResultAttr> getLabResultAttrService( int  consultId, int  tid);
    
	/*
	 * public List<ViewLabResultAttr_Dup1> getLabResultAttrService_dup1( Integer
	 * consultId , Integer tid);
	 */
    
    
    //==========================================for Consultation details End===============================
    
    //==========================================for RETIRE PATIENT START================================

    //----- View Patient Info Today ->retired   Details
    List<ViewPatientRetInfoToday> getViewPatientInfoTodayRetiredDetails(String SDate,String EDate,int ofcId);
	public HashMap<String, Object> getViewPatientInfoTodayRetiredDetailsRange(String SDate, String EDate, int ofcId);
   	
	//==========================================for RETIRE PATIENT END================================

    


}
