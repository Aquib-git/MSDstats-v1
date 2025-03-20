import { dateValidator } from './coreBirtUtils.js';


//----------------------------- Sick Leave Summary Report FORM SUBMIT LOGIC START----------------------------------

document.addEventListener('DOMContentLoaded', function (){
			
		 var form = document.getElementById('slsr'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

		e.preventDefault(); // Always prevent the default form submission at the start


        var sdate = document.getElementById('sdate1').value;
        var edate = document.getElementById('edate1').value;
        var error = document.getElementById('slsr-error-message'); // Ensure you have this element in your HTML
        
 		
 		
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE START -----------------------------------
        if (!dateValidator(sdate, edate, error))
        {
           // e.preventDefault(); // Prevent form submission if validation fails
            return; // Exit the function
        }
        
        
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE END -----------------------------------

        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
        
        var queryString='?brtSdate=' + encodeURIComponent(sdate) + '&brtEdate=' + encodeURIComponent(edate);
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END  -----------------------------------

        
         window.open(form.getAttribute('action') + queryString, '_blank');
        
    });
});

//----------------------------- Sick Leave Summary Report FORM SUBMIT LOGIC END----------------------------------


	