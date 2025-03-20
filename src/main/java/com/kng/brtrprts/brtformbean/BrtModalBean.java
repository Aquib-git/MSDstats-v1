package com.kng.brtrprts.brtformbean;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class BrtModalBean 
{
	
	private String 	brtModalId;
	private String 	brtModalName;
	private Integer brtModalTitleNo;
	private String	brtModalTitle;
	private String	brtModalFormId;
	private String	brtModalFormAction;
	private String	brtModalErrorId;
	private String	brtModalCodeWriteHere;

}
