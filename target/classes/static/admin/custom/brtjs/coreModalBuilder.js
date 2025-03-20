import { modalSections } from './coreModalData.js';
import { reportSections } from './coreReportData.js'; 

document.addEventListener("DOMContentLoaded", function() 
{
    const modalContainer = document.getElementById('modalContainer');

    reportSections.forEach(section => 
    {
        if (section.mainTitleStatus === 'Y') 
        {
            section.reports.forEach(report =>
             {
                if (report.reportStatus === 'Y') 
                {
                    const button = document.querySelector(`[data-target="${report.modalTarget}"]`);
                    if (button) 
                    {
						console.log('Before click')
                        button.addEventListener('click', function()
                         {
							 console.log('Inside click');
							 //After satisfying the various filtration criteria it will execute modalBuilder().
                            const modalHTML = modalBuilder(report.modalTarget);
                            console.log('modalBuilder function has been called');
                            modalContainer.innerHTML = modalHTML;
                            // After appending the modal, you might need to activate it with Bootstrap's JavaScript
                            $(report.modalTarget).modal('show');
                        });
                    }
                }
            });
        }
    });
});


function modalBuilder(modalTargetValue) 
{
    // Find the relevant section data
    const modalData = modalSections.find((modalSection) => modalSection.modalId === modalTargetValue);
     console.log('Inside modalBuilder with modalTargetValue:', modalTargetValue);
    console.log('Sending modalData to server:', modalData);
    
	// AJAX Logic to communicate from client to thymelaf server side rendering START
    fetch('/renderBirtModalTemplate', 
    {
        method: 'POST',
        headers: 
        {
            'Content-Type': 'application/json',
            // CSRF token if necessary
        },
        body: JSON.stringify(modalData)
    })
    .then((response) => 
    { 
		console.log('Received response from server:', response);
		if (!response.ok)
		 {
            		throw new Error('Server responded with status: ' + response.status);
       	 }
		return response.text();
	})
    .then((html) => 
    {
        // Inject the Thymeleaf-rendered HTML into the modal container
        console.log('HTML returned from server:', html);
        document.getElementById('modalContainer').innerHTML = html;
        // Show the modal
        $(modalTargetValue).modal('show');
       
    })
    .catch((error) =>
    {
		 console.error('Error during fetch operation:', error);
	});
   // AJAX Logic to communicate from client to thymelaf server side rendering START  
}













