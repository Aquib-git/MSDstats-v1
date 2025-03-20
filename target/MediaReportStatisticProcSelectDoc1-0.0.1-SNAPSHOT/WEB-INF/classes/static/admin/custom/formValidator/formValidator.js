// ------------------------------- COMMON FORM DATE VALIDATOR FUNCTION START ------------------------------- 
export function formDateValidator(sdate, edate, errorElement) 
{
	var startDate = new Date(sdate);
    var endDate = new Date(edate);
    var currentDate = new Date();

    // Start Date must not be empty
    if (!sdate) 
    {
        errorElement.textContent = 'From date must not be empty.';
        return false; // Indicate validation failure
    }
    // End date must not be empty
    if (!edate) 
    {
        errorElement.textContent = 'To date must not be empty.';
        return false; // Indicate validation failure
    }
    // Start date should be less than end date
    if (startDate > endDate) 
    {
        errorElement.textContent = 'From date must be less than To date.';
        return false; // Indicate validation failure
    }
    // End date does not exceed current date
    if (endDate > currentDate) 
    {
        errorElement.textContent = 'To date should not exceed the current date.';
        return false; // Indicate validation failure
    }

    // Clear error message and indicate success
    errorElement.textContent = '';
    return true;
}
// ------------------------------- COMMON FORM DATE VALIDATOR FUNCTION END ------------------------------- 

// ------------------------------- COMMON FORM CLINIC VALIDATOR FUNCTION START ------------------------------- 

export function formClinicValidator(oid, errorElement) 
{
	 if (oid === '0') {
        errorElement.textContent = 'Please select Clinic';
        return false; // Indicate validation failure
    }

    // Clear error message and indicate success
    errorElement.textContent = '';
    return true;
}
// ------------------------------- COMMON FORM CLINIC VALIDATOR FUNCTION END ------------------------------- 

// ------------------------------- COMMON FORM DYNAMIC DEPARTMENT FILTER OPTIONS  based on OFFICE ID START ------------------------------- 

export function formDepartmentDynaFilter (officeId, departmentDropdownId) {
    document.getElementById(officeId).addEventListener('change', function() {
        var clinicId = this.value;
        fetch('./departmentList/' + clinicId)
            .then(response => response.json())
            .then(data => {
                var departmentDropdown = document.getElementById(departmentDropdownId);
                departmentDropdown.innerHTML = '<option th:value="0">-- Select Department / ALL --</option>';
                data.forEach(function(department) {
                    var option = new Option(department.departmentName, department.departmentId);
                    departmentDropdown.add(option);
                });
            })
            .catch(error => console.error('Error:', error));
    });
}
// ------------------------------- COMMON FORM DYNAMIC DEPARTMENT FILTER OPTIONS  based on OFFICE ID END ------------------------------- 


// ------------------------------- COMMON FORM DYNAMIC DOCTOR FILTER OPTIONS  based on DEPARTMENT ID START ------------------------------- 

export function formDoctorDynaFilter(departmentDropdownId, doctorDropdownId) {
    document.getElementById(departmentDropdownId).addEventListener('change', function() {
        var departmentId = this.value;
        fetch('./doctorList/' + departmentId)
            .then(response => response.json())
            .then(data => {
                var doctorDropdown = document.getElementById(doctorDropdownId);
                doctorDropdown.innerHTML = '<option th:value="0">-- Select Doctor / ALL --</option>';
                data.forEach(function(doctor) {
                    var option = new Option(doctor.doctorName, doctor.doctorId);
                    doctorDropdown.add(option);
                });
            })
            .catch(error => console.error('Error:', error));
    });
}
// ------------------------------- COMMON FORM DYNAMIC DOCTOR FILTER OPTIONS  based on DEPARTMENT ID END ------------------------------- 


