import { openWindowCreator } from '../openWindowCreator/openWindowCreator.js';

/* =========================================================== VERTICAL BAR CHART CREATOR function START =========================================================== */
//type:'bar'
export function VerticalBarChartCreator(ChartLabelElement,ChartDataElement,ChartNameElement,ChartColorElement,ChartHoverDescriptionElement,ChartUrlLogicElement)
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
					/* Array of Objects aplied here */
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

/* =========================================================== VERTICAL BAR CHART CREATOR function END =========================================================== */



/*
//The below is Eslams code how he called the ChartLabel and ChartData. This is just for reference

	var ChartLabel = ChartLabelElement.value;
		ChartLabel = ChartLabel.replace("[","").replace("]","").replaceAll("-MultiSpeciality","").split(",");
	
	var ChartData =  ChartDataElement.value.trim();
		ChartData =  ChartData.replace("[","").replace("]","").split(",");


*/

