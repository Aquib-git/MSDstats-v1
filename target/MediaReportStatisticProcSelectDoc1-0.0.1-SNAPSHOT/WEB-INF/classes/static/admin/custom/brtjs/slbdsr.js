import { dateValidator } from './coreBirtUtils.js';

//----------------------------- Sick Leave by Doctor Summary Report FORM SUBMIT LOGIC START----------------------------------
			
document.addEventListener('DOMContentLoaded', function (){
			
		 var form = document.getElementById('slbdsr'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

       	e.preventDefault(); // Prevent form submission if validation fails
       
        var sdate = document.getElementById('sdate').value;
        var edate = document.getElementById('edate').value;
        var oid = document.getElementById('oid').value;
        var error = document.getElementById('slbdsr-error-message'); // Ensure you have this element in your HTML
        
       
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE START -----------------------------------
        if (!dateValidator(sdate, edate, error))
        {
                return; // Exit the function
        }
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE END -----------------------------------
       

        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
        
        var queryString='?brtSdate=' + encodeURIComponent(sdate) + '&brtEdate=' + encodeURIComponent(edate)+ '&brtOid=' +encodeURIComponent(oid);
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------

        window.open(form.getAttribute('action') + queryString, '_blank');
        
        
        
    });
		});
			
//----------------------------- Sick Leave by Doctor Summary Report FORM SUBMIT LOGIC END----------------------------------
	