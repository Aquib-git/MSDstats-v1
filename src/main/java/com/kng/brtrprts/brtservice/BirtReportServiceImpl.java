package com.kng.brtrprts.brtservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kng.brtrprts.brtmodel.DepartmentFilterSetup;
import com.kng.brtrprts.brtmodel.DoctorsFilterSetup;
import com.kng.brtrprts.brtmodel.ItemFilterMaster;
import com.kng.brtrprts.brtmodel.OfficeFilterDetails;
import com.kng.brtrprts.brtrepository.DepartmenFiltertSetupRepo;
import com.kng.brtrprts.brtrepository.DoctorFilterSetupRepo;
import com.kng.brtrprts.brtrepository.ItemFilterMasterRepo;
import com.kng.brtrprts.brtrepository.OfficeFilterDetailsRepo;

@Service
public class BirtReportServiceImpl implements BirtReportService 
{
	@Autowired
	OfficeFilterDetailsRepo ofdrepo;
	
	@Autowired
	DepartmenFiltertSetupRepo dsrepo;
	
	@Autowired
	DoctorFilterSetupRepo dcrepo;

	@Autowired
	ItemFilterMasterRepo imrepo;
	
	@Override
	public List<OfficeFilterDetails> getOfficeDetailsFilter() 
	{
		List<OfficeFilterDetails> ofdrList = ofdrepo.getOfficeDetailsFilter();
		return ofdrList;
	}
	
	@Override
	public List<DepartmentFilterSetup> getDepartmentListByOfficeId(int officeId)
	{
		List<DepartmentFilterSetup> dsList=dsrepo.getDepartmentListByOfficeId(officeId);
		return dsList;
	}
	
	@Override
	public List<DoctorsFilterSetup> getDoctorListByOfficeId(int departmentId)
	{
		List<DoctorsFilterSetup> dcList=dcrepo.getDoctorListByOfficeId(departmentId);
		return dcList;
	}
	
	
	@Override
	public List<ItemFilterMaster> getItemListByOfficeId(int officeId)
	{
		List<ItemFilterMaster> imList=imrepo.getItemFilterMasterByOfficeId(officeId);
		return imList;
	}
}











