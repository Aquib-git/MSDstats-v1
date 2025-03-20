export const reportSections = 
[    
	{
		mainTitleNo: 1,
        mainTitle: "General",
        mainArabicTitle:"عام",
        mainTitleStatus:'Y',
        reports: 
        [
            {
				 buttonTitleNo:1,
				 buttonTitle: "Emergency Services", 
				 buttonArabicTitle:"الخدمات الطارئة",
            	 modalTarget: "#esmodal", 
            	 buttonClass: "col-md-3" ,
            	 reportStatus:'Y'
            },
        ]
    },
    
    {
		mainTitleNo: 2,
        mainTitle: "Investigation",
        mainArabicTitle: "تحقيق",
        mainTitleStatus:'Y',
        reports: 
        [
            {
				 buttonTitleNo:1,
				 buttonTitle: "KNG Xray tests taken", 
				 buttonArabicTitle:"اختبارات الأشعة السينية للحرس الوطني",
            	 modalTarget: "#xrayModal", 
            	 buttonClass: "col-md-3" ,
            	 reportStatus:'Y'
            },
            {
				 buttonTitleNo:2,
				 buttonTitle: "KNG Lab tests taken",
				 buttonArabicTitle:"اختبارات المختبر للحرس الوطني",
				 modalTarget: "#labModal", 
				 buttonClass: "col-md-3" ,
				 reportStatus:'Y'
			},
			{
				 buttonTitleNo:3,
				 buttonTitle: "KNG Lab Patient Collected Count",
				 buttonArabicTitle:"تعدد المرضى الذين تم جمعهم في مختبر",
				 modalTarget: "#labPatCollectModal", 
				 buttonClass: "col-md-3" ,
				 reportStatus:'Y'
			},
			{
				 buttonTitleNo:4,
				 buttonTitle: "KNG Lab Patient Accessed Count",
				 buttonArabicTitle:"عدد المرضى الذين تم الوصول إليهم في مختبر",
				 modalTarget: "#labPatAccessedModal", 
				 buttonClass: "col-md-3" ,
				 reportStatus:'Y'
			},
			{
				 buttonTitleNo:5,
				 buttonTitle: "KNG Lab Patient Processed Count",
				 buttonArabicTitle:"تمت معالجة عدد المرضى في مختبر",
				 modalTarget: "#labpcpModal", 
				 buttonClass: "col-md-3" ,
				 reportStatus:'Y'
			},
        ]
    },
    
    
    {
		mainTitleNo: 3,
        mainTitle: "Patient Visit",
        mainArabicTitle:"زيارة المريض",
        mainTitleStatus:'Y',
        reports: 
        [
            { 
				buttonTitleNo:1,
				buttonTitle: "Patient visits by Doctor,Dept Report", 
				buttonArabicTitle:"زيارات المرضى حسب تقرير الطبيب، القسم",
				modalTarget: "#pvbddrModal",
				buttonClass: "col-md-3" ,
				reportStatus:'Y'
			},
            { 
				buttonTitleNo:2,
				buttonTitle: "Chronic Patients Detailed", 
				buttonArabicTitle:"تفاصيل المرضى المزمنين",
            	modalTarget: "#cpdModal", 
            	buttonClass: "col-md-3",
				reportStatus:'Y'
             },
           	{ 
				buttonTitleNo:3,  
				buttonTitle: "Patient Yearly Visits per Speciality",
				buttonArabicTitle:"الزيارات السنوية للمرضى حسب التخصص",
				modalTarget: "#pyvpsModal",
				buttonClass: "col-md-3" ,
				reportStatus:'Y'
			},
           	{ 
				buttonTitleNo:4, 
				buttonTitle: "Patient Yearly Visits Categorized By Procedure",
				buttonArabicTitle:"الزيارات السنوية للمرضى مصنفة حسب الإجراء",
				modalTarget: "#pyvcbpModal",
				buttonClass: "col-md-3",
				reportStatus:'Y' 
			},
           	{ 
				buttonTitleNo:5, 
				buttonTitle: "Patient Visits Categorized By Procedure-Doctor Wise(Quarter)", 
				buttonArabicTitle:"زيارات المرضى مصنفة حسب الإجراء- حسب الطبيب (ربع سنوي)",
				modalTarget: "#pvcbpdwModal",
				buttonClass: "col-md-3",
				reportStatus:'Y'
		 	},
           	{ 
				buttonTitleNo:6, 
				buttonTitle: "Speciality Visits",
				buttonArabicTitle:"زيارات التخصص",
				modalTarget: "#svModal",
				buttonClass: "col-md-3" ,
				reportStatus:'Y'
			},
           	{
				buttonTitleNo:7, 
				buttonTitle: "Patient Count",
				buttonArabicTitle:"عدد المرضى",
				modalTarget: "#pcModal",
				buttonClass: "col-md-3" ,
				reportStatus:'Y'
			},
           	{ 
				buttonTitleNo:8, 
				buttonTitle: "Visit Count",
				buttonArabicTitle:"عدد الزيارات",
				modalTarget: "#vcModal",
				buttonClass: "col-md-3",
				reportStatus:'Y' 
			},
			{ 
				buttonTitleNo:9, 
				buttonTitle: "Patient Visit-Officer,Soldier,Civilian,Family",
				buttonArabicTitle:"زيارة المريض- ضابط، جندي، مدني، عائلة",
				modalTarget: "#pvoscfModal",
				buttonClass: "col-md-3",
				reportStatus:'Y' 
			},
			{ 
				buttonTitleNo:10, 
				buttonTitle: "Patient Monthly Visits per Speciality",
				buttonArabicTitle:"الزيارات الشهرية للمرضى حسب التخصص",
				modalTarget: "#pmvpsModal",
				buttonClass: "col-md-3" ,
				reportStatus:'Y'
			},
			{ 
				buttonTitleNo:11, 
				buttonTitle: "Patient Monthly Visits Categorized by Procedure",
				buttonArabicTitle:"الزيارات الشهرية للمرضى مصنفة حسب الإجراء",
				modalTarget: "#pmvcbpModal",
				buttonClass: "col-md-3",
				reportStatus:'N' 
			},
        ]
    },
    
    {
		mainTitleNo: 4,
        mainTitle: "Pharmacy",
        mainArabicTitle:"الصيدلية",
        mainTitleStatus:'Y',
        reports: 
        [
			{ 
				buttonTitleNo:1, 
				buttonTitle: "Medicine Stock-Clinic wise",
				buttonArabicTitle:"مخزون الأدوية- حسب العيادة",
				modalTarget: "#mscwModal",
				buttonClass: "col-md-3",
				reportStatus:'Y' 
			},
			
			{ 
				buttonTitleNo:2, 
				buttonTitle: "Medicine by KNG Pharmacy",
				buttonArabicTitle:"الأدوية من صيدلية الحرس الوطني",
				modalTarget: "#mbkpModal",
				buttonClass: "col-md-3",
				reportStatus:'Y' 
			},
			
			{ 
				buttonTitleNo:3, 
				buttonTitle: "Pharmacy Visit History Report",
				buttonArabicTitle:"تقرير تاريخ زيارات الصيدلية",
				modalTarget: "#pvhrModal",
				buttonClass: "col-md-3" ,
				reportStatus:'Y'
			},
			
			{ 
				buttonTitleNo:4, 
				buttonTitle: "Pharmacy Visit-Officer,Soldier,Civilian,Family",
				buttonArabicTitle: "زيارة الصيدلية- ضابط، جندي، مدني، عائلة",
				modalTarget: "#phavoscfModal",
				buttonClass: "col-md-3" ,
				reportStatus:'Y'
			},
			
			{ 
				buttonTitleNo:5, 
				buttonTitle: "Pharmacy Items Total Dispensed Report",
				buttonArabicTitle:"تقرير إجمالي الأصناف المصروفة من الصيدلية",
				modalTarget: "#pitdrModal",
				buttonClass: "col-md-3" ,
				reportStatus:'N'
			},
		]
	},
    
    {
		mainTitleNo: 5,
        mainTitle: "Sick Leave",
        mainArabicTitle:"إجازة مرضية",
        mainTitleStatus:'Y',
        reports: 
        [
			{ 
				buttonTitleNo:1, 
				buttonTitle: "Sick Leave by Doctor Summary Report",
				buttonArabicTitle:"تقرير ملخص الإجازات المرضية حسب الطبيب",
				modalTarget: "#slbdsrModal",
				buttonClass: "col-md-3",
				reportStatus:'Y' 
			},
			
			{ 
				buttonTitleNo:2, 
				buttonTitle: "Sick Leave Summary Report",
				buttonArabicTitle:"تقرير ملخص الإجازات المرضية",
				modalTarget: "#slsrModal",
				buttonClass: "col-md-3" ,
				reportStatus:'Y'
			},
			
			{ 
				buttonTitleNo:3, 
				buttonTitle: "Exemption Details By Doctor",
				buttonArabicTitle:"تفاصيل الإعفاءات حسب الطبيب",
				modalTarget: "#edbdModal",
				buttonClass: "col-md-3",
				reportStatus:'Y' 
			},
		]
	},
    
];

