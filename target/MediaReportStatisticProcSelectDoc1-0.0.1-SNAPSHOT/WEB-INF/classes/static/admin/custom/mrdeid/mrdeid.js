import { fetchAndPopulatePatientName, initializePatientDropdown } from '../formValidator/formValidator.js';

  //----------------------------- MRD BY EMPLOYEE ID FORM SUBMIT LOGIC START----------------------------------
			
document.addEventListener('DOMContentLoaded', function () 
{

    //fetchAndPopulatePatientName('mrdInputEid');
   
    initializePatientDropdown('mrdInputEid');
    
    var form = document.getElementById('mrdFormBeanEid'); // Get the form by its ID
    var dropOperator = document.getElementById('mrdInputEid'); // Get the input field by its ID

    // Function to handle form validation and submission
    function handleFormSubmission(e) 
    {
        var empId = document.getElementById('mrdInputEid').value; // Get the empId from the input
        var fdate = document.getElementById('fdate').value;
        var tdate = document.getElementById('tdate').value;
        var error = document.getElementById('error-message'); // Ensure you have this element in your HTML
        
        console.log("Military No: "+empId+" Start Date: "+fdate+" End Date: "+tdate);
        
        //Essentials for JS validations
        var maxPrecision = 10;
        var minPrecision = 3;
        var startDate = new Date(fdate);
        var endDate = new Date(tdate);
        var currentDate = new Date();
        
        //---------- MILITARY ID JS LOGIC START ----------
        
        //empId should not be empty
        if (!empId) 
        {
            error.textContent = 'Military ID must not be empty.';
            e.preventDefault(); // Prevent form submission
            return; // Exit the function
        }
        
        //empId must not exceed the maximum length
        else if (empId.length > maxPrecision) 
        {
            error.textContent = 'Military ID length must not be more than ' + maxPrecision + ' digits.';
            e.preventDefault(); // Prevent form submission
            return; // Exit the function
        }
        
        //empId must not be below the minimum length
        else if (empId.length < minPrecision) 
        {
            error.textContent = 'Military ID length must not be less than ' + minPrecision + ' digits.';
            e.preventDefault(); // Prevent form submission
            return; // Exit the function
        }
        //---------- MILITARY ID JS LOGIC END ----------
        //---------- MRD DATE FILTER JS LOGIC START --------
        
        // Start Date must not be empty
        if (!fdate) {
            error.textContent = 'From date must not be empty.';
            e.preventDefault(); // Prevent form submission
            return; // Exit the function
        }
       
        //End date must not be empty
        if (!tdate) {
            error.textContent = 'To date must not be empty.';
            e.preventDefault(); // Prevent form submission
            return; // Exit the function
        }
       
        // Start date should be less than end date
        if (startDate > endDate) {
            error.textContent = 'From date must be less than To date.';
            e.preventDefault(); // Prevent form submission
            return; // Exit the function
        }
        
        // End date does not exceed current date
        if (endDate > currentDate) {
            error.textContent = 'To date should not exceed the current date.';
            e.preventDefault(); // Prevent form submission
            return; // Exit the function
        }
        //------------ MRD DATE FILTER JS LOGIC END -----------
        
        // If all validations pass, clear any error messages and proceed with the form submission
        error.textContent = '';

        // Construct the query string for the URL
        var queryString = '?selectEmpId=' + encodeURIComponent(empId);

        if (fdate) 
        {
            queryString += '&selectMRDSdate=' + encodeURIComponent(fdate);
        }
        if (tdate) 
        {
            queryString += '&selectMRDEdate=' + encodeURIComponent(tdate);
        }

        // Only change the window location if form validation passes
        if (!e.defaultPrevented) 
        {
            window.location.href = form.getAttribute('action') + queryString;
        }
    }

  

    // Form Submit -> Event listener
    form.addEventListener('submit', function (e) 
    {
        handleFormSubmission(e);
    });
    
});
	
