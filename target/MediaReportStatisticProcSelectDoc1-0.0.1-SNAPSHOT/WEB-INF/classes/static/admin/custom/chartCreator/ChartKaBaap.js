import { openWindowCreator } from '../openWindowCreator/openWindowCreator.js';
import {LabelTranslationsData} from './LabelTranslationsData.js';

/* =========================================================== CHART GOD function START =========================================================== */
//VERSION 2: Modified on: 10 March 2024, Not Implemented. The logic is applied for Vertical Bar, Pie, Doughnut
export function ChartKaBaap(ChartLabelElement, ChartDataElement, ChartNameElement, ChartColorElement, ChartHoverDescriptionElement, ChartUrlLogicElement, ChartType, ChartLangElement) 
{
    var ChartLabel = ChartLabelElement.value.replace("[", "").replace("]", "").replaceAll("-MultiSpeciality", "").split(",").map(function (label) { return label.trim(); });

    // Make a copy of the original English labels for URL construction
    var originalEnglishLabels = [...ChartLabel];

    var ChartData = ChartDataElement.value.trim().replace("[", "").replace("]", "").split(",");

    if (ChartLangElement === 'ar')
    {
        ChartLabel = ChartLabel.map(label => LabelTranslationsData[label] || label);
    }

    var ChartDataToDisplay = 
    {
        labels: ChartLabel,
        datasets: [{
            data: ChartData,
            backgroundColor: ChartColorElement,
            label: ChartHoverDescriptionElement,
        }]
    }

    var ChartOptions = (function()
    {
        // Base options with onClick
        var options = 
        {
            onClick: function (event, element) 
            {
                if (ChartUrlLogicElement !== "" && element.length > 0) 
                {
                    var englishLabel = originalEnglishLabels[element[0].index].trim();
                    var url = ChartUrlLogicElement + encodeURIComponent(englishLabel);
                    openWindowCreator(url);
                }
            }
        };

        // Conditional logic for additional options
        if (ChartType === 'bar') 
        {
            Object.assign(
            //Vertical Bar Charts --> essential plugins ---> START
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
            }
            //Vertical Bar Charts --> essential plugins ---> END
            ,options); //Vertical Bar Chart Object closing tag
        } 
        else if (ChartType === 'pie') 
        {
            Object.assign( 
            //Pie Charts --> essential plugins ---> START
            {
					legend: {display: true},
					plugins:
					{
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
            }
            //Pie Charts --> essential plugins ---> END			 
            ,options);//PIE Object closing tag;
        }
        else if (ChartType === 'doughnut') 
        {
            Object.assign( 
            //Doughnut Charts --> essential plugins ---> START
            {
               		legend: {
								align:'end',
								labels:{ usePointStyle: true, padding: 20}
							},
					plugins:{
								datalabels:
								{ 
									color:'white',
									fontStyle:'bolder',
									align:'left',
									formatter:
												function(value,ctx)
												{
													return value>0?value:'';
												},
								}	
							},			 
            }
            //Doughnut Charts --> essential plugins ---> END
            ,options);//Doughnut Object closing tag;
        }
        return options;
    })();

    var ChartCreator = new Chart(document.getElementById(ChartNameElement), {
        type: ChartType,
        data: ChartDataToDisplay,
        options: ChartOptions,
        plugins: [ChartDataLabels]
    });
}

/* =========================================================== CHART GOD function END =========================================================== */

//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
												//LEGACY CODE -----> Do not delete the code below. Keep as referenece.
//----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

//VERSION 1: Before Jan 2024
/*
export function ChartKaBaap(ChartLabelElement,ChartDataElement,ChartNameElement,ChartColorElement,ChartHoverDescriptionElement,ChartUrlLogicElement,ChartType, ChartLangElement)
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
					 data:ChartData ,// [30, 17, 15, 19, 20],
		      		 backgroundColor: ChartColorElement,
		      		 label: ChartHoverDescriptionElement,
      			  }]
	}
	
	
	var ChartOptions =
	{
		// --------------------------- From here MAJOR CODE CHANGE will take place START ---------------------------
		
		// --------------------------- From here MAJOR CODE CHANGE will take place END ---------------------------
		
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
        type: ChartType,
        data: ChartDataToDisplay,
        options: ChartOptions,
        plugins: [ChartDataLabels]
    }); 
}
*/












