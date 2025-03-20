import { yearFilter,clinicValidator } from './coreBirtUtils.js';

//----------------------------- PATIENT YEARLY VISIT Categorized By Procedure Report FORM SUBMIT LOGIC START----------------------------------
			
document.addEventListener('DOMContentLoaded', function (){
			
		// ----------------------------------- MONTH and YEAR FILTER START -----------------------------------
		 	yearFilter('yearid9');
		// ----------------------------------- MONTH and YEAR FILTER END -----------------------------------

		 var form = document.getElementById('procyvps'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

		e.preventDefault(); // Prevent the default form submission
        var oid = document.getElementById('oid9').value;
        var yearid = document.getElementById('yearid9').value;
        
        
        var error = document.getElementById('procyvps-error-message'); // Ensure you have this element in your HTML

		// ----------------------------------- BIRT FILTER VALIDATOR CALLED HERE START -----------------------------------
       
        if (!clinicValidator(oid, error))
        {
            e.preventDefault(); // Prevent form submission if validation fails
            return; // Exit the function
        }
 		// ----------------------------------- BIRT FILTER VALIDATOR CALLED HERE END -----------------------------------
       
       
        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
       
        var queryString='?brtOid=' + encodeURIComponent(oid) + '&brtYearid=' +encodeURIComponent(yearid);
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------
        
        // Open a new tab with the form's action URL and the query string
        	window.open(form.getAttribute('action') + queryString, '_blank');
    });

});
		
//----------------------------- PATIENT YEARLY VISIT Categorized By Procedure Report FORM SUBMIT LOGIC START----------------------------------
