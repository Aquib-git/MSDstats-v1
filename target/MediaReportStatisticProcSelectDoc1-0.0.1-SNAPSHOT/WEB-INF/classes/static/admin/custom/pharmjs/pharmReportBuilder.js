import {coreReportModuleWiseBuilder} from '../brtjs/coreReportModuleWiseBuilder.js';

document.addEventListener("DOMContentLoaded", function() 
{
	const lang = new URLSearchParams(window.location.search).get('lang');
  	console.log("Language value is: " + lang);
    coreReportModuleWiseBuilder("dynamicPharmReportContainer", "Pharmacy", "الصيدلية",lang);
});
			
