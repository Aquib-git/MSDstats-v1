package com.kng.brtrprts.brtcontroller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.kng.brtrprts.brtformbean.BrtFormBean;
import com.kng.brtrprts.brtservice.BirtReportService;

@Controller
public class BirtSickController 
{
	Logger logger = LoggerFactory.getLogger(BirtSickController.class);
	
	@Autowired
	public BrtFormBean brtFormBean;
	
	@Autowired
	public BirtReportService bs;
	
	public String sdate = "", edate = "",reportUrl=""; 
	public Integer oid;
	
	@Value("${birt.report.base.url}")
	private String reportBaseUrl;


	// ----------------------------------------------- SICK LEAVE By Doctor Summary CONTROLLER START ----------------------------------------------
	
	
		@GetMapping("/sickLeaveByDoctorSumaryReport")	
		public void getsickLeaveByDoctorSumaryReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
		{
			System.out.println("sickLeaveByDoctorSumaryReport====" + reportBaseUrl);

			sdate = brtFormBean.getBrtSdate();
			edate = brtFormBean.getBrtEdate();
			oid	=	brtFormBean.getBrtOid();
			
			if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
			{		
				if(brtFormBean.getBrtOid()==0)
				{					
					reportUrl= reportBaseUrl+"KngMsd_sickLeaveByDoctorSumaryReport_all.rptdesign&SDATE="+sdate+"&EDATE="+edate;
				}
				else 
				{
					reportUrl= reportBaseUrl+"KngMsd_sickLeaveByDoctorSumaryReport_ByOffice.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
				}
				response.sendRedirect(reportUrl);
			}

		}
		
	// ----------------------------------------------- SICK LEAVE By Doctor Summary CONTROLLER START ----------------------------------------------
	
	
   // ----------------------------------------------- SICK LEAVE By Summary CONTROLLER START ----------------------------------------------
			
		@GetMapping("/sickLeaveSumaryReport")
		public void getsickLeaveBySumaryReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
		{
			System.out.println("sickLeaveSumaryReport====" + reportBaseUrl);
		

			sdate = brtFormBean.getBrtSdate();
			edate = brtFormBean.getBrtEdate();
			
			if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
			{	
				reportUrl= reportBaseUrl+"KngMsd_sickLeaveSumaryReport_all.rptdesign&SDATE="+sdate+"&EDATE="+edate;
			}
			response.sendRedirect(reportUrl);
		}
		
		
  // ----------------------------------------------- SICK LEAVE By Summary CONTROLLER START ----------------------------------------------
		
		
	// ----------------------------------------------- Exemption Detail by Doctor CONTROLLER START ----------------------------------------------
		
		@GetMapping("/exemptionDetailReport")
		public void getexemptionDetailReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
		{
			System.out.println("exemptionDetailReport====" + reportBaseUrl);
		
			sdate = brtFormBean.getBrtSdate();
			edate = brtFormBean.getBrtEdate();
			oid	=	brtFormBean.getBrtOid();
			
			if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
			{				
				if(brtFormBean.getBrtOid()==0)
				{
					reportUrl= reportBaseUrl+"KngMsd_exemption_all.rptdesign&SDATE="+sdate+"&EDATE="+edate;
				}
				else 
				{
					reportUrl= reportBaseUrl+"KngMsd_exemption_ByOffice.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
				}		
			}
			response.sendRedirect(reportUrl);
		}
		
		
	// ----------------------------------------------- Exemption Detail by Doctor CONTROLLER END ----------------------------------------------
	
		public String CurrentDate() {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String formatDate = dateFormat.format(calendar.getTime());
			return formatDate;
		}
	
	
}
