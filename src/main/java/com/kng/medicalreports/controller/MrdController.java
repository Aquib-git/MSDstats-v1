package com.kng.medicalreports.controller;



import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;

import com.kng.langutils.LangutilService;
import com.kng.medicalreports.formbean.MrdFormBean;
import com.kng.medicalreports.service.DailyStatisticsService;
import com.kng.medicalreports.service.MrdService;

@Controller
public class MrdController 
{
	
	
	public String civilId="";
	public String eid="";
	public String fdate = "", tdate = "";
	
	public String cid="", tid="";
	
	public String currentLang="";
	
	Logger logger = LoggerFactory.getLogger(MrdController.class);
	
	@Autowired
	MrdService mrds;
	
	@Autowired
	DailyStatisticsService ds;
	
	@Autowired
	public MrdFormBean  mrdFormBean ;
	
	@Autowired
	public LangutilService langutilService;
	
	
//=====================================/mrdeid=========================================================================
	@GetMapping("/mrdeid") //USED
	public String findByEmployeeId(@ModelAttribute MrdFormBean mrdFormBean,Model model,
			@RequestParam(name= "lang", required = false) String lang, HttpServletRequest request)
	{
		
		Logger logger = LoggerFactory.getLogger(MrdController.class);
		
		System.out.println("==================  Language settings CALLED ==================" );
		//------------------------------------------ LANGUAGE SETTINGS START -----------------------------------------------------
			langutilService.configureLanguage(request, model);
	   //------------------------------------------ LANGUAGE SETTINGS STOP -----------------------------------------------------
		System.out.println("================== Language settings EXECUTED ==================" );
		
		if(mrdFormBean.getSelectEmpId()==null && mrdFormBean.getSelectMRDSdate()!=null && mrdFormBean.getSelectMRDEdate()!=null)
		{
			System.out.println("Case 1=== Inital Load");
			 eid="0";
			fdate=mrdFormBean.getSelectMRDSdate();
			tdate=mrdFormBean.getSelectMRDEdate();
			System.out.println("CONTROLLER LAYER ===> findByEmployeeId ===> Military Id: "+eid+" "+"Start Date: "+fdate+" "+"End Date: "+tdate);	
		}
		else if (mrdFormBean.getSelectEmpId()!=null && mrdFormBean.getSelectMRDSdate()!=null && mrdFormBean.getSelectMRDEdate()!=null)
		{
			System.out.println("Case 2=== when military id is passed");
			eid=mrdFormBean.getSelectEmpId();
			fdate=mrdFormBean.getSelectMRDSdate();
			tdate=mrdFormBean.getSelectMRDEdate();
			System.out.println("CONTROLLER LAYER ===> findByEmployeeId ===> Military Id: "+eid+" "+"Start Date: "+fdate+" "+"End Date: "+tdate);
		}
		
		model.addAttribute("MrdPatDemographDetails", mrds.getPatMrdEIDDemographicDetails2(eid));
		model.addAttribute("MrdPatConsultationDetails", mrds.getMRDEID2(eid,fdate, tdate));
		return "./mrdeid";
	}
	
	
	
	@GetMapping("/mrdDetails/findByConsultId")
	public String findMRDByConsultId(Model model, @RequestParam("consultid") Integer consultId) {

		model.addAttribute("PatConsultDetails",ds.getPatConsultDetails(consultId));
		model.addAttribute("PatConsultLabDetails",ds.getPatConsultLabDetails(consultId));
		model.addAttribute("PatConsultRabDetails",ds.getPatConsultRadDetails(consultId));
		model.addAttribute("PatConsultProcDetails",ds.getPatConsultProcDetails(consultId));
		model.addAttribute("PatConsultVitalDetails",ds.getPatConsultVitalDetails(consultId));
		model.addAttribute("PatConsultSickDetails",ds.getPatConsultSickLeaveDetails(consultId));
		model.addAttribute("PatConsultDispenceDetails",ds.getPatDispenceDetails(consultId));

		return "./MRDconsultationDetails";
	}

	@GetMapping("/LabResultAttr/findByConsultId")
	public String findLabResultByParam(Model model,@RequestParam("consultid") int consultId,@RequestParam("tid") int  tid) {
		
		
		  
		  System.out.println("====" + cid);
		  
		  System.out.println("====" + tid);
		 

		  model.addAttribute("LabResultAttrInfo",ds.getLabResultAttrService(consultId, tid));


		return "./LabResultAttr";
	}
	
	
	
	//new lab result attribute for test 
	
	/*
	 * @GetMapping("/LabResultAttr_dup1/findByConsultId") public String
	 * findLabResultByParam_dup1(Model model,@RequestParam("consultid") String
	 * consultId ,
	 * 
	 * @RequestParam("tdsid") String tdsid,@RequestParam("lid") String lid,
	 * 
	 * @RequestParam("tid") String tid,@RequestParam("opn") String opn) {
	 * 
	 * 
	 * System.out.println("====" + consultId);
	 * 
	 * System.out.println("====" + tdsid);
	 * 
	 * System.out.println("====" + lid);
	 * 
	 * System.out.println("====" + tid);
	 * 
	 * 
	 * 
	 * System.out.println("====" + opn);
	 * 
	 * 
	 * //
	 * model.addAttribute("LabResultAttrInfo",ds.getLabResultAttrService(consultId,
	 * tid));
	 * 
	 * 
	 * model.addAttribute("LabResultAttrInfo_dup1",ds.getLabResultAttrService_dup1(
	 * consultId,tdsid,lid,tid,opn));
	 * 
	 * return "./LabResultAttr_dup1"; }
	 */
	/*
	 * @GetMapping("/LabResultAttr_dup1/findByConsultId") public String
	 * findByConsultId(Model model, @RequestParam("consultid") Integer consultId,
	 * 
	 * @RequestParam("tdsid") Integer tdsid, @RequestParam("lid") Integer lid,
	 * 
	 * @RequestParam("tid") Integer tid, @RequestParam("opn") String opn) { logger.
	 * debug("Received request with parameters: consultId={}, tdsid={}, lid={}, tid={}, opn={}"
	 * , consultId, tdsid, lid, tid, opn);
	 * 
	 * List<ViewLabResultAttr_Dup1> labResultsAttrList =
	 * ds.getLabResultAttrService_dup1(consultId, tdsid, lid, tid, opn);
	 * 
	 * model.addAttribute("LabResultAttrInfo_dup1contl", labResultsAttrList);
	 * logger.debug("Model attribute LabResultAttrInfo_dup1contl set with: {}",
	 * labResultsAttrList);
	 * 
	 * System.out.println("LabResultAttrInfo_dup1contl" +labResultsAttrList);
	 * 
	 * return "./LabResultAttr_dup1";
	 * 
	 * }
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
