package com.kng.pharm.pharmservice;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kng.pharm.pharmmodel.PharmItemMaster;
import com.kng.pharm.pharmmodel.PharmacyStockList;
import com.kng.pharm.pharmrepository.PharmItemMasterRepo;
import com.kng.pharm.pharmrepository.PharmStockRepository;

@Service
public class PharmStockServiceImpl implements PharmStockService 
{

	public String itemIdPrime = "";
	
	@Autowired 
	public PharmStockRepository psrepo;
	
	@Autowired
	private PharmItemMasterRepo pr;
	
	
	@Override
	public List<PharmItemMaster> getItemMasterList()
	{
		List<PharmItemMaster> imList = pr.getItemMasterList();
		return imList;
	}
	
	/* ----------------------------------------------------------------------------------------------------------------------------------------------------- */
	 													// HQ STOCK SCENARIOS
	
	//HQ STOCK ->FULL LIST ->OFFICE_ID=4
	@Override
    public List<PharmacyStockList> getHqStockList() 
    {
		 return  psrepo.findAll().stream().filter(e -> e.getOFFICE_ID().equals(4)).collect(Collectors.toList());        
    }
	
	//HQ STOCK -> Specific LIST by ITEM_ID ->OFFICE_ID=4
	@Override
	public List<PharmacyStockList> getHqStockListByItemId(String itemId)
	{
		
		return psrepo.getPharmStockListByItemId(itemId).stream().filter(e -> e.getOFFICE_ID().equals(4)).collect(Collectors.toList()); 
	}
	
	/* ----------------------------------------------------------------------------------------------------------------------------------------------------- */
														// SCM STOCK SCENARIOS
	
    //SCM STOCK ->FULL LIST ->OFFICE_ID=7
	@Override
    public List<PharmacyStockList> getScmStockList() 
    {
		return  psrepo.findAll().stream().filter(e -> e.getOFFICE_ID().equals(7)).collect(Collectors.toList());        
   
    }
    
	//SCM STOCK -> Specific LIST by ITEM_ID ->OFFICE_ID=7
	@Override
	public List<PharmacyStockList> getScmStockListByItemId(String itemId)
	{
		return psrepo.getPharmStockListByItemId(itemId).stream().filter(e -> e.getOFFICE_ID().equals(7)).collect(Collectors.toList()); 
	}
	
	/* ----------------------------------------------------------------------------------------------------------------------------------------------------- */
														// TCM STOCK SCENARIOS
	
    //TCM STOCK ->FULL LIST ->OFFICE_ID=5
	@Override
    public List<PharmacyStockList> getTcmStockList() 
    {
		return  psrepo.findAll().stream().filter(e -> e.getOFFICE_ID().equals(5)).collect(Collectors.toList());         
    }
	
	//TCM STOCK -> Specific LIST by ITEM_ID ->OFFICE_ID=5
	@Override
	public List<PharmacyStockList> getTcmStockListByItemId(String itemId)
	{
		return psrepo.getPharmStockListByItemId(itemId).stream().filter(e -> e.getOFFICE_ID().equals(5)).collect(Collectors.toList()); 
	}
    
	/* ----------------------------------------------------------------------------------------------------------------------------------------------------- */
														// TD STOCK SCENARIOS
	
    //TD STOCK ->FULL LIST ->OFFICE_ID=6
	@Override
    public List<PharmacyStockList> getTdStockList() 
    {
		return  psrepo.findAll().stream().filter(e -> e.getOFFICE_ID().equals(6)).collect(Collectors.toList());        
    }
	
	//TD STOCK -> Specific LIST by ITEM_ID ->OFFICE_ID=6
	@Override
	public List<PharmacyStockList> getTdStockListByItemId(String itemId)
	{
		return psrepo.getPharmStockListByItemId(itemId).stream().filter(e -> e.getOFFICE_ID().equals(6)).collect(Collectors.toList()); 
	}
	
    
	/* ----------------------------------------------------------------------------------------------------------------------------------------------------- */
													// KAZ STOCK SCENARIOS
	
    //KAZ STOCK ->FULL LIST ->OFFICE_ID=8
	@Override
    public List<PharmacyStockList> getKazStockList() 
    {
		return  psrepo.findAll().stream().filter(e -> e.getOFFICE_ID().equals(8)).collect(Collectors.toList());        
    }
	
	//KAZ STOCK -> Specific LIST by ITEM_ID ->OFFICE_ID=8
	@Override
	public List<PharmacyStockList> getKazStockListByItemId(String itemId)
	{
		return psrepo.getPharmStockListByItemId(itemId).stream().filter(e -> e.getOFFICE_ID().equals(8)).collect(Collectors.toList()); 
	}

	/* ----------------------------------------------------------------------------------------------------------------------------------------------------- */
	 
}
