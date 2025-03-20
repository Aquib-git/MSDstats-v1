import { reportSections } from './coreReportData.js';


//VERSION 4:
document.addEventListener("DOMContentLoaded", function() 
{
    const container = document.getElementById("dynamicReportContainer");

    // Filter out Headers where mainTitleStatus === 'Y' (Active Heading), 'N'(Passive Heading)
    reportSections.filter(section => section.mainTitleStatus === 'Y')
    			  .forEach((section) => 
    {
        let card = `
	            <div class="row">
	                <div class="col-12">
	                    <div class="card card-success collapsed-card">
	                        <div class="card-header" data-card-widget="collapse">
	                            <h3 class="card-title">${section.mainTitleNo}. ${section.mainTitle}</h3>
	                            <!-- Other header elements -->
	                        </div>
	                        <!-- Card Body -->
	                        <div class="card-body pad table-responsive">
	                            <table class="table table-bordered text-center">
              `;

        // Filter out reports where reportStatus==='Y' (Active Report), 'N'(Passive Report)
        const filteredReports = section.reports.filter(report => report.reportStatus === 'Y');

        // 4 Reports in one line logic
        for (let i = 0; i < filteredReports.length; i += 4) 
        {
            card += `<tr>`;
            let reportsInRow = 0;
            for (let j = i; j < i + 4 && j < filteredReports.length; j++) 
            {
                card += `
	                    <td class="${filteredReports[j].buttonClass}">
	                        <button type="button" class="btn btn-block bg-gradient-primary" data-toggle="modal" data-target="${filteredReports[j].modalTarget}">
	                        ${filteredReports[j].buttonTitleNo}. ${filteredReports[j].buttonTitle}
	                        </button>
	                    </td>
                       `;
               reportsInRow++;
            }
            	// Void column space logic if the number of reports is less than 4. 
			if (reportsInRow < 4) 
			{
				 let remainingSpace = 4 - reportsInRow; 
				 let colspan = remainingSpace * 3; // since each report takes col-md-3
				// card += `<td class="col-md-${colspan}"></td>`;
				 card += `<td colspan="${colspan}"></td>`;
			}
            
            card += `</tr>`;
        }

	        card += ` </table>
			            </div>
			            <!-- End Card Body -->
			        </div>
			    </div>
			</div>
				`;
        container.innerHTML += card;
    });
}
);
//VERSION 3: Stable version before 31 jan 2024 



/*
document.addEventListener("DOMContentLoaded", function() 
{
    const container = document.getElementById("dynamicReportContainer");

    // Filter out Headers where mainTitleStatus === 'Y' (Active Heading), 'N'(Passive Heading)
    reportSections.filter(section => section.mainTitleStatus === 'Y')
    			  .forEach((section) => 
    {
        let card = `
	            <div class="row">
	                <div class="col-12">
	                    <div class="card card-success collapsed-card">
	                        <div class="card-header" data-card-widget="collapse">
	                            <h3 class="card-title">${section.mainTitleNo}. ${section.mainTitle}</h3>
	                            <!-- Other header elements -->
	                        </div>
	                        <!-- Card Body -->
	                        <div class="card-body pad table-responsive">
	                            <table class="table table-bordered text-center">
              `;

        // Filter out reports where reportStatus==='Y' (Active Report), 'N'(Passive Report)
        const filteredReports = section.reports.filter(report => report.reportStatus === 'Y');

        // 4 Reports in one line logic
        for (let i = 0; i < filteredReports.length; i += 4) 
        {
            card += `<tr>`;
            for (let j = i; j < i + 4 && j < filteredReports.length; j++) 
            {
                card += `
	                    <td class="${filteredReports[j].buttonClass}">
	                        <button type="button" class="btn btn-block bg-gradient-primary" data-toggle="modal" data-target="${filteredReports[j].modalTarget}">
	                        ${filteredReports[j].buttonTitleNo}. ${filteredReports[j].buttonTitle}
	                        </button>
	                    </td>
                       `;
            }
            card += `</tr>`;
        }

	        card += ` </table>
			            </div>
			            <!-- End Card Body -->
			        </div>
			    </div>
			</div>
				`;
        container.innerHTML += card;
    });
}
);
*/
