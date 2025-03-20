/* global Chart:false */

$(function () {
  'use strict'

  /* ChartJS
   * -------
   * Here we will create a few charts using ChartJS
   */

// $('.daterange').daterangepicker({
 //   ranges: {
 //     Today: [moment(), moment()],
//      Yesterday: [moment().subtract(1, 'days'), moment().subtract(1, 'days')],
//      'Last 7 Days': [moment().subtract(6, 'days'), moment()],
 //     'Last 30 Days': [moment().subtract(29, 'days'), moment()],
//      'This Month': [moment().startOf('month'), moment().endOf('month')],
//      'Last Month': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
//    },
 //   startDate: moment().subtract(29, 'days'),
 //   endDate: moment()
//  }, function (start, end) {
    // eslint-disable-next-line no-alert
//    alert('You chose: ' + start.format('MMMM D, YYYY') + ' - ' + end.format('MMMM D, YYYY'))
//  })

  //-----------------------
  // - MONTHLY  CHART -
  //-----------------------

  // Get context with jQuery - using jQuery's .get() method.
  var hmpCategoryLabels = $("#hmpCategoryLabels").val();
  hmpCategoryLabels = hmpCategoryLabels.replace("[","").replace("]","").split(",");
  var hmpCategoryData = $("#hmpCategoryData").val().trim();
  hmpCategoryData = hmpCategoryData.replace("[","").replace("]","").split(",");
  
var healthManDoctorChartCanvas = $('#healthManDoctorChart').get(0).getContext('2d')
  var healthManDoctorChartData = {
	//labels: hmpCategoryLabels,
    labels: [
      'Nurses',
      'Pharmacusts',
      'Other ',
      'Radiographer Technician',
      'Radiographer Technologist',
      'Dentist',
      'Doctors'
    ],
    datasets: [
      {
        data:hmpCategoryData,
      //  data: [250, 41, 25, 100, 15,10],
        //backgroundColor: ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc','#d2d6de']
          backgroundColor: ['#00c0ef', '#f39c12', '#1f2d3d', '#3c8dbc', '#132f89','#00a65a','#f56954']
      }
    ]
   
  }
   var healthManDoctorChartOptions = {
    legend: {
      display: false
    },
    
     plugins:{
	  labels:[{
	
		render:'value',
		fontColor:'white',
		fontStyle:'bolder',
		
		},
		{
	   
		fontColor:'Blue',
		fontStyle:'bolder',
		position:'outside'
			
		}]
		
}
    
   
  }
  // Create pie or douhnut chart
  // You can switch between pie and douhnut using the method below.
  // eslint-disable-next-line no-unused-vars
  var healthManDoctorChart = new Chart(healthManDoctorChartCanvas, {
    type: 'doughnut',
    data: healthManDoctorChartData,
    options: healthManDoctorChartOptions
    //plugins:[ChartDataLabels]
    
   
  })

  //---------------------------
  // - END MONTHLY SALES CHART -
  //---------------------------

  //-------------
  // - PIE CHART -
  //-------------
  // Get context with jQuery - using jQuery's .get() method.
  var hmpBranchesLabels = $("#hmpBranchesLabels").val();
  hmpBranchesLabels = hmpBranchesLabels.replace("[","").replace("]","").split(",");
  var hmpBranchesData = $("#hmpBranchesData").val().trim();
  hmpBranchesData = hmpBranchesData.replace("[","").replace("]","").split(",");
  
  var hmpBranchesChartCanvas = $('#hmpBranchesChart').get(0).getContext('2d')
  var hmpBranchesChartData = {
    //labels: hmpBranchesLabels,
    labels: [
	  'Head Quarters',
	  'Sheikh Salem Camp',
	  'Summod Camp',
      'Tahreer Camp-Dental',
      'Tahreer Camp'
     
    ],
    datasets: [
      {
        data: hmpBranchesData,
        //data: [700, 500, 400, 600, 300],
        backgroundColor: ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc']
      }
    ]
   
  }
   var hmpBranchesChartOptions = {
    legend: {
      display: false
    },
    plugins:{
	  labels:[{
	
		render:'value',
		fontColor:'white',
		fontStyle:'bolder',
		
		},
		{
	   
		fontColor:'Blue',
		fontStyle:'bolder',
		position:'outside'
			
		}]
		
}
   
  }
  // Create pie or douhnut chart
  // You can switch between pie and douhnut using the method below.
  // eslint-disable-next-line no-unused-vars
  var hmpBranchesChartChart = new Chart(hmpBranchesChartCanvas, {
    type: 'pie',
    data: hmpBranchesChartData,
    options: hmpBranchesChartOptions
    //plugins:[ChartDataLabels]
    
   
  })

  //-----------------
  // - END PIE CHART -
  //-----------------
 
 
 // Get context with jQuery - using jQuery's .get() method.
 var hmpDoctorBranchesLabels = $("#hmpDoctorBranchesLabels").val();
  hmpDoctorBranchesLabels = hmpDoctorBranchesLabels.replace("[","").replace("]","").split(",");
  var hmpDoctorBranchesData = $("#hmpDoctorBranchesData").val().trim();
  hmpDoctorBranchesData = hmpDoctorBranchesData.replace("[","").replace("]","").split(",");
 
  var pieDoctorChartCanvas = $('#pieDoctorChart').get(0).getContext('2d')
  var pieDoctorData = {
    labels: [
	   'Head Quarters',
	  'Sheikh Salem Camp',
	  'Summod Camp',
      'Tahreer Camp-Dental',
      'Tahreer Camp'
      
    ],
    datasets: [
      {
          data:hmpDoctorBranchesData ,// [30, 17, 15, 19, 20],
          backgroundColor: ['#4b77a9', '#B27200', '#00c0ef','#5f255f','#d21243']
          //backgroundColor: ['#4b77a9' ,'#5f255f','#d21243','#B27200','#00c0ef']
      }
    ]
   
  }
   var pieDoctorOptions = {
    legend: {
      display: false
    },
    
    
    plugins:{
	labels:{
	
		//render:'value',
		fontColor:'white',
		fontStyle:'bolder'
		}
	 // labels:[{
	
		//render:'value',
	//	fontColor:'white',
	//	fontStyle:'bolder',
		
	//	}
	//	,
	//	{
	   
		//fontColor:'Blue',
		//fontStyle:'bolder',
	//	position:'outside'
			
	//	}]
		
}
   
  }
  // Create pie or douhnut chart
  // You can switch between pie and douhnut using the method below.
  // eslint-disable-next-line no-unused-vars
  var pieDoctorChart = new Chart(pieDoctorChartCanvas, {
    type: 'doughnut',
    data: pieDoctorData,
    options: pieDoctorOptions
    //plugins:[ChartDataLabels]
    
   
  })

  //-----------------
  // - END PIE CHART -
  //-----------------
  
  
  
   //-------------
    //- BAR CHART -
    //-------------
  var hmpPatientVisitLabels = $("#hmpPatientVisitLabels").val();
  hmpPatientVisitLabels = hmpPatientVisitLabels.replace("[","").replace("]","").split(",");
  var hmpPatientVisitData = $("#hmpPatientVisitData").val().trim();
  hmpPatientVisitData = hmpPatientVisitData.replace("[","").replace("]","").split(",");
    
      var areaBarChartData = {
      labels  : hmpPatientVisitLabels,// ['2017', '2018', '2019', '2020', '2021', '2022', '2023'],
      datasets: [
         {
	       label  : 'Out-Patient Visits',
           data: hmpPatientVisitData ,//[150, 400, 530, 600, 450,800,250],
       // backgroundColor: ['#f56954', '#00a65a','#f39c12','#00c0ef','#3c8dbc']
          backgroundColor: ['#5f255f','#d21243','#B27200','#00c0ef','green'],
        //  backgroundColor: ['#4b77a9' ,'#5f255f','#d21243','#B27200','#00c0ef','green'],
          
          
        
          borderColor         : 'rgba(60,141,188,0.8)',
          pointRadius          : false,
          pointColor          : '#3b8bba',
          pointStrokeColor    : 'rgba(60,141,188,1)',
          pointHighlightFill  : '#fff',
          pointHighlightStroke: 'rgba(60,141,188,1)',
          data: hmpPatientVisitData //[150, 400, 530, 600, 450,800,250]
          
      }
      ]
    }

   
    var barChartCanvas = $('#barChart').get(0).getContext('2d')
    var barChartData = $.extend(true, {}, areaBarChartData)
    

    var barBarOptions = {
      responsive              : true,
      maintainAspectRatio     : false,
     // datasetFill             : false,
      plugins:{
	   labels:{
		render:'value',
		fontColor:'white',
		fontStyle:'bolder',
		arc:true,
		positon:'outside',
		overlap:false
		}
		
}
      
     
       }
    

    new Chart(barChartCanvas, {
      type: 'bar',
      data: barChartData,
      options: barBarOptions,
      
    })
  
  
  
  
  
   //- DONUT CHART -
    //-------------
    // Get context with jQuery - using jQuery's .get() method.
   var hmpPatientDeptLabels = $("#hmpPatientDeptLabels").val();
  hmpPatientDeptLabels = hmpPatientDeptLabels.replace("[","").replace("]","").split(",");
  var hmpPatientDeptData = $("#hmpPatientDeptData").val().trim();
  hmpPatientDeptData = hmpPatientDeptData.replace("[","").replace("]","").split(",");
  
    var donutVisitChartCanvas = $('#donutVisitChart').get(0).getContext('2d')
    var donutVisitData        = {
      labels: hmpPatientDeptLabels,
       // [ 'General Paractice', 'Dental','Internal Medical','Surgical','EMS','Emergeny Medical','Nutrition','Allergy','Cardiology','Ophthalmology','physiotherapy',],
      datasets: [
        {
          data: hmpPatientDeptData, //[104,50,60,48,30,43,60,20,15,42,70,40],
          backgroundColor : ['#5f255f','#9ba8b7','#2b78fd','#e11011', '#f10bf1', '#260326fc' ,'#00c0ef','#27a544','#000080','#4b77a9', '#d21243', '#ff5e07','#6610f2', '#1f2d3d','#7FFF00','#800000','#808000','#B27200'],
         // ['#f56954', '#00a65a', '#f39c12', '#00c0ef', '#3c8dbc', '#d2d6de','#f56954', '#00a65a', '#f39c12','#3c8dbc', '#d2d6de'],
         
        }
      ]
    }
    var donutVisitOptions     = {
        maintainAspectRatio : false,
        responsive : true,
        legend: {
      display: false
    },
        plugins:{
	    labels:{
	
		//render:'value',
		fontColor:'white',
		fontStyle:'bolder'
		}
		
}
      }
    //Create pie or douhnut chart
    // You can switch between pie and douhnut using the method below.
    new Chart(donutVisitChartCanvas, {
      type: 'doughnut',
      data: donutVisitData,
      options: donutVisitOptions
     // plugins:[ChartDataLabels]
    })
  
 
  /* jVector Maps
   * ------------
   * Create a world map with markers
   */
  $('#world-map-markers').mapael({
    map: {
      name: 'usa_states',
      zoom: {
        enabled: true,
        maxLevel: 10
      }
    }
  })
  
  
   


  // $('#world-map-markers').vectorMap({
  //   map              : 'world_en',
  //   normalizeFunction: 'polynomial',
  //   hoverOpacity     : 0.7,
  //   hoverColor       : false,
  //   backgroundColor  : 'transparent',
  //   regionStyle      : {
  //     initial      : {
  //       fill            : 'rgba(210, 214, 222, 1)',
  //       'fill-opacity'  : 1,
  //       stroke          : 'none',
  //       'stroke-width'  : 0,
  //       'stroke-opacity': 1
  //     },
  //     hover        : {
  //       'fill-opacity': 0.7,
  //       cursor        : 'pointer'
  //     },
  //     selected     : {
  //       fill: 'yellow'
  //     },
  //     selectedHover: {}
  //   },
  //   markerStyle      : {
  //     initial: {
  //       fill  : '#00a65a',
  //       stroke: '#111'
  //     }
  //   },
  //   markers          : [
  //     {
  //       latLng: [41.90, 12.45],
  //       name  : 'Vatican City'
  //     },
  //     {
  //       latLng: [43.73, 7.41],
  //       name  : 'Monaco'
  //     },
  //     {
  //       latLng: [-0.52, 166.93],
  //       name  : 'Nauru'
  //     },
  //     {
  //       latLng: [-8.51, 179.21],
  //       name  : 'Tuvalu'
  //     },
  //     {
  //       latLng: [43.93, 12.46],
  //       name  : 'San Marino'
  //     },
  //     {
  //       latLng: [47.14, 9.52],
  //       name  : 'Liechtenstein'
  //     },
  //     {
  //       latLng: [7.11, 171.06],
  //       name  : 'Marshall Islands'
  //     },
  //     {
  //       latLng: [17.3, -62.73],
  //       name  : 'Saint Kitts and Nevis'
  //     },
  //     {
  //       latLng: [3.2, 73.22],
  //       name  : 'Maldives'
  //     },
  //     {
  //       latLng: [35.88, 14.5],
  //       name  : 'Malta'
  //     },
  //     {
  //       latLng: [12.05, -61.75],
  //       name  : 'Grenada'
  //     },
  //     {
  //       latLng: [13.16, -61.23],
  //       name  : 'Saint Vincent and the Grenadines'
  //     },
  //     {
  //       latLng: [13.16, -59.55],
  //       name  : 'Barbados'
  //     },
  //     {
  //       latLng: [17.11, -61.85],
  //       name  : 'Antigua and Barbuda'
  //     },
  //     {
  //       latLng: [-4.61, 55.45],
  //       name  : 'Seychelles'
  //     },
  //     {
  //       latLng: [7.35, 134.46],
  //       name  : 'Palau'
  //     },
  //     {
  //       latLng: [42.5, 1.51],
  //       name  : 'Andorra'
  //     },
  //     {
  //       latLng: [14.01, -60.98],
  //       name  : 'Saint Lucia'
  //     },
  //     {
  //       latLng: [6.91, 158.18],
  //       name  : 'Federated States of Micronesia'
  //     },
  //     {
  //       latLng: [1.3, 103.8],
  //       name  : 'Singapore'
  //     },
  //     {
  //       latLng: [1.46, 173.03],
  //       name  : 'Kiribati'
  //     },
  //     {
  //       latLng: [-21.13, -175.2],
  //       name  : 'Tonga'
  //     },
  //     {
  //       latLng: [15.3, -61.38],
  //       name  : 'Dominica'
  //     },
  //     {
  //       latLng: [-20.2, 57.5],
  //       name  : 'Mauritius'
  //     },
  //     {
  //       latLng: [26.02, 50.55],
  //       name  : 'Bahrain'
  //     },
  //     {
  //       latLng: [0.33, 6.73],
  //       name  : 'São Tomé and Príncipe'
  //     }
  //   ]
  // })
})

// lgtm [js/unused-local-variable]



  
  