//----------------------------- MRD BY EMPLOYEE ID FORM SUBMIT LOGIC START----------------------------------
	
	  /*
        $(document).ready(function()
		{
		
			var dropOperator = document.getElementById('mrdInputEid');
			
			dropOperator.addEventListener('change', function()
			{		
				document.getElementById("mrdFormBeanEid").submit();
			});
	
		});
      */

		
	//----------------------------- MRD BY EMPLOYEE ID FORM SUBMIT LOGIC END----------------------------------
	
			//----------------------------- LAB TAB JS START----------------------------------
			  $(function () {
				$("#labTab").DataTable({
				  "responsive": true, "lengthChange": false, "autoWidth": false,"pageLength":10,
				  //"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
				  "buttons": [ "excel", "colvis"]
				}).buttons().container().appendTo('#labTab_wrapper .col-md-6:eq(0)');
				$('#example2').DataTable({
				  "paging": true,
				  "lengthChange": false,
				  "searching": false,
				  "ordering": true,
				  "info": true,
				  "autoWidth": false,
				  "responsive": true,
				});
			  });
			//----------------------------- LAB TAB JS END----------------------------------
 
			
			//----------------------------- XRAY TAB JS START----------------------------------
			  $(function () {
				$("#xrayTab").DataTable({
				  "responsive": true, "lengthChange": false, "autoWidth": false,"pageLength":10,
				  //"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
				  "buttons": [ "excel", "colvis"]
				}).buttons().container().appendTo('#xrayTab_wrapper .col-md-6:eq(0)');
				$('#example2').DataTable({
				  "paging": true,
				  "lengthChange": false,
				  "searching": false,
				  "ordering": true,
				  "info": true,
				  "autoWidth": false,
				  "responsive": true,
				});
			  });
			//----------------------------- XRAY TAB JS END----------------------------------
			
			//----------------------------- PROC TAB JS START----------------------------------
			  $(function () {
				$("#procTab").DataTable({
				  "responsive": true, "lengthChange": false, "autoWidth": false,"pageLength":10,
				  //"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
				  "buttons": [ "excel", "colvis"]
				}).buttons().container().appendTo('#procTab_wrapper .col-md-6:eq(0)');
				$('#example2').DataTable({
				  "paging": true,
				  "lengthChange": false,
				  "searching": false,
				  "ordering": true,
				  "info": true,
				  "autoWidth": false,
				  "responsive": true,
				});
			  });
			//----------------------------- PROC TAB JS END----------------------------------


			//----------------------------- SICK TAB JS START----------------------------------
			  $(function () {
				$("#sickTab").DataTable({
				  "responsive": true, "lengthChange": false, "autoWidth": false,"pageLength":10,
				  //"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
				  "buttons": [ "excel", "colvis"]
				}).buttons().container().appendTo('#sickTab_wrapper .col-md-6:eq(0)');
				$('#example2').DataTable({
				  "paging": true,
				  "lengthChange": false,
				  "searching": false,
				  "ordering": true,
				  "info": true,
				  "autoWidth": false,
				  "responsive": true,
				});
			  });
			//----------------------------- SICK TAB JS END----------------------------------
			
			
			//----------------------------- SICK TAB JS START----------------------------------
			  $(function () {
				$("#vitalTab").DataTable({
				  "responsive": true, "lengthChange": false, "autoWidth": false,"pageLength":10,
				  //"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
				  "buttons": [ "excel", "colvis"]
				}).buttons().container().appendTo('#vitalTab_wrapper .col-md-6:eq(0)');
				$('#example2').DataTable({
				  "paging": true,
				  "lengthChange": false,
				  "searching": false,
				  "ordering": true,
				  "info": true,
				  "autoWidth": false,
				  "responsive": true,
				});
			  });
			//----------------------------- SICK TAB JS END----------------------------------

			
				
			//----------------------------- DISPENSE TAB JS START----------------------------------
			  $(function () {
				$("#dispenseTab").DataTable({
				  "responsive": true, "lengthChange": false, "autoWidth": false,"pageLength":10,
				  //"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
				  "buttons": [ "excel", "colvis"]
				}).buttons().container().appendTo('#dispenseTab_wrapper .col-md-6:eq(0)');
				$('#example2').DataTable({
				  "paging": true,
				  "lengthChange": false,
				  "searching": false,
				  "ordering": true,
				  "info": true,
				  "autoWidth": false,
				  "responsive": true,
				});
			  });
			//----------------------------- DISPENSE TAB JS END----------------------------------

			
