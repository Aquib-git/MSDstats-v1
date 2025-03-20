import { dateValidator } from './coreBirtUtils.js';

//----------------------------- Exemption Detail by Doctor Summary Report FORM SUBMIT LOGIC START----------------------------------
			
document.addEventListener('DOMContentLoaded', function (){
			
		 var form = document.getElementById('edbd'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

        e.preventDefault(); // Prevent form submission if validation fails
        var sdate = document.getElementById('sdate3').value;
        var edate = document.getElementById('edate3').value;
        var oid = document.getElementById('oid3').value;
        var error = document.getElementById('edbd-error-message'); // Ensure you have this element in your HTML
        
 
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE START -----------------------------------
        if (!dateValidator(sdate, edate, error))
        {
            return; // Exit the function
        }
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE END -----------------------------------
       

        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
       
        var queryString='?brtSdate=' + encodeURIComponent(sdate) + '&brtEdate=' + encodeURIComponent(edate)+ '&brtOid=' +encodeURIComponent(oid);
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------
        
        // Only change the window location if form validation passes
       /* if (!e.defaultPrevented) {
            window.location.href = form.getAttribute('action') + queryString;
        }*/
        
         window.open(form.getAttribute('action') + queryString, '_blank');
    });

});
		
//----------------------------- Exemption Detail by Doctor Summary Report FORM SUBMIT LOGIC START----------------------------------
