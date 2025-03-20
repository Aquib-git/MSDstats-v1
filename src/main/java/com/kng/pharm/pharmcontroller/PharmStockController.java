package com.kng.pharm.pharmcontroller;

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

import com.kng.brtrprts.brtformbean.BrtFormBean;
import com.kng.brtrprts.brtservice.BirtReportService;
import com.kng.langutils.LangutilService;
import com.kng.pharm.pharmformbean.PharmFormBean;
import com.kng.pharm.pharmservice.PharmReportService;
import com.kng.pharm.pharmservice.PharmStockService;

@Controller
public class PharmStockController 
{
	
	Logger logger = LoggerFactory.getLogger(PharmStockController.class);
	
	public String itemid = "";
	public String currentLang="";

	@Autowired
	public PharmFormBean pharmFormBean;	
	
	@Autowired
	public BrtFormBean brtFormBean;
	
	@Autowired
	public PharmReportService prs;
	
	@Autowired
	public PharmStockService pss;
	
	@Autowired
	public BirtReportService bs;
	
	@Autowired
	public LangutilService langutilService;
	
	@GetMapping("/pharmStock")
	public String getPharmReportPage(@ModelAttribute PharmFormBean pharmFormBean, Model model,
			  @RequestParam(name= "lang", required = false) String lang,
			  HttpServletRequest request)
	{
		System.out.println("================== Pharmacy Stock CONTROLLER layer called ==================" );
		model.addAttribute("pharmFormBean", new PharmFormBean());
		
		//model.addAttribute("pharmItemMasterList",pss.getItemMasterList());
		
		System.out.println("==================  Language settings CALLED ==================" );
		//------------------------------------------ LANGUAGE SETTINGS START -----------------------------------------------------
			langutilService.configureLanguage(request, model);
	   //------------------------------------------ LANGUAGE SETTINGS STOP -----------------------------------------------------
		System.out.println("================== Language settings EXECUTED ==================" );  
		  
		if (!"0".equals(pharmFormBean.getPharmItemid()))
		{
			itemid = pharmFormBean.getPharmItemid();
			
			System.out.println("Item Id Value====" +itemid);
			
			model.addAttribute("hqStockList", pss.getHqStockListByItemId(itemid));
			model.addAttribute("scmStockList", pss.getScmStockListByItemId(itemid));
			model.addAttribute("tcmStockList", pss.getTcmStockListByItemId(itemid));
			model.addAttribute("tdStockList", pss.getTdStockListByItemId(itemid));
			model.addAttribute("kazStockList", pss.getKazStockListByItemId(itemid));
			
		} 
		if(pharmFormBean.getPharmItemid() == null||"0".equals(pharmFormBean.getPharmItemid()))
		{
			model.addAttribute("hqStockList", pss.getHqStockList());
			model.addAttribute("scmStockList", pss.getScmStockList());
			model.addAttribute("tcmStockList", pss.getTcmStockList());
			model.addAttribute("tdStockList", pss.getTdStockList());
			model.addAttribute("kazStockList", pss.getKazStockList());
		}
		return "./pharmStock";
		//return "./pharmStatistics";
	}
		
/* -------------------------------------- INTERNAL METHODS FREQUENTLY USED (Lang) IN PHARMACY CHART CONTROLLER START -----------------------------------------*/
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
/* -------------------------------------- INTERNAL METHODS FREQUENTLY USED (Lang) IN PHARMACY CHART CONTROLLER END -----------------------------------------*/
	
	
	

}



/*
 
   if (lang == null) 
	    {
	        // Attempt to get language from session or default to English
	        lang = (String) request.getSession().getAttribute("lang");
	        if (lang == null) 
	        {
	            lang = "en";
	        }
	    } 
	    else 
	    {
	        // Save the current language setting in the session
	        request.getSession().setAttribute("lang", lang);
	    }
	      currentLang = lang; // Update the currentLang variable

	      String urlWithArabic = createUrlWithLang(request, "ar");
		  model.addAttribute("urlWithArabic", urlWithArabic);
		  
          String urlWithEnglish = createUrlWithLang(request, "en"); 
		  model.addAttribute("urlWithEnglish", urlWithEnglish);
		  
		  model.addAttribute("currentLang", currentLang); 
  
 
 */












