package com.kng.medicalreports.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.kng.langutils.LangutilService;
import com.kng.langutils.Langutils;
import com.kng.medicalreports.formbean.DateRange;
import com.kng.medicalreports.formbean.MrdFormBean;
import com.kng.medicalreports.service.DailyStatisticsService;
import com.kng.medicalreports.service.DoctorDashboardService;
import com.kng.medicalreports.service.MainDashboardService;

@Controller
public class DoctorDashboardController {
	

	@Autowired
	DailyStatisticsService dailyStatisticsService;
	@Autowired
	MainDashboardService MaindashboardService;
	@Autowired
	DoctorDashboardService DoctorDashboardService;
	@Autowired
	public MrdFormBean mrdFormBean;
	
	
	@Autowired
	public Langutils langutils;
	
	public String civilId="";
	public String eid="";
	public String fdate = "", tdate = "";
	public int SelectedYear=0;
	
	public String currentLang="";
	
	@Autowired
	public LangutilService langutilService;
	
	Logger logger = LoggerFactory.getLogger(DoctorDashboardController.class);
	
	
	
	 @GetMapping("/doctorDashboard")
	    public String getMainDashDetails(@ModelAttribute MrdFormBean mrdFormBean ,Model model,
	    		@RequestParam(name= "lang", required = false) String lang, HttpServletRequest request )
	 {
		 
			if(mrdFormBean.getSelectMRDSdate()!=null && mrdFormBean.getSelectMRDEdate()!=null )
			{
				fdate=mrdFormBean.getSelectMRDSdate();
				tdate=mrdFormBean.getSelectMRDEdate();
			}
			else if(mrdFormBean.getSelectMRDSdate()==null && mrdFormBean.getSelectMRDEdate()==null)
			{
				 fdate=CurrentDate();
				 tdate=CurrentDate();
			}
			System.out.println("====" + fdate);
			System.out.println("====" + tdate);
			System.out.println("================== Doctor Dashboard Language settings being CALLED ==================" );
		
		//------------------------------------------ LANGUAGE SETTINGS STOP -----------------------------------------------------
			  
			  
			  
			  
			 System.out.println("================== Doctor Dashboard Language settings EXECUTED ==================" );
			
			// get doctorbranches by dates  
			model.addAttribute("hmpDoctorBranch", MaindashboardService.getViewDoctorOfficeCountAllByDate(fdate, tdate));
	        
	        // Category by dates
	        model.addAttribute("hmpCatogary", MaindashboardService.getViewKngDashCardDataByCategoryDate(fdate, tdate));
	   	 
	    	 model.addAttribute("hmpDoctorList", DoctorDashboardService.findDoctorConsultAllByDate(fdate, tdate));
	    	
	    	 model.addAttribute("randomValue", Math.random()*3);	 
	    	 
	    	 
	    		  
	    		// Calling Langauge change
	 		langutilService.configureLanguage(request, model);
	 		

	    	return "./doctorDashboard";
	    	
	    } 

	 

		 @GetMapping("/doctorListOnly")
		 public String getDoctorList(Model model) {

			 model.addAttribute("doctorOnlyListByDate",DoctorDashboardService.findDoctorsOnlyByDate(fdate,tdate));
			 
			 DateRange dr1 = new DateRange();
			 dr1.setStartDateBuffer(fdate);
			 dr1.setEndDateBuffer(tdate);
			 
			 model.addAttribute("dr1",dr1);
			 
			 return "./doctorListOnly";
		 }
		 
		 @GetMapping("/dentistListOnly")
		 public String getDentistList(Model model) {
				 
			model.addAttribute("dentistOnlyListByDate",DoctorDashboardService.findDentistOnlyByDate(fdate,tdate));
			 
			 DateRange dr1 = new DateRange();
			 dr1.setStartDateBuffer2(fdate);
			 dr1.setEndDateBuffer2(tdate);
			 
			 model.addAttribute("dr1",dr1);
			
			return "./dentistListOnly";
		}
//--------------------------------------------------- DASHBOARD PATIENT LIST START ---------------------------------------------------
	 
		@GetMapping("/DashPatientDetailsList/findByDoctorId")
		public String findByDoctorId(Model model, @RequestParam("doctorid") Integer doctorId)
		{
		    // Your logic to fetch doctor details based on ID and consult date
		    // Add the results to the model
	
			System.out.println("Before service layer called START DATE====" + fdate);
			System.out.println("Before service layer called END DATE====" + tdate);
	
			 model.addAttribute("hmpdoctordemo",DoctorDashboardService.findDoctorInfoByDate(doctorId,fdate,tdate));
			model.addAttribute("hmpPatientDetailsList",MaindashboardService.getViewDashPatientInfoTodayDetail(doctorId,fdate,tdate));
			
			 DateRange dr = new DateRange();
			 dr.setStartDateBuffer(fdate);
			 dr.setEndDateBuffer(tdate);
			
			model.addAttribute("dr", dr);
			 
		    return "./DashPatientDetailsList"; 
		}

//--------------------------------------------------- DASHBOARD PATIENT LIST END ---------------------------------------------------
		
//--------------------------------------------------- DASHBOARD DOCTOR INFO CARD START ---------------------------------------------------
		
	 @GetMapping("/doctorInfo")
	 public String getdoctorInfo(Model model,@RequestParam("docId") Integer docId)
	 {
		 System.out.println("Before service layer called START DATE====" + fdate);
		 System.out.println("Before service layer called END DATE====" + tdate);
		  model.addAttribute("hmpdoctorInfo", DoctorDashboardService.findDoctorInfoByDate(docId,fdate,tdate));
     	
	    	return "./doctorInfo";
	 } 
	 
//--------------------------------------------------- DASHBOARD DOCTOR INFO CARD END ---------------------------------------------------
 
/* -------------------------------------- INTERNAL METHODS FREQUENTLY (Lang) USED  IN DOCTOR DASHBOARD CONTROLLER START -----------------------------------------*/	
	 public int CurrentYear()
		{
			Calendar calendar = Calendar.getInstance();
			int year = calendar.get(Calendar.YEAR);
			return year;
		}

		public String CurrentDate() 
		{
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formatDate = dateFormat.format(calendar.getTime());
			return formatDate;
		}
		
		
/* -------------------------------------- INTERNAL METHODS FREQUENTLY (Lang) USED  IN DOCTOR DASHBOARD CONTROLLER END -----------------------------------------*/	
	    
}
