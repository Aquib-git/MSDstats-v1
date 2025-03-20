import { pharmChartBuilder } from "./pharmChartBuilder";
import { pharmStockBuilder } from "./pharmStockBuilder";
import { pharmReportBuilder } from "./pharmReportBuilder";


export function pharmStatisticsBuilder()
{
	pharmChartBuilder();
	pharmStockBuilder();
	pharmReportBuilder(); 
}