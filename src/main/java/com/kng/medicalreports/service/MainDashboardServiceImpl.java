package com.kng.medicalreports.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kng.medicalreports.model.ViewDocLabCatTestCount;
import com.kng.medicalreports.model.ViewDocRadCatTestCount;
import com.kng.medicalreports.model.ViewDoctorOfficeCountAll;
import com.kng.medicalreports.model.ViewHealrhCenterTotalManpower;
import com.kng.medicalreports.model.ViewKngDashCardData;
import com.kng.medicalreports.model.ViewPatientInfoToday;
import com.kng.medicalreports.model.ViewPatientVisitDeptAll;
import com.kng.medicalreports.model.ViewPatientVisitOfficeCurrSummary;
import com.kng.medicalreports.model.ViewPatientVisitYearwise;
import com.kng.medicalreports.repository.ViewDashPatientRepository;
import com.kng.medicalreports.repository.ViewDocLabCatTestCountRepository;
import com.kng.medicalreports.repository.ViewDocRadCatTestCountRepository;
import com.kng.medicalreports.repository.ViewDoctorOfficeCountAllRepository;
import com.kng.medicalreports.repository.ViewHealrhCenterTotalManpowerRepository;
import com.kng.medicalreports.repository.ViewKngDashCardDataRepository;
import com.kng.medicalreports.repository.ViewPatientVisitDeptAllRepository;
import com.kng.medicalreports.repository.ViewPatientVisitOfficeRepository;
import com.kng.medicalreports.repository.ViewPatientVisitYearwiseRepository;

@Service
public class MainDashboardServiceImpl implements MainDashboardService {

		@Autowired
	    private ViewHealrhCenterTotalManpowerRepository healthManpowerByBranchesRepository;
		
		
		@Autowired
	    private ViewKngDashCardDataRepository viewKngDashCardDataRepository;
		
		@Autowired
	    private ViewDocLabCatTestCountRepository viewDocLabCatTestCountRepository;
		
		@Autowired
	    private ViewDocRadCatTestCountRepository viewDocRadCatTestCountRepository;
		
		@Autowired
	    private ViewPatientVisitOfficeRepository viewPatientVisitOfficeRepository;
		
		@Autowired
	    private ViewDoctorOfficeCountAllRepository viewDoctorOfficeCountAllRepository;
		
		@Autowired
	    private ViewPatientVisitYearwiseRepository viewPatientVisitYearwiseRepository;
		
		@Autowired
	    private ViewPatientVisitDeptAllRepository viewPatientVisitDeptAllRepository;
		
		@Autowired
	    private ViewDashPatientRepository viewDashPatientRepository;
		
//		// for View test
//		@Autowired
//	    private ReceIptListRepository receIptListRepository;
	
		@Override
		public List<ViewHealrhCenterTotalManpower> findHealthManpowerByBranches() {
			//return healthManpowerByBranchesRepository.findViewHealrhCenterTotalManpowerByBranch();
			return healthManpowerByBranchesRepository.findAll();
		}

		@Override
		public HashMap<String, Object> getAllHealthManpowerByBranches() {
			
			List<ViewHealrhCenterTotalManpower> hmpBranchList=findHealthManpowerByBranches();

	        HashMap<String, Object> hmpBranchMap = new HashMap<>();

	        List<String> label = new ArrayList<>();
	        List<String> data = new ArrayList<>();
	        
	        int TotalHealthManpower=0;

//	        label.add("Instore Sales");
//	        label.add("Download Sales");
//	        label.add("Mail-Order Sales");
//	        data.add("30");
//	        data.add("12");
//	        data.add("20");

	        for (ViewHealrhCenterTotalManpower ViewHealrhCenterTotalManpower : hmpBranchList) {
	            label.add(ViewHealrhCenterTotalManpower.getOfficeName());
	            data.add(String.valueOf(ViewHealrhCenterTotalManpower.getTotalCount()));
	            TotalHealthManpower+=ViewHealrhCenterTotalManpower.getTotalCount();
	        }
	        hmpBranchMap.put("hmpbLabels", label.toString());
	        hmpBranchMap.put("hmpbData", data.toString());
	        hmpBranchMap.put("TotalHealthManpower", String.format("%,d",TotalHealthManpower));
	        
	        return hmpBranchMap;
			
		}

