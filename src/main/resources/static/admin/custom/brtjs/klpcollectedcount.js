import { dateValidator } from './coreBirtUtils.js';
import { reportTypeFilterV1 } from './coreBirtUtils.js';

// ------------------------------------------- KNG Lab Patient Count Collected Report Tests Taken START --------------------------------------------------------------			
document.addEventListener('DOMContentLoaded', function ()
{
	// ----------------------------------- REPORT TYPE FILTER START -----------------------------------
		 	reportTypeFilterV1('reporttype_klpcollectedcount');
	// ----------------------------------- REPORT TYPE FILTER START -----------------------------------
		
	 var form = document.getElementById('klpcollectedcount'); // Get the form by its ID
	 
	 form.addEventListener('submit', function (e) {

        e.preventDefault(); // Prevent form submission if validation fails
        var sdate = document.getElementById('sdate_klpcollectedcount').value;
        var edate = document.getElementById('edate_klpcollectedcount').value;
        var oid = document.getElementById('oid_klpcollectedcount').value;
        var rprttypeid= document.getElementById('reporttype_klpcollectedcount').value;
        var error = document.getElementById('klpcollectedcount-error-message'); // Ensure you have this element in your HTML
        
       
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE START -----------------------------------
        if (!dateValidator(sdate, edate, error))
        {
            return; // Exit the function
        }
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE END -----------------------------------
       

        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
        
        var queryString='?brtSdate=' + encodeURIComponent(sdate) + '&brtEdate=' + encodeURIComponent(edate)+ '&brtOid=' +encodeURIComponent(oid)+ '&brtReportTypeId=' +encodeURIComponent(rprttypeid);
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------
        
        
        window.open(form.getAttribute('action') + queryString, '_blank');
        
        
    });
	 

});

// ------------------------------------------- KNG Lab Patient Count Collected Report Tests Taken END --------------------------------------------------------------			
