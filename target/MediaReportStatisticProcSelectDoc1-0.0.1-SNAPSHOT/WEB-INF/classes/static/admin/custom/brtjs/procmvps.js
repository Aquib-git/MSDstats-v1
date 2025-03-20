import { monthFilter,yearFilter } from './coreBirtUtils.js';

//----------------------------- Patient Monthly Visits Categorized by Procedure FORM SUBMIT LOGIC START----------------------------------
			
document.addEventListener('DOMContentLoaded', function (){
			
		// ----------------------------------- MONTH and YEAR FILTER START -----------------------------------
	     	monthFilter('monthid8');
		 	yearFilter('yearid8');
		// ----------------------------------- MONTH and YEAR FILTER END -----------------------------------

		 var form = document.getElementById('pmvps'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

		e.preventDefault(); // Prevent the default form submission
        var oid = document.getElementById('oid8').value;
        var monthid = document.getElementById('monthid8').value;
        var yearid = document.getElementById('yearid8').value;
        
        
        //var error = document.getElementById('pmvps-error-message'); // Ensure you have this element in your HTML


        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
       
        var queryString='?brtOid=' + encodeURIComponent(oid) + '&brtMonthid=' + encodeURIComponent(monthid)+ '&brtYearid=' +encodeURIComponent(yearid);
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------
        
        // Only change the window location if form validation passes
        if (!e.defaultPrevented) {
            window.location.href = form.getAttribute('action') + queryString;
        }
    });

});
		
//----------------------------- Patient Monthly Visits Categorized by Procedure FORM SUBMIT LOGIC START----------------------------------