		@Override
		public HashMap<String, Object> getViewKngDashCardDataByCategory() {
			// TODO Auto-generated method stub
			List<ViewKngDashCardData> hmpList=viewKngDashCardDataRepository.findAll();

	        HashMap<String, Object> hmpCategoryMap = new HashMap<>();

	        List<String> label = new ArrayList<>();
	        List<String> data = new ArrayList<>();

	        int TotalPatientVisit=0 ,TotalPatientRegistered=0,SickLeaveCount =0,TotalNurses=0;
	        
	        int TotalDoctors=0 ,TotalDentist=0,TotalPharmacusts =0,TotalRadiographerTechn=0,TotalOther=0,TotalMedicines=0;
	        int TotalProcedure=0;
	       
	        for (ViewKngDashCardData ViewKngDashCardData : hmpList) {
	        	if(ViewKngDashCardData.getRow_num() < 8 ) {
	             label.add(ViewKngDashCardData.getName());
	             data.add(Integer.toString(ViewKngDashCardData.getTotalCount()));
	        	}
	        	
	        
				if(ViewKngDashCardData.getRow_num()==8) {
	              TotalPatientVisit =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==9) {
		          TotalPatientRegistered =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==10) {
		            SickLeaveCount =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==1) {
					TotalNurses =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==2) {
					TotalPharmacusts =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==3) {
					TotalOther =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==4) {
					TotalRadiographerTechn =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==5) {
					int TotalRadiographerTechnTemp1 =ViewKngDashCardData.getTotalCount();
					TotalRadiographerTechn =TotalRadiographerTechn+TotalRadiographerTechnTemp1;
				}
				else if(ViewKngDashCardData.getRow_num()==6) {
					TotalDentist =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==7) {
					TotalDoctors =ViewKngDashCardData.getTotalCount();
					
				}else if(ViewKngDashCardData.getRow_num()==12) {
					TotalMedicines =ViewKngDashCardData.getTotalCount();
					
				}else if(ViewKngDashCardData.getRow_num()==17) {
					TotalProcedure =ViewKngDashCardData.getTotalCount();
				}
				
				
				
	        }
	        	        
	        hmpCategoryMap.put("hmpLabels", label.toString());
	        hmpCategoryMap.put("hmpData", data.toString());
	        hmpCategoryMap.put("TotalPatientVisit", String.format("%,d",TotalPatientVisit));
	        hmpCategoryMap.put("TotalPatientRegistered", String.format("%,d",TotalPatientRegistered));
	        hmpCategoryMap.put("SickLeaveCount", String.format("%,d",SickLeaveCount));
	        hmpCategoryMap.put("TotalNurses", TotalNurses);
	        hmpCategoryMap.put("TotalPharmacusts", TotalPharmacusts);
	        hmpCategoryMap.put("TotalOther", TotalOther);
	        hmpCategoryMap.put("TotalRadiographerTechn", TotalRadiographerTechn);
	        hmpCategoryMap.put("TotalDentist", TotalDentist);
	        hmpCategoryMap.put("TotalDoctors", TotalDoctors);
	        hmpCategoryMap.put("TotalMedicines", String.format("%,d",TotalMedicines));
	        hmpCategoryMap.put("TotalProcedure", String.format("%,d",TotalProcedure));
	        
	      
	        
	        
	        return hmpCategoryMap;
		}
		
		
		
