package com.kng.medicalreports.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kng.medicalreports.dao.ViewPatientVisitOfficeCountTodayImp;
import com.kng.medicalreports.model.ViewDoctorDashboardListKng;
import com.kng.medicalreports.repository.ViewDoctorDashboardListKngRepository;

@Service
public class DoctorDashboardServiceImp implements DoctorDashboardService {

	int Cyear = new Date().getYear();

	@Autowired
	private ViewDoctorDashboardListKngRepository viewDoctorDashboardListKngRepository;



	@Override
	public ViewDoctorDashboardListKng findDoctorInfoByDate(Integer docId, String sdate, String edate) {
		/* hmpdocList= viewDoctorDashboardListKngRepository.findById(Id).get(); */
		return viewDoctorDashboardListKngRepository.findByDateRange(docId, sdate, edate);
	}

	@Override
	public List<ViewDoctorDashboardListKng> findDoctorConsultAllByDate(String fdate, String tdate) {
		// TODO Auto-generated method stub

		List<ViewDoctorDashboardListKng> hmpDoctorConsultListByDate;

		if (fdate != null && tdate != null) {

			hmpDoctorConsultListByDate = viewDoctorDashboardListKngRepository.findAllByListDate(fdate, tdate);

		} else {

			hmpDoctorConsultListByDate = viewDoctorDashboardListKngRepository.findAll();

		}

		return hmpDoctorConsultListByDate;

	}

	@Override
	public List<ViewDoctorDashboardListKng> findDoctorsOnlyByDate(String fdate, String tdate) {
		List<ViewDoctorDashboardListKng> DoctorOnlyListByDate;
		if (fdate != null && tdate != null) {

			DoctorOnlyListByDate = viewDoctorDashboardListKngRepository.findDoctorsOnlyListByDate(fdate, tdate);

		} else {

			DoctorOnlyListByDate = viewDoctorDashboardListKngRepository.findAll();

		}

		return DoctorOnlyListByDate;

	}

	@Override
	public List<ViewDoctorDashboardListKng> findDentistOnlyByDate(String fdate, String tdate) {
		List<ViewDoctorDashboardListKng> DentistOnlyListByDate;

		if (fdate != null && tdate != null) {

			DentistOnlyListByDate = viewDoctorDashboardListKngRepository.findDentistsOnlyListByDate(fdate, tdate);

		} else {

			DentistOnlyListByDate = viewDoctorDashboardListKngRepository.findAll();

		}

		return DentistOnlyListByDate;

	}

}
