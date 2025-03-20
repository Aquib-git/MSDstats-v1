import { coreReportModuleWiseBuilder } from '../brtjs/coreReportModuleWiseBuilder.js';

document.addEventListener("DOMContentLoaded", function()
{  
  		const lang = new URLSearchParams(window.location.search).get('lang');
  		console.log("Language value is: " + lang);
  		coreReportModuleWiseBuilder("dynamicLabReportContainer", "Investigation","تحقيق", lang);
});




















/* //OLD CODE: 18 March 2024
document.addEventListener("DOMContentLoaded", function()
{
    // Apply translations based on the 'lang' parameter
    
     $(document).ready(function() 
	{ 
		titleTranslations();
    	translateTitlesIfArabic(reportSections);
    });
    

    // Now, generate the report content with possibly translated titles
    coreReportModuleWiseBuilder("dynamicLabReportContainer", "Investigation", reportSections);
    
    
    
});
*/




/*import {coreReportModuleWiseBuilder} from '../brtjs/coreReportModuleWiseBuilder.js';
import {reportSections,titleTranslations,translateTitlesIfArabic} from '../brtjs/coreReportData.js';

document.addEventListener("DOMContentLoaded", function() 

{
	
	
	
	
	coreReportModuleWiseBuilder("dynamicLabReportContainer", "Investigation", reportSections);
	
	
			titleTranslations(reportSections);
    	//translateTitlesIfArabic(reportSections);


    
    
});
*/

/*		
import { coreReportModuleWiseBuilder } from '../brtjs/coreReportModuleWiseBuilder.js';
import { reportSections, translateTitles } from '../brtjs/coreReportData.js';

document.addEventListener("DOMContentLoaded", function() {
    // Apply translations based on the 'lang' parameter
    translateTitles(reportSections);

    // Now, generate the report content with possibly translated titles
    coreReportModuleWiseBuilder("dynamicLabReportContainer", "Investigation", reportSections);
});

*/