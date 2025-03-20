package com.kng.medicalreports.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kng.brtrprts.brtformbean.BrtFormBean;
import com.kng.brtrprts.brtservice.BirtReportService;
import com.kng.medicalreports.model.ViewLabResultAttr_Dup1;
import com.kng.medicalreports.service.*;

@Controller
public class LabResultAttr_dup1controller {
	
	
	
	@Autowired
	public BrtFormBean brtFormBean;
	
	@Autowired
	public BirtReportService bs;
	
	public String opn = "", lid = "",reportUrl=""; 
	public Integer tdsid;
	
	@Value("${birt.report.base.url}")
	private String reportBaseUrl;
	
	
	@Autowired
	DailyStatisticsService dailyStatisticsService;

    @Autowired
    private LabResultAttr_Service labResult_Service;

    @GetMapping("/labResults/findByConsultId")
    public String getLabResults(Model model,@RequestParam int consultid, @RequestParam String  tid) {
    	
    	 
      model.addAttribute("LabResultAttrInfo_dup1contl",labResult_Service.getLabResultAttrService_dup1(consultid ,tid));
        
      model.addAttribute("PatConsultDetails",dailyStatisticsService.getPatConsultDetails(consultid));
    	
        return "LabResultAttr_dup1";
    }
    
    
    @GetMapping("/labResults2/findByConsultId")
    public String getLabResults2(Model model,@RequestParam int consultid, @RequestParam String  tid) {
    	
    	 
      model.addAttribute("LabResultAttrInfo_dup1contl",labResult_Service.getLabResultAttrService_dup1(consultid ,tid));
        
      model.addAttribute("PatConsultDetails",dailyStatisticsService.getPatConsultDetails(consultid));
    	
        return "LabResultAttr_dup2";
    }
    
    

	// LAB
	@GetMapping("/LabResultBirtReport")
	public void getKngLabTest(@ModelAttribute ViewLabResultAttr_Dup1 ViewLabResultAttr_Dup1,
			HttpServletResponse response) throws IOException {
		System.out.println("LabResultBirtReport====" + reportBaseUrl);

		opn = ViewLabResultAttr_Dup1.getOP_NUMBER();
		lid = ViewLabResultAttr_Dup1.getLAB_IDNO();
		tdsid = ViewLabResultAttr_Dup1.getTEST_DETAILSID();

		if (ViewLabResultAttr_Dup1.getOP_NUMBER() != null && ViewLabResultAttr_Dup1.getLAB_IDNO() != null
				&& ViewLabResultAttr_Dup1.getTEST_DETAILSID() != null) {

			reportUrl = reportBaseUrl + "list_xrays_Staff15.rptdesign&tdsid=" + tdsid + "&lid=" + lid + "&opn=" + opn;

		}
		//response.sendRedirect(reportUrl);
	}
    
    
    
}
