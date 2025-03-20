package com.kng.medicalreports.formbean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.Past;

/*import javax.validation.constraints.*;
*/
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Data;

@Component
@Data
public class MrdFormBean 
{
	
	

	private String selectCivilId;
	

	private String selectEmpId;

	String currentDate =new Date().toLocaleString();

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	@Past(message="Start date must be less than Today")  
	private String    selectMRDSdate;
	
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@NotNull
	@Past(message="End date must be greate than Start date")  
	private String    selectMRDEdate;

	private String fdate;
	private String tdate;
	
	
	   public MrdFormBean() {
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        String currentDate = sdf.format(new Date());
	        this.selectMRDSdate = currentDate;
	        this.selectMRDEdate = currentDate;
    
	    }

	
}