// Translation lookup table
export const titleTranslations = 
{    
     // Main Titles
    "General": "عام",
    "Investigation": "تحقيق",
    "Patient Visit": "زيارة المريض",
    "Pharmacy": "الصيدلية",
    "Sick Leave": "إجازة مرضية",
    // Button Titles
    "Emergency Services": "الخدمات الطارئة",
    "KNG Xray tests taken": "اختبارات الأشعة السينية للحرس الوطني",
    "KNG Lab tests taken": "اختبارات المختبر للحرس الوطني",
    "KNG Lab Patient Collected Count":"عدد المرضى الذين تم جمعهم في مختبر",
    "KNG Lab Patient Accessed Count":"عدد المرضى الذين تم الوصول إليهم في مختبر",
    "KNG Lab Patient Processed Count":"تمت معالجة عدد المرضى في مختبر",
    "Patient visits by Doctor,Dept Report": "زيارات المرضى حسب تقرير الطبيب، القسم",
    "Chronic Patients Detailed": "تفاصيل المرضى المزمنين",
    "Patient Yearly Visits per Speciality": "الزيارات السنوية للمرضى حسب التخصص",
    "Patient Yearly Visits Categorized By Procedure": "الزيارات السنوية للمرضى مصنفة حسب الإجراء",
    "Patient Visits Categorized By Procedure-Doctor Wise(Quarter)": "زيارات المرضى مصنفة حسب الإجراء- حسب الطبيب (ربع سنوي)",
    "Speciality Visits": "زيارات التخصص",
    "Patient Count": "عدد المرضى",
    "Visit Count": "عدد الزيارات",
    "Patient Visit-Officer,Soldier,Civilian,Family": "زيارة المريض- ضابط، جندي، مدني، عائلة",
    "Patient Monthly Visits per Speciality": "الزيارات الشهرية للمرضى حسب التخصص",
    "Patient Monthly Visits Categorized by Procedure": "الزيارات الشهرية للمرضى مصنفة حسب الإجراء",
    "Medicine Stock-Clinic wise": "مخزون الأدوية- حسب العيادة",
    "Medicine by KNG Pharmacy": "الأدوية من صيدلية الحرس الوطني",
    "Pharmacy Visit History Report": "تقرير تاريخ زيارات الصيدلية",
    "Pharmacy Visit-Officer,Soldier,Civilian,Family": "زيارة الصيدلية- ضابط، جندي، مدني، عائلة",
    "Pharmacy Items Total Dispensed Report": "تقرير إجمالي الأصناف المصروفة من الصيدلية",
    "Sick Leave by Doctor Summary Report": "تقرير ملخص الإجازات المرضية حسب الطبيب",
    "Sick Leave Summary Report": "تقرير ملخص الإجازات المرضية",
    "Exemption Details By Doctor": "تفاصيل الإعفاءات حسب الطبيب",
};


