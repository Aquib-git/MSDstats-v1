package com.kng.pharm.pharmservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kng.pharm.pharmmodel.PharmOfficeFilterDetails;
import com.kng.pharm.pharmrepository.PharmOfficeFilterDetailsRepo;

@Service
public class PharmReportServiceImpl implements PharmReportService 
{
	@Autowired
	PharmOfficeFilterDetailsRepo podrepo;
	
	
	@Override
	public List<PharmOfficeFilterDetails> getPharmOfficeDetailsFilter() 
	{
		List<PharmOfficeFilterDetails> pofdrList = podrepo.getPharmOfficeDetailsFilter();
		return pofdrList;
	}
}
