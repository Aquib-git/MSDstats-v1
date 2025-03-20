import { dateValidator } from './coreBirtUtils.js';
import { kwtNkwtFilter } from './coreBirtUtils.js';


//----------------------------- Sick Leave by Doctor Summary Report FORM SUBMIT LOGIC START----------------------------------
			
document.addEventListener('DOMContentLoaded', function (){
	
		// ----------------------------------- KWTI - NKWTI FILTER START -----------------------------------
		 	kwtNkwtFilter('kwtid17');
		// ----------------------------------- KWTI - NKWTI FILTER START -----------------------------------
		
			
		 var form = document.getElementById('xray'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

       	e.preventDefault(); // Prevent form submission if validation fails
        var sdate = document.getElementById('sdate17').value;
        var edate = document.getElementById('edate17').value;
        var oid = document.getElementById('oid17').value;
        var kwtid= document.getElementById('kwtid17').value;
        var error = document.getElementById('xray-error-message'); // Ensure you have this element in your HTML
        
       
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE START -----------------------------------
        if (!dateValidator(sdate, edate, error))
        {
            return; // Exit the function
        }
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE END -----------------------------------
       

        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
        
        var queryString='?brtSdate=' + encodeURIComponent(sdate) + '&brtEdate=' + encodeURIComponent(edate)+ '&brtOid=' +encodeURIComponent(oid)+ '&brtKwtNkwtid=' +encodeURIComponent(kwtid);
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------
             
         window.open(form.getAttribute('action') + queryString, '_blank');
    });
		});
			
//----------------------------- Sick Leave by Doctor Summary Report FORM SUBMIT LOGIC END----------------------------------
	