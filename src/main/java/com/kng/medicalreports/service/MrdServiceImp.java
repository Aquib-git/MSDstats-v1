package com.kng.medicalreports.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kng.medicalreports.model.ViewDispenseInfoToday;
import com.kng.medicalreports.model.ViewLabtestInfoToday;
import com.kng.medicalreports.model.ViewMrdPatDemo;
import com.kng.medicalreports.model.ViewPatientInfoToday;
import com.kng.medicalreports.model.ViewProcInfoToday;
import com.kng.medicalreports.model.ViewRadTestInfoToday;
import com.kng.medicalreports.model.ViewSickLeaveInfoToday;
import com.kng.medicalreports.model.ViewVitalsInfoToday;
import com.kng.medicalreports.repository.ViewDispenseInfoTodayRepository;
import com.kng.medicalreports.repository.ViewLabtestInfoTodayRepository;
import com.kng.medicalreports.repository.ViewMrdPatDemoRepository;
import com.kng.medicalreports.repository.ViewPatientInfoTodayRepository;
import com.kng.medicalreports.repository.ViewProcInfoTodayRepository;
import com.kng.medicalreports.repository.ViewRadTestInfoTodayRepository;
import com.kng.medicalreports.repository.ViewSickLeaveInfoTodayRepository;
import com.kng.medicalreports.repository.ViewVitalsInfoTodayRepository;

@Service
public class MrdServiceImp implements MrdService
{
	
	@Autowired
	private ViewMrdPatDemoRepository mrdPatDemog;
	
	@Autowired
	private ViewPatientInfoTodayRepository mrdEID;
	
	@Autowired
	private ViewLabtestInfoTodayRepository mrdLab;

	@Autowired
	private ViewRadTestInfoTodayRepository mrdRad;
	
	@Autowired
	private ViewProcInfoTodayRepository mrdProc;
	
	@Autowired
	private ViewVitalsInfoTodayRepository mrdVitals;
	
	@Autowired
	private ViewSickLeaveInfoTodayRepository mrdSick;

	@Autowired
	private ViewDispenseInfoTodayRepository mrdDispense;
	
	// Logger for debugging
    private static final Logger LOGGER = LoggerFactory.getLogger(MrdServiceImp.class);

	
	//==============================================MRD logic code starts===========================================================
	@Override
	public List<ViewMrdPatDemo> getPatMrdDemographicDetails(String civilId) {
		
		List<ViewMrdPatDemo> mrdPatDemogList = mrdPatDemog.findByCivilId(civilId);
		
		return mrdPatDemogList;
	}
	
	
	@Override
	public List<ViewLabtestInfoToday> getPatMrdLabDetails(String civilId) {

		List<ViewLabtestInfoToday> mrdLabDetailsList = mrdLab.findByCivilId(civilId);

		return mrdLabDetailsList;

	}

	@Override
	public List<ViewRadTestInfoToday> getPatMrdRadDetails(String civilId) {

		List<ViewRadTestInfoToday> mrdRadDetailsList = mrdRad.findByCivilId(civilId);

		return mrdRadDetailsList;

	}

	@Override
	public List<ViewProcInfoToday> getPatMrdProcDetails(String civilId) {

		List<ViewProcInfoToday> mrdProcDetailsList = mrdProc.findByCivilId(civilId);

		return mrdProcDetailsList;

	}
	
	@Override
	public List<ViewVitalsInfoToday> getPatMrdVitalDetails(String civilId) {

	
		List<ViewVitalsInfoToday> mrdVitalsDetailsList = mrdVitals.findByCivilId(civilId);

		return mrdVitalsDetailsList;

	}
	
	
	@Override
	public List<ViewSickLeaveInfoToday> getPatMrdSickLeaveDetails(String civilId) {

	
		List<ViewSickLeaveInfoToday> mrdSickDetailsList = mrdSick.findByCivilId(civilId);

		return mrdSickDetailsList;

	}
	
	
	@Override
	public List<ViewDispenseInfoToday> getPatMrdDispenceDetails(String civilId) {

	
		List<ViewDispenseInfoToday> mrdDispenseDetailsList = mrdDispense.findByCivilId(civilId);

		return mrdDispenseDetailsList;

	}
	
	
	
	
	
