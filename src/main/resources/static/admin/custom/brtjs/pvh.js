import { patientValidator } from './coreBirtUtils.js';

//----------------------------- 4.4 Pharmacy Visit History Report FORM SUBMIT LOGIC START----------------------------------
			
document.addEventListener('DOMContentLoaded', function (){
			
		 var form = document.getElementById('pvh'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

		 e.preventDefault(); // Prevent the default form submission
        var pid = document.getElementById('pid1').value;
        var error = document.getElementById('pvh-error-message'); // Ensure you have this element in your HTML
         


	  // ----------------------------------- BIRT PATIENT MILITARY ID/CIVIL ID/OP NUMBER VALIDATOR CALLED HERE START -----------------------------------

		if (!patientValidator(pid,error))
        {
            return; // Exit the function
        }
	  // ----------------------------------- BIRT PATIENT MILITARY ID/CIVIL ID/OP NUMBER VALIDATOR CALLED HERE END -----------------------------------


      // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
        
        var queryString='?brtPid=' +encodeURIComponent(pid);
		
	 // ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------

            // Open a new tab with the form's action URL and the query string
        	window.open(form.getAttribute('action') + queryString, '_blank');
    });
		});
			
//----------------------------- 4.4 Pharmacy Visit History Report FORM SUBMIT LOGIC END ----------------------------------
	