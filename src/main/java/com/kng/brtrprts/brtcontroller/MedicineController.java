package com.kng.brtrprts.brtcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.kng.brtrprts.brtmodel.ItemFilterMaster;
import com.kng.brtrprts.brtservice.BirtReportService;

@RestController
public class MedicineController 
{
	@Autowired
	public BirtReportService bs;

	
	@GetMapping("/medicineList/{clinicId}")
	 public ResponseEntity<List<ItemFilterMaster>> getMedicinesByClinic(@PathVariable int clinicId)
	{
		List<ItemFilterMaster> items = bs.getItemListByOfficeId(clinicId);
        return ResponseEntity.ok(items);
	}
	
}
