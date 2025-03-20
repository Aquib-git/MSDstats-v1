package com.kng.medicalreports.service;

import java.util.List;

import com.kng.medicalreports.model.ViewLabResultAttr_Dup1;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kng.medicalreports.dao.ViewDoctorOfficeCountTodayImp;
import com.kng.medicalreports.dao.ViewLabRadTestsOfficeCountTodayImp;
import com.kng.medicalreports.dao.ViewPatientVisitOfficeCountTodayImp;
import com.kng.medicalreports.model.*;
import com.kng.medicalreports.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kng.medicalreports.service.LabResultAttr_Service;

@Service
public class LabResultAttr_serviceImp implements LabResultAttr_Service  {
	
	// Logger for debugging
	private static final Logger LOGGER = LoggerFactory.getLogger(DailyStatisticsServiceImp.class);
	
	@Autowired
	private ViewLabResultAttrRepository_dup1 viewLabResultAttrRepository_dup1;
	
	  @Override
	    public List<ViewLabResultAttr_Dup1> getLabResultAttrService_dup1(int consultid,String tid) {
			
	        List<ViewLabResultAttr_Dup1> labResultsAttrList1serv = 
	        viewLabResultAttrRepository_dup1.findLabResultAttrRepo_dup1(consultid,tid);
	        
	        for (ViewLabResultAttr_Dup1 result : labResultsAttrList1serv) {
	            result.calculateStyle();
	        }
	        
	        
//	        LOGGER.debug("Stored procedure returned: {}", labResultsAttrList1serv);
//	        
//	        System.out.println("labResultsAttrList1serv" +labResultsAttrList1serv);
	        
	        return labResultsAttrList1serv;
	    }

}
