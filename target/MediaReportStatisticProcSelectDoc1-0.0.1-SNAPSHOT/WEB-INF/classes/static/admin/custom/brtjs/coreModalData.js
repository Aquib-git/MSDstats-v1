
export const modalSections = 
[    
  /* --------------------------------------------------- SICK LEAVE REPORTS START --------------------------------------------------- */
	{
		modalId: '#slbdsrModal',
		modalName: 'slbdsrModal',
		modalTitleNo:1,
        modalTitle: "Sick Leave by Doctor Summary Report",
		modalFormId: "slbdsr",
		modalFormAction:"sickLeaveByDoctorSumaryReport",
		modalErrorId:"slbdsr",
		modalCodeWriteHere:` <div id="fragments-container" th:replace="birtmodals/birtModals :: sickLeaveByDoctorSumaryFragment"></div>	` 
	//	modalCodeWriteHere: "sickLeaveByDoctorSumary"
	/*	modalCodeWriteHere:` <div class="col-sm-4">
			                    	<div class="form-group">
				                        <label>From Date:</label>
				                        <input type="date" th:field="*{brtSdate}" id="sdate" class="form-control">
				                      </div>
			                	</div>
			                	
			                	
			                	<div class="col-sm-4">
			                		<div class="form-group">
				                        <label>To Date:</label>
				                       <input type="date" th:field="*{brtEdate}" id="edate" class="form-control">
				                      </div>
			                	</div> 
			                	
			                	 <div class="col-sm-4">
			                    	<div class="form-group">
				                        <label>Clinic Name:</label>
				                        <select class="form-control" th:field="*{brtOid}" id="oid">
				        	       			<option th:value='0'>-- All Clinics--</option>			    					  					    					    
						          			<option th:each="e : ${officeDateFilter}"
												th:value="${e.officeId}"
												th:text="${e.officeName}">
											</option>
		 					    			</select>
				                      </div>
			                	</div>
		`
	*/
    },
    {	
		modalId: '#slsrModal',
		modalName: 'slsrModal',
		modalTitleNo:2,
        modalTitle: "Sick Leave Summary Report",
		modalFormId: "slsr",
		modalFormAction:"sickLeaveSumaryReport",
		modalErrorId:"slsr",
		modalCodeWriteHere:` <div id="fragments-container" th:replace="birtmodals/sick_modals :: sickLeaveSumaryFragment"></div>  `
		//modalCodeWriteHere: "sickLeaveSumary"  
    },
    {
		modalId: '#edbdModal',
		modalName: 'edbdModal',
		modalTitleNo:3,
        modalTitle: "Exemption Details By Doctor",
		modalFormId: "edbd",
		modalFormAction:"exemptionDetailReport",
		modalErrorId:"edbd",
		modalCodeWriteHere:` <div id="fragments-container" th:replace="birtmodals/sick_modals :: exemptionDetailFragment"></div>  ` 
		//modalCodeWriteHere:"exemptionDetail"
		 
    },
 /* --------------------------------------------------- SICK LEAVE REPORTS END --------------------------------------------------- */

]



/*
1.
<div class="col-sm-4">
			                    	<div class="form-group">
				                        <label>From Date:</label>
				                        <input type="date" th:field="*{brtSdate}" id="sdate" class="form-control">
				                      </div>
			                	</div>
			                	
			                	
			                	<div class="col-sm-4">
			                		<div class="form-group">
				                        <label>To Date:</label>
				                       <input type="date" th:field="*{brtEdate}" id="edate" class="form-control">
				                      </div>
			                	</div> 
			                	
			                	 <div class="col-sm-4">
			                    	<div class="form-group">
				                        <label>Clinic Name:</label>
				                        <select class="form-control" th:field="*{brtOid}" id="oid">
				        	       			<option th:value='0'>-- All Clinics--</option>			    					  					    					    
						          			<option th:each="e : ${officeDateFilter}"
												th:value="${e.officeId}"
												th:text="${e.officeName}">
											</option>
		 					    			</select>
				                      </div>
			                	</div>
			                	
2.
<div class="col-sm-6">
			                    	<div class="form-group">
				                        <label>From Date:</label>
				                        <input type="date" th:field="*{brtSdate}" id="sdate1" class="form-control">
				                      </div>
			                	</div>
			                	<div class="col-sm-6">
			                		<div class="form-group">
				                        <label>To Date:</label>
				                        <input type="date" th:field="*{brtEdate}" id="edate1" class="form-control">
				                      </div>
			                	</div> 			                	
			                	
3.
<div class="col-sm-4">
			                    	<div class="form-group">
				                        <label>From Date:</label>
				                        <input type="date" th:field="*{brtSdate}" id="sdate3" class="form-control">
				                      </div>
			                	</div>
			                	
			                	
			                	<div class="col-sm-4">
			                		<div class="form-group">
				                        <label>To Date:</label>
				                       <input type="date" th:field="*{brtEdate}" id="edate3" class="form-control">
				                      </div>
			                	</div> 
			                	
			                	 <div class="col-sm-4">
			                    	<div class="form-group">
				                        <label>Clinic Name:</label>
				                        <select class="form-control" th:field="*{brtOid}" id="oid3">
				        	       			<option th:value='0'>-- All Clinics--</option>			    					  					    					    
						          			<option th:each="e : ${officeDateFilter}"
												th:value="${e.officeId}"
												th:text="${e.officeName}">
											</option>
		 					    			</select>
				                      </div>
			                	</div>


 */