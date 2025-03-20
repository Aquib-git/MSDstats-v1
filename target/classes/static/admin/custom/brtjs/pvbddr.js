import { dateValidator } from './coreBirtUtils.js';
import { departmentDynaFilter, doctorDynaFilter } from './coreBirtUtils.js';

//oid4,did4
//did4,docid4
    
      
 // ------------------------------------ Patient visits by Doctor, Dept Report START  ------------------------------------   
 document.addEventListener('DOMContentLoaded', function ()
 {

    // ----------------------------------- DYNAMIC FILTERS START -----------------------------------
     departmentDynaFilter('oid4', 'did4');
	 doctorDynaFilter('did4', 'docid4');
	// ----------------------------------- DYNAMIC FILTERS END -----------------------------------
        
		
		
	 var form = document.getElementById('pvbddr'); // Get the form by its ID

     form.addEventListener('submit', function (e) {

        e.preventDefault();
        var sdate = document.getElementById('sdate4').value;
        var edate = document.getElementById('edate4').value;
        var oid = document.getElementById('oid4').value;
        
        var didInt = document.getElementById('did4').value;
        var did = (didInt === '-- Select Department / ALL --') ? 0 : didInt;
         
        var docidInt = document.getElementById('docid4').value;
        var docid = (docidInt === '-- Select Doctor / ALL --') ? 0 :docidInt;
        
        var error = document.getElementById('pvbddr-error-message'); // Ensure you have this element in your HTML
    
        console.log(sdate,edate,oid,did,docid)  ;     
  		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE START -----------------------------------
        if (!dateValidator(sdate, edate, error))
        {
            e.preventDefault(); // Prevent form submission if validation fails
            return; // Exit the function
        }
 		// ----------------------------------- BIRT DATE FILTER VALIDATOR CALLED HERE END -----------------------------------

        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
       
        var queryString='?brtSdate=' + encodeURIComponent(sdate) + '&brtEdate=' + encodeURIComponent(edate)+ '&brtOid=' +encodeURIComponent(oid)+ '&brtDid=' +encodeURIComponent(did)+'&brtDocid=' +encodeURIComponent(docid);
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------
        
        // Only change the window location if form validation passes
        window.open(form.getAttribute('action') + queryString, '_blank');
    });
		});
     
 // ------------------------------------ Patient visits by Doctor, Dept Report END  ------------------------------------     
      
      
      
      
      
      
      
      
      
      
      
      
      