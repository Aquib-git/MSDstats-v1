package com.kng.medicalreports.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.kng.langutils.LangutilService;
import com.kng.langutils.Langutils;
import com.kng.medicalreports.formbean.DataFormBean;

import com.kng.medicalreports.model.*;
import com.kng.medicalreports.service.*;

@Controller

public class DailyStatisticsController  extends RoleBaseController{
	
	Logger logger = LoggerFactory.getLogger(DailyStatisticsController.class);

	@Autowired
	DailyStatisticsService dailyStatisticsService;
	
	@Autowired
	public LangutilService langutilService;
	
	@Autowired
	public DataFormBean dataformbean;

	public String sDate = "", eDate = "";
	
	public String consultDate = "";
	
	public int usrId = 0;
	
	public int ofcId = 0;
	
	public String currentLang="";
	
	/*
	 * @Autowired public Langutils langutils;
	 */

	@GetMapping("/dailyStatistics")
	public String getMainDashDetails(@ModelAttribute DataFormBean dataFormBean, Model model,
			@RequestParam(name= "lang", required = false) String lang, HttpServletRequest request) {
		
		
	
		

		if (dataFormBean.getSelectSDate() != null && dataFormBean.getSelectEDate() != null) {
			sDate = dataFormBean.getSelectSDate();
			eDate = dataFormBean.getSelectEDate();
		} else {
			sDate = CurrentDate();
			eDate = CurrentDate();
		}

	
		if (dataFormBean.getOfcId() != 0) {

			ofcId = dataFormBean.getOfcId();

		} else {

			ofcId = 0;

		}

		
		
		System.out.println("====" + sDate);
		System.out.println("====" + eDate);
		System.out.println("====" + ofcId);
		
		
		// Calling Langauge change
		langutilService.configureLanguage(request, model);
		
		 // Default language setting
			/*
			 * if (lang == null) { // Attempt to get language from session or default to
			 * English lang = (String) request.getSession().getAttribute("lang"); if (lang
			 * == null) { lang = "en"; } } else { // Save the current language setting in
			 * the session request.getSession().setAttribute("lang", lang); }
			 * 
			 * currentLang = lang; // Update the currentLang variable
			 * 
			 * 
			 * 
			 * String urlWithArabic = langutils.createUrlWithLang(request, "ar");
			 * 
			 * model.addAttribute("urlWithArabic", urlWithArabic);
			 * 
			 * String urlWithEnglish = langutils.createUrlWithLang(request, "en");
			 * 
			 * model.addAttribute("urlWithEnglish", urlWithEnglish);
			 * 
			 * model.addAttribute("currentLang", currentLang);
			 */
		
	//	addRoleAttributes(model);

		// model.addAttribute("hmpLabRadTestToday",
		// dailyStatisticsService.getViewLabRadTestsOfficeCountToday());
		model.addAttribute("hmpLabRadTestToday",
				dailyStatisticsService.getViewLabRadTestsOfficeCountRange(sDate, eDate,ofcId));

		// model.addAttribute("hmpViewPatientToday",
		// dailyStatisticsService.getViewPatientVisitOfficeToday());
		model.addAttribute("hmpViewPatientToday", dailyStatisticsService.getViewPatientVisitOfficeRange(sDate, eDate,ofcId));

		// model.addAttribute("hmpDoctorBranchToday",
		// dailyStatisticsService.getViewDoctorOfficeCountToday());
		model.addAttribute("hmpDoctorBranchToday", dailyStatisticsService.getViewDoctorOfficeCountRange(sDate, eDate,ofcId));

		// model.addAttribute("hmpViewSickLeaveToday",
		// dailyStatisticsService.getViewSickLeaveOfficeCountToday());
		model.addAttribute("hmpViewSickLeaveToday",
				dailyStatisticsService.getViewSickLeaveOfficeCountRange(sDate, eDate,ofcId));

		// model.addAttribute("hmpProceduOfficeToday",
		// dailyStatisticsService.getViewProceduOfficeCountToday());
		model.addAttribute("hmpProceduOfficeToday",
				dailyStatisticsService.getViewProceduOfficeCountRange(sDate, eDate,ofcId));

		
		
		
		
		// model.addAttribute("hmpPatientVisitMonthWiseByYear",
		// dailyStatisticsService.getViewPatientVisitOfficeMonthWiseByYearByYear(CurrentYear()-1));

		// model.addAttribute("hmpViewPatientVisitDeptToday",
		// dailyStatisticsService.getViewPatientVisitDeptToday());
		model.addAttribute("hmpViewPatientVisitDeptToday",
				dailyStatisticsService.getViewPatientVisitDeptRange(sDate, eDate,ofcId));

		// model.addAttribute("hmpViewDispenseInfoTodayTotal",
		// dailyStatisticsService.getViewDispenseInfoTodayDetails2());
		model.addAttribute("hmpViewDispenseInfoTodayTotal",
				dailyStatisticsService.getViewDispenseInfoTodayDetailsRange(sDate, eDate,ofcId));

		model.addAttribute("hmpViewVitalsInfoTodayTotal",
				dailyStatisticsService.getViewVitalsInfoTodayDetailsRang(sDate, eDate,ofcId).size());

		model.addAttribute("hmpViewDispenseOfficeToday",
				dailyStatisticsService.getViewDispenseOfficeCountRange(sDate, eDate,ofcId));// here
//	       model.addAttribute("hmpPatientVisitDeptData", MaindashboardService.getViewPatientVisitDeptData());
		
		
		// model.addAttribute("eclinics", new ArrayList<OfficeDetails>());

				model.addAttribute("eclinic", dailyStatisticsService.getviewOfficeDetails());

	

				//for consultation details
				
				model.addAttribute("hmpViewPatientInfoTodayById",
						dailyStatisticsService.getViewPatientInfoTodayDetailById(usrId,consultDate));
				
				model.addAttribute("hmpViewPatientInfoTodayRetiredDetailsRangeTotal",dailyStatisticsService.getViewPatientInfoTodayRetiredDetailsRange(sDate, eDate, ofcId));
	
				
//	        	
		return "./dailyStatistics";
	}
	
	
	public int CurrentYear() {
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		return year;
	}

