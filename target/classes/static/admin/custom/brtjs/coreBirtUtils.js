// ------------------------------- COMMON DATE VALIDATOR FUNCTION START ------------------------------- 
export function dateValidator(sdate, edate, errorElement) 
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
// ------------------------------- COMMON DATE VALIDATOR FUNCTION END ------------------------------- 


// ------------------------------- COMMON CLINIC VALIDATOR FUNCTION START ------------------------------- 

export function clinicValidator(oid, errorElement) 
{
	 if (oid === '0') {
        errorElement.textContent = 'Please select Clinic';
        return false; // Indicate validation failure
    }

    // Clear error message and indicate success
    errorElement.textContent = '';
    return true;
}
// ------------------------------- COMMON CLINIC VALIDATOR FUNCTION END ------------------------------- 

// ------------------------------- PATIENT MILITARY ID/CIVIL ID/OP_NUMBER START ------------------------------- 
export function patientValidator(pid, errorElement) 
{
	pid = pid.trim();
	
	if (!pid) {
        errorElement.textContent = 'Civil Id/Military Id/MR.No should not be empty.Please enter Data.';
        return false; // Indicate validation failure
    }
    
    if (/\s/.test(pid)) {
        errorElement.textContent = 'Civil Id/Military Id/MR.No should not contain whitespaces.';
        return false; // Indicate validation failure
    }
   
    if(pid.length>6 && pid.length<=8)
    {
		errorElement.textContent = 'Military id length should be less than 7 characters. Please check the military ID entered.';
        return false; // Indicate validation failure
	}
	
    if (pid.length>8 && pid.length < 12) 
    {
        errorElement.textContent = 'Civil id length is less than 12 characters. Please check the civil ID entered.';
        return false; // Indicate validation failure
    }

	if (pid.length > 12 && pid.length <13) 
	{
        errorElement.textContent = 'Civil id length should not exceed 12 characters. Please check the civil ID entered.';
        return false; // Indicate validation failure
    }
    
    if (pid.length === 13 && !pid.startsWith('KNG-')) 
	{
		errorElement.textContent = 'MR. No should start with the pattern `KNG-`. `KNG-` should be in Capital letters.';
        return false; // Indicate validation failure	
    }
    
    if (pid.length > 13 && !pid.startsWith('KNG-')) 
	{
     	errorElement.textContent = 'MR. No length should not exceed 13 characters. Please check the MR. No entered.';
        return false; // Indicate validation failure
        //KNG-01-000037
    }
    
    // Clear error message and indicate success
    errorElement.textContent = '';
    return true;
}
// ------------------------------- PATIENT MILITARY ID/CIVIL ID/OP_NUMBER END ------------------------------- 



// ------------------------------- MILITARY ID VALIDATOR START ------------------------------- 
export function militaryIdValidator(pid, errorElement) 
{
	pid = pid.trim();
	
	 if (/\s/.test(pid)) 
	 {
        errorElement.textContent = 'Military Id should not contain whitespaces.';
        return false; // Indicate validation failure
     }
   
    
    if (/[A-Za-z]/.test(pid)) 
	 {
        errorElement.textContent = 'Military Id should not contain any alphabets';
        return false; // Indicate validation failure
     }
     
    if(pid.length>6 && pid.length<=8)
    {
		errorElement.textContent = 'Military id length should be less than 7 characters. Please check the military ID entered.';
        return false; // Indicate validation failure
	}
	
	
	// Clear error message and indicate success
    errorElement.textContent = '';
    return true;
	
}
// ------------------------------- MILITARY ID VALIDATOR END ------------------------------- 

// ------------------------------- MEDICINE FILLER VALIDATOR START ------------------------------- 
export function fillerIdValidator(fid, errorElement) 
{
	
	 if (fid.length > 4 && fid.length < 4 && !fid.startsWith('All')) 
	{
     	errorElement.textContent = 'Medicines Dispensed field should either be `All` or empty.';
        return false; // Indicate validation failure
        //All
    }
	// Clear error message and indicate success
    errorElement.textContent = '';
    return true;
}

// ------------------------------- MEDICINE FILLER  VALIDATOR END ------------------------------- 

// ------------------------------- DYNAMIC DEPARTMENT FILTER OPTIONS  based on OFFICE ID START ------------------------------- 

