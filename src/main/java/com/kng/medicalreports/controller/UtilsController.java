package com.kng.medicalreports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kng.medicalreports.model.ViewNewRegistration;
import com.kng.medicalreports.service.UtilsService;

@RestController
public class UtilsController 
{
	
	@Autowired
	private UtilsService us;

	@GetMapping("/util_Patient_List")
	public ResponseEntity<List<ViewNewRegistration>> getPatientList(@RequestParam String searchTerm)
	{
		System.out.println("Utils Controller ==> getPatientList");
		
		List<ViewNewRegistration> vrlist = us.getPatientNameList(searchTerm);
		//System.out.println("Patient Registered List:: "+ vrlist);
		return ResponseEntity.ok(vrlist);
	}
}