		// for getting hmp category by dates
		
		
		@Override
		public HashMap<String, Object> getViewKngDashCardDataByCategoryDate(String fdate, String tdate) {
			// TODO Auto-generated method stub
			
			
			List<ViewKngDashCardData> hmpList;
			
			if(fdate!=null && tdate!=null) {
				
			
		 hmpList=viewKngDashCardDataRepository.findAllByDate(fdate,tdate);
			
			}else {
				
			hmpList=viewKngDashCardDataRepository.findAll();
				
			}
			
			HashMap<String, Object> hmpCategoryMap = new HashMap<>();

	        List<String> label = new ArrayList<>();
	        List<String> data = new ArrayList<>();
	        
	        

	        int TotalPatientVisit=0 ,TotalPatientRegistered=0,SickLeaveCount =0,TotalNurses=0;
	        
	        int TotalDoctors=0 ,TotalDentist=0,TotalPharmacusts =0,TotalRadiographerTechn=0,TotalOther=0,TotalMedicines=0;
	        int TotalProcedure=0;
	       
	        
	        
	        
	        for (ViewKngDashCardData ViewKngDashCardData : hmpList) {
	        	if(ViewKngDashCardData.getRow_num() < 8 ) {
	             label.add(ViewKngDashCardData.getName());
	             data.add(Integer.toString(ViewKngDashCardData.getTotalCount()));
	        	}
	        	
	        
				if(ViewKngDashCardData.getRow_num()==8) {
	              TotalPatientVisit =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==9) {
		          TotalPatientRegistered =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==10) {
		            SickLeaveCount =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==1) {
					TotalNurses =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==2) {
					TotalPharmacusts =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==3) {
					TotalOther =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==4) {
					TotalRadiographerTechn =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==5) {
					int TotalRadiographerTechnTemp1 =ViewKngDashCardData.getTotalCount();
					TotalRadiographerTechn =TotalRadiographerTechn+TotalRadiographerTechnTemp1;
				}
				else if(ViewKngDashCardData.getRow_num()==6) {
					TotalDentist =ViewKngDashCardData.getTotalCount();
				}
				else if(ViewKngDashCardData.getRow_num()==7) {
					TotalDoctors =ViewKngDashCardData.getTotalCount();
					
				}else if(ViewKngDashCardData.getRow_num()==12) {
					TotalMedicines =ViewKngDashCardData.getTotalCount();
					
				}else if(ViewKngDashCardData.getRow_num()==17) {
					TotalProcedure =ViewKngDashCardData.getTotalCount();
				}
				
				
				
	        }
	        	        
	        hmpCategoryMap.put("hmpLabels", label.toString());
	        hmpCategoryMap.put("hmpData", data.toString());
	        hmpCategoryMap.put("TotalPatientVisit", String.format("%,d",TotalPatientVisit));
	        hmpCategoryMap.put("TotalPatientRegistered", String.format("%,d",TotalPatientRegistered));
	        hmpCategoryMap.put("SickLeaveCount", String.format("%,d",SickLeaveCount));
	        hmpCategoryMap.put("TotalNurses", TotalNurses);
	        hmpCategoryMap.put("TotalPharmacusts", TotalPharmacusts);
	        hmpCategoryMap.put("TotalOther", TotalOther);
	        hmpCategoryMap.put("TotalRadiographerTechn", TotalRadiographerTechn);
	        hmpCategoryMap.put("TotalDentist", TotalDentist);
	        hmpCategoryMap.put("TotalDoctors", TotalDoctors);
	        hmpCategoryMap.put("TotalMedicines", String.format("%,d",TotalMedicines));
	        hmpCategoryMap.put("TotalProcedure", String.format("%,d",TotalProcedure));
	        
	      
	        
	        
	        return hmpCategoryMap;
		}
		
		
		

