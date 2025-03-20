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
public class BirtPatController
{
	Logger logger = LoggerFactory.getLogger(BirtPatController.class);
	
	@Autowired
	public BrtFormBean brtFormBean;
	
	@Autowired
	public BirtReportService bs;
	
	public String sdate = "", edate = "",reportUrl=""; 
	public Integer oid,yid,did,docid,qid,demogid;
	
	
	@Value("${birt.report.base.url}")
	private String reportBaseUrl;
	
	
	@GetMapping("/patientVisitsByDoctorDepartmentReport")	
	public void getpatientVisitsByDoctorDepartmentReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
	{
		System.out.println("patientVisitsByDoctorDepartmentReport====" + reportBaseUrl);
		
		  sdate	=brtFormBean.getBrtSdate();
		  edate	=brtFormBean.getBrtEdate();
		  oid	=brtFormBean.getBrtOid();
		  did	=brtFormBean.getBrtDid();
		  docid	=brtFormBean.getBrtDocid();
		
		//.START
		if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
		{	
			if(brtFormBean.getBrtOid()==0)// all clinic -> all department -> all doctors
			{
				reportUrl= reportBaseUrl+"KngMsd_patientVisitsByDoctorDepartmentReport_AllClinic_AllDep_AllDoc.rptdesign&SDATE="+sdate+"&EDATE="+edate;
			}
			else //SPECIFIC CLINIC SCENARIO
			{
				if(did==0)//specific clinic -> all department -> all doctor
				{
					reportUrl= reportBaseUrl+"KngMsd_patientVisitsByDoctorDepartmentReport_Clinic_AllDep_AllDoc.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
				}
				else
				{
					if(docid==0)//specific clinic -> specific department -> all doctors
					{
						reportUrl= reportBaseUrl+"KngMsd_patientVisitsByDoctorDepartmentReport_Clinic_Dep_AllDoc.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid+"&DID="+did;
					}
					else//specific clinic -> specific department -> specific doctor
					{
						reportUrl= reportBaseUrl+"KngMsd_patientVisitsByDoctorDepartmentReport_Clinic_Dep_Doc.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid+"&DID="+did+"&DOCID="+docid;
					}
				}
			}
		}
		response.sendRedirect(reportUrl);
		//.STOP
		
	}
	

	@GetMapping("/specialityvisit")	
	public void getspecialityvisitReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
	{
		System.out.println("specialityvisit====" + reportBaseUrl);
		
		  sdate	=brtFormBean.getBrtSdate();
		  edate	=brtFormBean.getBrtEdate();
		  oid	=brtFormBean.getBrtOid();
		  demogid=brtFormBean.getBrtKwtNkwtid();
		  
		  //1->All,
		
		//.START
		if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
		{
			if(brtFormBean.getBrtOid()==0)// all Clinic 
			{
				if(demogid==1) //all clinic->All
				{
					reportUrl= reportBaseUrl+"KngMsd_specialityVisitReport_AllClinic_All.rptdesign&SDATE="+sdate+"&EDATE="+edate;
				}
				if(demogid==2) //all clinic->Kuwaiti
				{
					reportUrl= reportBaseUrl+"KngMsd_specialityVisitReport_AllClinic_KWT.rptdesign&SDATE="+sdate+"&EDATE="+edate;
				}
				if(demogid==3) //all clinic->Non-Kuwaiti
				{
					reportUrl= reportBaseUrl+"KngMsd_specialityVisitReport_AllClinic_NKWT.rptdesign&SDATE="+sdate+"&EDATE="+edate;
				}
				
			}
			else //Specific Clinic
			{
				if(demogid==1) //Specific clinic->All
				{
					reportUrl= reportBaseUrl+"KngMsd_specialityVisitReport_SpecificClinic_All.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
				}
				if(demogid==2) //Specific clinic->Kuwaiti
				{
					reportUrl= reportBaseUrl+"KngMsd_specialityVisitReport_SpecificClinic_KWT.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
				}
				if(demogid==3) //Specific clinic->Non-Kuwaiti
				{
					reportUrl= reportBaseUrl+"KngMsd_specialityVisitReport_SpecificClinic_NKWT.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
				}
			}
			
		}
		response.sendRedirect(reportUrl);
	}
	
	
	
	
	@GetMapping("/patientcount")
	public void getpatientcountReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
	{
		System.out.println("patientcount====" + reportBaseUrl);
		
		  sdate	=brtFormBean.getBrtSdate();
		  edate	=brtFormBean.getBrtEdate();
		  
		  if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
		  {
			  reportUrl= reportBaseUrl+"pat_count_demogr1.rptdesign&SDATE="+sdate+"&EDATE="+edate;
		  }
		  response.sendRedirect(reportUrl);
	}
	
	
	@GetMapping("/visitcount")
	public void getvisitcountReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
	{
		System.out.println("visitcount====" + reportBaseUrl);
		
		  sdate	=brtFormBean.getBrtSdate();
		  edate	=brtFormBean.getBrtEdate();
		  
		  if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
		  {			  
			  reportUrl= reportBaseUrl+"pat_count_demogr2.rptdesign&SDATE="+sdate+"&EDATE="+edate;
		  }
		  response.sendRedirect(reportUrl);
	}
	
	
	
