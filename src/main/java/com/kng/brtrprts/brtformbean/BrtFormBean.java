package com.kng.brtrprts.brtformbean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BrtFormBean 
{
	
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private String brtSdate;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private String  brtEdate;	
		
	private String brtPid;
	
	private String brtFillerid;
	
	private int brtOid;
	
	
	private int brtDid;
	
	private int brtDocid;
	
	private int brtMonthid;
	
	private int brtQrterid;
	
	private int brtYearid;
	
	private int brtKwtNkwtid;
	
	private int brtReportTypeId;
	
	
	
	private List<String> brtMedicineid;
	
	 public BrtFormBean() {
	        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	        String currentDate = sdf1.format(new Date());
	        this.brtSdate = currentDate;
	        this.brtEdate = currentDate;
 
	    }
	  
}
