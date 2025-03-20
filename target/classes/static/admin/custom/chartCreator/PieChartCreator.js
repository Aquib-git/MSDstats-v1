import { openWindowCreator } from '../openWindowCreator/openWindowCreator.js';
import {LabelTranslationsData} from './LabelTranslationsData.js';

/* =========================================================== PIE CHART CREATOR function START =========================================================== */
//VERSION 2: Date created: 10 March 2024
export function PieChartCreator(ChartLabelElement,ChartDataElement,ChartNameElement,ChartColorElement,ChartHoverDescriptionElement,ChartUrlLogicElement,ChartLangElement)
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
					 data:ChartData ,
		      		 backgroundColor: ChartColorElement,
		      		 label: ChartHoverDescriptionElement,
      			  }]
    }
	
	var ChartOptions =
	{
		legend: {display: true},
		plugins:{
					labels:
					{
						render:'value',
						fontColor:'white',
						fontStyle:'bolder'
					},
					datalabels:
					{
						color:'white',
						fontStyle:'bolder',
						formatter:
							function(value,ctx)
							{
								return value>0?value:'';
							}
					}
				},
		onClick: function(event,element)
				 {
					if(ChartUrlLogicElement !== ""  && element.length>0)
					{
						//var url=ChartUrlLogicElement+ChartCreator.data.labels[element[0].index].trim(); //OLD: ORIGINAL CODE version 1
						var englishLabel = originalEnglishLabels[element[0].index].trim();
						var url = ChartUrlLogicElement+encodeURIComponent(englishLabel);
						openWindowCreator(url);
					}
				 }
	}
	
	var ChartCreator = new Chart(document.getElementById(ChartNameElement), {
		type: 'pie',
		data: ChartDataToDisplay,
		options: ChartOptions,
		plugins:[ChartDataLabels]

	});
	
}

/* =========================================================== PIE CHART CREATOR function END =========================================================== */


//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
												//LEGACY CODE -----> Do not delete the code below. Keep as referenece.
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

/*
//VERSION 1: First Month of January
export function PieChartCreatorOldV1(ChartLabelElement,ChartDataElement,ChartNameElement,ChartColorElement,ChartHoverDescriptionElement,ChartUrlLogicElement)
{
	var ChartLabel = ChartLabelElement.value.replace("[","").replace("]","").replaceAll("-MultiSpeciality","").split(",");
		
	var ChartData =  ChartDataElement.value.trim().replace("[","").replace("]","").split(",");
		
	var ChartDataToDisplay = 
	{	
		labels:ChartLabel,
		datasets: [{
					 data:ChartData ,
		      		 backgroundColor: ChartColorElement,
		      		 label: ChartHoverDescriptionElement,
      			  }]
    }
	
	var ChartOptions =
	{
		legend: {display: true},
		plugins:{
					labels:
					{
						render:'value',
						fontColor:'white',
						fontStyle:'bolder'
					},
					datalabels:
					{
						color:'white',
						fontStyle:'bolder',
						formatter:
							function(value,ctx)
							{
								return value>0?value:'';
							}
					}
				},
		onClick: function(event,element)
				 {
					if(ChartUrlLogicElement !== ""  && element.length>0)
					{
						var url=ChartUrlLogicElement+ChartCreator.data.labels[element[0].index].trim(); //ORIGINAL CODE
						openWindowCreator(url);
					}
				 }
	}
	
	var ChartCreator = new Chart(document.getElementById(ChartNameElement), {
		type: 'pie',
		data: ChartDataToDisplay,
		options: ChartOptions,
		plugins:[ChartDataLabels]

	});
	
}
*/
