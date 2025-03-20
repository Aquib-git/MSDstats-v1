package com.kng.medicalreports.controller;


import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kng.medicalreports.formbean.DataFormBean;

import com.kng.medicalreports.model.*;
import com.kng.medicalreports.service.*;

@Controller
@RequestMapping("/user")
public class AdminController {
	
		@Autowired
		DailyStatisticsService dailyStatisticsService;
		
		@Autowired
		public DataFormBean dataformbean;

		public String sDate = "", eDate = "";
		
		public String consultDate = "";
		
		public int usrId = 0;
		
		public int ofcId = 0;

		@RequestMapping("/dailyStatistics")
		public String getMainDashDetails(@ModelAttribute DataFormBean dataFormBean, Model model) {

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
//		       model.addAttribute("hmpPatientVisitDeptData", MaindashboardService.getViewPatientVisitDeptData());
			
			
			// model.addAttribute("eclinics", new ArrayList<OfficeDetails>());

					model.addAttribute("eclinic", dailyStatisticsService.getviewOfficeDetails());
					
				
					
					
					//for consultation details
					
					model.addAttribute("hmpViewPatientInfoTodayById",
							dailyStatisticsService.getViewPatientInfoTodayDetailById(usrId,consultDate));
					
					
					
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

		/*
		 * @GetMapping("/labTestInfo") public String getLabTestInfo(Model model) {
		 * 
		 * model.addAttribute("hmpViewLabtestInfoDetailsToday",
		 * dailyStatisticsService.getViewLabtestInfoTodayDetails(sDate, eDate,ofcId));
		 * 
		 * return "labTestInfo"; }
		 */

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

		
		/*
		 * @GetMapping("/consultationDetails/findByConsultId") public String
		 * findByConsultId(Model model, @RequestParam("consultid") Integer consultId {
		 * 
		 * model.addAttribute("patConsultLabDetails",dailyStatisticsService.
		 * getPatConsultLabDetails(consultId));
		 * 
		 * model.addAttribute("patConsultRadDetails",dailyStatisticsService.
		 * getPatConsultRadDetails(consultId));
		 * 
		 * model.addAttribute("patConsultProcDetails",dailyStatisticsService.
		 * getPatConsultabProcDetails(consultId));
		 * 
		 * 
		 * return "./consultationDetails"; }
		 */
		
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
		


		

	}