	public String CurrentDate() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String formatDate = dateFormat.format(calendar.getTime());
		return formatDate;
	}
	
	
	

	@GetMapping("/labTestInfo")
	public String getLabTestInfo(Model model) {

		model.addAttribute("hmpViewLabtestInfoDetailsToday",
				dailyStatisticsService.getViewLabtestInfoTodayDetails(sDate, eDate,ofcId));

		return "labTestInfo";
	}
	
	@GetMapping("/labTestInfo2")
	public String getLabTestInfo2(@ModelAttribute DataFormBean dataFormBean, Model model, HttpServletRequest request) {
		
	    if (dataFormBean.getSelectSDate() != null && dataFormBean.getSelectEDate() != null) {
	        sDate = dataFormBean.getSelectSDate();
	        eDate = dataFormBean.getSelectEDate();
	    } else {
	        sDate = CurrentDate();
	        eDate = CurrentDate();
	    }

	    if (dataFormBean.getOfcId() != 0) {
	        ofcId = dataFormBean.getOfcId();
	    } else {
	        ofcId = 0;
	    }

	    langutilService.configureLanguage(request, model);

	    model.addAttribute("dataFormBean", dataFormBean); // Add dataFormBean to the model
	    model.addAttribute("hmpViewLabtestInfoDetailsToday",
	            dailyStatisticsService.getViewLabtestInfoTodayDetails(sDate, eDate, ofcId));
	    model.addAttribute("eclinic", dailyStatisticsService.getviewOfficeDetails());

	    return "labTestInfo2";
	}
	

	@GetMapping("/labTestInfoWithOffice")
	public String getLabTestInfoWithOffice(Model model, @RequestParam("OfficeName") String Name) {

		List<ViewLabtestInfoToday> temp = dailyStatisticsService.getViewLabtestInfoTodayDetails(sDate, eDate,ofcId);
		List<ViewLabtestInfoToday> finalResult = null;
		if (Name != null) {

			finalResult = temp.stream()
					.filter(t -> t.getOFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", "")))
					.collect(Collectors.toList());
		}
		model.addAttribute("hmpViewLabtestInfoDetailsToday", finalResult);

		return "labTestInfo";
	}

	@GetMapping("/sickLeaveInfo")
	public String getSickLeaveInfo(Model model) {

		model.addAttribute("hmpViewSickLeaveInfoDetailsToday",
				dailyStatisticsService.getViewSickLeaveInfoTodayDetails(sDate, eDate,ofcId));

		return "sickLeaveInfo";
	}

	@GetMapping("/sickLeaveInfoWithOffice")
	public String getSickLeaveInfo(Model model, @RequestParam("OfficeName") String Name) {

		List<ViewSickLeaveInfoToday> temp = dailyStatisticsService.getViewSickLeaveInfoTodayDetails(sDate, eDate,ofcId);
		List<ViewSickLeaveInfoToday> finalResult = null;
		if (Name != null) {

			finalResult = temp.stream()
					.filter(t -> t.getOFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", "")))
					.collect(Collectors.toList());
		}
		model.addAttribute("hmpViewSickLeaveInfoDetailsToday", finalResult);

		return "sickLeaveInfo";
	}

	@GetMapping("/radTestInfo")
	public String getRadTestInfo(Model model) {

		model.addAttribute("hmpViewRadtestInfoDetailsToday",
				dailyStatisticsService.getViewRadTestInfoTodayDetails(sDate, eDate,ofcId));

		return "radTestInfo";
	}

	@GetMapping("/radTestInfoWithOffice")
	public String getRadTestInfoWithOffice(Model model, @RequestParam("OfficeName") String Name) {

		List<ViewRadTestInfoToday> temp = dailyStatisticsService.getViewRadTestInfoTodayDetails(sDate, eDate,ofcId);
		List<ViewRadTestInfoToday> finalResult = null;

		if (Name != null) {

			finalResult = temp.stream()
					.filter(t -> t.getOFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", "")))
					.collect(Collectors.toList());
		}
		model.addAttribute("hmpViewRadtestInfoDetailsToday", finalResult);

		return "radTestInfo";
	}

	@GetMapping("/procInfo")
	public String getProcInfoInfo(Model model) {

		model.addAttribute("hmpViewProcInfoDetailsToday",
				dailyStatisticsService.getViewProcInfoTodayDetails(sDate, eDate,ofcId));

		return "procInfo";
	}

	@GetMapping("/procInfooWithOffice")
	public String getProcInfoInfoWithOffice(Model model, @RequestParam("OfficeName") String Name) {

		List<ViewProcInfoToday> temp = dailyStatisticsService.getViewProcInfoTodayDetails(sDate, eDate,ofcId);
		List<ViewProcInfoToday> finalResult = null;
		if (Name != null) {

			finalResult = temp.stream()
					.filter(t -> t.getOFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", "")))
					.collect(Collectors.toList());
		}
		model.addAttribute("hmpViewProcInfoDetailsToday", finalResult);

		return "procInfo";
		
	}

	@GetMapping("/doctorDetailsTodyInfo")
	public String getDocDetailsTodyInfo(Model model) {

		// model.addAttribute("hmpViewDocInfoTodayDetailsToday",
		// dailyStatisticsService.getViewDocInfoTodayDetails());
		model.addAttribute("hmpViewDocInfoTodayDetailsToday",
				
				dailyStatisticsService.getViewDocInfoTodayDetails(sDate, eDate,ofcId));

		return "doctorDetailsTodyInfo";
	}
	

	

	@GetMapping("/doctorDetailsTodyInfoWithOffice")
	public String getRadTestInfoWithOfficeWithOffice(Model model, @RequestParam("OfficeName") String Name) {

		List<ViewDocInfoToday> temp = dailyStatisticsService.getViewDocInfoTodayDetails(sDate, eDate,ofcId);
		List<ViewDocInfoToday> finalResult = null;
		if (Name != null) {

			finalResult = temp.stream()
					.filter(t -> t.getOFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", "")))
					.collect(Collectors.toList());
		}
		model.addAttribute("hmpViewDocInfoTodayDetailsToday", finalResult);

		return "doctorDetailsTodyInfo";
	}

	@GetMapping("/patientDetailsTodyInfo")
	public String getPatientDetailsTodyInfo(Model model) {

		model.addAttribute("hmpViewPatientDetailsToday",
				dailyStatisticsService.getViewPatientInfoTodayDetails(sDate, eDate,ofcId));

		return "patientDetailsTodyInfo";
	}
	
	// for reverse the previous page 
	@GetMapping("/msd/patientDetailsTodyInfo")
	public String getPatientDetailsTodyInfo2(Model model) {

	

		return "patientDetailsTodyInfo";
	}

	@GetMapping("/patientDetailsTodyInfoWithOffice")
	public String getPatientDetailsTodyInfoWithOffice(Model model, @RequestParam("OfficeName") String Name) {

		List<ViewPatientInfoToday> temp = dailyStatisticsService.getViewPatientInfoTodayDetails(sDate, eDate,ofcId);
		List<ViewPatientInfoToday> finalResult = null;

		if (Name != null) {

			finalResult = temp.stream()
					.filter(t -> t.getOFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", "")))
					.collect(Collectors.toList());
		}

		model.addAttribute("hmpViewPatientDetailsToday", finalResult);

		return "patientDetailsTodyInfo";
	}

	@GetMapping("/patientDetailsTodyInfoWithDept")
	public String getPatientDetailsTodyInfoWithDept(Model model, @RequestParam("DeptName") String name) {

		List<ViewPatientInfoToday> temp = dailyStatisticsService.getViewPatientInfoTodayDetails(sDate, eDate,ofcId);
		List<ViewPatientInfoToday> finalResult = null;
		if (name != null && name.equalsIgnoreCase("Dental")) {
			finalResult = temp.stream().filter(t -> t.getDEPARTMENT_NAME().trim().contains(name))
					.collect(Collectors.toList());
		} else if (name != null) {

			finalResult = temp.stream().filter(t -> t.getDEPARTMENT_NAME().trim().equalsIgnoreCase(name))
					.collect(Collectors.toList());
		}

		model.addAttribute("hmpViewPatientDetailsToday", finalResult);

		return "patientDetailsTodyInfo";
	}

	@GetMapping("/dispenseDetailsTodyInfo")
	public String getDispenseDetailsTodyInfo(Model model) {

		model.addAttribute("hmpViewDispenseInfoToday",
				dailyStatisticsService.getViewDispenseInfoRangeDetails(sDate, eDate,ofcId));
		// model.addAttribute("hmpViewDispenseInfoToday",
		// dailyStatisticsService.getViewDispenseInfoTodayDetails());

		return "dispenseDetailsTodyInfo";
	}

	@GetMapping("/vitalsTodayInfo")
	public String getViewVitalsTodayInfo(Model model) {

		model.addAttribute("hmpViewVitalsInfoToday",
				dailyStatisticsService.getViewVitalsInfoTodayDetailsRang(sDate, eDate,ofcId));

		return "vitalsTodayInfo";
	}

	

	
	
	
	//---------------------------------------- FETCH PATIENT CONSULTATION DETAILS by CONSULT ID START --------------------------------------------------
	
		@GetMapping("/consultationDetails/findByConsultId")
		public String findByConsultId(Model model, @RequestParam("consultid") Integer consultId) {

			model.addAttribute("PatConsultDetails",dailyStatisticsService.getPatConsultDetails(consultId));
			model.addAttribute("PatConsultLabDetails",dailyStatisticsService.getPatConsultLabDetails(consultId));
			model.addAttribute("PatConsultRabDetails",dailyStatisticsService.getPatConsultRadDetails(consultId));
			model.addAttribute("PatConsultProcDetails",dailyStatisticsService.getPatConsultProcDetails(consultId));
			model.addAttribute("PatConsultVitalDetails",dailyStatisticsService.getPatConsultVitalDetails(consultId));
			model.addAttribute("PatConsultSickDetails",dailyStatisticsService.getPatConsultSickLeaveDetails(consultId));
			model.addAttribute("PatConsultDispenceDetails",dailyStatisticsService.getPatDispenceDetails(consultId));
			
			
			model.addAttribute("PatConsultLabDetails_dup1",dailyStatisticsService.getPatConsultLabDetails_dup1(consultId));
			
//			  System.out.println("PatConsultLabDetails_dup1/contrl" +dailyStatisticsService.getPatConsultLabDetails_dup1(consultId));
//			  
//			  System.out.println("PatConsultDetails_dup1/contrl" +dailyStatisticsService.getPatConsultDetails(consultId));

			return "./consultationDetails";
		}
		
		
		
		@GetMapping("/consultationDetails2/findByConsultId")
		public String findByConsultId2(Model model, @RequestParam("consultid") Integer consultId) {

			model.addAttribute("PatConsultDetails",dailyStatisticsService.getPatConsultDetails(consultId));
			model.addAttribute("PatConsultLabDetails",dailyStatisticsService.getPatConsultLabDetails(consultId));
			model.addAttribute("PatConsultRabDetails",dailyStatisticsService.getPatConsultRadDetails(consultId));
			model.addAttribute("PatConsultProcDetails",dailyStatisticsService.getPatConsultProcDetails(consultId));
			model.addAttribute("PatConsultVitalDetails",dailyStatisticsService.getPatConsultVitalDetails(consultId));
			model.addAttribute("PatConsultSickDetails",dailyStatisticsService.getPatConsultSickLeaveDetails(consultId));
			model.addAttribute("PatConsultDispenceDetails",dailyStatisticsService.getPatDispenceDetails(consultId));

			return "./consultationDetails2";
		}

	//---------------------------------------- FETCH PATIENT CONSULTATION DETAILS by CONSULT ID END --------------------------------------------------

		@GetMapping("/PatientDetailsList/findByDoctorId")
		public String findByDoctorId(Model model, @RequestParam("doctorid") Integer doctorId,@RequestParam("departmentid") Integer departmentid, @RequestParam("consultdate") String consultDate)
		{
		    // Add the results to the model
			model.addAttribute("hmpDocDemograph", dailyStatisticsService.getViewDoctorDemographDetailsV2(doctorId,departmentid,consultDate));
			model.addAttribute("hmpPatientDetailsList",dailyStatisticsService.getViewPatientInfoTodayDetailByIdV2(doctorId,departmentid,consultDate));
			
		    return "./PatientDetailsList"; 
		}
	
		/*
			@GetMapping("/PatientDetailsList/findByDoctorId")
			public String findByDoctorId(Model model, @RequestParam("doctorid") Integer doctorId, @RequestParam("consultdate") String consultDate) {
			    // Your logic to fetch doctor details based on ID and consult date
			    // Add the results to the model
				model.addAttribute("hmpDocDemograph", dailyStatisticsService.getViewDoctorDemographDetails(doctorId,consultDate));
				model.addAttribute("hmpPatientDetailsList",dailyStatisticsService.getViewPatientInfoTodayDetailById(doctorId,consultDate));
				
			    return "./PatientDetailsList"; 
			}
		 */
	
	
	

	
	//new added
	@GetMapping("/dispenseInfoWithOffice")
	public String getDispenseOfficeInfo(Model model, @RequestParam("OfficeName") String Name) {// here

		List<ViewDispenseInfoToday> temp = dailyStatisticsService.getViewDispenseInfoRangeDetails(sDate, eDate,ofcId);
		List<ViewDispenseInfoToday> finalResult = null;
		if (Name != null) {

			finalResult = temp.stream()
					.filter(t -> t.getOFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", "")))
					.collect(Collectors.toList());
		}
		model.addAttribute("hmpViewDispenseInfoToday", finalResult);

		return "dispenseDetailsTodyInfo";
	}
	
	
	//==========================================for RETIRE PATIENT START================================
						//RETIRED PATIENT LIST INFO is present here
	
	@GetMapping("/patListRetInfo")
	public String getPatListRetnfo(Model model) {
		
		System.out.println("==================PATIENT RETIRED LIST TODAY -> ALL -> SERVICE LAYER ======================");
		System.out.println("Start Date =============="+sDate);
		System.out.println("End Date ================"+eDate);
		System.out.println("Office Id================"+ofcId);
		
		
		model.addAttribute("hmpPatListRetInfo",
				dailyStatisticsService.getViewPatientInfoTodayRetiredDetails(sDate, eDate, ofcId));

		System.out.println("Result================" + dailyStatisticsService.getViewPatientInfoTodayRetiredDetails(sDate, eDate, ofcId));
		
		return "patListRetInfo";
	}

	@GetMapping("/patListRetInfoWithOffice")
	public String getPatListRetnfoWithOffice(Model model, @RequestParam("OfficeName") String Name) {

		System.out.println("==================PATIENT RETIRED LIST TODAY -> By Office Name -> SERVICE LAYER ======================");
		System.out.println("Start Date =============="+sDate);
		System.out.println("End Date ================"+eDate);
		System.out.println("Office Id================"+ofcId);
		
		List<ViewPatientRetInfoToday> temp = dailyStatisticsService.getViewPatientInfoTodayRetiredDetails(sDate, eDate,
				ofcId);
		List<ViewPatientRetInfoToday> finalResult = null;
		if (Name != null) {

			finalResult = temp.stream()
					.filter(t -> t.getOFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", "")))
					.collect(Collectors.toList());
		}
		model.addAttribute("hmpPatListRetInfo", finalResult);

		System.out.println("Result================" + finalResult);
		
		
		return "patListRetInfo";
	}
	
	//==========================================for RETIRE PATIENT END================================
	
	
	
	
	
	

	/*
	 * @GetMapping("/LabResultAttr_dup1/findByConsultId") public String
	 * findByConsultId(Model model, @RequestParam("consultid") Integer consultId,
	 * 
	 * @RequestParam("tid") Integer tid) {
	 * 
	 * 
	 * List<ViewLabResultAttr_Dup1> labResultsAttrList =
	 * dailyStatisticsService.getLabResultAttrService_dup1(consultId,tid);
	 * 
	 * model.addAttribute("PatConsultDetails",dailyStatisticsService.
	 * getPatConsultDetails(consultId));
	 * 
	 * model.addAttribute("LabResultAttrInfo_dup1contl", labResultsAttrList);
	 * 
	 * 
	 * 
	 * System.out.println("LabResultAttrInfo_dup1contl" +labResultsAttrList);
	 * 
	 * return "./LabResultAttr_dup1";
	 * 
	 * }
	 */
	
	

}