		@Override
		public HashMap<String, Object> getViewDocLabCatTestCountByCategory() {
			List<ViewDocLabCatTestCount> hmpLabTestList=viewDocLabCatTestCountRepository.findAll();

	        HashMap<String, Object> hmpLabTestMap = new HashMap<>();

	        List<String> label = new ArrayList<>();
	        List<String> data = new ArrayList<>();
	        
	        int TotalLabTest=0;


	        for (ViewDocLabCatTestCount ViewDocLabCatTestCount : hmpLabTestList) {
	            label.add(ViewDocLabCatTestCount.getName());
	            data.add(String.valueOf(ViewDocLabCatTestCount.getTotalCount()));
	            TotalLabTest+=ViewDocLabCatTestCount.getTotalCount();
	        }
	        hmpLabTestMap.put("hmpbLabels", label.toString());
	        hmpLabTestMap.put("hmpbData", data.toString());
	        hmpLabTestMap.put("TotalLabTest", String.format("%,d",TotalLabTest));
	        
	        return hmpLabTestMap;
		}

		
		@Override
		public HashMap<String, Object> getViewDocRadCatTestCountByCategory() {
			List<ViewDocRadCatTestCount> hmpRadTestList=viewDocRadCatTestCountRepository.findAll();

	        HashMap<String, Object> hmpRadTestMap = new HashMap<>();

	        List<String> label = new ArrayList<>();
	        List<String> data = new ArrayList<>();
	        
	        int TotalRadTest=0;


	        for (ViewDocRadCatTestCount ViewDocRadCatTestCount : hmpRadTestList) {
	            label.add(ViewDocRadCatTestCount.getName());
	            data.add(String.valueOf(ViewDocRadCatTestCount.getTotalCount()));
	            TotalRadTest+=ViewDocRadCatTestCount.getTotalCount();
	        }
	        hmpRadTestMap.put("hmpbLabels", label.toString());
	        hmpRadTestMap.put("hmpbData", data.toString());
	        hmpRadTestMap.put("TotalRadTest", String.format("%,d",TotalRadTest));
	        
	        return hmpRadTestMap;
		}

		@Override
		public HashMap<String, Object> getViewPatientVisitOfficeCurrSummary() {
			
			List<ViewPatientVisitOfficeCurrSummary> hmpPatientVisitList=viewPatientVisitOfficeRepository.findAll();

	        HashMap<String, Object> hmpPatientVisitMap = new HashMap<>();

	        
	        int TotalPatientVisit=0;


	        for (ViewPatientVisitOfficeCurrSummary ViewPatientVisitOfficeCurrSummary : hmpPatientVisitList) {
	            
	        	TotalPatientVisit+=ViewPatientVisitOfficeCurrSummary.getTotalCount();
	        }
	       
	        hmpPatientVisitMap.put("hmpPatientVisitData", hmpPatientVisitList);
	        hmpPatientVisitMap.put("TotalPatientVisit", TotalPatientVisit);
	        
	        return hmpPatientVisitMap;
			
			
			
			
			// TODO Auto-generated method stub
			
		}

		@Override
		public HashMap<String, Object> getViewDoctorOfficeCountAll() {
			
			   List<ViewDoctorOfficeCountAll> hmpDoctorOfficeList=viewDoctorOfficeCountAllRepository.findAll();
			
			  HashMap<String, Object> hmpDoctorOfficeMap = new HashMap<>();

		        List<String> label = new ArrayList<>();
		        List<String> data = new ArrayList<>();
		        
		        int TotalDoctorOffice=0;


		        for (ViewDoctorOfficeCountAll ViewDoctorOfficeCountAll : hmpDoctorOfficeList) {
		            label.add(ViewDoctorOfficeCountAll.getOfficeName());
		            data.add(String.valueOf(ViewDoctorOfficeCountAll.getTotalCount()));
		            //TotalDoctorOffice+=ViewDoctorOfficeCountAll.getTotalCount();
		        }
		        hmpDoctorOfficeMap.put("hmpbLabels", label.toString());
		        hmpDoctorOfficeMap.put("hmpbData", data.toString());
		        hmpDoctorOfficeMap.put("TotalDoctorOffice", TotalDoctorOffice);
		        
		        return hmpDoctorOfficeMap;
		}
		
		
		
