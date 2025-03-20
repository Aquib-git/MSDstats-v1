package com.kng.pharm.pharmservice;

import java.util.List;

import com.kng.pharm.pharmmodel.PharmItemMaster;
import com.kng.pharm.pharmmodel.PharmacyStockList;

public interface PharmStockService 
{
	public List<PharmItemMaster> getItemMasterList();	
	
	public List<PharmacyStockList> getHqStockList();
	public List<PharmacyStockList> getHqStockListByItemId(String itemId);
	
	
	public List<PharmacyStockList> getScmStockList();
	public List<PharmacyStockList> getScmStockListByItemId(String itemId);
	
	public List<PharmacyStockList> getTcmStockList();
	public List<PharmacyStockList> getTcmStockListByItemId(String itemId);
	
	public List<PharmacyStockList> getTdStockList();
	public List<PharmacyStockList> getTdStockListByItemId(String itemId);
	
	
	public List<PharmacyStockList> getKazStockList();
	public List<PharmacyStockList> getKazStockListByItemId(String itemId);

}
