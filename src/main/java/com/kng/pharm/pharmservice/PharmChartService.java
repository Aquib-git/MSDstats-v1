package com.kng.pharm.pharmservice;

import java.util.HashMap;
import java.util.List;

import com.kng.pharm.pharmmodel.PharmDirectTransferHdrListAll;
import com.kng.pharm.pharmmodel.PharmStockAdjustHdrListAll;

public interface PharmChartService 
{
	
	public HashMap<String, Object> getStockAdjustHdrOfficeCountRange(String SDate, String EDate, int ofcId);
	public List<PharmStockAdjustHdrListAll> getStockAdjustHdrList(String SDate, String EDate, int ofcId);
	
	public HashMap<String, Object> getDirectTransferHdrOfficeCountRange(String SDate, String EDate, int ofcId);
	public List<PharmDirectTransferHdrListAll> getDirectTransferHdrList(String SDate, String EDate, int ofcId);
}