		// get doctor branches by Dates 
		
		
		@Override
		public HashMap<String, Object> getViewDoctorOfficeCountAllByDate(String fdate, String tdate) {
			
			
			  List<ViewDoctorOfficeCountAll> hmpDoctorOfficeList;
			  
			  
			  if(fdate!=null && tdate!=null) {
				  
				  hmpDoctorOfficeList=viewDoctorOfficeCountAllRepository.findAllbyDate(fdate,tdate);
			  }else {
			
			 hmpDoctorOfficeList=viewDoctorOfficeCountAllRepository.findAll();
			 
			 
			  }
			
			  HashMap<String, Object> hmpDoctorOfficeMap = new HashMap<>();

		        List<String> label = new ArrayList<>();
		        List<String> data = new ArrayList<>();
		        
		        int TotalDoctorOffice=0;


		        for (ViewDoctorOfficeCountAll ViewDoctorOfficeCountAll : hmpDoctorOfficeList) {
		            label.add(ViewDoctorOfficeCountAll.getOfficeName());
		            data.add(String.valueOf(ViewDoctorOfficeCountAll.getTotalCount()));
		            //TotalDoctorOffice+=ViewDoctorOfficeCountAll.getTotalCount();
		        }
		        hmpDoctorOfficeMap.put("hmpbLabels", label.toString());
		        hmpDoctorOfficeMap.put("hmpbData", data.toString());
		        hmpDoctorOfficeMap.put("TotalDoctorOffice", TotalDoctorOffice);
		        
		        return hmpDoctorOfficeMap;
		}
		
		
		// for getting data on basis of seleted year wise 
		
