import { yearFilter,clinicValidator } from './coreBirtUtils.js';

//----------------------------- PATIENT YEARLY VISIT per SPECIALITY Report FORM SUBMIT LOGIC START----------------------------------
			
document.addEventListener('DOMContentLoaded', function (){
			
		// ----------------------------------- BIRT FILTER START -----------------------------------
		 	yearFilter('yearid7');
		 	//officeFilterWithoutAllCondition('oid7');
		// ----------------------------------- BIRT FILTER END -----------------------------------

		 var form = document.getElementById('pyvps'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

		e.preventDefault(); // Prevent the default form submission
        var oid = document.getElementById('oid7').value;
        var yearid = document.getElementById('yearid7').value;
        
        
        var error = document.getElementById('pyvps-error-message'); // Ensure you have this element in your HTML
        
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
		
//----------------------------- PATIENT YEARLY VISIT per SPECIALITY Report FORM SUBMIT LOGIC END----------------------------------