export function fetchAndPopulateMedicines(medicineDropdownId) {
    fetch('./pharmMedicineList')
        .then(response => response.json())
        .then(data => {
            var medicineDropdown = $('#' + medicineDropdownId);
            medicineDropdown.empty(); // Clear existing options
            medicineDropdown.append('<option value="0"></option>'); // Default empty option
            
            data.forEach(function(medicine) {
                medicineDropdown.append(new Option(medicine.itemName, medicine.itemId));
            });

            // Re-initialize select2 for the updated dropdown
            medicineDropdown.select2({
                placeholder: "Search and Select a medicine",
                allowClear: true,
                multiple: false, // Enable multiple selection
                tags: true      // Allow creating new tags (medicines) if not found in the list
            });
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

export function fetchAndPopulatePatientName(patientDropdownId) 
{
	console.log("fetchAndPopulatePatientName Function entered");

    fetch('./util_Patient_List')
        .then(response => response.json())
        .then(data => {
            var patientDropdown = $('#' + patientDropdownId);
            patientDropdown.empty(); // Clear existing options
            patientDropdown.append('<option value="0"></option>'); // Default empty option

            // Prepare data for Select2
            var select2Data = data.map(patient => {
                return {
                    id: patient.patientEmployeeId,
                    text: `${patient.patientName} _${patient.patientEmployeeId}`
                };
            });

            // Initialize Select2 with data
            patientDropdown.select2({
                data: select2Data,
                placeholder: "Search and Select Military No:/ Patient Name",
                allowClear: true,
                multiple: false, // Disable multiple selection
                tags: true       // Allow creating new tags (medicines) if not found in the list
            });
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

export function initializePatientDropdown(patientDropdownId)
{
        $('#' + patientDropdownId).select2({
        ajax: 
        {
            url: './util_Patient_List',
            dataType: 'json',
            delay: 250, // Delay in milliseconds before triggering the request
            data: function (params) 
            {
                // Query parameters for the request
                return {
                    searchTerm: params.term // search term
                };
            },
            processResults: function (data) 
            {
                // Map the data to the format Select2 expects
                return {
                    results: data.map(patient => (
						{
                        	id: patient.patientEmployeeId,
                        	text: `${patient.patientName} ${patient.patientEmployeeId}`
                    	}))
                };
            },
            cache: true
        },
        placeholder: "Search and Select Military No:/ Patient Name",
        allowClear: true,
        minimumInputLength: 3, // Minimum number of characters before triggering the search
        multiple: false, // Disable multiple selection
        tags: false      // Do not allow creating new tags
   	 }).on('select2:select', function (e)
   	  	{
        	// Get the selected employee ID
        	var selectedEmployeeId = e.params.data.id;
        
        	// Pass the selected employee ID to the controller or form
        	document.getElementById('selectedEmployeeId').value = selectedEmployeeId;
    	});
}



//WIP ->11 July 2024 at 1_13pm
/*
export function fetchAndPopulatePatientName(patientDropdownId) 
{
	console.log("fetchAndPopulatePatientName Fnction entered");
	
    fetch('./util_Patient_List')
        .then(response => response.json())
        .then(data => {
            var patientDropdown = $('#' + patientDropdownId);
            patientDropdown.empty(); // Clear existing options
            patientDropdown.append('<option value="0"></option>'); // Default empty option
            
            data.forEach(function(patient) 
            {
                
                 var optionText = `${patient.patientName} _${patient.patientEmployeeId}`;
                patientDropdown.append(new Option(optionText, patient.patientEmployeeId));
                
                
              //  console.log("Patient Employee Id: ",patient.patientEmployeeId);
              //  console.log("Patient Name:",patient.patientName);
            });

            // Re-initialize select2 for the updated dropdown
            patientDropdown.select2({
                placeholder: "Search and Select Military No:/ Patient Name",
                allowClear: true,
                multiple: false, // Enable multiple selection
                tags: true      // Allow creating new tags (medicines) if not found in the list
            });
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
*/



//WIP
/*
export function fetchAndPopulateMedicines(medicineDropdownId, preselectedItemId) {
    fetch('/pharmMedicineList')
        .then(response => response.json())
        .then(data => {
            var medicineDropdown = $('#' + medicineDropdownId);
            medicineDropdown.empty(); // Clear existing options
            medicineDropdown.append('<option value="0"></option>'); // Default empty option
            
            data.forEach(function(medicine) {
                var option = new Option(medicine.itemName, medicine.itemId, false, medicine.itemId === preselectedItemId);
                medicineDropdown.append(option);
            });

            // Re-initialize select2 for the updated dropdown
            medicineDropdown.select2({
                placeholder: "Search and Select a medicine",
                allowClear: true,
                multiple: false, // Enable multiple selection
                tags: true      // Allow creating new tags (medicines) if not found in the list
            });

            // If a preselected item ID is provided, set it as selected
            if (preselectedItemId) {
                medicineDropdown.val(preselectedItemId).trigger('change');
            }
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
*/


























































