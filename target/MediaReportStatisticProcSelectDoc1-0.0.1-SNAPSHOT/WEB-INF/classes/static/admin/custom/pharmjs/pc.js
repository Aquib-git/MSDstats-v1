import { formDateValidator } from '../formValidator/formValidator.js';
		
	  //----------------------------- PHARM CHART FORM SUBMIT LOGIC START----------------------------------
			
		document.addEventListener('DOMContentLoaded', function (){
			
		 var form = document.getElementById('pharmFormBeanChart'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

        
        var sdate = document.getElementById('pharmySdate').value;
        var edate = document.getElementById('pharmyEdate').value;
        var oid = document.getElementById('pharmyClinicId').value;
        var error = document.getElementById('pharmChart-error-message'); 
        
       console.log(sdate,edate,oid)
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE START -----------------------------------
        if (!formDateValidator(sdate, edate, error))
        {
			e.preventDefault(); 
            return; // Exit the function
        }
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE END -----------------------------------
       
        
        // If all validations pass, clear any error messages and proceed with the form submission
        error.textContent = '';

         // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
        
        var queryString='?pharmSdate=' + encodeURIComponent(sdate) + '&pharmEdate=' + encodeURIComponent(edate)+ '&pharmOid=' +encodeURIComponent(oid);
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------
        
        // Only change the window location if form validation passes
        if (!e.defaultPrevented) {
            window.location.href = form.getAttribute('action') + queryString;
        }
    });
		});
	

		
	 //----------------------------- PHARM CHART FORM SUBMIT LOGIC END----------------------------------
		
	