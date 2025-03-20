
import { departmentDynaFilter, doctorDynaFilter } from './coreBirtUtils.js';
import { quarterFilter } from './coreBirtUtils.js';
import { yearFilter,clinicValidator } from './coreBirtUtils.js';
//import { clinicValidator } from './coreBirtUtils';


//----------------------------- PATIENT VISIT Categorized By Procedure-Doctor Wise(Quarter) Report FORM SUBMIT LOGIC START----------------------------------
document.addEventListener('DOMContentLoaded', function (){
			
		// ----------------------------------- UTILITIES START -----------------------------------
		 	departmentDynaFilter('oid10', 'did10');
	 		doctorDynaFilter('did10', 'docid10');
	 		quarterFilter('qid10')
		 	yearFilter('yearid10');
		// ----------------------------------- UTILITIES  END -----------------------------------

		 var form = document.getElementById('pvcbpdw'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

		e.preventDefault(); // Prevent form submission if validation fails
        var oid = document.getElementById('oid10').value;
        
        var didInt = document.getElementById('did10').value;
        var did = (didInt === '-- Select Department / ALL --') ? 0 : didInt;
       
       // var docid = document.getElementById('docid10').value;
        var docidInt = document.getElementById('docid10').value;
        var docid = (docidInt === '-- Select Doctor / ALL --') ? 0 :docidInt;
        
        var qid = document.getElementById('qid10').value;
        var yearid = document.getElementById('yearid10').value;
		var error = document.getElementById('pvcbpdw-error-message'); // Ensure you have this element in your HTML


		 // ----------------------------------- BIRT FILTER VALIDATOR CALLED HERE START -----------------------------------
       
	        if (!clinicValidator(oid, error))
	        {
	            e.preventDefault(); // Prevent form submission if validation fails
	            return; // Exit the function
	        }
 		// ----------------------------------- BIRT FILTER VALIDATOR CALLED HERE END -----------------------------------
       
	
        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
       
        var queryString='?brtOid=' + encodeURIComponent(oid) +'&brtDid=' +encodeURIComponent(did) + '&brtDocid=' +encodeURIComponent(docid) + '&brtQrterid=' +encodeURIComponent(qid) +'&brtYearid=' +encodeURIComponent(yearid);
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------
        
        // Only change the window location if form validation passes
         window.open(form.getAttribute('action') + queryString, '_blank');
    });

});


//----------------------------- PATIENT VISIT Categorized By Procedure-Doctor Wise(Quarter) Report FORM SUBMIT LOGIC END----------------------------------