export function departmentDynaFilter (officeId, departmentDropdownId) {
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
// ------------------------------- DYNAMIC DEPARTMENT FILTER OPTIONS  based on OFFICE ID END ------------------------------- 


// ------------------------------- DYNAMIC DOCTOR FILTER OPTIONS  based on DEPARTMENT ID START ------------------------------- 

export function doctorDynaFilter(departmentDropdownId, doctorDropdownId) {
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
// ------------------------------- DYNAMIC DOCTOR FILTER OPTIONS  based on DEPARTMENT ID END ------------------------------- 


// ------------------------------- MONTH FILTER OPTIONS START ------------------------------- 

export function monthFilter(monthdropdownId) {
    const monthNames = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    const monthDropdown = document.getElementById(monthdropdownId);

    monthNames.forEach((month, index) => {
        const option = new Option(month, index + 1); // Month id starts from 1 for January
        monthDropdown.add(option);
    });
}
// ------------------------------- MONTH FILTER OPTIONS END ------------------------------- 

// ------------------------------- YEAR FILTER OPTIONS START ------------------------------- 

export function yearFilter(yeardropdownId) {
    const yearDropdown = document.getElementById(yeardropdownId);
    const currentYear = new Date().getFullYear();
    const startYear = 2019;

    for (let year = startYear; year <= currentYear; year++) {
        const option = new Option(year, year);
        yearDropdown.add(option);
    }
}
// ------------------------------- YEAR FILTER OPTIONS END ------------------------------- 

// ------------------------------- QUARTER FILTER OPTIONS START ------------------------------- 
export function quarterFilter(quarterdropdownId){
	const quarterNames = ["First Quarter", "Second Quarter","Third Quarter", "Fourth Quarter" ];
    const quarterDropdown = document.getElementById(quarterdropdownId);

	 quarterNames.forEach((quarter, index) => {
        const option = new Option(quarter, index + 1); // Quarter id starts from 1 for First Quarter
        quarterDropdown.add(option);
    });

}
// ------------------------------- QUARTER FILTER OPTIONS END ------------------------------- 


// ------------------------------- KUWAITI- NON KUWAITI FILTER OPTIONS START ------------------------------- 
export function kwtNkwtFilter(kwtNkwtdropdownId){
	const kwtNkwtNames = ["All","Kuwaiti","Non-Kuwaiti"];
    const kwtNkwtDropdown = document.getElementById(kwtNkwtdropdownId);

	 kwtNkwtNames.forEach((kwtnkwt, index) => {
        const option = new Option(kwtnkwt, index + 1); // The id starts from 1 for All
        kwtNkwtDropdown.add(option);
    });

}

//	---- All=1,Kuwaiti=2, Non-Kuwaiti=3 -----
// ------------------------------- KUWAITI- NON KUWAITI FILTER OPTIONS END ------------------------------- 

// ------------------------------- KUWAITI- NON KUWAITI FILTER version 2 OPTIONS START ------------------------------- 
export function kwtNkwtFilter2(kwtNkwtdropdownId2){
	const kwtNkwtNames2 = ["Kuwaiti","Non-Kuwaiti"];
    const kwtNkwtDropdown2 = document.getElementById(kwtNkwtdropdownId2);

	 kwtNkwtNames2.forEach((kwtnkwt2, index2) => {
        const option2 = new Option(kwtnkwt2, index2 + 1); // The id starts from 1 for Kuwaiti
        kwtNkwtDropdown2.add(option2);
    });

}

//	---- Kuwaiti=1, Non-Kuwaiti=2 -----
// ------------------------------- KUWAITI- NON KUWAITI FILTER version 2 OPTIONS END ------------------------------- 




// ------------------------------- DYNAMIC MEDICINE FILTER OPTIONS  based on OFFICE ID START ------------------------------- 

export function medicineDynaFilter(officeId, medicineDropdownId) {
    document.getElementById(officeId).addEventListener('change', function() {
        var clinicId = this.value;
        fetch('./medicineList/' + clinicId)
            .then(response => response.json())
            .then(data => {
                var medicineDropdown = $('#' + medicineDropdownId);
                medicineDropdown.empty(); // Clear existing options
                medicineDropdown.append('<option value="0"></option>');
                
                data.forEach(function(medicine) {
                    medicineDropdown.append(new Option(medicine.itemName, medicine.itemId));
                });

                // Re-initialize select2
                medicineDropdown.select2({
                    placeholder: "Seach and Select a medicine",
                    allowClear: true,
                    multiple: true, // Enable multiple selection
                    tags: true      // Allow creating new tags (medicines) if not found in the list
                });
            })
            .catch(error => console.error('Error:', error));
    });
}




// ------------------------------- DYNAMIC MEDICINE FILTER OPTIONS  based on OFFICE ID END ------------------------------- 


// ------------------------------- OFFICE FILTER OPTIONS START ------------------------------- 

export function officeFilterWithoutAllCondition(officedropdownId) {
   const officeNames = ["HeadQuarters-MultiSpeciality","Sheikh Salem Al Ali Camp","Summod Camp-MultiSpeciality","Tahreer Camp-Dental","Tahreer Camp-MultiSpeciality"];
    const officeDropdown = document.getElementById(officedropdownId);

    officeNames.forEach((office, index) => {
        const option = new Option(office, index + 1); // Month id starts from 1 for January
        officeDropdown.add(option);
    });
}
// ------------------------------- OFFICE FILTER OPTIONS END ------------------------------- 



// ------------------------------- REPORT TYPE FILTER OPTIONS START ------------------------------- 
export function reportTypeFilterV1(reportTypedropdownId){
	const ReportTypeNames = ["Summary","Detailed"];
    const ReportTypeDropdown = document.getElementById(reportTypedropdownId);

	 ReportTypeNames.forEach((val, index) => {
        const option = new Option(val, index + 1); // The id starts from 1 for All
        ReportTypeDropdown.add(option);
    });

}

//	---- Summary=1,Detailed=2 ----
// ------------------------------- REPORT TYPE FILTER OPTIONS START ------------------------------- 



















