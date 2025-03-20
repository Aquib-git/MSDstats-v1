

//----------------------------- 4.1 Medicine Stock-Clinic wise FORM SUBMIT LOGIC START----------------------------------
			
document.addEventListener('DOMContentLoaded', function (){
			
		 var form = document.getElementById('mscw'); // Get the form by its ID

    	form.addEventListener('submit', function (e) {

		 e.preventDefault(); // Prevent the default form submission
        var oid = document.getElementById('oid19').value;
       // var error = document.getElementById('mscw-error-message'); // Ensure you have this element in your HTML
        

        // ----------------------------------- QUERY STRING CONSTRUCTOR START -----------------------------------
        
        var queryString='?brtOid=' +encodeURIComponent(oid);
		
		// ----------------------------------- QUERY STRING CONSTRUCTOR END -----------------------------------

            // Open a new tab with the form's action URL and the query string
        	window.open(form.getAttribute('action') + queryString, '_blank');
    });
		});
			
//----------------------------- 4.1 Medicine Stock-Clinic wise FORM SUBMIT LOGIC END ----------------------------------
	