export function translateTitlesIfArabic(reportSections) {
    const urlParams = new URLSearchParams(window.location.search);
    const lang = urlParams.get('lang');

  if (lang!=='ar') return; 
       // Only apply translations if 'ar'; otherwise, keep English
  

    reportSections.forEach(section => 
    {
        // Translate mainTitle and buttonTitles for 'ar'
        section.mainTitle = titleTranslations[section.mainTitle] || section.mainTitle;
        section.reports.forEach(report => {
            report.buttonTitle = titleTranslations[report.buttonTitle] || report.buttonTitle;
        });
    });
    
      
}

// Call the function to perform the translation if necessary
translateTitlesIfArabic(reportSections);

export function applyTranslationsToReportSections(reportSections, modulelang) {
    if (modulelang === 'ar') 
    {
        reportSections.forEach(section => 
        {
            section.reports.forEach(report => 
            {
                if (titleTranslations[report.buttonTitle]) 
                {
                    report.translatedButtonTitle = titleTranslations[report.buttonTitle];
                }
            });
        });
    }
}












/*function translateTitlesIfArabic(reportSections) {
    const urlParams = new URLSearchParams(window.location.search);
    const lang = urlParams.get('lang');
    console.log("Language:", lang);

    reportSections.forEach(section => {
        console.log("Original Title:", section.mainTitle);
        
        // Translate mainTitle
        if (lang === 'ar' && titleTranslations[section.mainTitle]) {
            section.mainTitle = titleTranslations[section.mainTitle];
            console.log("Translated Main Title:", section.mainTitle);
        }
        
        // Translate each report's buttonTitle
        section.reports.forEach(report => {
            if (lang === 'ar' && titleTranslations[report.buttonTitle]) {
                report.buttonTitle = titleTranslations[report.buttonTitle];
                console.log(`Translated Button Title: ${report.buttonTitle}`);
            }
        });
    });
}

// Ensure this is called before any DOM manipulations or renderings
translateTitlesIfArabic(reportSections);*/
