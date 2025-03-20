import { buildLabReport } from './labReportBuilder.js';

export function lazyLoadLabTabBuilder(tabName, element) 
{
	        $('.nav-link').removeClass('active');
	        $(element).addClass('active');
	        let contentId = '#' + tabName + 'Content'; 
	
	        $.ajax(
		    {
	            url: '/labtab/' + tabName,
	            success: function(data) 
	            {
	                $(contentId).html(data).addClass('active');
	                $('.tab-pane').not(contentId).removeClass('active');
	                
	                
	                /* -------------------------------------- LAB REPORTS TAB FUNCTIONS called here START --------------------------------------*/
	            	if (tabName === 'labReport') 
	            	 {
	                	buildLabReport();
	           		 } 
	           		/* -------------------------------------- LAB REPORTS TAB FUNCTIONS called here START --------------------------------------*/
	            	
	             },
	            error: function() 
	            {
	                $(contentId).html('Error loading content');
	            }
	        });
}


//window.lazyLoadLabTabBuilder = lazyLoadLabTabBuilder;