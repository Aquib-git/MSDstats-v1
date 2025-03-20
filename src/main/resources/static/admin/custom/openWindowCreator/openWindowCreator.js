export function openWindowCreator(url)
{
	var popupwindow=window.open(url,'','location=no,width=1500,height=900');
	popupwindow.moveTo((screen.width/2)-700,(screen.height/2)-450);
		
}