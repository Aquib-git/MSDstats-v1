package com.kng.lab.labformbean;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


import lombok.Data;

@Component
@Data
public class LabFormBean 
{
	
	@DateTimeFormat(pattern="yyyy-MM-dd")  
	private String labSdate;
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd") 
	private String  labEdate;	
	
	
	private int labOid;
	
	
	private int labDid;
	
	private int labDocid;
	
	 public LabFormBean() 
	 {
	        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
	        String currentDate = sdf1.format(new Date());
	        this.labSdate = currentDate;
	        this.labEdate = currentDate;
	 }
		

}
