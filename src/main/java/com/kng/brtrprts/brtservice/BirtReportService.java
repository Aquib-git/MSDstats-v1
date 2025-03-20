package com.kng.brtrprts.brtservice;

import java.util.List;

import com.kng.brtrprts.brtmodel.DepartmentFilterSetup;
import com.kng.brtrprts.brtmodel.DoctorsFilterSetup;
import com.kng.brtrprts.brtmodel.ItemFilterMaster;
import com.kng.brtrprts.brtmodel.OfficeFilterDetails;

public interface BirtReportService 
{
	
	
	public List<OfficeFilterDetails> getOfficeDetailsFilter();
	public List<DepartmentFilterSetup> getDepartmentListByOfficeId(int officeId);
	public List<DoctorsFilterSetup> getDoctorListByOfficeId(int departmentId);
	public List<ItemFilterMaster> getItemListByOfficeId(int officeId);
	
	
}
