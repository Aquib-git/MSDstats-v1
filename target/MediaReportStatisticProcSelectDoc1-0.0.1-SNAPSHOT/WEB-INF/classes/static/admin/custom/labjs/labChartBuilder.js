import { VerticalBarChartCreator } from '../chartCreator/VerticalBarChartCreator.js';


export function labChartBuilder()
{
	 //LAB Sample collection chart Logic
      var sampleCollectChartLabels = document.getElementById("sampleCollectChartLabels");
	  var sampleCollectChartData = document.getElementById("sampleCollectChartData");
	  var sampleCollectChartName = `sampleCollectChart`; //This has to be same as the id present in the canvas
	  var sampleCollectChartColor = ['#4b77a9', '#B27200', '#00c0ef','#5f255f','#d21243'];
	  var sampleCollectHoverDescription= `Sample Collect`;
	  var sampleCollectByOfficeUrlLogic=`./sampleCollectInfoWithOffice?OfficeName=`;
	  
	  VerticalBarChartCreator(sampleCollectChartLabels,sampleCollectChartData,sampleCollectChartName,sampleCollectChartColor,sampleCollectHoverDescription,sampleCollectByOfficeUrlLogic);
             
      //LAB Accession acknowledge chart logic
      var accessionChartLabels = document.getElementById("accessAcknwldgChartLabels");
	  var accessionChartData = document.getElementById("accessAcknwldgChartData");
	  var accessionChartName = `accessAcknwldgChart`; //This has to be same as the id present in the canvas
	  var accessCollectChartColor = ['#4b77a9', '#B27200', '#00c0ef','#5f255f','#d21243'];
	  var accessionHoverDescription= `Accession`;
	  var accessionByOfficeUrlLogic=`./accessAcknwldgInfoWithOffice?OfficeName=`;
	  
	  VerticalBarChartCreator(accessionChartLabels,accessionChartData,accessionChartName,accessCollectChartColor,accessionHoverDescription,accessionByOfficeUrlLogic);
}

