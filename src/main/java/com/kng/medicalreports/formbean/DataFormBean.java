package com.kng.medicalreports.formbean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DataFormBean {
	
	private String      selectSDate;
	private String      selectEDate;
	
	private String      lang;
	


	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getSelectMRDSdate() {
		return selectMRDSdate;
	}
	public void setSelectMRDSdate(String selectMRDSdate) {
		this.selectMRDSdate = selectMRDSdate;
	}


	private String    selectMRDSdate;
	
	   public DataFormBean () {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String currentDate = sdf.format(new Date());
	        this.selectSDate = currentDate;
	        this.selectEDate = currentDate;
	        
	        
	        
	    }


	private Integer    selectNaID;
	private Integer    selecOID;
	
	
	private int ofcId;
	
	private int SelectedYear;
	

	public int getOfcId() {
		return ofcId;
	}
	public void setOfcId(int ofcId) {
		this.ofcId = ofcId;
	}
	

	public int getSelectedYear() {
		return SelectedYear;
	}
	public void setSelectedYear(int selectedYear) {
		SelectedYear = selectedYear;
	}
	public String getSelectSDate() {
		return selectSDate;
	}
	public void setSelectSDate(String selectSDate) {
		this.selectSDate = selectSDate;
	}
	public String getSelectEDate() {
		return selectEDate;
	}
	public void setSelectEDate(String selectEDate) {
		this.selectEDate = selectEDate;
	}
	public Integer getSelectNaID() {
		return selectNaID;
	}
	public void setSelectNaID(Integer selectNaID) {
		this.selectNaID = selectNaID;
	}
	public Integer getSelecOID() {
		return selecOID;
	}
	public void setSelecOID(Integer selecOID) {
		this.selecOID = selecOID;
	}
	
	
	

}
