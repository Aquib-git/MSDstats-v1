package com.kng.brtrprts.brtcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kng.brtrprts.brtmodel.DoctorsFilterSetup;
import com.kng.brtrprts.brtservice.BirtReportService;

@RestController
public class DoctorController 
{
	@Autowired
	public BirtReportService bs;
	
	 @GetMapping("/doctorList/{departmentId}")
	    public ResponseEntity<List<DoctorsFilterSetup>> getDoctorsByDepartment(@PathVariable int departmentId) 
	 	{
	        List<DoctorsFilterSetup> doctors = bs.getDoctorListByOfficeId(departmentId);
	        return ResponseEntity.ok(doctors);
	    }

}
