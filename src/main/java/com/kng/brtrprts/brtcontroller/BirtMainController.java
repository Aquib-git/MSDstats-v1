package com.kng.brtrprts.brtcontroller;

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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.kng.brtrprts.brtformbean.BrtFormBean;
import com.kng.brtrprts.brtformbean.BrtModalBean;
import com.kng.brtrprts.brtservice.BirtReportService;
import com.kng.langutils.LangutilService;
import com.kng.langutils.Langutils;
import com.kng.medicalreports.formbean.MrdFormBean;

@Controller
public class BirtMainController {

	Logger logger = LoggerFactory.getLogger(BirtMainController.class);

	@Autowired
	public BrtFormBean brtFormBean;

	@Autowired
	public BirtReportService bs;
	

	
	@Autowired
	public LangutilService langutilService;

	public String currentLang = "";

	@GetMapping("/birtReport")
	public String getBirtReportPage(Model model, @RequestParam(name = "lang", required = false) String lang,
			HttpServletRequest request) 
	{

		System.out.println("================== BIRT Report Language settings CALLED ==================" );
		//------------------------------------------ LANGUAGE SETTINGS START -----------------------------------------------------
		/*
		 * if (lang == null) { // Attempt to get language from session or default to
		 * English lang = (String) request.getSession().getAttribute("lang"); if (lang
		 * == null) { lang = "en"; } } else { // Save the current language setting in
		 * the session request.getSession().setAttribute("lang", lang); }
		 * 
		 * currentLang = lang; // Update the currentLang variable
		 * 
		 * String urlWithArabic = langutils.createUrlWithLang(request, "ar");
		 * model.addAttribute("urlWithArabic", urlWithArabic);
		 * 
		 * String urlWithEnglish = langutils.createUrlWithLang(request, "en");
		 * model.addAttribute("urlWithEnglish", urlWithEnglish);
		 * 
		 * model.addAttribute("currentLang", currentLang);
		 */
		
		
		// Calling Langauge change
 		langutilService.configureLanguage(request, model);
		//------------------------------------------ LANGUAGE SETTINGS STOP -----------------------------------------------------
		System.out.println("================== BIRT Report Language settings EXECUTED ==================" );
		
		
		model.addAttribute("brtFormBean", new BrtFormBean());
		model.addAttribute("officeDateFilter", bs.getOfficeDetailsFilter());
	
		return "./birtReport";

	}

	@GetMapping("/birtReportOld")
	public String getBirtReportPageOld() {
		return "./birtReportOld";
	}

	/*
	 * ---------------------------------------------------------- LOGIC to call the
	 * THYMELEAF MODAL DYNAMICALLY START
	 * ----------------------------------------------------------
	 */

	@PostMapping("/renderBirtModalTemplate")
	public String renderModal(@RequestBody BrtModalBean modalData, Model model) {

		System.out.println("Rendering the Birt Modal Template ====");
		model.addAttribute("modalData", modalData);

		return "birtmodals/birtCreator :: birtCreator";
	}

	/*
	 * ---------------------------------------------------------- LOGIC to call the
	 * THYMELEAF MODAL DYNAMICALLY START
	 * ----------------------------------------------------------
	 */

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
