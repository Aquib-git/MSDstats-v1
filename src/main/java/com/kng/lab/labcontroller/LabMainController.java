package com.kng.lab.labcontroller;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.kng.brtrprts.brtformbean.BrtFormBean;
import com.kng.brtrprts.brtservice.BirtReportService;
import com.kng.lab.labformbean.LabFormBean;
import com.kng.lab.labservice.LabChartService;
import com.kng.lab.labservice.LabReportService;
import com.kng.langutils.LangutilService;
import com.kng.langutils.Langutils;


@Controller
public class LabMainController 
{
	Logger logger = LoggerFactory.getLogger(LabMainController.class);
	
	
	@Autowired
	public LabFormBean labFormBean;	
	
	@Autowired
	public BrtFormBean brtFormBean;
	
	@Autowired
	public LabReportService ls;
	
	@Autowired
	public BirtReportService bs;
	
	@Autowired
	public LabChartService lcs;
	
	@Autowired
	public LangutilService langutilService;
	
	//public String sDate = "2024-02-12", eDate = "2024-02-12";
	//public int ofcId = 4;
	public String currentLang="";
	
	@GetMapping("/labStatistics")
	public String getLabStatisticsPage(Model model)
	{
		model.addAttribute("labFormBean", new LabFormBean());
		model.addAttribute("brtFormBean", new BrtFormBean());
		model.addAttribute("LabOfficeDateFilter",ls.getLabOfficeDetailsFilter());
		model.addAttribute("officeDateFilter",bs.getOfficeDetailsFilter());
		return "./labStatistics";
	}
	
	@GetMapping("/labReport")
	public String getLabReportPage(Model model,@RequestParam(name= "lang", required = false) String lang, HttpServletRequest request)
	{
		model.addAttribute("brtFormBean", new BrtFormBean());
		model.addAttribute("officeDateFilter",bs.getOfficeDetailsFilter());
		System.out.println("================== Lab Report Language settings CALLED ==================" );
		//------------------------------------------ LANGUAGE SETTINGS START -----------------------------------------------------
	
		// Calling Langauge change
		langutilService.configureLanguage(request, model);
		
	   //------------------------------------------ LANGUAGE SETTINGS STOP -----------------------------------------------------
		  System.out.println("================== Lab Report Language settings EXECUTED ==================" );
		
		return "./labReport";
	}
	
	
	@GetMapping("/labtab")
	public String loadTabContent(@RequestParam("tabName") String tabName, Model model)
	{
        // Initialize attributes common to all tabs
      //  model.addAttribute("labFormBean", new LabFormBean());
        model.addAttribute("brtFormBean", new BrtFormBean());
        model.addAttribute("LabOfficeDateFilter", ls.getLabOfficeDetailsFilter());
        // Add other common attributes as necessary

      // String fragmentPath = "labmodals/"; // Base path for the fragments
        String fragmentPath="";
        switch (tabName) {
            case "labChart":
                System.out.println("============== labChart Tab entered ==============");
               fragmentPath="forward:/loadlabChart";
                break;
            case "labReport":
                System.out.println("============== labReport Tab entered ==============");
                fragmentPath="labmodals/labReport::labReport";
                break;
            default:
                System.out.println("============== Default Tab entered ===============");
                tabName = "defaultModal"; 
                break;
        }
        return fragmentPath;
    }
	
	
	
	
	
	//OLD LOGIC
	@GetMapping("/labtabold/{tabName}")
    public String loadTabContentold(@PathVariable String tabName, Model model)
	{
        // Define a variable for the fragment name
        String fragmentName = "";
        model.addAttribute("labFormBean", new LabFormBean());
        model.addAttribute("brtFormBean", new BrtFormBean());
    	model.addAttribute("LabOfficeDateFilter",ls.getLabOfficeDetailsFilter());
    	//model.addAttribute("sampleCollectChart",lcs.getLabSampleCollectionOfficeCountRange(sDate, eDate, ofcId));
        switch (tabName) 
        {
            case "labChart":
                //model.addAttribute("specificAttribute", "valueForLabChart");
            	System.out.println("============== labChart Tab entered ============== ");
               // fragmentName = "labChart";
            	//fragmentName="labChart::labChart";
            	//fragmentName="labmodals/labChart::labChart";
            	fragmentName=tabName;
                break;
            case "labReport":
            	System.out.println("============== labReport Tab entered ==============");
               // fragmentName = "labReport";
            	fragmentName=tabName;
                break;
            default:
                fragmentName = "defaultModal"; // A default fragment if the tabName doesn't match
                break;
        }
        
        return "labmodals/" + fragmentName + " :: " + fragmentName;
       // return fragmentName;
        
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
	
	
	/* -------------------------------------- INTERNAL METHODS FREQUENTLY USED (Lang) IN MRD CONTROLLER END -----------------------------------------*/

	

}


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
