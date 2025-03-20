package com.kng.brtrprts.brtcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.kng.brtrprts.brtmodel.DepartmentFilterSetup;
import com.kng.brtrprts.brtservice.BirtReportService;

import java.util.List;

@RestController
public class DepartmentController 
{
	@Autowired
	public BirtReportService bs;
	

    @GetMapping("/departmentList/{clinicId}")
    public ResponseEntity<List<DepartmentFilterSetup>> getDepartmentsByClinic(@PathVariable int clinicId) {
        List<DepartmentFilterSetup> departments = bs.getDepartmentListByOfficeId(clinicId);
        return ResponseEntity.ok(departments);
    }
}
