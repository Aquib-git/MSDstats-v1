import { dateValidator} from './coreBirtUtils.js';
import { kwtNkwtFilter2 } from './coreBirtUtils.js';
import { militaryIdValidator} from './coreBirtUtils.js';
/*import {fillerIdValidator} from './coreBirtUtils.js';*/

// ------------------------------------------- 4.2 Medicine by KNG Pharmacy START --------------------------------------------------------------			
document.addEventListener('DOMContentLoaded', function (){
	
		// ----------------------------------- KWTI - NKWTI FILTER START -----------------------------------
		 	kwtNkwtFilter2('kwtid19');
		// ----------------------------------- KWTI - NKWTI FILTER START -----------------------------------
		
			
		 var form = document.getElementById('mbkp'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

        e.preventDefault(); // Prevent form submission if validation fails
        var sdate = document.getElementById('sdate19').value;
        var edate = document.getElementById('edate19').value;
        var oid = document.getElementById('oid20').value;
        var pid= document.getElementById('pid19').value;
        /*var fid= document.getElementById('fid19').value;*/
        var kwtid= document.getElementById('kwtid19').value;
        var error = document.getElementById('mbkp-error-message'); // Ensure you have this element in your HTML
       	let queryString='';
       console.log(sdate,edate,oid,kwtid);
       
 		// ----------------------------------- BIRT  VALIDATORS CALLED HERE START -----------------------------------
        if (!dateValidator(sdate, edate, error))
        {
            return; // Exit the function
        }
      if(!militaryIdValidator(pid,error))
        {
			return; // Exit the function
		}
		/*if(fillerIdValidator(fid,error))
		{
			return; // Exit the function
		}*/
 		// ----------------------------------- BIRT VALIDATORS CALLED HERE END -----------------------------------
       

        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
        
	    if(pid==''||pid==null)
	     {
			 queryString='?brtSdate=' + encodeURIComponent(sdate) +'&brtEdate=' + encodeURIComponent(edate)+ '&brtOid=' +encodeURIComponent(oid)+ '&brtKwtNkwtid=' +encodeURIComponent(kwtid);
			console.log('hit1');
		 }
	     else
	     {
			   queryString='?brtSdate=' + encodeURIComponent(sdate) + '&brtEdate=' + encodeURIComponent(edate)+ '&brtOid=' +encodeURIComponent(oid)+'&brtKwtNkwtid=' +encodeURIComponent(kwtid)+'&brtPid='+encodeURIComponent(pid);
			console.log('hit2');
		 }
			//console.log('hit3');
		
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------
        
        
        window.open(form.getAttribute('action') + queryString, '_blank');
        
        
    });
		});
			
// ------------------------------------------- 4.2 Medicine by KNG Pharmacy END --------------------------------------------------------------			
	