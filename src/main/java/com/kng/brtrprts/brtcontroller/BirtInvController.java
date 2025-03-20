package com.kng.brtrprts.brtcontroller;

import java.io.IOException;

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
public class BirtInvController 
{
Logger logger = LoggerFactory.getLogger(BirtPhaController.class);
	
	@Autowired
	public BrtFormBean brtFormBean;
	
	@Autowired
	public BirtReportService bs;
	
	public String sdate = "", edate = "",reportUrl=""; 
	public Integer oid,demogid, reporttypeid;
	
	@Value("${birt.report.base.url}")
	private String reportBaseUrl;
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	//XRAY
	@GetMapping("/KngXrayTestTaken")	
	public void getKngXrayTest(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
	{
		System.out.println("KngXrayTestTaken====" + reportBaseUrl);
		
		sdate = brtFormBean.getBrtSdate();
		edate = brtFormBean.getBrtEdate();
		oid	=	brtFormBean.getBrtOid();
		demogid = brtFormBean.getBrtKwtNkwtid();
		
		//brtFormBean.getBrtKwtNkwtid() {All=1, Kuwaiti = 2, Non-Kuwaiti = 3}
		
		//.START
		if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
		{
			if(brtFormBean.getBrtOid()==0) //ALL CLINIC SCENARIO
			{
				if(brtFormBean.getBrtKwtNkwtid()==1)//All clinic -> `All` Demograph
				{
					reportUrl= reportBaseUrl+"list_xrays_Staff03.rptdesign&SDATE="+sdate+"&EDATE="+edate;
					
					// Url: list_xrays_Staff03.rptdesign&SDATE=2023-12-04&EDATE=2023-12-12
				}
				if(brtFormBean.getBrtKwtNkwtid()==2)//All clinic ->  `Kuwaiti` Demograph
				{
					reportUrl= reportBaseUrl+"list_xrays_Staff01.rptdesign&SDATE="+sdate+"&EDATE="+edate;
					
					// Url: list_xrays_Staff01.rptdesign&SDATE=2023-12-04&EDATE=2023-12-12
				}
				if(brtFormBean.getBrtKwtNkwtid()==3)//All clinic -> `Non-Kuwaiti` Demograph
				{
					reportUrl= reportBaseUrl+"list_xrays_Staff02.rptdesign&SDATE="+sdate+"&EDATE="+edate;
					
					// Url: list_xrays_Staff02.rptdesign&SDATE=2023-12-04&EDATE=2023-12-12
					
				}
			}
			else //SPECIFIC CLINIC SCENARIO
			{
				if(brtFormBean.getBrtKwtNkwtid()==1)//Specific clinic -> `All` Demograph
				{
					reportUrl= reportBaseUrl+"list_xrays_Staff13.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
					
					// Url: list_xrays_Staff13.rptdesign&SDATE=2023-12-04&EDATE=2023-12-12&OID=4
				}
				if(brtFormBean.getBrtKwtNkwtid()==2)//Specific clinic ->  `Kuwaiti` Demograph
				{
					reportUrl= reportBaseUrl+"list_xrays_Staff11.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
					
					// Url: list_xrays_Staff11.rptdesign&SDATE=2023-12-04&EDATE=2023-12-12&OID=4
				}
				if(brtFormBean.getBrtKwtNkwtid()==3)//Specific clinic -> `Non-Kuwaiti` Demograph
				{
					reportUrl= reportBaseUrl+"list_xrays_Staff12.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
					
					// Url: list_xrays_Staff12.rptdesign&SDATE=2023-12-04&EDATE=2023-12-12&OID=4
				}
				
			}
		}
		//.STOP
		
		response.sendRedirect(reportUrl);
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	//LAB
	@GetMapping("/KngLabTestTaken")	
	public void getKngLabTest(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
	{
		System.out.println("KngLabTestTaken====" + reportBaseUrl);
		
		sdate = brtFormBean.getBrtSdate();
		edate = brtFormBean.getBrtEdate();
		oid	=	brtFormBean.getBrtOid();
		demogid = brtFormBean.getBrtKwtNkwtid();
		
		//brtFormBean.getBrtKwtNkwtid() {All=1, Kuwaiti = 2, Non-Kuwaiti = 3}
		
		//.START
		if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
		{
			if(brtFormBean.getBrtOid()==0) //ALL CLINIC SCENARIO
			{
				if(brtFormBean.getBrtKwtNkwtid()==1)//All clinic -> `All` Demograph
				{
					reportUrl= reportBaseUrl+"list_labs_Staff03.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
					
					// Url: list_labs_Staff03.rptdesign&SDATE=2023-12-10&EDATE=2023-12-12&OID=0
				}
				if(brtFormBean.getBrtKwtNkwtid()==2)//All clinic ->  `Kuwaiti` Demograph
				{
					reportUrl= reportBaseUrl+"list_labs_Staff01.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
					
					// Url: list_labs_Staff01.rptdesign&SDATE=2023-12-10&EDATE=2023-12-12&OID=0
				}
				if(brtFormBean.getBrtKwtNkwtid()==3)//All clinic -> `Non-Kuwaiti` Demograph
				{
					reportUrl= reportBaseUrl+"list_labs_Staff02.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
					
					// Url: list_labs_Staff02.rptdesign&SDATE=2023-12-10&EDATE=2023-12-12&OID=0
					
				}
			}
			else //SPECIFIC CLINIC SCENARIO
			{
				if(brtFormBean.getBrtKwtNkwtid()==1)//Specific clinic -> `All` Demograph
				{
					reportUrl= reportBaseUrl+"list_labs_Staff13.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
					
					// Url: list_labs_Staff13.rptdesign&SDATE=2023-12-10&EDATE=2023-12-12&OID=4
				}
				if(brtFormBean.getBrtKwtNkwtid()==2)//Specific clinic ->  `Kuwaiti` Demograph
				{
					reportUrl= reportBaseUrl+"list_labs_Staff11.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
					
					// Url: list_labs_Staff11.rptdesign&SDATE=2023-12-10&EDATE=2023-12-12&OID=4
				}
				if(brtFormBean.getBrtKwtNkwtid()==3)//Specific clinic -> `Non-Kuwaiti` Demograph
				{
					reportUrl= reportBaseUrl+"list_labs_Staff12.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
					
					// Url: list_labs_Staff12.rptdesign&SDATE=2023-12-10&EDATE=2023-12-12&OID=4
				}
				
			}
		}
		//.STOP
		
		response.sendRedirect(reportUrl);
	}
	
	// -----------------------------------------------------------------------------------------------------------------------------------------
			
			//LAB	->	Patient Count	->	Sample Collected
			@GetMapping("/KngLabPatientCollectedCount")	
			public void getKngLabPatientCollectedCount(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
			{
				
				System.out.println("KngLabPatientCollectedCount====" + reportBaseUrl);
				
				sdate = brtFormBean.getBrtSdate();
				edate = brtFormBean.getBrtEdate();
				oid	=	brtFormBean.getBrtOid();
				reporttypeid = brtFormBean.getBrtReportTypeId();
				
				//brtFormBean.getBrtReportTypeId() {Summary=1, Detailed=2}
				System.out.println("Start Date=== "+ sdate);
				System.out.println("End Date=== "+ edate);
				System.out.println("Office Id=== "+ oid);
				System.out.println("Report Type Id=== "+ reporttypeid);
				
				
				//.START
				if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
				{
					if(brtFormBean.getBrtOid()==0) //ALL CLINIC SCENARIO
					{
						if(brtFormBean.getBrtReportTypeId()==1)//All clinic -> `Summary`
						{
							reportUrl= reportBaseUrl+"KngMsd_Lab_PatientCount_Collected_Summary_All.rptdesign&SDATE="+sdate+"&EDATE="+edate;
							System.out.println("Report Url=== "+reportUrl);
						}
						
						if(brtFormBean.getBrtReportTypeId()==2)//All clinic -> `Detailed`
						{
							reportUrl= reportBaseUrl+"KngMsd_Lab_PatientCount_Collected_Detailed_All.rptdesign&SDATE="+sdate+"&EDATE="+edate;
							System.out.println("Report Url=== "+reportUrl);
						}
					}
					
					if(brtFormBean.getBrtOid()!=0) //SPECIFIC CLINIC SCENARIO
					{
						if(brtFormBean.getBrtReportTypeId()==1)//Specific clinic -> `Summary`
						{
							reportUrl= reportBaseUrl+"KngMsd_Lab_PatientCount_Collected_Summary_ByOffice.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
							System.out.println("Report Url=== "+reportUrl);
						}
						
						if(brtFormBean.getBrtReportTypeId()==2)//Specific clinic -> `Detailed`
						{
							reportUrl= reportBaseUrl+"KngMsd_Lab_PatientCount_Collected_Detailed_ByOffice.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
							System.out.println("Report Url=== "+reportUrl);
						}
					}
				}
				//.STOP
				

				response.sendRedirect(reportUrl);
			}
	
		// -----------------------------------------------------------------------------------------------------------------------------------------
				
			//LAB	->	Patient Count	->	Sample Accessed
			@GetMapping("/KngLabPatientAccessedCount")	
			public void getKngLabPatientAccessedCount(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
			{
				
				System.out.println("KngLabPatientAccessedCount====" + reportBaseUrl);
				
				sdate = brtFormBean.getBrtSdate();
				edate = brtFormBean.getBrtEdate();
				oid	=	brtFormBean.getBrtOid();
				reporttypeid = brtFormBean.getBrtReportTypeId();
				
				//brtFormBean.getBrtReportTypeId() {Summary=1, Detailed=2}
				System.out.println("Start Date=== "+ sdate);
				System.out.println("End Date=== "+ edate);
				System.out.println("Office Id=== "+ oid);
				System.out.println("Report Type Id=== "+ reporttypeid);
				
				
				//.START
				if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
				{
					if(brtFormBean.getBrtOid()==0) //ALL CLINIC SCENARIO
					{
						if(brtFormBean.getBrtReportTypeId()==1)//All clinic -> `Summary`
						{
							reportUrl= reportBaseUrl+"KngMsd_Lab_PatientCount_Accession_Summary_All.rptdesign&SDATE="+sdate+"&EDATE="+edate;
							System.out.println("Report Url=== "+reportUrl);
						}
						
						if(brtFormBean.getBrtReportTypeId()==2)//All clinic -> `Detailed`
						{
							reportUrl= reportBaseUrl+"KngMsd_Lab_PatientCount_Accession_Detailed_All.rptdesign&SDATE="+sdate+"&EDATE="+edate;
							System.out.println("Report Url=== "+reportUrl);
						}
					}
					
					if(brtFormBean.getBrtOid()!=0) //SPECIFIC CLINIC SCENARIO
					{
						if(brtFormBean.getBrtReportTypeId()==1)//Specific clinic -> `Summary`
						{
							reportUrl= reportBaseUrl+"KngMsd_Lab_PatientCount_Accession_Summary_ByOffice.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
							System.out.println("Report Url=== "+reportUrl);
						}
						
						if(brtFormBean.getBrtReportTypeId()==2)//Specific clinic -> `Detailed`
						{
							reportUrl= reportBaseUrl+"KngMsd_Lab_PatientCount_Accession_Detailed_ByOffice.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
							System.out.println("Report Url=== "+reportUrl);
						}
					}
				}
				//.STOP
				

				response.sendRedirect(reportUrl);
			}
			
			
			
	// -----------------------------------------------------------------------------------------------------------------------------------------
	
	
		//LAB	->	Patient Count	->	Sample Processed
		@GetMapping("/KngLabPatientCountProcessed")	
		public void getKngLabPatientCountProcesse(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
		{
			
			System.out.println("KngLabPatientCountProcessed====" + reportBaseUrl);
			
			sdate = brtFormBean.getBrtSdate();
			edate = brtFormBean.getBrtEdate();
			oid	=	brtFormBean.getBrtOid();
			reporttypeid = brtFormBean.getBrtReportTypeId();
			
			//brtFormBean.getBrtReportTypeId() {Summary=1, Detailed=2}
			System.out.println("Start Date=== "+ sdate);
			System.out.println("End Date=== "+ edate);
			System.out.println("Office Id=== "+ oid);
			System.out.println("Report Type Id=== "+ reporttypeid);
			
			
			//.START
			if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
			{
				if(brtFormBean.getBrtOid()==0) //ALL CLINIC SCENARIO
				{
					if(brtFormBean.getBrtReportTypeId()==1)//All clinic -> `Summary`
					{
						reportUrl= reportBaseUrl+"KngMsd_LabPatientCountProcessed_Summary_All.rptdesign&SDATE="+sdate+"&EDATE="+edate;
						System.out.println("Report Url=== "+reportUrl);
					}
					
					if(brtFormBean.getBrtReportTypeId()==2)//All clinic -> `Detailed`
					{
						reportUrl= reportBaseUrl+"KngMsd_LabPatientCountProcessed_Detailed_All.rptdesign&SDATE="+sdate+"&EDATE="+edate;
						System.out.println("Report Url=== "+reportUrl);
					}
				}
				
				if(brtFormBean.getBrtOid()!=0) //SPECIFIC CLINIC SCENARIO
				{
					if(brtFormBean.getBrtReportTypeId()==1)//Specific clinic -> `Summary`
					{
						reportUrl= reportBaseUrl+"KngMsd_LabPatientCountProcessed_Summary_ByOffice.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
						System.out.println("Report Url=== "+reportUrl);
					}
					
					if(brtFormBean.getBrtReportTypeId()==2)//Specific clinic -> `Detailed`
					{
						reportUrl= reportBaseUrl+"KngMsd_LabPatientCountProcessed_Detailed_ByOffice.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
						System.out.println("Report Url=== "+reportUrl);
					}
				}
			}
			//.STOP
			

			response.sendRedirect(reportUrl);
		}
	
	
	
	

}
