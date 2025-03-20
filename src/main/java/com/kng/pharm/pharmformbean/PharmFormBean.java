package com.kng.pharm.pharmformbean;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class PharmFormBean 
{
	
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private String pharmSdate;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private String  pharmEdate;	
	
	private String pharmItemid;
	
	private int pharmOid;
	
	
	 public PharmFormBean() 
	 {
	        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	        String currentDate = sdf1.format(new Date());
	        this.pharmSdate = currentDate;
	        this.pharmEdate = currentDate;
	 }
		

}
