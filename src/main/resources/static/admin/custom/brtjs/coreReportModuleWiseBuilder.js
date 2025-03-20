import { reportSections } from './coreReportData.js';

//VERSION 2:
export function coreReportModuleWiseBuilder(moduleId, EngTitleNameToAccess ,ArbTitleNameToAccess ,lang) 
{
    const container = document.getElementById(moduleId);

    if (!container) 
    {
        console.error(`Container with ID "${moduleId}" not found.`);
        return;
    }

    console.log("=========== Lab report builder here ===========");
    reportSections.filter(section => section.mainTitleStatus === 'Y' && (section.mainTitle === EngTitleNameToAccess || section.mainArabicTitle === ArbTitleNameToAccess))
        .forEach((section) => {
            let card = `
                <div class="row">
                    <div class="col-12">
                        <div class="card-body pad table-responsive">
                            <table class="table table-bordered text-center">
            `;

            const filteredReports = section.reports.filter(report => report.reportStatus === 'Y');

            for (let i = 0; i < filteredReports.length; i += 2) {
                card += `<tr>`;
                let reportsInRow = 1;
                for (let j = i; j < i + 2 && j < filteredReports.length; j++) 
                {
					let buttonTitle = (lang ==='en' ? filteredReports[j].buttonTitle: filteredReports[j].buttonArabicTitle);
                    card += `
                        <td class="${filteredReports[j].buttonClass}">
                            <button type="button" class="btn btn-block medas-linklist" data-toggle="modal" data-target="${filteredReports[j].modalTarget}">
                            ${filteredReports[j].buttonTitleNo}. ${buttonTitle}
                            </button>
                        </td>
                    `;
                    reportsInRow++;
                }
                if (reportsInRow < 2) {
                    let remainingSpace = 2 - reportsInRow;
                    let colspan = remainingSpace * 6;
                    card += `<td colspan="${colspan}"></td>`;
                }

                card += `</tr>`;
            }

            card += ` </table>
                    </div>
                </div>
            </div>
            `;
            container.innerHTML += card;
        });
}

//VERSION 1:
/*
export function coreReportModuleWiseBuilder(moduleId, EngTitleNameToAccess ,ArbTitleNameToAccess ,lang) 
{
    const container = document.getElementById(moduleId);

    if (!container) 
    {
        console.error(`Container with ID "${moduleId}" not found.`);
        return;
    }

    console.log("=========== Lab report builder here ===========");
    reportSections.filter(section => section.mainTitleStatus === 'Y' && (section.mainTitle === EngTitleNameToAccess || section.mainArabicTitle === ArbTitleNameToAccess))
        .forEach((section) => {
            let card = `
                <div class="row">
                    <div class="col-12">
                        <div class="card-body pad table-responsive">
                            <table class="table table-bordered text-center">
            `;

            const filteredReports = section.reports.filter(report => report.reportStatus === 'Y');

            for (let i = 0; i < filteredReports.length; i += 4) {
                card += `<tr>`;
                let reportsInRow = 0;
                for (let j = i; j < i + 4 && j < filteredReports.length; j++) 
                {
					let buttonTitle = (lang ==='en' ? filteredReports[j].buttonTitle: filteredReports[j].buttonArabicTitle);
                    card += `
                        <td class="${filteredReports[j].buttonClass}">
                            <button type="button" class="btn btn-block bg-gradient-primary" data-toggle="modal" data-target="${filteredReports[j].modalTarget}">
                            ${filteredReports[j].buttonTitleNo}. ${buttonTitle}
                            </button>
                        </td>
                    `;
                    reportsInRow++;
                }
                if (reportsInRow < 4) {
                    let remainingSpace = 4 - reportsInRow;
                    let colspan = remainingSpace * 3;
                    card += `<td colspan="${colspan}"></td>`;
                }

                card += `</tr>`;
            }

            card += ` </table>
                    </div>
                </div>
            </div>
            `;
            container.innerHTML += card;
        });
}
*/

/*  //OLD CODE: 18 March 2024
export function coreReportModuleWiseBuilder(moduleId, moduleNameToAccess , reportSections) 
{
    const container = document.getElementById(moduleId);

    if (!container) 
    {
        console.error(`Container with ID "${moduleId}" not found.`);
        return;
    }

    console.log("=========== Lab report builder here ===========");
    reportSections.filter(section => section.mainTitleStatus === 'Y' && section.mainTitle === moduleNameToAccess)
        .forEach((section) => {
            let card = `
                <div class="row">
                    <div class="col-12">
                        <div class="card-body pad table-responsive">
                            <table class="table table-bordered text-center">
            `;

            const filteredReports = section.reports.filter(report => report.reportStatus === 'Y');

            for (let i = 0; i < filteredReports.length; i += 4) {
                card += `<tr>`;
                let reportsInRow = 0;
                for (let j = i; j < i + 4 && j < filteredReports.length; j++) {
                    card += `
                        <td class="${filteredReports[j].buttonClass}">
                            <button type="button" class="btn btn-block bg-gradient-primary" data-toggle="modal" data-target="${filteredReports[j].modalTarget}">
                            ${filteredReports[j].buttonTitleNo}. ${filteredReports[j].buttonTitle}
                            </button>
                        </td>
                    `;
                    reportsInRow++;
                }
                if (reportsInRow < 4) {
                    let remainingSpace = 4 - reportsInRow;
                    let colspan = remainingSpace * 3;
                    card += `<td colspan="${colspan}"></td>`;
                }

                card += `</tr>`;
            }

            card += ` </table>
                    </div>
                </div>
            </div>
            `;
            container.innerHTML += card;
        });
}

$(document).ready(function() 
{ 
		titleTranslations(reportSections);
    	translateTitlesIfArabic(reportSections);
});
*/
