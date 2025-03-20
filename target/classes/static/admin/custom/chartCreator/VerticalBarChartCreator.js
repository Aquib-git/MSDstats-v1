import { openWindowCreator } from '../openWindowCreator/openWindowCreator.js';
import {LabelTranslationsData} from './LabelTranslationsData.js';

/* =========================================================== VERTICAL BAR CHART CREATOR function START =========================================================== */
//VERSION 2: Date created: 10 March 2024
export function VerticalBarChartCreator(ChartLabelElement,ChartDataElement,ChartNameElement,ChartColorElement,ChartHoverDescriptionElement,ChartUrlLogicElement,ChartLangElement)
{
	
	var ChartLabel = ChartLabelElement.value.replace("[","").replace("]","").replaceAll("-MultiSpeciality","").split(",").map(function(label){return label.trim();});
		
	// Make a copy of the original English labels for URL construction
    var originalEnglishLabels = [...ChartLabel];
    	
	var ChartData =  ChartDataElement.value.trim().replace("[","").replace("]","").split(",");
		
	if(ChartLangElement === 'ar')
	{
		ChartLabel=ChartLabel.map(label => LabelTranslationsData[label] || label);
	}	
		
	var ChartDataToDisplay = 
	{	
		labels:ChartLabel,
		datasets: [{
					 data:ChartData,
		      		 backgroundColor: ChartColorElement,
		      		 label: ChartHoverDescriptionElement,
      			  }]
    }
	
	var ChartOptions =
	{
		legend: {display: false},
		plugins:{
					legend: {display: false},
		  			labels:
		  			{
						render:'value',
						fontColor:'white',
						fontStyle:'bolder',
					 },
			 		datalabels:
			 		{
		        		labels:{ value:{ color:'white' } }
		        	}		
				 },
		scales:{
					// Array of Objects aplied here 
	  				yAxes: [{    ticks: { beginAtZero:true }	}]
			   },
		onClick: function(event,element)
				{
					if(ChartUrlLogicElement !== ""  && element.length>0)
					{
								let str=parseInt(element[0].index);
								let num=str+1;
								//var url = ChartUrlLogicElement+ChartCreator.data.labels[element[0].index].trim(); //OLD: ORIGINAL CODE version 1
								var englishLabel = originalEnglishLabels[element[0].index].trim();
								var url = ChartUrlLogicElement+encodeURIComponent(englishLabel);
								openWindowCreator(url);
					}
				}
	}
	
	var ChartCreator = new Chart( document.getElementById(ChartNameElement),{
        type: 'bar',
        data: ChartDataToDisplay,
        options: ChartOptions,
        plugins: [ChartDataLabels]
    }); 
	
}
/* =========================================================== VERTICAL BAR CHART CREATOR function END =========================================================== */



//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
												//LEGACY CODE -----> Do not delete the code below. Keep as referenece.
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
//VERSION 1: First Month of January
export function VerticalBarChartCreatorOldV1(ChartLabelElement,ChartDataElement,ChartNameElement,ChartColorElement,ChartHoverDescriptionElement,ChartUrlLogicElement)
{
	
	var ChartLabel = ChartLabelElement.value.replace("[","").replace("]","").replaceAll("-MultiSpeciality","").split(",");
		
	var ChartData =  ChartDataElement.value.trim().replace("[","").replace("]","").split(",");
		
	var ChartDataToDisplay = 
	{	
		labels:ChartLabel,
		datasets: [{
					 data:ChartData,
		      		 backgroundColor: ChartColorElement,
		      		 label: ChartHoverDescriptionElement,
      			  }]
    }
	
	var ChartOptions =
	{
		legend: {display: false},
		plugins:{
					legend: {display: false},
		  			labels:
		  			{
						render:'value',
						fontColor:'white',
						fontStyle:'bolder',
					 },
			 		datalabels:
			 		{
		        		labels:{ value:{ color:'white' } }
		        	}		
				 },
		scales:{
					// Array of Objects aplied here 
	  				yAxes: [{    ticks: { beginAtZero:true }	}]
			   },
		onClick: function(event,element)
				{
					if(ChartUrlLogicElement !== ""  && element.length>0)
					{
								let str=parseInt(element[0].index);
								let num=str+1;
								var url = ChartUrlLogicElement+ChartCreator.data.labels[element[0].index].trim();
								openWindowCreator(url);
							}
				}
	}
	
	var ChartCreator = new Chart( document.getElementById(ChartNameElement),{
        type: 'bar',
        data: ChartDataToDisplay,
        options: ChartOptions,
        plugins: [ChartDataLabels]
    }); 
	
}
*/



/*
//The below is Eslams code how he called the ChartLabel and ChartData. This is just for reference

	var ChartLabel = ChartLabelElement.value;
		ChartLabel = ChartLabel.replace("[","").replace("]","").replaceAll("-MultiSpeciality","").split(",");
	
	var ChartData =  ChartDataElement.value.trim();
		ChartData =  ChartData.replace("[","").replace("]","").split(",");


*/

