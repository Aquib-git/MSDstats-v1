
import { dateValidator ,clinicValidator} from './coreBirtUtils.js';
import { medicineDynaFilter } from './coreBirtUtils.js';

//----------------------------- 4.3 Pharmacy Items Total Dispensed Report START ----------------------------------
			
document.addEventListener('DOMContentLoaded', function (){
					
			
    // ----------------------------------- SEARCH Medicine using SELECT2 -----------------------------------
	    $('#mid14').select2({
	        placeholder: "Select a medicine",
	        allowClear: true,
	    });
	    
	 // ------------------------------ SEARCH Medicine using SELECT2 -----------------------------------	
	
	// ----------------------------------- MONTH and YEAR FILTER START -----------------------------------
	     	
	     	medicineDynaFilter('oid14','mid14');
		 	
	// ----------------------------------- MONTH and YEAR FILTER END -----------------------------------
	
			
			
		 var form = document.getElementById('pitdr'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

        e.preventDefault(); // Prevent the default form submission
        var sdate = document.getElementById('sdate14').value;
        var edate = document.getElementById('edate14').value;
        var oid = document.getElementById('oid14').value;
       
        var selectedMedicines = $('#mid14').select2('data'); // Get selected items
   		var medicineIds = selectedMedicines.map(function(item) { return item.id; }); // Extract the IDs

        var error = document.getElementById('pitdr-error-message'); // Ensure you have this element in your HTML
        
 
 		// ----------------------------------- BIRT FILTER VALIDATOR CALLED HERE START -----------------------------------
        if (!dateValidator(sdate, edate, error))
        {
            e.preventDefault(); // Prevent form submission if validation fails
            return; // Exit the function
        }
        
        if (!clinicValidator(oid, error))
        {
            e.preventDefault(); // Prevent form submission if validation fails
            return; // Exit the function
        }
 		// ----------------------------------- BIRT FILTER VALIDATOR CALLED HERE END -----------------------------------
       

        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
       
        var queryString='?brtSdate=' + encodeURIComponent(sdate) + '&brtEdate=' + encodeURIComponent(edate)+ '&brtOid=' +encodeURIComponent(oid)+ '&brtMedicineid=' +encodeURIComponent(medicineIds.join(','));
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------
        
        // Open a new tab with the form's action URL and the query string
        	window.open(form.getAttribute('action') + queryString, '_blank');
    });

});
		
//----------------------------- 4.3 Pharmacy Items Total Dispensed Report END----------------------------------
