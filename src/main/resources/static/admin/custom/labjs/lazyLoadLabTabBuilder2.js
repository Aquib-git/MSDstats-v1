
import { labChartBuilder } from "./labChartBuilder.js";
import {labReportBuilder} from "./labReportBuilder.js";
import {lc} from "./lc.js";


//VERSION 2:
export function lazyLoadLabTabBuilder2(tabId, element) {
    fetch(`/labtab?tabName=${tabId}`)
        .then(response => response.text())
        .then(html => {
            // Insert the fetched HTML into the target content div
            const contentDiv = document.getElementById(`${tabId}Content`);
            contentDiv.innerHTML = html;

            // After the HTML content is set, you can now attach the event listeners
            
            // -------------------------------------- LAB CHART TAB FUNCTIONS called here START --------------------------------------   
   
            if(tabId === 'labChart') 
            {
                lc(); // Attach the event listener to the form
                labChartBuilder(); // Initialize the chart
            }
            // -------------------------------------- LAB CHART TAB FUNCTIONS called here end --------------------------------------   
   
   			// -------------------------------------- LAB REPORT TAB FUNCTIONS called here START --------------------------------------   
   
             else if (tabId === 'labReport') 
            {
                labReportBuilder();
            }
			// -------------------------------------- LAB REPORT TAB FUNCTIONS called here END --------------------------------------   
   
            // Update the active state for the clicked tab
            document.querySelectorAll('.nav-link').forEach(link => {
                link.classList.remove('active');
            });
            element.classList.add('active');

            // Show the active tab's content and hide others
            document.querySelectorAll('.tab-pane').forEach(tabContent => {
                tabContent.classList.remove('active');
            });
            contentDiv.classList.add('active');
        })
        .catch(error => {
            console.error('Error loading the tab content:', error);
        });
}




























//VERSION 1: SOME WHAT WORKING
/*
export function lazyLoadLabTabBuilder2(tabId, element) 
{
	
    // Making an AJAX call to the Spring controller to fetch the Thymeleaf fragment
   fetch(`/labtab?tabName=${tabId}`).then(response => response.text()).then(html => 
   {
            // Insert the fetched HTML into the target content div
            document.getElementById(`${tabId}Content`).innerHTML = html;

            // Update the active state for the clicked tab
            document.querySelectorAll('.nav-link').forEach(function(link){
                	link.classList.remove('active');
            	});
            element.classList.add('active');

            // Show the active tab's content and hide others
            document.querySelectorAll('.tab-pane').forEach(function(tabContent){
                	tabContent.classList.remove('active');
            	});
            document.getElementById(`${tabId}Content`).classList.add('active');
            
       // -------------------------------------- LAB CHART TAB FUNCTIONS called here START --------------------------------------   
        if(tabId === 'labChart') 
         {
			lc();//validation logic and form submission applied here
			labChartBuilder();
			
         }
       // -------------------------------------- LAB CHART TAB FUNCTIONS called here END --------------------------------------   
             
       // -------------------------------------- LAB REPORTS TAB FUNCTIONS called here START --------------------------------------
	    if (tabId === 'labReport') 
	      {
	         labReportBuilder();
	      } 
	   // -------------------------------------- LAB REPORTS TAB FUNCTIONS called here START --------------------------------------
       

     })
    .catch(error => {   console.error('Error loading the tab content:', error); });
}
*/

