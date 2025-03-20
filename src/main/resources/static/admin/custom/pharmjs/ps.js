import { fetchAndPopulateMedicines } from '../formValidator/formValidator.js';
  //----------------------------- PHARM CHART FORM SUBMIT LOGIC START----------------------------------
			
document.addEventListener('DOMContentLoaded', function () {
    
    fetchAndPopulateMedicines('pharmItemId1');// Populate the medicines dropdown

    var form = document.getElementById('pharmStockId');

    form.addEventListener('submit', function (e)
     {
        e.preventDefault(); // Prevent the default form submission

        
        var selectedItem = $('#pharmItemId1').select2('data')[0]; // Assuming single selection
        var itemidPrime = selectedItem ? selectedItem.id : '0'; // Fallback to '0' if nothing is selected

        // Construct the query string with the selected item's ID
        var queryString = '?pharmItemid=' + encodeURIComponent(itemidPrime);

		window.location.href = form.getAttribute('action') + queryString;
        
       
    });
});

