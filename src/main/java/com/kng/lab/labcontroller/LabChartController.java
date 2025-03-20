package com.kng.lab.labcontroller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.kng.lab.labformbean.LabFormBean;
import com.kng.lab.labmodel.LabAccessionAcknowledgeListAll;
import com.kng.lab.labmodel.LabSampleCollectionListAll;
import com.kng.lab.labservice.LabChartService;
import com.kng.lab.labservice.LabReportService;
import com.kng.langutils.LangutilService;
import com.kng.medicalreports.formbean.DataFormBean;


@Controller
public class LabChartController 
{
	Logger logger = LoggerFactory.getLogger(LabChartController.class);
	
	
	public String sDate = "", eDate = "";
	public String currentLang="";
	public int ofcId = 0;
	
	@Autowired
	LabChartService lcs;
	
	@Autowired
	LabReportService ls;
	
	@Autowired
	public LabFormBean labFormBean;
	
	@Autowired
	public LangutilService langutilService;
	
	/*
	 
	 //Implemented in KNG-AJAX-WIP context. I don't want to include this logic in this context.
	@GetMapping("/loadlabChart")
	public String getLoadLabChartPage( // @ModelAttribute LabFormBean labFormBean,  Model model,
								  @RequestParam(name= "lang", required = false) String lang,
								  HttpServletRequest request)
	{
		sDate = CurrentDate();
		eDate = CurrentDate();
		ofcId = 0;
		

		
		System.out.println("================== LOADING LAB CHART CONTROLLER layer called ==================" );
		System.out.println("sDate====" + sDate);
		System.out.println("eDate====" + eDate);
		System.out.println("ofcId====" + ofcId);
		
		model.addAttribute("labFormBean", new LabFormBean());
		
		model.addAttribute("sampleCollectChart",lcs.getLabSampleCollectionOfficeCountRange(sDate, eDate, ofcId));
		System.out.println("========= SAMPLE COLLECTION CHART SERVICE LOGIC called  SUCCESSFULLY =========" );
		
		model.addAttribute("accessAcknwldgChart",lcs.getLabAccessionAcknwldgOfficeCountRange(sDate, eDate, ofcId));
		System.out.println("========= ACCESSION ACKNOWLEDGE CHART SERVICE LOGIC called SUCCESSFULLY  =========" );
		
		return "labmodals/labChart::labChart";
	}
	*/
	@GetMapping("/labChart")
	public String getLabChartPage(@ModelAttribute LabFormBean labFormBean, Model model,
								  @RequestParam(name= "lang", required = false) String lang,
								  HttpServletRequest request)
	{
		//model.addAttribute("labFormBean", new LabFormBean());
		model.addAttribute("LabOfficeDateFilter",ls.getLabOfficeDetailsFilter());
		

		if (labFormBean.getLabSdate() != null && labFormBean.getLabEdate() != null)
		{
			sDate = labFormBean.getLabSdate();
			eDate = labFormBean.getLabEdate();
		} 
		else
		{
			sDate = CurrentDate();
			eDate = CurrentDate();
		}

		if (labFormBean.getLabOid() != 0) 
		{
			ofcId = labFormBean.getLabOid();
		} 
		else 
		{
			ofcId = 0;
		}
		System.out.println("================== LAB CHART CONTROLLER layer called ==================" );
		System.out.println("sDate====" + sDate);
		System.out.println("eDate====" + eDate);
		System.out.println("ofcId====" + ofcId);
			
		System.out.println("==================  Language settings CALLED ==================" );
		//------------------------------------------ LANGUAGE SETTINGS START -----------------------------------------------------
			langutilService.configureLanguage(request, model);
	   //------------------------------------------ LANGUAGE SETTINGS STOP -----------------------------------------------------
		System.out.println("================== Language settings EXECUTED ==================" );  
		
	
		model.addAttribute("sampleCollectChart",lcs.getLabSampleCollectionOfficeCountRange(sDate, eDate, ofcId));
		System.out.println("========= SAMPLE COLLECTION CHART SERVICE LOGIC called =========" );
		
		model.addAttribute("accessAcknwldgChart",lcs.getLabAccessionAcknwldgOfficeCountRange(sDate, eDate, ofcId));
		System.out.println("========= ACCESSION ACKNOWLEDGE CHART SERVICE LOGIC called =========" );
		
		 //model.addAttribute("loadLabChartFragment", true);
		return "./labChart";
		//return "./labStatistics";
		//return "labmodals/labChart::labChart";
		// return "redirect:/loadlabChart";
	}
	
	
	
	@GetMapping("/sampleCollectInfoWithOffice")
	public String getSampleCollectionList(Model model, @RequestParam("OfficeName") String Name) 
	{
		List<LabSampleCollectionListAll> listy = lcs.getSampleCollectDetails(sDate, eDate, ofcId);
		List<LabSampleCollectionListAll> finalResult =null;
		if (Name != null)
		{
			
			finalResult = listy.stream()
					.filter(t -> t.getOFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", "")))
					.collect(Collectors.toList());
		}
		model.addAttribute("ListSampleCollectInfo", finalResult);
		System.out.println("========= SAMPLE COLLECTION LIST CONTROLLER LOGIC called =========" );
		System.out.println("sDate====" + sDate);
		System.out.println("eDate====" + eDate);
		System.out.println("ofcId====" + ofcId);
		System.out.println("Name====" + Name);
		System.out.println("Sample Collection final Result====" + finalResult);
		
		
		return "sampleCollectInfo";
	}
	
	@GetMapping("/accessAcknwldgInfoWithOffice")
	public String getAccessionAcknowledgeList(Model model, @RequestParam("OfficeName") String Name) 
	{
		List<LabAccessionAcknowledgeListAll> listy = lcs.getAccessionAcknowledgeDetails(sDate, eDate, ofcId);//all
		List<LabAccessionAcknowledgeListAll> finalResult =null;
		if (Name != null)
		{
			
			finalResult = listy.stream()
					.filter(t -> t.getOFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", "")))
					.collect(Collectors.toList());
		}
		model.addAttribute("ListAccessAcknwldgInfo", finalResult);
		System.out.println("========= ACCESSION ACKNOWLEDGE LIST CONTROLLER LOGIC called =========" );
		System.out.println("sDate====" + sDate);
		System.out.println("eDate====" + eDate);
		System.out.println("ofcId====" + ofcId);
		System.out.println("Name====" + Name);
		//System.out.println("Accession Acknowledge final Result====" + finalResult);
		return "accessAcknwldgInfo";
	}
	
	
	
	
	
	
/* -------------------------------------- INTERNAL METHODS FREQUENTLY (Lang) USED  IN LAB CHART CONTROLLER START -----------------------------------------*/	
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
	
/* -------------------------------------- INTERNAL METHODS FREQUENTLY (Lang) USED  IN LAB CHART CONTROLLER END -----------------------------------------*/	
	

}
