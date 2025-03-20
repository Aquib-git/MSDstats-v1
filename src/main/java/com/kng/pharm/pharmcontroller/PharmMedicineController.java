package com.kng.pharm.pharmcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kng.pharm.pharmmodel.PharmItemMaster;
import com.kng.pharm.pharmservice.PharmStockService;

@RestController
public class PharmMedicineController
{
	@Autowired
	public PharmStockService pss;
	
	@GetMapping("/pharmMedicineList")
	 public ResponseEntity<List<PharmItemMaster>> getMedicinesByClinic()
	{
		List<PharmItemMaster> items = pss.getItemMasterList();
       return ResponseEntity.ok(items);
	}

}