	@GetMapping("/patvisitOfficerSoldierCivilianFamily")
	public void getpatvisitOfficerSoldierCivilianFamilyReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
	{
		System.out.println("patvisitOfficerSoldierCivilianFamily====" + reportBaseUrl);
		
		  sdate	=brtFormBean.getBrtSdate();
		  edate	=brtFormBean.getBrtEdate();
		  
		  if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
		  {
			  reportUrl= reportBaseUrl+"speciality_stat.rptdesign&SDATE="+sdate+"&EDATE="+edate;
		  }
		  response.sendRedirect(reportUrl);
	}
	
	@GetMapping("/chronicPatientReport")
	public void getpatChronicPatientDetailedReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
	{
		System.out.println("patvisitOfficerSoldierCivilianFamily====" + reportBaseUrl);
		
		
		 sdate =brtFormBean.getBrtSdate();
		 edate =brtFormBean.getBrtEdate();
		 oid   =brtFormBean.getBrtOid();
		 
		 
		if(brtFormBean.getBrtSdate()!=null && brtFormBean.getBrtEdate()!=null)
		  {
				if(brtFormBean.getBrtOid()==0)// user selects all clinic scenario
				{
					reportUrl= reportBaseUrl+"KngMsd_ChronicPatient_All.rptdesign&SDATE="+sdate+"&EDATE="+edate;
				}
				else 
				{
					reportUrl= reportBaseUrl+"KngMsd_ChronicPatient_ByOffice.rptdesign&SDATE="+sdate+"&EDATE="+edate+"&OID="+oid;
				}
		  }
		  response.sendRedirect(reportUrl);
	}
	
	
	@GetMapping("/patientYearlyVisitsperSpecalityReport")
	public void getpatientYearlyVisitsperSpecalityReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
	{
		System.out.println("patientYearlyVisitsperSpecalityReport====" + reportBaseUrl);
		
		yid = brtFormBean.getBrtYearid();
		oid = brtFormBean.getBrtOid();
		
		if(brtFormBean.getBrtOid()!=0)
		  {
			reportUrl= reportBaseUrl+"KngMsd_PatientVisitperSpeciality_ByOffice.rptdesign&OID="+oid+"&YID="+yid;
		  }
		
		response.sendRedirect(reportUrl);
		
	}
	
