package com.kng.pharm.pharmservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kng.pharm.pharmmodel.PharmDirectTransferHdrListAll;
import com.kng.pharm.pharmmodel.PharmDirectTransferHdrOfficeCountAll;
import com.kng.pharm.pharmmodel.PharmStockAdjustHdrListAll;
import com.kng.pharm.pharmmodel.PharmStockAdjustHdrOfficeCountAll;
import com.kng.pharm.pharmrepository.PharmDirectTransferHdrListAllRepo;
import com.kng.pharm.pharmrepository.PharmDirectTransferHdrOfficeCountRepo;
import com.kng.pharm.pharmrepository.PharmStockAdjustHdrListAllRepo;
import com.kng.pharm.pharmrepository.PharmStockAdjustHdrOfficeCountRepo;

@Service
public class PhaChartServiceImpl implements PharmChartService
{
	@Autowired
	private PharmStockAdjustHdrOfficeCountRepo psa;
	@Autowired
	private PharmStockAdjustHdrListAllRepo psal;
	
	@Autowired
	private PharmDirectTransferHdrOfficeCountRepo pdt;
	@Autowired
	private PharmDirectTransferHdrListAllRepo pdtl;
	

	
	/* ------------------------------------------------- STOCK ADJUST SERVICE LOGIC START ------------------------------------------------- */	
	@Override
	public HashMap<String, Object> getStockAdjustHdrOfficeCountRange(String SDate, String EDate, int ofcId)
	{
		
		//You may have to create `LabSampleCollectionOfficeCountAllDao` and try with dao layer
		System.out.println("========= Hello. I am --> Sample Collection CHART SERVICE LAYER =========");
		System.out.println("Service layer=== sc haspmap ===" + SDate);
		System.out.println("Service layer=== sc haspmap ===" + EDate);
		System.out.println("Service layer=== sc haspmap ===" + ofcId);
		List<PharmStockAdjustHdrOfficeCountAll> phasaList;
		
		if (ofcId != 0) 
		{
			phasaList = psa.getPharmStockAdjustHdrOfficeCountId(SDate,EDate,ofcId);
		} 
		else
		{
			phasaList = psa.getPharmStockAdjustHdrOfficeCountAll(SDate, EDate);
		}

		HashMap<String, Object> phasaMap = new HashMap<>();
		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();
		
		int TotalStockAdjustCount =0;
		
		if (!phasaList.isEmpty()) 
		{
			for (PharmStockAdjustHdrOfficeCountAll p : phasaList)
			{
				label.add(p.getOFFICE_NAME().trim());
				
				
				Long totalCount = p.getPHA_COUNT();
				data.add(totalCount != null ? String.valueOf(totalCount) : "0");

				if (totalCount != null) 
				{
					TotalStockAdjustCount += totalCount;
				}
			}
		}
		
		System.out.println("Total Count ========"+TotalStockAdjustCount);
		System.out.println("phasaLabel===" + label.toString());
		System.out.println("phasaData===" + data.toString());
		System.out.println("phasaList===" + phasaList);
		
		
		phasaMap.put("phasaLabel",label.toString());
		phasaMap.put("phasaData", data.toString());
		phasaMap.put("phasaList",phasaList);
		phasaMap.put("TotalStockAdjustCount",TotalStockAdjustCount);
		
		return phasaMap;
	}

	@Override
	public List<PharmStockAdjustHdrListAll> getStockAdjustHdrList(String SDate, String EDate, int ofcId)
	{

		System.out.println("========= Hello. I am --> Stock Adjust LIST SERVICE LAYER =========");
		System.out.println("Service layer === sa list ===" + SDate);
		System.out.println("Service layer === sa list ===" + EDate);
		System.out.println("Service layer === sa list ===" + ofcId);
		
		if (ofcId != 0) {

			List<PharmStockAdjustHdrListAll>pp=psal.getPharmStockAdjustHdrListOid(SDate, EDate, ofcId);
			System.out.println("Service layer === pp value ===" + pp);
			return psal.getPharmStockAdjustHdrListOid(SDate, EDate, ofcId);

		} else {

			return psal.getPharmStockAdjustHdrListAll(SDate, EDate);

		}
	}

	
	
	/* ------------------------------------------------- STOCK ADJUST SERVICE LOGIC END ------------------------------------------------- */	
	

	
	/* ------------------------------------------------- DIRECT TRANSFER SERVICE LOGIC START ------------------------------------------------- */	
	
	
	@Override
	public HashMap<String, Object> getDirectTransferHdrOfficeCountRange(String SDate, String EDate, int ofcId)
	{
		
		//You may have to create `LabSampleCollectionOfficeCountAllDao` and try with dao layer
		System.out.println("========= Hello. I am --> Direct Transfer CHART SERVICE LAYER =========");
		System.out.println("Service layer=== dt haspmap ===" + SDate);
		System.out.println("Service layer=== dt haspmap ===" + EDate);
		System.out.println("Service layer=== dt haspmap ===" + ofcId);
		List<PharmDirectTransferHdrOfficeCountAll> phadtList;
		
		if (ofcId != 0) 
		{
			phadtList = pdt.getPharmDirectTransferHdrOfficeCountId(SDate,EDate,ofcId);
		} 
		else
		{
			phadtList = pdt.getPharmDirectTransferHdrOfficeCountAll(SDate, EDate);
		}

		HashMap<String, Object> phadtMap = new HashMap<>();
		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();
		
		int TotalDirectTransferCount =0;
		
		if (!phadtList.isEmpty()) 
		{
			for (PharmDirectTransferHdrOfficeCountAll p : phadtList)
			{
				label.add(p.getOFFICE_NAME().trim());
				
				
				Long totalCount = p.getPHA_COUNT();
				data.add(totalCount != null ? String.valueOf(totalCount) : "0");

				if (totalCount != null) 
				{
					TotalDirectTransferCount += totalCount;
				}
			}
		}
		
		System.out.println("Total Count ========"+TotalDirectTransferCount);
		System.out.println("phadtLabel===" + label.toString());
		System.out.println("phadtData===" + data.toString());
		System.out.println("phadtList===" + phadtList);
		
		
		phadtMap.put("phadtLabel",label.toString());
		phadtMap.put("phadtData", data.toString());
		phadtMap.put("phadtList",phadtList);
		phadtMap.put("TotalDirectTransferCount",TotalDirectTransferCount);
		
		return phadtMap;
	}

	@Override
	public List<PharmDirectTransferHdrListAll> getDirectTransferHdrList(String SDate, String EDate, int ofcId) {

		System.out.println("========= Hello. I am --> Direct Transfer LIST SERVICE LAYER =========");
		System.out.println("Service layer === dt list ===" + SDate);
		System.out.println("Service layer === dt list ===" + EDate);
		System.out.println("Service layer === dt list ===" + ofcId);
		
		if (ofcId != 0) {

			return pdtl.getPharmDirectTransferHdrListOid(SDate, EDate, ofcId);

		} else {

			return pdtl.getPharmDirectTransferHdrListAll(SDate, EDate);

		}
	}

	
	
	
	
	/* ------------------------------------------------- DIRECT TRANSFER SERVICE LOGIC END ------------------------------------------------- */	
	
	
	
}
