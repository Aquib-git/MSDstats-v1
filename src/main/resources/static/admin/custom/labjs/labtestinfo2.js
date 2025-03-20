import { formDateValidator } from '../formValidator/formValidator.js';

document.addEventListener('DOMContentLoaded', function () {
    var form = document.getElementById('formBean');
    var fromDateInput = document.getElementById('fdate');
    var toDateInput = document.getElementById('tdate');
    var errorMessage = document.getElementById('error-message');

    form.addEventListener('submit', function (e) {
        var fromDate = fromDateInput.value;
        var toDate = toDateInput.value;

        if (!formDateValidator(fromDate, toDate, errorMessage)) {
            e.preventDefault(); // Prevent form submission if validation fails
        }
    });
});