	@GetMapping("/patientYearlyVisitsCategorizedProcedure")
	public void getpatientMonthlyVisitsCategorizedProcedureReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
	{
		System.out.println("patientYearlyVisitsCategorizedProcedure====" + reportBaseUrl);
		
		yid = brtFormBean.getBrtYearid();
		oid = brtFormBean.getBrtOid();
		
		if(brtFormBean.getBrtOid()!=0)
		  {
			reportUrl= reportBaseUrl+"KngMsd_ProcPatientVisitperSpeciality_ByOffice.rptdesign&OID="+oid+"&YID="+yid;
		  }
		
		response.sendRedirect(reportUrl);
		
	}
	
	
	//patientVisitsCategorizedProcedureDocWise
	@GetMapping("/patientVisitsCategorizedProcedureDocWise")
	public void getpatientVisitsCategorizedProcedureDocWiseReport(@ModelAttribute BrtFormBean brtFormBean, HttpServletResponse response) throws IOException
	{
		System.out.println("patientVisitsCategorizedProcedureDocWise====" + reportBaseUrl);
		
		  yid	=brtFormBean.getBrtYearid();
		  oid	=brtFormBean.getBrtOid();
		  did	=brtFormBean.getBrtDid();
		  docid	=brtFormBean.getBrtDocid();
		  qid	=brtFormBean.getBrtQrterid();
		  
		//.START
			if(brtFormBean.getBrtYearid()!=0)
			{	
					if(did==0)//specific clinic -> all department -> all doctor
					{
						if(qid==1)//specific clinic -> all department -> all doctor-> First Quarter
						{
							reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_AllDept_AllDoc_FirstQrtr.rptdesign&YID="+yid+"&OID="+oid;
						}
						if(qid==2)//specific clinic -> all department -> all doctor-> Second Quarter
						{
							reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_AllDept_AllDoc_SecondQrtr.rptdesign&YID="+yid+"&OID="+oid;
						}
						if(qid==3)//specific clinic -> all department -> all doctor-> Third Quarter
						{
							reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_AllDept_AllDoc_ThirdQrtr.rptdesign&YID="+yid+"&OID="+oid;
						}
						if(qid==4)//specific clinic -> all department -> all doctor-> Fourth Quarter
						{
							reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_AllDept_AllDoc_FrthQrtr.rptdesign&YID="+yid+"&OID="+oid;
						}
					}
					else//specific clinic -> specific department scenario
					{
						if(docid == 0)//specific clinic -> specific department -> all doctors
						{
							if(qid==1)//specific clinic -> specific department -> all doctors-> First Quarter
							{
								reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_SpecDept_AllDoc_FirstQrtr.rptdesign&YID="+yid+"&OID="+oid+"&DID="+did;
							}
							if(qid==2)//specific clinic -> specific department -> all doctors-> Second Quarter
							{
								reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_SpecDept_AllDoc_SecondQrtr.rptdesign&YID="+yid+"&OID="+oid+"&DID="+did;
							}
							if(qid==3)//specific clinic -> specific department -> all doctors-> Third Quarter
							{
								reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_SpecDept_AllDoc_ThirdQrtr.rptdesign&YID="+yid+"&OID="+oid+"&DID="+did;
							}
							if(qid==4)//specific clinic -> specific department -> all doctors-> Fourth Quarter
							{
								reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_SpecDept_AllDoc_FrthQrtr.rptdesign&YID="+yid+"&OID="+oid+"&DID="+did;
							}
						}
						else//specific clinic -> specific department -> specific doctor
						{
							if(qid==1)//specific clinic -> specific department -> specific doctor-> First Quarter
							{
								reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_SpecDept_SpecDoc_FirstQrtr.rptdesign&YID="+yid+"&OID="+oid+"&DID="+did+"&DOCID="+docid;
							}
							if(qid==2)//specific clinic -> specific department -> specific doctor-> Second Quarter
							{
								reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_SpecDept_SpecDoc_SecondQrtr.rptdesign&YID="+yid+"&OID="+oid+"&DID="+did+"&DOCID="+docid;
							}
							if(qid==3)//specific clinic -> specific department -> specific doctor-> Third Quarter
							{
								reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_SpecDept_SpecDoc_ThirdQrtr.rptdesign&YID="+yid+"&OID="+oid+"&DID="+did+"&DOCID="+docid;
							}
							if(qid==4)//specific clinic -> specific department -> specific doctor-> Fourth Quarter
							{
								reportUrl= reportBaseUrl+"KngMsd_patientVisitsCategorizedProcedureDocWise_SpecClinic_SpecDept_SpecDoc_FrthQrtr.rptdesign&YID="+yid+"&OID="+oid+"&DID="+did+"&DOCID="+docid;
							}
						}
					}
				}
			response.sendRedirect(reportUrl);
			//.STOP
		  
		  
		
	}
	
}
