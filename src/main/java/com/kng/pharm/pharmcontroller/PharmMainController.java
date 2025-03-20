package com.kng.pharm.pharmcontroller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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

import com.kng.brtrprts.brtformbean.BrtFormBean;
import com.kng.brtrprts.brtservice.BirtReportService;
import com.kng.langutils.LangutilService;
import com.kng.pharm.pharmformbean.PharmFormBean;
import com.kng.pharm.pharmservice.PharmReportService;

@Controller
public class PharmMainController 
{
	Logger logger = LoggerFactory.getLogger(PharmMainController.class);

	@Autowired
	public PharmFormBean pharmFormBean;	
	
	@Autowired
	public BrtFormBean brtFormBean;
	
	@Autowired
	public PharmReportService ps;
	
	@Autowired
	public LangutilService langutilService;
	
	@Autowired
	public BirtReportService bs;
	
	public String currentLang="";
	

	@GetMapping("/pharmStatistics")
	public String getPharmStatisticsPage(Model model)
	{
		model.addAttribute("pharmFormBean", new PharmFormBean());
		model.addAttribute("brtFormBean", new BrtFormBean());
		model.addAttribute("pharmOfficeDateFilter",ps.getPharmOfficeDetailsFilter());
		model.addAttribute("officeDateFilter",bs.getOfficeDetailsFilter());
		return "./pharmStatistics";
	}

	@GetMapping("/pharmReport")
	public String getPharmReportPage(Model model,@RequestParam(name= "lang", required = false) String lang, HttpServletRequest request)
	{
		model.addAttribute("brtFormBean", new BrtFormBean());
		model.addAttribute("officeDateFilter",bs.getOfficeDetailsFilter());

		System.out.println("==================  Language settings CALLED ==================" );
		//------------------------------------------ LANGUAGE SETTINGS START -----------------------------------------------------
			langutilService.configureLanguage(request, model);
	   //------------------------------------------ LANGUAGE SETTINGS STOP -----------------------------------------------------
		System.out.println("================== Language settings EXECUTED ==================" );  
		
		return "./pharmReport";
	}
	
	/* -------------------------------------- INTERNAL METHODS FREQUENTLY USED (Lang) IN MRD CONTROLLER START -----------------------------------------*/
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

	public String OriginalDate() 
	{
		return "2019-11-24";
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
		    
		    // Add or replace the 'lang' parameter
		    uriBuilder.queryParam("lang", lang);
		    return uriBuilder.build().encode().toString(); // Ensure encoding in case of special characters
	}
	/* -------------------------------------- INTERNAL METHODS FREQUENTLY USED (Lang) IN MRD CONTROLLER END -----------------------------------------*/

	
	
	
	
	
}
