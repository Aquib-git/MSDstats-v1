package com.kng.brtrprts.brtcontroller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class BirtGenController 
{
	
	public String sdate = "", edate = "",reportUrl=""; 
	public Integer oid;
	
	
	@Value("${birt.report.base.url}")
	private String reportBaseUrl;
	
	// ----------------------------------------------- Emergency Service CONTROLLER START ----------------------------------------------
	
	@GetMapping("/emergencyServiceReport")
	public void getsickLeaveBySumaryReport(HttpServletResponse response) throws IOException
	{
		System.out.println("Emergency Sevrice Report====" + reportBaseUrl);
	
		
				reportUrl= reportBaseUrl+"amb_srv.rptdesign";
		
			
				
		response.sendRedirect(reportUrl);
		
	}
	
	// ----------------------------------------------- Emergency Service CONTROLLER END ----------------------------------------------
	
	
	
}
