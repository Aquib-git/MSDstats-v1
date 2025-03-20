package com.kng.medicalreports.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.kng.medicalreports.model.ViewLabResultAttr_Dup1;


public interface LabResultAttr_Service {
	
	public List<ViewLabResultAttr_Dup1> getLabResultAttrService_dup1( int consultid , String tid);

}
