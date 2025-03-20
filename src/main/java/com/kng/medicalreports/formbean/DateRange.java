package com.kng.medicalreports.formbean;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class DateRange 
{

	private String startDateBuffer;
 
	private String endDateBuffer;
	
	
	private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static final DateTimeFormatter OUTPUT_FORMATTER = DateTimeFormatter.ofPattern("dd MMM yyyy");
    private static final DateTimeFormatter OUTPUT_FORMATTER2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    
    
    //---------------------------------- VERSION 1 START -------------------------------------------------------
    
    
    public void setStartDateBuffer(String startDate) {
        this.startDateBuffer = convertDateFormat(startDate);
    }

    public void setEndDateBuffer(String endDate) {
        this.endDateBuffer = convertDateFormat(endDate);
    }
    private String convertDateFormat(String date) {
        if (date != null && !date.isEmpty()) {
            LocalDate localDate = LocalDate.parse(date, INPUT_FORMATTER);
            return localDate.format(OUTPUT_FORMATTER);
        }
        return null;
    }
    
    //---------------------------------- VERSION 2 START -------------------------------------------------------
    
    
  //---------------------------------- VERSION 2 START -------------------------------------------------------
    
    public void setStartDateBuffer2(String startDate) {
        this.startDateBuffer = convertDateFormat2(startDate);
    }
    
    public void setEndDateBuffer2(String endDate) {
        this.endDateBuffer = convertDateFormat2(endDate);
    }
    
    private String convertDateFormat2(String date) {
        if (date != null && !date.isEmpty()) {
            LocalDate localDate = LocalDate.parse(date, INPUT_FORMATTER);
            return localDate.format(OUTPUT_FORMATTER2);
        }
        return null;
    }
  //---------------------------------- VERSION 2 END -------------------------------------------------------
     
    
    
   
    
    
}