		/*
		 * @Override public HashMap<String, Object>
		 * getViewDoctorOfficeCountByListYear(int SelectedYear) {
		 * 
		 * List<ViewDoctorOfficeCountAll>
		 * hmpDoctorOfficeList=viewDoctorOfficeCountAllRepository.findAllByListYear(
		 * SelectedYear);
		 * 
		 * HashMap<String, Object> hmpDoctorOfficeMap = new HashMap<>();
		 * 
		 * List<String> label = new ArrayList<>(); List<String> data = new
		 * ArrayList<>();
		 * 
		 * int TotalDoctorOffice=0;
		 * 
		 * 
		 * for (ViewDoctorOfficeCountAll ViewDoctorOfficeCountAll : hmpDoctorOfficeList)
		 * { label.add(ViewDoctorOfficeCountAll.getOfficeName());
		 * data.add(String.valueOf(ViewDoctorOfficeCountAll.getTotalCount()));
		 * //TotalDoctorOffice+=ViewDoctorOfficeCountAll.getTotalCount(); }
		 * hmpDoctorOfficeMap.put("hmpbLabels", label.toString());
		 * hmpDoctorOfficeMap.put("hmpbData", data.toString());
		 * hmpDoctorOfficeMap.put("TotalDoctorOffice", TotalDoctorOffice);
		 * 
		 * return hmpDoctorOfficeMap; }
		 */
//------------------------------------ViewPatientVisitYearwise-----------------------------------
		@Override
		public HashMap<String, Object> getViewPatientVisitYearwise() {
			List<ViewPatientVisitYearwise> hmpViewPatientVisitList=viewPatientVisitYearwiseRepository.findAll();
			
			  HashMap<String, Object> hmpViewPatientMap = new HashMap<>();

		        List<String> label = new ArrayList<>();
		        List<String> data = new ArrayList<>();
		        
		        int TotalViewPatientVisit=0;


		        for (ViewPatientVisitYearwise ViewPatientVisitYearwise : hmpViewPatientVisitList) {
		            label.add(ViewPatientVisitYearwise.getYearWise());
		            data.add(String.valueOf(ViewPatientVisitYearwise.getTotalCount()));
		            //TotalLabTest+=viewDocLabCatTestCountImp.getTotalCount();
		        }
		        hmpViewPatientMap.put("hmpbLabels", label.toString());
		        hmpViewPatientMap.put("hmpbData", data.toString());
		        hmpViewPatientMap.put("TotalViewPatientVisit", String.format("%,d",TotalViewPatientVisit));
		        
		        return hmpViewPatientMap;
		}
//------------------------------------ViewPatientVisitDeptAll-----------------------------------
		@Override
		public HashMap<String, Object> getViewPatientVisitDeptAll() {
			List<ViewPatientVisitDeptAll> hmpViewPatientVisitDeptList=viewPatientVisitDeptAllRepository.findAll();
			
			  HashMap<String, Object> hmpViewPatientDeptMap = new HashMap<>();

		        List<String> label = new ArrayList<>();
		        List<String> data = new ArrayList<>();
		        
		        int TotalViewPatientVisitDept=0;
		        int TotalViewPatientVisitDental=0;

		        for (ViewPatientVisitDeptAll ViewPatientVisitDeptAll : hmpViewPatientVisitDeptList) {
		        	if(!ViewPatientVisitDeptAll.getFlagFilter().equals("Others")) {
			            TotalViewPatientVisitDental+=ViewPatientVisitDeptAll.getTotalCount();
			            }	
		        	
		        }
		          label.add("Dental");
	              data.add(String.valueOf(TotalViewPatientVisitDental));
	              
	              
		        for (ViewPatientVisitDeptAll ViewPatientVisitDeptAll : hmpViewPatientVisitDeptList) {
		        	if(ViewPatientVisitDeptAll.getFlagFilter().equals("Others")) {
		             label.add(ViewPatientVisitDeptAll.getName());
		             data.add(String.valueOf(ViewPatientVisitDeptAll.getTotalCount()));
		           	}
		           
		        }
		        hmpViewPatientDeptMap.put("hmpbLabels", label.toString());
		        hmpViewPatientDeptMap.put("hmpbData", data.toString());
		        hmpViewPatientDeptMap.put("TotalViewPatientVisitDept", String.format("%,d",TotalViewPatientVisitDept));
		        
		        return hmpViewPatientDeptMap;
		}

		
		@Override
		public HashMap<String, Object> getViewPatientVisitDeptData() {
			List<ViewPatientVisitDeptAll> hmpViewPatientVisitDeptList=viewPatientVisitDeptAllRepository.findAll();
			
			  HashMap<String, Object> hmpViewPatientDeptMap = new HashMap<>();
		        int TotalViewPatientVisitDental=0;
		        for (ViewPatientVisitDeptAll ViewPatientVisitDeptAll : hmpViewPatientVisitDeptList) {
		        	if(!ViewPatientVisitDeptAll.getFlagFilter().equals("Others")) {
			            TotalViewPatientVisitDental+=ViewPatientVisitDeptAll.getTotalCount();
			            }	
		        	
		           }
		          hmpViewPatientDeptMap.put("Dental", String.format("%,d",TotalViewPatientVisitDental));
		         
	              
		        for (ViewPatientVisitDeptAll ViewPatientVisitDeptAll : hmpViewPatientVisitDeptList) {
		        	if(ViewPatientVisitDeptAll.getFlagFilter().equals("Others")) {
		               hmpViewPatientDeptMap.put(ViewPatientVisitDeptAll.getName(),String.valueOf(String.format("%,d",ViewPatientVisitDeptAll.getTotalCount())));
		           	}
		           
		        }
		        
		        
		        return hmpViewPatientDeptMap;
		}
		
		
		
		

	    // Fetch available years for the dashboard
	    public List<Integer> getAvailableYears() {
	        // Mock data for now. Ideally, you'd fetch this from a database or another data source.
	        return Arrays.asList(2019, 2020, 2021, 2022, 2023);
	    }

		
		
	    @Override
		public List<ViewPatientInfoToday> getViewDashPatientInfoTodayDetail(int doctorId,String sdate, String edate){
	    	
	    	List<ViewPatientInfoToday> hmpList1;
	    	
	    	if(doctorId!=0 && sdate!=null && edate!=null) {
	    	
	  hmpList1=viewDashPatientRepository.findAllByRangeDate(doctorId, sdate,edate);;
	    	
	    	
	    	}else {
	    		
	    		 hmpList1=viewDashPatientRepository.findAll();;
	 	    	
	    		
	    	}	
	    	
	    	
	    	return hmpList1;
	    	
	    }
		
//	//	for test View
//		@Override
//		public List<ReceIptList> findReceIptListBranches() {
//			// TODO Auto-generated method stub
//	     System.out.print("islam========="+receIptListRepository.findAll().size());
//			return receIptListRepository.findAll();
//		}

}
