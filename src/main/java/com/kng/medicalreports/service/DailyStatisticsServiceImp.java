package com.kng.medicalreports.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kng.medicalreports.dao.ViewDoctorOfficeCountTodayImp;
import com.kng.medicalreports.dao.ViewLabRadTestsOfficeCountTodayImp;
import com.kng.medicalreports.dao.ViewPatientVisitOfficeCountTodayImp;
import com.kng.medicalreports.model.*;
import com.kng.medicalreports.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DailyStatisticsServiceImp implements DailyStatisticsService {

	@Autowired
	private ViewDoctorOfficeCountTodayRepository viewDoctorOfficeCountTodayRepository;

	@Autowired
	private ViewPatientVisitOfficeCountTodayRepository viewPatientVisitOfficeCountTodayRepository;

	@Autowired
	private ViewLabRadTestsOfficeCountTodayRepository viewLabRadTestsOfficeCountTodayRepository;

	@Autowired
	private ViewSickLeaveOfficeCountTodayRepository viewSickLeaveOfficeCountTodayRepository;

	@Autowired
	private ViewProceduOfficeCountTodayRepository viewProceduOfficeCountTodayRepository;

	@Autowired
	private ViewPatientVisitOfficeMonthWiseRepository viewPatientVisitOfficeMonthWiseRepository;

	@Autowired
	private ViewPatientVisitDeptTodayRepository viewPatientVisitDeptTodayRepository;

	@Autowired
	private ViewDocLabCatTestCountRepository viewDocLabCatTestCountRepository;

	@Autowired
	private ViewLabtestInfoTodayRepository viewLabtestInfoTodayRepository;

	@Autowired
	private ViewLabtestInfoTodayRepository_dup1 viewLabtestInfoTodayRepository_dup1;

	@Autowired
	private ViewSickLeaveInfoTodayRepository viewSickLeaveInfoTodayRepository;

	@Autowired
	private ViewRadTestInfoTodayRepository viewRadTestInfoTodayRepository;

	@Autowired
	private ViewProcInfoTodayRepository viewProcInfoTodayRepository;

	@Autowired
	private ViewDocInfoTodayRepository viewDocInfoTodayRepository;

	@Autowired
	private ViewPatientInfoTodayRepository viewPatientInfoTodayRepository;

	@Autowired
	private ViewDispenseInfoTodayRepository viewDispenseInfoTodayRepository;

	@Autowired
	private ViewVitalsInfoTodayRepository viewVitalsInfoTodayRepository;

	@Autowired
	private ViewDispenseOfficeCountTodayRepository viewDispenseOfficeCountTodayRepository;

	@Autowired
	private ViewEclinicRepository viewEclinicRepository;

	@Autowired
	private ViewLabResultAttrRepository viewLabResultAttrRepository;

	@Autowired
	private ViewLabResultAttrRepository_dup1 viewLabResultAttrRepository_dup1;
	
	//==========================================for RETIRE PATIENT START================================
	
	
	@Autowired
	private ViewPatRetInfoTodayRepository viewPatRetInfoTodayRepository;
	@Autowired
	private ViewPatientRetiredOfficeCountTodayRepo vproctrepo;
	//==========================================for RETIRE PATIENT END================================
	

	// Logger for debugging
	private static final Logger LOGGER = LoggerFactory.getLogger(DailyStatisticsServiceImp.class);

	@Override
	// @Cacheable("doctor")
	public HashMap<String, Object> getViewDoctorOfficeCountToday() {
		List<ViewDoctorOfficeCountToday> hmpDoctorOfficeTodayList = viewDoctorOfficeCountTodayRepository.findAll();

		HashMap<String, Object> hmpDoctorOfficeMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();

		int TotalDoctorOfficeToday = 0;

		for (ViewDoctorOfficeCountToday ViewDoctorOfficeCountToday : hmpDoctorOfficeTodayList) {
			label.add(ViewDoctorOfficeCountToday.getOfficeName().trim());
			data.add(String.valueOf(ViewDoctorOfficeCountToday.getTotalCount()));
			TotalDoctorOfficeToday += ViewDoctorOfficeCountToday.getTotalCount();
		}
		hmpDoctorOfficeMap.put("hmpbLabels", label.toString());
		hmpDoctorOfficeMap.put("hmpbData", data.toString());
		hmpDoctorOfficeMap.put("TotalDoctorOfficeToday", TotalDoctorOfficeToday);

		return hmpDoctorOfficeMap;
	}

	@Override
	public HashMap<String, Object> getViewDoctorOfficeCountRange(String SDate, String EDate, int ofcId) {
		List<ViewDoctorOfficeCountTodayImp> hmpDoctorOfficeTodayList;

		if (ofcId != 0) {
			hmpDoctorOfficeTodayList = viewDoctorOfficeCountTodayRepository.findViewDoctorOfficeCountByRangeDate(SDate,
					EDate, ofcId);
		} else {

			hmpDoctorOfficeTodayList = viewDoctorOfficeCountTodayRepository.findViewDoctorOfficeCountByRangeDate(SDate,
					EDate);
		}

		HashMap<String, Object> hmpDoctorOfficeMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();

		int TotalDoctorOfficeToday = 0;

		for (ViewDoctorOfficeCountTodayImp ViewDoctorOfficeCountTodayImp : hmpDoctorOfficeTodayList) {
			label.add(ViewDoctorOfficeCountTodayImp.getOfficeName().trim());
			data.add(String.valueOf(ViewDoctorOfficeCountTodayImp.getTotalCount()));
			TotalDoctorOfficeToday += ViewDoctorOfficeCountTodayImp.getTotalCount();
		}
		hmpDoctorOfficeMap.put("hmpbLabels", label.toString());
		hmpDoctorOfficeMap.put("hmpbData", data.toString());
		hmpDoctorOfficeMap.put("TotalDoctorOfficeToday", TotalDoctorOfficeToday);

		return hmpDoctorOfficeMap;
	}

	@Override
	public HashMap<String, Object> getViewPatientVisitOfficeToday() {
		List<ViewPatientVisitOfficeCountToday> hmpPatientVisitTodayList = viewPatientVisitOfficeCountTodayRepository
				.findAll();

		HashMap<String, Object> hmpPatientVisitTodayMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();

		int TotalPatientVisitToday = 0;

		if (!hmpPatientVisitTodayList.isEmpty()) {
			for (ViewPatientVisitOfficeCountToday ViewPatientVisitOfficeCountToday : hmpPatientVisitTodayList) {

				label.add(ViewPatientVisitOfficeCountToday.getOfficeName().trim());
				data.add(String.valueOf(ViewPatientVisitOfficeCountToday.getTotalCount()));
				TotalPatientVisitToday += ViewPatientVisitOfficeCountToday.getTotalCount();

			}
		}
		System.out.println("TotalPatientVisitToday========" + TotalPatientVisitToday);

		hmpPatientVisitTodayMap.put("hmpbLabels", label.toString());
		hmpPatientVisitTodayMap.put("hmpbData", data.toString());
		hmpPatientVisitTodayMap.put("hmpPatientVisitDataToday", hmpPatientVisitTodayList);
		hmpPatientVisitTodayMap.put("TotalPatientVisitToday", TotalPatientVisitToday);

		return hmpPatientVisitTodayMap;

	}

	@Override
	public HashMap<String, Object> getViewPatientVisitOfficeRange(String SDate, String EDate, int ofcId) {

		List<ViewPatientVisitOfficeCountTodayImp> hmpPatientVisitTodayList;

		if (ofcId != 0) {
			hmpPatientVisitTodayList = viewPatientVisitOfficeCountTodayRepository
					.findViewPatientVisitOfficeCountByRangeDate(SDate, EDate, ofcId);
		} else {

			hmpPatientVisitTodayList = viewPatientVisitOfficeCountTodayRepository
					.findViewPatientVisitOfficeCountByRangeDate(SDate, EDate);
		}

		HashMap<String, Object> hmpPatientVisitTodayMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();

		int TotalPatientVisitToday = 0;
		if (!hmpPatientVisitTodayList.isEmpty()) {
			for (ViewPatientVisitOfficeCountTodayImp patientVisit : hmpPatientVisitTodayList) {
				label.add(patientVisit.getOfficeName().trim());

				Integer totalCount = patientVisit.getTotalCount();
				data.add(totalCount != null ? String.valueOf(totalCount) : "0");

				if (totalCount != null) {
					TotalPatientVisitToday += totalCount;
				}
			}
		}
		// System.out.println("TotalPatientVisitToday========"+TotalPatientVisitToday);

		hmpPatientVisitTodayMap.put("hmpbLabels", label.toString());
		hmpPatientVisitTodayMap.put("hmpbData", data.toString());
		hmpPatientVisitTodayMap.put("hmpPatientVisitDataToday", hmpPatientVisitTodayList);
		hmpPatientVisitTodayMap.put("TotalPatientVisitToday", TotalPatientVisitToday);

		return hmpPatientVisitTodayMap;
	}

	@Override
	public HashMap<String, Object> getViewLabRadTestsOfficeCountToday() {
		List<ViewLabRadTestsOfficeCountToday> hmpLabRadTestsTodayList = viewLabRadTestsOfficeCountTodayRepository
				.findAll();

		HashMap<String, Object> hmpLabRadTestsTodayMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> Labdata = new ArrayList<>();
		List<String> Raddata = new ArrayList<>();

		int TotalLabVisitToday = 0;
		int TotalRadVisitToday = 0;

		for (ViewLabRadTestsOfficeCountToday ViewLabRadTestsOfficeCountToday : hmpLabRadTestsTodayList) {

			label.add(ViewLabRadTestsOfficeCountToday.getOfficeName());
			Labdata.add(String.valueOf(ViewLabRadTestsOfficeCountToday.getTotalLabCount()));
			Raddata.add(String.valueOf(ViewLabRadTestsOfficeCountToday.getTotalRadCount()));

			TotalLabVisitToday += ViewLabRadTestsOfficeCountToday.getTotalLabCount();
			TotalRadVisitToday += ViewLabRadTestsOfficeCountToday.getTotalRadCount();
		}
		// System.out.println("TotalPatientVisitToday========"+TotalPatientVisitToday);

		hmpLabRadTestsTodayMap.put("hmpbLabels", label.toString());
		hmpLabRadTestsTodayMap.put("hmpLabData", Labdata.toString());
		hmpLabRadTestsTodayMap.put("hmpRadData", Raddata.toString());

		hmpLabRadTestsTodayMap.put("hmpLabRadDataToday", hmpLabRadTestsTodayList);

		hmpLabRadTestsTodayMap.put("TotalLabVisitToday", TotalLabVisitToday);
		hmpLabRadTestsTodayMap.put("TotalRadVisitToday", TotalRadVisitToday);

		return hmpLabRadTestsTodayMap;
	}

	@Override
	public HashMap<String, Object> getViewLabRadTestsOfficeCountRange(String SDate, String EDate, int ofcId) {

		List<ViewLabRadTestsOfficeCountTodayImp> hmpLabRadTestsTodayList;

		if (ofcId != 0) {

			hmpLabRadTestsTodayList = viewLabRadTestsOfficeCountTodayRepository
					.findViewLabRadTestsOfficeCountByRangeDate(SDate, EDate, ofcId);

		} else {

			hmpLabRadTestsTodayList = viewLabRadTestsOfficeCountTodayRepository
					.findViewLabRadTestsOfficeCountByRangeDate(SDate, EDate);
		}

		HashMap<String, Object> hmpLabRadTestsTodayMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> Labdata = new ArrayList<>();
		List<String> Raddata = new ArrayList<>();

		int TotalLabVisitToday = 0;
		int TotalRadVisitToday = 0;

		/*
		 * for (ViewLabRadTestsOfficeCountTodayImp ViewLabRadTestsOfficeCountTodayImp :
		 * hmpLabRadTestsTodayList) {
		 * 
		 * label.add(ViewLabRadTestsOfficeCountTodayImp.getOfficeName());
		 * Labdata.add(String.valueOf(ViewLabRadTestsOfficeCountTodayImp.
		 * getTotalLabCount()));
		 * Raddata.add(String.valueOf(ViewLabRadTestsOfficeCountTodayImp.
		 * getTotalRadCount()));
		 * 
		 * TotalLabVisitToday+=ViewLabRadTestsOfficeCountTodayImp.getTotalLabCount();
		 * TotalRadVisitToday+=ViewLabRadTestsOfficeCountTodayImp.getTotalRadCount(); }
		 * //
		 * System.out.println("TotalPatientVisitToday========"+TotalPatientVisitToday);
		 */

		for (ViewLabRadTestsOfficeCountTodayImp labRadCount : hmpLabRadTestsTodayList) {
			label.add(labRadCount.getOfficeName());

			Integer totalLabCount = labRadCount.getTotalLabCount();
			Labdata.add(totalLabCount != null ? String.valueOf(totalLabCount) : "0");

			Integer totalRadCount = labRadCount.getTotalRadCount();
			Raddata.add(totalRadCount != null ? String.valueOf(totalRadCount) : "0");

			if (totalLabCount != null) {
				TotalLabVisitToday += totalLabCount;
			}

			if (totalRadCount != null) {
				TotalRadVisitToday += totalRadCount;
			}
		}

		hmpLabRadTestsTodayMap.put("hmpbLabels", label.toString());
		hmpLabRadTestsTodayMap.put("hmpLabData", Labdata.toString());
		hmpLabRadTestsTodayMap.put("hmpRadData", Raddata.toString());

		hmpLabRadTestsTodayMap.put("hmpLabRadDataToday", hmpLabRadTestsTodayList);

		hmpLabRadTestsTodayMap.put("TotalLabVisitToday", TotalLabVisitToday);
		hmpLabRadTestsTodayMap.put("TotalRadVisitToday", TotalRadVisitToday);

		return hmpLabRadTestsTodayMap;
	}

	@Override
	public HashMap<String, Object> getViewSickLeaveOfficeCountToday() {

		List<ViewSickLeaveOfficeCountToday> hmpSickLeaveTodayList = viewSickLeaveOfficeCountTodayRepository.findAll();

		HashMap<String, Object> hmpSickLeaveTodayMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();

		int TotalSickLeaveToday = 0;

		for (ViewSickLeaveOfficeCountToday ViewSickLeaveOfficeCountToday : hmpSickLeaveTodayList) {

			label.add(ViewSickLeaveOfficeCountToday.getOfficeName().trim());
			data.add(String.valueOf(ViewSickLeaveOfficeCountToday.getTotalCount()));

			TotalSickLeaveToday += ViewSickLeaveOfficeCountToday.getTotalCount();
		}

		hmpSickLeaveTodayMap.put("hmpbLabels", label.toString());
		hmpSickLeaveTodayMap.put("hmpbData", data.toString());
		hmpSickLeaveTodayMap.put("hmpSickLeaveToday", hmpSickLeaveTodayList);
		hmpSickLeaveTodayMap.put("TotalSickLeaveToday", TotalSickLeaveToday);

		return hmpSickLeaveTodayMap;
	}

	@Override
	public HashMap<String, Object> getViewSickLeaveOfficeCountRange(String SDate, String EDate, int ofcId) {

		List<ViewSickLeaveOfficeCountToday> hmpSickLeaveTodayList;

		if (ofcId != 0) {
			hmpSickLeaveTodayList = viewSickLeaveOfficeCountTodayRepository
					.findViewSickLeaveOfficeCountByRangeDate(SDate, EDate, ofcId);

		} else {

			hmpSickLeaveTodayList = viewSickLeaveOfficeCountTodayRepository
					.findViewSickLeaveOfficeCountByRangeDate(SDate, EDate);

		}

		HashMap<String, Object> hmpSickLeaveTodayMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();

		int TotalSickLeaveToday = 0;

		for (ViewSickLeaveOfficeCountToday ViewSickLeaveOfficeCountToday : hmpSickLeaveTodayList) {

			label.add(ViewSickLeaveOfficeCountToday.getOfficeName().trim());
			data.add(String.valueOf(ViewSickLeaveOfficeCountToday.getTotalCount()));

			TotalSickLeaveToday += ViewSickLeaveOfficeCountToday.getTotalCount();
		}

		hmpSickLeaveTodayMap.put("hmpbLabels", label.toString());
		hmpSickLeaveTodayMap.put("hmpbData", data.toString());
		hmpSickLeaveTodayMap.put("hmpSickLeaveToday", hmpSickLeaveTodayList);
		hmpSickLeaveTodayMap.put("TotalSickLeaveToday", TotalSickLeaveToday);

		return hmpSickLeaveTodayMap;
	}

	@Override
	public HashMap<String, Object> getViewProceduOfficeCountToday() {

		List<ViewProceduOfficeCountToday> hmpProceduOfficeCountTodayList = viewProceduOfficeCountTodayRepository
				.findAll();

		HashMap<String, Object> hmpProceduOfficeCountTodayMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();
		int TotalProceduOfficeCountToday = 0;

		if (!hmpProceduOfficeCountTodayList.isEmpty()) {
			for (ViewProceduOfficeCountToday ViewProceduOfficeCountToday : hmpProceduOfficeCountTodayList) {

				label.add(ViewProceduOfficeCountToday.getOfficeName().trim());
				data.add(String.valueOf(ViewProceduOfficeCountToday.getTotalCount()));
				TotalProceduOfficeCountToday += ViewProceduOfficeCountToday.getTotalCount();

			}
			// System.out.println("TotalPatientVisitToday========"+TotalPatientVisitToday);
			hmpProceduOfficeCountTodayMap.put("hmpbLabels", label.toString());
			hmpProceduOfficeCountTodayMap.put("hmpbData", data.toString());
			hmpProceduOfficeCountTodayMap.put("hmpProceduOfficeCountToday", hmpProceduOfficeCountTodayList);
			hmpProceduOfficeCountTodayMap.put("TotalProceduOfficeCountToday", TotalProceduOfficeCountToday);
		}
		return hmpProceduOfficeCountTodayMap;
	}

	@Override
	public HashMap<String, Object> getViewProceduOfficeCountRange(String SDate, String EDate, int ofcId) {

		List<ViewProceduOfficeCountToday> hmpProceduOfficeCountTodayList;

		if (ofcId != 0) {
			hmpProceduOfficeCountTodayList = viewProceduOfficeCountTodayRepository
					.findViewProceduOfficeCountTodayByRangeDate(SDate, EDate, ofcId);
		} else {

			hmpProceduOfficeCountTodayList = viewProceduOfficeCountTodayRepository
					.findViewProceduOfficeCountTodayByRangeDate(SDate, EDate);

		}

		HashMap<String, Object> hmpProceduOfficeCountTodayMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();
		int TotalProceduOfficeCountToday = 0;

		if (!hmpProceduOfficeCountTodayList.isEmpty()) {
			for (ViewProceduOfficeCountToday ViewProceduOfficeCountToday : hmpProceduOfficeCountTodayList) {

				label.add(ViewProceduOfficeCountToday.getOfficeName().trim());
				data.add(String.valueOf(ViewProceduOfficeCountToday.getTotalCount()));
				TotalProceduOfficeCountToday += ViewProceduOfficeCountToday.getTotalCount();

			}
		}
		// System.out.println("TotalPatientVisitToday========"+TotalPatientVisitToday);
		hmpProceduOfficeCountTodayMap.put("hmpbLabels", label.toString());
		hmpProceduOfficeCountTodayMap.put("hmpbData", data.toString());
		hmpProceduOfficeCountTodayMap.put("hmpProceduOfficeCountToday", hmpProceduOfficeCountTodayList);
		hmpProceduOfficeCountTodayMap.put("TotalProceduOfficeCountToday", TotalProceduOfficeCountToday);

		return hmpProceduOfficeCountTodayMap;
	}

	@Override
	public HashMap<String, Object> getViewPatientVisitOfficeMonthWiseByYearByYear(Integer Year) {
		// TODO Auto-generated method stub
		List<ViewPatientVisitOfficeMonthWise> hmpPatientVisitOfficeMonthWiseList = viewPatientVisitOfficeMonthWiseRepository
				.findByYearWise(Year);

		HashMap<String, Object> hmphmpPatientVisitOfficeMonthWiseMap = new HashMap<>();

		List<String> HQdata = new ArrayList<>();
		List<String> Shdata = new ArrayList<>();
		List<String> Smdata = new ArrayList<>();
		List<String> ThDdata = new ArrayList<>();
		List<String> THdata = new ArrayList<>();

		for (ViewPatientVisitOfficeMonthWise ViewPatientVisitOfficeMonthWise : hmpPatientVisitOfficeMonthWiseList) {

			if (ViewPatientVisitOfficeMonthWise.getOfficeNo() == 4)
				HQdata.add(String.valueOf(ViewPatientVisitOfficeMonthWise.getTotalCount()));

			if (ViewPatientVisitOfficeMonthWise.getOfficeNo() == 8)
				Shdata.add(String.valueOf(ViewPatientVisitOfficeMonthWise.getTotalCount()));

			if (ViewPatientVisitOfficeMonthWise.getOfficeNo() == 7)
				Smdata.add(String.valueOf(ViewPatientVisitOfficeMonthWise.getTotalCount()));

			if (ViewPatientVisitOfficeMonthWise.getOfficeNo() == 6)
				ThDdata.add(String.valueOf(ViewPatientVisitOfficeMonthWise.getTotalCount()));

			if (ViewPatientVisitOfficeMonthWise.getOfficeNo() == 5)
				THdata.add(String.valueOf(ViewPatientVisitOfficeMonthWise.getTotalCount()));

		}

//		System.out.println("HQdata==="+HQdata.size());
//		System.out.println("Shdata==="+HQdata.size());
//		System.out.println("Smdata==="+HQdata.size());
//		System.out.println("ThDdata=="+HQdata.size());
//		System.out.println("THdata==="+HQdata.size());

		hmphmpPatientVisitOfficeMonthWiseMap.put("hmpHQdata", HQdata.toString());
		hmphmpPatientVisitOfficeMonthWiseMap.put("hmpShdata", Shdata.toString());
		hmphmpPatientVisitOfficeMonthWiseMap.put("hmpSmdata", Smdata.toString());
		hmphmpPatientVisitOfficeMonthWiseMap.put("hmpThDdata", ThDdata.toString());
		hmphmpPatientVisitOfficeMonthWiseMap.put("hmpTHdata", THdata.toString());

		return hmphmpPatientVisitOfficeMonthWiseMap;
	}

	@Override
	public HashMap<String, Object> getViewPatientVisitDeptToday() {

		List<ViewPatientVisitDeptToday> hmpViewPatientVisitDeptTodayList = viewPatientVisitDeptTodayRepository
				.findAll();

		HashMap<String, Object> hmpViewPatientVisitDeptTodayMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();

		int TotalViewPatientVisitDept = 0;
		int TotalViewPatientVisitDental = 0;

		for (ViewPatientVisitDeptToday ViewPatientVisitDeptToday : hmpViewPatientVisitDeptTodayList) {
			if (!ViewPatientVisitDeptToday.getFlagFilter().equals("Others")) {
				TotalViewPatientVisitDental += ViewPatientVisitDeptToday.getTotalCount();
			}

		}
		label.add("Dental");
		data.add(String.valueOf(TotalViewPatientVisitDental));

		for (ViewPatientVisitDeptToday ViewPatientVisitDeptToday : hmpViewPatientVisitDeptTodayList) {
			if (ViewPatientVisitDeptToday.getFlagFilter().equals("Others")) {
				label.add(ViewPatientVisitDeptToday.getName().trim());
				data.add(String.valueOf(ViewPatientVisitDeptToday.getTotalCount()));
			}

		}
		hmpViewPatientVisitDeptTodayMap.put("hmpbLabels", label.toString());
		hmpViewPatientVisitDeptTodayMap.put("hmpbData", data.toString());
		hmpViewPatientVisitDeptTodayMap.put("TotalViewPatientVisitDept",
				String.format("%,d", TotalViewPatientVisitDept));
		return hmpViewPatientVisitDeptTodayMap;
	}

	@Override
	public HashMap<String, Object> getViewPatientVisitDeptRange(String SDate, String EDate, int ofcId) {

		List<ViewPatientVisitDeptToday> hmpViewPatientVisitDeptTodayList;

		if (ofcId != 0) {
			hmpViewPatientVisitDeptTodayList = viewPatientVisitDeptTodayRepository
					.findViewPatientVisitDeptByRangeDate(SDate, EDate, ofcId);

		} else {

			hmpViewPatientVisitDeptTodayList = viewPatientVisitDeptTodayRepository
					.findViewPatientVisitDeptByRangeDate(SDate, EDate);
		}

		HashMap<String, Object> hmpViewPatientVisitDeptTodayMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();

		int TotalViewPatientVisitDept = 0;
		int TotalViewPatientVisitDental = 0;

		for (ViewPatientVisitDeptToday ViewPatientVisitDeptToday : hmpViewPatientVisitDeptTodayList) {
			if (!ViewPatientVisitDeptToday.getFlagFilter().equals("Others")) {
				TotalViewPatientVisitDental += ViewPatientVisitDeptToday.getTotalCount();
			}

		}
		label.add("Dental");
		data.add(String.valueOf(TotalViewPatientVisitDental));

		for (ViewPatientVisitDeptToday ViewPatientVisitDeptToday : hmpViewPatientVisitDeptTodayList) {
			if (ViewPatientVisitDeptToday.getFlagFilter().equals("Others")) {
				label.add(ViewPatientVisitDeptToday.getName().trim());
				data.add(String.valueOf(ViewPatientVisitDeptToday.getTotalCount()));
			}

		}
		hmpViewPatientVisitDeptTodayMap.put("hmpbLabels", label.toString());
		hmpViewPatientVisitDeptTodayMap.put("hmpbData", data.toString());
		hmpViewPatientVisitDeptTodayMap.put("TotalViewPatientVisitDept",
				String.format("%,d", TotalViewPatientVisitDept));
		return hmpViewPatientVisitDeptTodayMap;
	}

	@Override
	public List<ViewLabtestInfoToday> getViewLabtestInfoTodayDetails(String SDate, String EDate, int ofcId) {

		if (ofcId != 0) {

			return viewLabtestInfoTodayRepository.findAllByRangeDate(SDate, EDate, ofcId);

		} else {

			return viewLabtestInfoTodayRepository.findAllByRangeDate(SDate, EDate);

		}
	}

	@Override
	public List<ViewSickLeaveInfoToday> getViewSickLeaveInfoTodayDetails(String SDate, String EDate, int ofcId) {

		if (ofcId != 0) {

			return viewSickLeaveInfoTodayRepository.findAllByRangeDate(SDate, EDate, ofcId);

		} else {

			return viewSickLeaveInfoTodayRepository.findAllByRangeDate(SDate, EDate);

		}
	}

	@Override
	public List<ViewRadTestInfoToday> getViewRadTestInfoTodayDetails(String SDate, String EDate, int ofcId) {
		// TODO Auto-generated method stub

		if (ofcId != 0) {
			return viewRadTestInfoTodayRepository.findAllByRangeDate(SDate, EDate, ofcId);
		} else {

			return viewRadTestInfoTodayRepository.findAllByRangeDate(SDate, EDate);

		}
	}

	@Override
	public List<ViewProcInfoToday> getViewProcInfoTodayDetails(String SDate, String EDate, int ofcId) {

		if (ofcId != 0) {

			return viewProcInfoTodayRepository.findAllByRangeDate(SDate, EDate, ofcId);
		} else {

			return viewProcInfoTodayRepository.findAllByRangeDate(SDate, EDate);

		}

	}

	@Override
	// @Cacheable("doctor")
	public List<ViewDocInfoToday> getViewDocInfoTodayDetails(String SDate, String EDate, int ofcId) {

		if (ofcId != 0) {

			return viewDocInfoTodayRepository.findAllByRangeDate(SDate, EDate, ofcId);

		} else {

			return viewDocInfoTodayRepository.findAllByRangeDate(SDate, EDate);

		}

	}

	@Override
	// @Cacheable("patient")
	public List<ViewPatientInfoToday> getViewPatientInfoTodayDetails(String SDate, String EDate, int ofcId) {

		if (ofcId != 0) {
			return viewPatientInfoTodayRepository.findAllByRangeDate(SDate, EDate, ofcId);
		} else {

			return viewPatientInfoTodayRepository.findAllByRangeDate(SDate, EDate);
		}
	}

	@Override
	public List<ViewDispenseInfoToday> getViewDispenseInfoTodayDetails() {
		// TODO Auto-generated method stub
		Sort sort = Sort.by("INVCUSTNAME").ascending();
		return viewDispenseInfoTodayRepository.findAll(sort);
		// return viewDispenseInfoTodayRepository.findAll();
	}

	@Override
	// @Cacheable("dispense")
	public List<ViewDispenseInfoToday> getViewDispenseInfoRangeDetails(String SDate, String EDate, int ofcId) {
		if (ofcId != 0) {
			return viewDispenseInfoTodayRepository.findAllByRangeDate(SDate, EDate, ofcId);
		}

		else {

			return viewDispenseInfoTodayRepository.findAllByRangeDate(SDate, EDate);
		}
	}

	@Override
	// @Cacheable("vitals")
	public List<ViewVitalsInfoToday> getViewVitalsInfoTodayDetailsRang(String SDate, String EDate, int ofcId) {

		if (ofcId != 0) {

			// Call the repository method to fetch data from the database
			List<ViewVitalsInfoToday> vitalsInfoTodayList = viewVitalsInfoTodayRepository.findAllByRangeDate(SDate,
					EDate, ofcId);
			// Return the fetched data
			return vitalsInfoTodayList;

		} else {

			// Call the repository method to fetch data from the database
			List<ViewVitalsInfoToday> vitalsInfoTodayList = viewVitalsInfoTodayRepository.findAllByRangeDate(SDate,
					EDate);

			// Return the fetched data
			return vitalsInfoTodayList;

		}
	}

	/*
	 * @Override // ("vitalsById") public List<ViewDocInfoToday>
	 * getViewPatientInfoTodayDetailById(int usrId, String consultDate) {
	 * 
	 * 
	 * 
	 * 
	 * List<ViewDocInfoToday> PatientInfoById =
	 * viewDocInfoTodayRepository.findAllByConsulId(usrId ,consultDate);
	 * 
	 * 
	 * 
	 * 
	 * // Return the fetched data return
	 * viewDocInfoTodayRepository.findAllByConsulId(usrId ,consultDate);
	 * 
	 * }
	 */

	@Override
	public HashMap<String, Object> getViewDispenseInfoTodayDetails2() {
		// TODO Auto-generated method stub
		List<ViewDispenseInfoToday> tempist = getViewDispenseInfoTodayDetails();
		HashMap<String, Object> hashMapToday = new HashMap<>();
		int TotalViewDispense = 0;

		for (ViewDispenseInfoToday ViewDispenseInfoToday : tempist) {
			TotalViewDispense += ViewDispenseInfoToday.getITEM_COUNT();
		}

		hashMapToday.put("ViewDispenseInfoToda", tempist);
		hashMapToday.put("TotalViewDispense", TotalViewDispense);

		return hashMapToday;
	}

	@Override
	public HashMap<String, Object> getViewDispenseInfoTodayDetailsRange(String SDate, String EDate, int ofcId) {
		// TODO Auto-generated method stub
		List<ViewDispenseInfoToday> tempist = getViewDispenseInfoRangeDetails(SDate, EDate, ofcId);
		HashMap<String, Object> hashMapToday = new HashMap<>();
		int TotalViewDispense = 0;

		for (ViewDispenseInfoToday ViewDispenseInfoToday : tempist) {
			TotalViewDispense += ViewDispenseInfoToday.getITEM_COUNT();
		}

		hashMapToday.put("ViewDispenseInfoToda", tempist);
		hashMapToday.put("TotalViewDispense", TotalViewDispense);

		return hashMapToday;
	}

	// new added
	@Override
	public HashMap<String, Object> getViewDispenseOfficeCountRange(String SDate, String EDate, int ofcId) {// here
		List<ViewDispenseOfficeCountToday> hmpDispenseOfficeTodayList;

		if (ofcId != 0) {
			hmpDispenseOfficeTodayList = viewDispenseOfficeCountTodayRepository
					.findViewDispenseOfficeCountTodayByRangeDate(SDate, EDate, ofcId);

		} else {

			hmpDispenseOfficeTodayList = viewDispenseOfficeCountTodayRepository
					.findViewDispenseOfficeCountTodayByRangeDate(SDate, EDate);

		}

		HashMap<String, Object> hmpDispenseOfficeTodayMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();

		int TotalDispenseToday = 0;

		for (ViewDispenseOfficeCountToday viewDispenseOfficeCountToday : hmpDispenseOfficeTodayList) {

			label.add(viewDispenseOfficeCountToday.getOfficeName().trim());
			data.add(String.valueOf(viewDispenseOfficeCountToday.getTotalCount()));

			TotalDispenseToday += viewDispenseOfficeCountToday.getTotalCount();
		}

		hmpDispenseOfficeTodayMap.put("hmpbLabels", label.toString());
		hmpDispenseOfficeTodayMap.put("hmpbData", data.toString());
		hmpDispenseOfficeTodayMap.put("hmpDispenseToday", hmpDispenseOfficeTodayList);
		hmpDispenseOfficeTodayMap.put("TotalDispenseToday", TotalDispenseToday);

		return hmpDispenseOfficeTodayMap;
	}

	@Override
	public List<ViewOfficeDetails> getviewOfficeDetails() {
		// TODO Auto-generated method stub
		return viewEclinicRepository.findAll();
	}

	// ==============================================for consultation logic code
	// starts===========================================================
	@Override
	public List<ViewPatientInfoToday> getPatConsultDetails(Integer consultId) {
		List<ViewPatientInfoToday> patientConsultDetailsList = viewPatientInfoTodayRepository
				.findByConsultId(consultId);

		return patientConsultDetailsList;
	}

	@Override
	public List<ViewLabtestInfoToday> getPatConsultLabDetails(Integer consultId) {

		List<ViewLabtestInfoToday> patientConsultLabDetailsList = viewLabtestInfoTodayRepository
				.findByConsultId(consultId);

		/*
		 * System.out.println("patientConsultLabDetailsList " +
		 * patientConsultLabDetailsList);
		 */

		return patientConsultLabDetailsList;

	}

	// new pat consult for lab result (5 may 2024)

	@Override
	public List<ViewLabtestInfoToday_dup1> getPatConsultLabDetails_dup1(Integer consultId) {

		List<ViewLabtestInfoToday_dup1> patientConsultLabDetailsList1 = viewLabtestInfoTodayRepository_dup1
				.findByConsultId_dup1(consultId);

		/*
		 * System.out.println("patientConsultLabDetailsList1 " +
		 * patientConsultLabDetailsList1);
		 */

		return patientConsultLabDetailsList1;

	}

	@Override
	public List<ViewRadTestInfoToday> getPatConsultRadDetails(Integer consultId) {

		List<ViewRadTestInfoToday> patientConsultRadDetailsList = viewRadTestInfoTodayRepository
				.findByConsultId(consultId);

		return patientConsultRadDetailsList;

	}

	@Override
	public List<ViewProcInfoToday> getPatConsultProcDetails(Integer consultId) {

		List<ViewProcInfoToday> patientConsultProcDetailsList = viewProcInfoTodayRepository.findByConsultId(consultId);

		return patientConsultProcDetailsList;

	}

	@Override
	public List<ViewVitalsInfoToday> getPatConsultVitalDetails(Integer consultId) {

		List<ViewVitalsInfoToday> patientConsultVitalDetailsList = viewVitalsInfoTodayRepository
				.findByConsultId(consultId);

		return patientConsultVitalDetailsList;

	}

	@Override
	public List<ViewSickLeaveInfoToday> getPatConsultSickLeaveDetails(Integer consultId) {

		List<ViewSickLeaveInfoToday> patientConsultSickLeaveDetailsList = viewSickLeaveInfoTodayRepository
				.findByConsultId(consultId);

		return patientConsultSickLeaveDetailsList;

	}

	@Override
	public List<ViewDispenseInfoToday> getPatDispenceDetails(Integer consultId) {

		List<ViewDispenseInfoToday> patientConsultDispenceDetailsList = viewDispenseInfoTodayRepository
				.findByConsultId(consultId);

		return patientConsultDispenceDetailsList;

	}

	// ==============================================for consultation logic code
	// Ends===========================================================

	// for patient count logic
	@Override // Method created on: 12 March 2024, Method Edited on:
	public List<ViewPatientInfoToday> getViewPatientInfoTodayDetailByIdV2(Integer doctorId, Integer departmentId,
			String consultDate) {
		List<ViewPatientInfoToday> patientConsultPatientDetailsList = viewPatientInfoTodayRepository
				.findAllBydoctorIdV2(doctorId, departmentId, consultDate);
		return patientConsultPatientDetailsList;
	}

	@Override // Method created on: 12 March 2024, Method Edited on:
	public List<ViewDocInfoToday> getViewDoctorDemographDetailsV2(Integer doctorId, Integer departmentId,
			String consultDate) {
		List<ViewDocInfoToday> docDemoPatientDetailList = viewDocInfoTodayRepository.findDocDemographDetailsV2(doctorId,
				departmentId, consultDate);
		return docDemoPatientDetailList;
	}

	// for lab result attribute
	@Override
	public List<ViewLabResultAttr> getLabResultAttrService(int consultId, int tid) {
		// Your logic to fetch and return doctor details

		List<ViewLabResultAttr> LabResultsAttrList;

		LabResultsAttrList = viewLabResultAttrRepository.findLabResultAttrRepo(consultId, tid);

		return LabResultsAttrList;

	}

	// for new lab test results attribute

	/*
	 * @Override public List<ViewLabResultAttr_Dup1>
	 * getLabResultAttrService_dup1(String consultId ,String tdsid, String
	 * lid,String tid,String opn){ // Your logic to fetch and return doctor details
	 * 
	 * List<ViewLabResultAttr_Dup1> LabResultsAttrList1;
	 * 
	 * 
	 * LabResultsAttrList1 = viewLabResultAttrRepository_dup1
	 * .findLabResultAttrRepo_dup1( consultId,tdsid,lid,tid,opn);
	 * 
	 * return LabResultsAttrList1;
	 * 
	 * }
	 */

	/*
	 * @Override public List<ViewLabResultAttr_Dup1>
	 * getLabResultAttrService_dup1(Integer consultId,Integer tid) {
	 * 
	 * LOGGER.
	 * debug("Calling stored procedure with parameters: consultId={}, tdsid={}, lid={}, tid={}, opn={}"
	 * , consultId, tdsid, lid, tid, opn);
	 * 
	 * List<ViewLabResultAttr_Dup1> labResultsAttrList1serv =
	 * viewLabResultAttrRepository_dup1.findLabResultAttrRepo_dup1(consultId, tid);
	 * 
	 * 
	 * LOGGER.debug("Stored procedure returned: {}", labResultsAttrList1serv);
	 * 
	 * System.out.println("labResultsAttrList1serv" +labResultsAttrList1serv);
	 * 
	 * return labResultsAttrList1serv; }
	 */
	// =========================================================================================================================================
	// OLD LOGICS
	// =========================================================================================================================================

	// for patient count logic
	@Override
	public List<ViewPatientInfoToday> getViewPatientInfoTodayDetailById(Integer doctorId, String consultDate) {
		// Your logic to fetch and return doctor details

		List<ViewPatientInfoToday> patientConsultPatientDetailsList = viewPatientInfoTodayRepository
				.findAllBydoctorId(doctorId, consultDate);

		return patientConsultPatientDetailsList;

	}

	// Doctor Demographic Details for the List of patients that has visited that
	// specific doctor
	@Override
	public List<ViewDocInfoToday> getViewDoctorDemographDetails(Integer doctorId, String consultDate) {

		List<ViewDocInfoToday> docDemoPatientDetailList = viewDocInfoTodayRepository.findDocDemographDetails(doctorId,
				consultDate);

		return docDemoPatientDetailList;
	}
	// =========================================================================================================================================
	
	
	//==========================================for RETIRE PATIENT START================================

	@Override
	public List<ViewPatientRetInfoToday> getViewPatientInfoTodayRetiredDetails(String SDate, String EDate, int ofcId) {
		
		if (ofcId != 0) 
		{

			return viewPatRetInfoTodayRepository.getPatRetInfoTodayListByOfficeId(SDate, EDate, ofcId);

		} else 
		{	

			return viewPatRetInfoTodayRepository.getPatRetInfoTodayListAll(SDate, EDate);

		}
	}
	
	
	@Override
	public HashMap<String, Object> getViewPatientInfoTodayRetiredDetailsRange(String SDate, String EDate, int ofcId) 
	{
		List<ViewPatientRetiredOfficeCountToday> hmpPatOfficeRetList;
		System.out.println("==================PATIENT RETIRED LIST TODAY -> SERVICE LAYER ======================");
		System.out.println("Start Date======="+SDate);
		System.out.println("End Date======="+EDate);
		System.out.println("Office id======="+ofcId);
		
		if (ofcId != 0) 
		{
			hmpPatOfficeRetList = vproctrepo.findViewPatientRetiredOfficeCountByRangeDateOid(SDate,EDate, ofcId);
		} 
		else 
		{
			hmpPatOfficeRetList = vproctrepo.findViewPatientRetiredOfficeCountByRangeDate(SDate,EDate);
		}

		HashMap<String, Object> hmpPatOfficeRetMap = new HashMap<>();

		List<String> label = new ArrayList<>();
		List<String> data = new ArrayList<>();

		int TotalPatOfficeRetListToday = 0;

		for (ViewPatientRetiredOfficeCountToday v : hmpPatOfficeRetList)
		{
			label.add(v.getOfficeName().trim());
			System.out.println("Total count before processing Integer.."+ v.getTotalCount());
			
			long totalPatCount = v.getTotalCount();
			//data.add(totalPatCount != null ? String.valueOf(v.getTotalCount()): "0");
			//TotalPatOfficeRetListToday += v.getTotalCount().intValue();
			
			TotalPatOfficeRetListToday += totalPatCount;
			/*
			 * if (totalPatCount != null) { TotalPatOfficeRetListToday += totalPatCount; }
			 */
			
		}
		hmpPatOfficeRetMap.put("retLabels", label.toString());
		hmpPatOfficeRetMap.put("retData", data.toString());
		hmpPatOfficeRetMap.put("TotalPatOfficeRetListToday", TotalPatOfficeRetListToday);

		System.out.println("Label======="+ label.toString());
		System.out.println("Data======="+ data.toString());
		System.out.println("TotalPatientRetCount======="+TotalPatOfficeRetListToday);
		
		return hmpPatOfficeRetMap;
	}
	//==========================================for RETIRE PATIENT END================================

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
