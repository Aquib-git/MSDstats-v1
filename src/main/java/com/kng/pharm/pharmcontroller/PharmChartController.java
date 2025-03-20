package com.kng.pharm.pharmcontroller;

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

import com.kng.pharm.pharmformbean.PharmFormBean;
import com.kng.brtrprts.brtservice.BirtReportService;
import com.kng.lab.labmodel.LabSampleCollectionListAll;
import com.kng.langutils.LangutilService;
import com.kng.pharm.pharmmodel.PharmDirectTransferHdrListAll;
import com.kng.pharm.pharmmodel.PharmStockAdjustHdrListAll;
import com.kng.pharm.pharmservice.PharmChartService;
import com.kng.pharm.pharmservice.PharmReportService;

@Controller
public class PharmChartController 
{
	
	Logger logger = LoggerFactory.getLogger(PharmChartController.class);

	public String sDate = "", eDate = "";
	public String currentLang="";
	public int ofcId = 0;

	@Autowired
	public PharmFormBean pharmFormBean;	
	
	@Autowired
	PharmChartService pcs;
	@Autowired
	PharmReportService ps;
	
	@Autowired
	public LangutilService langutilService;

	@GetMapping("/pharmChart")
	public String getLabChartPage(@ModelAttribute PharmFormBean pharmFormBean, Model model,
								  @RequestParam(name= "lang", required = false) String lang,
								  HttpServletRequest request)
	{
		//model.addAttribute("labFormBean", new LabFormBean());
		
		

		if (pharmFormBean.getPharmSdate() != null && pharmFormBean.getPharmEdate() != null)
		{
			sDate = pharmFormBean.getPharmSdate();
			eDate = pharmFormBean.getPharmEdate();
		} 
		else
		{
			sDate = CurrentDate();
			eDate = CurrentDate();
		}

		if (pharmFormBean.getPharmOid() != 0) 
		{
			ofcId = pharmFormBean.getPharmOid();
		} 
		else 
		{
			ofcId = 0;
		}
		System.out.println("================== PHRAMACY CHART CONTROLLER layer called ==================" );
		System.out.println("sDate====" + sDate);
		System.out.println("eDate====" + eDate);
		System.out.println("ofcId====" + ofcId);
		
		
		System.out.println("==================  Language settings CALLED ==================" );
		//------------------------------------------ LANGUAGE SETTINGS START -----------------------------------------------------
			langutilService.configureLanguage(request, model);
	   //------------------------------------------ LANGUAGE SETTINGS STOP -----------------------------------------------------
		System.out.println("================== Language settings EXECUTED ==================" );  
		
		
		model.addAttribute("pharmOfficeDateFilter",ps.getPharmOfficeDetailsFilter());
	
		model.addAttribute("staChart",pcs.getStockAdjustHdrOfficeCountRange(sDate, eDate, ofcId));
		System.out.println("========= STOCK ADJUST CHART SERVICE LOGIC called =========" );
		
		model.addAttribute("drctTrnsChart",pcs.getDirectTransferHdrOfficeCountRange(sDate, eDate, ofcId));
		System.out.println("========= DIRECT TRANSFER CHART SERVICE LOGIC called =========" );
		
		return "./pharmChart";
		//return "./pharmStatistics";
	}
	
	
	@GetMapping("/stockAdjustInfoWithOffice")
	public String getStockAdjustHdrListDetails(Model model, @RequestParam("OfficeName") String Name) 
	{
		List<PharmStockAdjustHdrListAll> listy = pcs.getStockAdjustHdrList(sDate, eDate, ofcId);
		List<PharmStockAdjustHdrListAll> finalResult =null;
		if (Name != null)
		{
			
			finalResult = listy.stream().filter(t -> t.getOFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", ""))).collect(Collectors.toList());
		}
		model.addAttribute("stockAdjustInfoList", finalResult);
		System.out.println("========= STOCK ADJUST LIST CONTROLLER LOGIC called =========" );
		System.out.println("sDate====" + sDate);
		System.out.println("eDate====" + eDate);
		System.out.println("ofcId====" + ofcId);
		
		System.out.println("LISTY====" + listy);
		
		System.out.println("Name====" + Name);
		System.out.println("StockAdjust final Result====" + finalResult);
		
		
		return "./stockAdjustInfo";
	}
	
	
	@GetMapping("/directTransferInfoWithOffice")
	public String getDirectTransferList(Model model, @RequestParam("OfficeName") String Name) 
	{
		List<PharmDirectTransferHdrListAll> listy = pcs.getDirectTransferHdrList(sDate, eDate, ofcId);
		List<PharmDirectTransferHdrListAll> finalResult =null;
		if (Name != null) {

			finalResult = listy.stream().filter(t -> t.getISSUED_FROM_OFFICE_NAME().equalsIgnoreCase(Name.replace("-MultiSpeciality", ""))).collect(Collectors.toList());
		}
		System.out.println("========= Stock Adjust LIST CONTROLLER LOGIC called =========" );
		System.out.println("sDate====" + sDate);
		System.out.println("eDate====" + eDate);
		System.out.println("ofcId====" + ofcId);
		System.out.println("listy====" + listy);
		System.out.println("Name====" + Name);
	    System.out.println("Direct Transfer list final Result====" + finalResult);
		
		model.addAttribute("directTransferInfoList", finalResult);		
		
		return "./directTransferInfo";
	}
	
	
	
	
/* -------------------------------------- INTERNAL METHODS FREQUENTLY (Lang) USED  IN PHA CHART CONTROLLER START -----------------------------------------*/
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
	
/* -------------------------------------- INTERNAL METHODS FREQUENTLY (Lang) USED  IN PHA CHART CONTROLLER END -----------------------------------------*/
	
	
	
	
}
