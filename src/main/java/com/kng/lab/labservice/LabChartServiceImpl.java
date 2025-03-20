package com.kng.lab.labservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kng.lab.labmodel.LabAccessionAcknowledgeListAll;
import com.kng.lab.labmodel.LabAccessionAcknowledgeOfficeCountAll;
import com.kng.lab.labmodel.LabSampleCollectionListAll;
import com.kng.lab.labmodel.LabSampleCollectionOfficeCountAll;
import com.kng.lab.labrepository.LabAccessionAcknowledgeOfficeCountRepo;
import com.kng.lab.labrepository.LabAccessionAcknowledgeRepo;
import com.kng.lab.labrepository.LabSampleCollectionOfficeCountRepo;
import com.kng.lab.labrepository.LabSampleCollectionRepo;

@Service
public class LabChartServiceImpl implements LabChartService 
{
	Logger logger = LoggerFactory.getLogger(LabChartServiceImpl.class);
	
	@Autowired
	private LabSampleCollectionOfficeCountRepo lsco;
	@Autowired
	private LabSampleCollectionRepo lsc;
	
	@Autowired
	private LabAccessionAcknowledgeOfficeCountRepo labaao;
	@Autowired
	private LabAccessionAcknowledgeRepo laa;
	
	
	
/* ------------------------------------------------- SAMPLE COLLECTION SERVICE LOGIC START ------------------------------------------------- */	
	@Override
	public HashMap<String, Object> getLabSampleCollectionOfficeCountRange(String SDate, String EDate, int ofcId)
	{
		
		//You may have to create `LabSampleCollectionOfficeCountAllDao` and try with dao layer
		System.out.println("========= Hello. I am --> Sample Collection CHART SERVICE LAYER =========");
		System.out.println("Service layer=== sc haspmap ===" + SDate);
		System.out.println("Service layer=== sc haspmap ===" + EDate);
		System.out.println("Service layer=== sc haspmap ===" + ofcId);
		List<LabSampleCollectionOfficeCountAll> labscoList;
		
		if (ofcId != 0) 
		{
			labscoList = lsco.getLabSampleCollectionOfficeCountById(SDate,EDate,ofcId);
		} 
		else
		{
			labscoList = lsco.getLabSampleCollectionOfficeCountAll(SDate, EDate);
		}

		HashMap<String, Object> labscoMap = new HashMap<>();
		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();
		
		int TotalSampleCollectionCount =0;
		
		if (!labscoList.isEmpty()) 
		{
			for (LabSampleCollectionOfficeCountAll lsc : labscoList)
			{
				label.add(lsc.getOFFICE_NAME().trim());
				
				
				Long totalCount = lsc.getLAB_TEST_COUNT();
				data.add(totalCount != null ? String.valueOf(totalCount) : "0");

				if (totalCount != null) 
				{
					TotalSampleCollectionCount += totalCount;
				}
			}
		}
		
		System.out.println("Total Count ========"+TotalSampleCollectionCount);
		System.out.println("labscoLabel===" + label.toString());
		System.out.println("labscoData===" + data.toString());
		System.out.println("labscoList===" + labscoList);
		
		
		labscoMap.put("labscoLabel",label.toString());
		labscoMap.put("labscoData", data.toString());
		labscoMap.put("labscoList",labscoList);
		labscoMap.put("TotalSampleCollectionCount",TotalSampleCollectionCount);
		
		return labscoMap;
	}

	@Override
	public List<LabSampleCollectionListAll> getSampleCollectDetails(String SDate, String EDate, int ofcId) {

		System.out.println("========= Hello. I am --> Sample Collection LIST SERVICE LAYER =========");
		System.out.println("Service layer === sc list ===" + SDate);
		System.out.println("Service layer === sc list ===" + EDate);
		System.out.println("Service layer === sc list ===" + ofcId);
		
		if (ofcId != 0) {

			return lsc.getLabSampleCollectionListByOfficeId(SDate, EDate, ofcId);

		} else {

			return lsc.getLabSampleCollectionListAll(SDate, EDate);

		}
	}
/* ------------------------------------------------- SAMPLE COLLECTION SERVICE LOGIC START ------------------------------------------------- */	


/* ------------------------------------------------- ACCESSION/ACKNWLDG SERVICE LOGIC START ------------------------------------------------- */	
	@Override
	public HashMap<String, Object> getLabAccessionAcknwldgOfficeCountRange(String SDate, String EDate, int ofcId)
	{
		System.out.println("========= Hello. I am --> Accession Acknowledge CHART SERVICE LAYER  =========");
		System.out.println("Service layer=== aa haspmap ===" + SDate);
		System.out.println("Service layer=== aa haspmap ===" + EDate);
		System.out.println("Service layer=== aa haspmap ===" + ofcId);
		List<LabAccessionAcknowledgeOfficeCountAll> labaaoList;
		
		if (ofcId != 0) 
		{
			labaaoList = labaao.getLabAccessionAcknowledgeOfficeCountByOfficeId(SDate,EDate,ofcId);
		} 
		else
		{
			labaaoList = labaao.getLabAccessionAcknowledgeOfficeCountAll(SDate, EDate);
		}

		HashMap<String, Object> labaaoMap = new HashMap<>();
		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();
		
		int TotalAccessioncknwldgCount =0;
		
		if (!labaaoList.isEmpty()) 
		{
			for (LabAccessionAcknowledgeOfficeCountAll laa : labaaoList)
			{
				label.add(laa.getOFFICE_NAME().trim());
				
				
				Long totalCount = laa.getLAB_TEST_COUNT();
				data.add(totalCount != null ? String.valueOf(totalCount) : "0");

				if (totalCount != null) 
				{
					TotalAccessioncknwldgCount += totalCount;
				}
			}
		}
	
		System.out.println("Total Count ========"+TotalAccessioncknwldgCount);
		System.out.println("labaaoLabel===" + label.toString());
		System.out.println("labaaoData===" + data.toString());
		System.out.println("labaaoList===" + labaaoList);
		
		labaaoMap.put("labaaoLabel",label.toString());
		labaaoMap.put("labaaoData", data.toString());
		labaaoMap.put("labaaoList",labaaoList);
		labaaoMap.put("TotalAccessionAcknwldgCount",TotalAccessioncknwldgCount);
		
		return labaaoMap;
	}
	
	@Override
	public List<LabAccessionAcknowledgeListAll> getAccessionAcknowledgeDetails(String SDate, String EDate, int ofcId) 
	{

		System.out.println("========= Hello. I am --> Accesion Acknowledge LIST SERVICE LAYER =========");
		System.out.println("Service layer=== aa list ===" + SDate);
		System.out.println("Service layer=== aa list ===" + EDate);
		System.out.println("Service layer=== aa list ===" + ofcId);
		if (ofcId != 0) {

			return laa.getLabAccessionAcknowledgeListAllByOfficeId(SDate, EDate, ofcId);

		} else {

			return laa.getLabAccessionAcknowledgeListAll(SDate, EDate);

		}
	}
	
	
/* ------------------------------------------------- ACCESSION/ACKNWLDG SERVICE LOGIC END ------------------------------------------------- */	
		
}