	//==============================================MRD logic code Ends===========================================================
	
	//========================================== MRD by employee id details START================================

			//used
			
			  @Override 
			  public List<ViewMrdPatDemo> getPatMrdEIDDemographicDetails2(String eid) {
			  
			  List<ViewMrdPatDemo> mrdEIDPatDemogList=mrdPatDemog.findByPatEmployeeId(eid); 
			  return mrdEIDPatDemogList;
			  }
			  
			  @Override
				public List<ViewPatientInfoToday> getMRDEID2(String eid,String fdate,String tdate)
				{
				  System.out.println("SERVICE LAYER ===> getMRDEID2 ===> Military Id: "+eid+" "+"Start Date: "+fdate+" "+"End Date: "+tdate);
					
					List<ViewPatientInfoToday> mrdEIDConsultationList=mrdEID.findMRDEID2(eid, fdate,tdate);
					return mrdEIDConsultationList;
				}
			
			
			// same as above but with 2
		
			//used
			/*
			 * @Override public List<ViewMrdPatDemo> getPatMrdEIDDemographicDetails2(String
			 * eid,String fdate,String tdate) {
			 * 
			 * List<ViewMrdPatDemo> mrdEIDPatDemogList=
			 * mrdPatDemog.findByPatEmployeeId2(eid, fdate,tdate); return
			 * mrdEIDPatDemogList; }
			 */
			
			
			
			
			//used
			/*
			 * @Override public List<ViewPatientInfoToday> getMRDEID(String eid){
			 * List<ViewPatientInfoToday> mrdEIDConsultationList=mrdEID.findMRDEID(eid);
			 * return mrdEIDConsultationList; }
			 */
			
			
			//  same as above but with 2
			
			
			//the below code keep as reference
			/*
			 * @Override public List<ViewLabtestInfoToday> getPatMrdEIDLabDetails(String
			 * eid) { List<ViewLabtestInfoToday> mrdEIDLabDetailsList =
			 * mrdLab.findByPatEmployeeId(eid); return mrdEIDLabDetailsList; }
			 */
			
			// same as above but with 2
		//	@Override
			
		/*	  public List<ViewLabtestInfoToday> getPatMrdEIDLabDetails2(String eid,String
			  fdate,String tdate) { List<ViewLabtestInfoToday> mrdEIDLabDetailsList =
			  mrdLab.findByPatEmployeeId2(eid, fdate,tdate); return mrdEIDLabDetailsList; }
			 
			
			
			@Override
			public List<ViewRadTestInfoToday> getPatMrdEIDRadDetails(String eid)
			{
				List<ViewRadTestInfoToday> mrdEIDRadDetailsList = mrdRad.findByPatEmployeeId(eid);

				return mrdEIDRadDetailsList;
			}
			
			@Override
			public List<ViewProcInfoToday> getPatMrdEIDProcDetails(String eid)
			{
				List<ViewProcInfoToday> mrdEIDProcDetailsList = mrdProc.findByPatEmployeeId(eid);

				return mrdEIDProcDetailsList;
				
			}
			
			@Override
			public List<ViewVitalsInfoToday> getPatMrdEIDVitalDetails(String eid)
			{
				List<ViewVitalsInfoToday> mrdEIDVitalsDetailsList = mrdVitals.findByPatEmployeeId(eid);

				return mrdEIDVitalsDetailsList;
				
			}
			
			@Override
			public List<ViewSickLeaveInfoToday> getPatMrdEIDSickLeaveDetails(String eid)
			{
				List<ViewSickLeaveInfoToday> mrdEIDSickDetailsList = mrdSick.findByPatEmployeeId(eid);

				return mrdEIDSickDetailsList;
			}
			
			@Override
			public List<ViewDispenseInfoToday> getPatMrdEIDDispenceDetails(String eid)
			{
				List<ViewDispenseInfoToday> mrdEIDDispenseDetailsList = mrdDispense.findByPatEmployeeId(eid);

				return mrdEIDDispenseDetailsList;
			}
			*/
		//========================================== MRD by employee id details END================================

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
