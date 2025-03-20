package com.kng.medicalreports.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.kng.langutils.LangutilService;
import com.kng.langutils.Langutils;
import com.kng.medicalreports.service.*;


@Controller
public class MainDashboardController {
	
	
	@Autowired
    MainDashboardService MaindashboardService;
	
	@Autowired
	DailyStatisticsService dailyStatisticsService;
	
	@Autowired
	public LangutilService langutilService;
	
	@Autowired
	public Langutils langutils;
	
	public String currentLang="";
   
   
    @GetMapping({"/", "/maindb"})
    public String getMainDashDetails(Model model,
    		@RequestParam(name= "lang", required = false) String lang, HttpServletRequest request ) {
    	
    	// Calling Langauge change
 		langutilService.configureLanguage(request, model);
    	
		/*
		 * // Default language setting if (lang == null) { // Attempt to get language
		 * from session or default to English lang = (String)
		 * request.getSession().getAttribute("lang"); if (lang == null) { lang = "en"; }
		 * } else { // Save the current language setting in the session
		 * request.getSession().setAttribute("lang", lang); }
		 * 
		 * currentLang = lang; // Update the currentLang variable
		 * 
		 * 
		 * String urlWithArabic = langutils.createUrlWithLang(request, "ar");
		 * model.addAttribute("urlWithArabic", urlWithArabic);
		 * 
		 * String urlWithEnglish = langutils.createUrlWithLang(request, "en");
		 * model.addAttribute("urlWithEnglish", urlWithEnglish);
		 * 
		 * model.addAttribute("currentLang", currentLang);
		 */
    	
    	
       model.addAttribute("hmpBranch", MaindashboardService.getAllHealthManpowerByBranches());
       model.addAttribute("hmpCatogary", MaindashboardService.getViewKngDashCardDataByCategory());
       model.addAttribute("hmpLabCatTest", MaindashboardService.getViewDocLabCatTestCountByCategory());
       model.addAttribute("hmpRadCatTest", MaindashboardService.getViewDocRadCatTestCountByCategory());
       model.addAttribute("hmpViewPatientAll", MaindashboardService.getViewPatientVisitOfficeCurrSummary());
       model.addAttribute("hmpDoctorBranch", MaindashboardService.getViewDoctorOfficeCountAll());
       model.addAttribute("hmpPatientVisitYearwise", MaindashboardService.getViewPatientVisitYearwise());
       model.addAttribute("hmpPatientVisitDept", MaindashboardService.getViewPatientVisitDeptAll());
       model.addAttribute("hmpPatientVisitDeptData", MaindashboardService.getViewPatientVisitDeptData());
       model.addAttribute("hmpPatientVisitMonthWiseByYear", dailyStatisticsService.getViewPatientVisitOfficeMonthWiseByYearByYear(CurrentYear()-1));
       
  
    	
    	return "./healthManpower";
    } 
    

		  
		
			//Language URL code here
			public String createUrlWithLang(HttpServletRequest request, String lang) 
			{
			    UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromUriString(request.getRequestURL().toString());
			    
			    // Add all current parameters, excluding 'lang'
			    request.getParameterMap().forEach((key, values) ->
			    {
			        if (!"lang".equals(key))
			        {
			            for (String value : values)
			            {
			                uriBuilder.queryParam(key, value);
			            }
			        }
			    });
		  
		  uriBuilder.queryParam("lang", lang);
		  
		  return uriBuilder.build().encode().toString();
		  
		  
		  }
    
    
    
    public int CurrentYear()
	 {
		 Calendar calendar=Calendar.getInstance();
		 int year=calendar.get(Calendar.YEAR);
		 return year;
	 }
    
      @GetMapping("/login")
	  public String login() {
		        return "./login";
	   }
      
      @GetMapping("/logout")
	  public String logout() {
		      return "./login";
	 }
      
     @GetMapping("/accessdenied")
   	  public String accessdenied() {
    	 
    	 System.out.println("islam ");
   		    return "./accessdenied";
   	 }

     
     

	 


}
