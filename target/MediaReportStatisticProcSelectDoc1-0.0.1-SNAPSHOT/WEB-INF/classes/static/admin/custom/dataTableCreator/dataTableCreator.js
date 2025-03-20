

//VERSION 2:
export function dataTableCreator(tableName, rowsPerPage, tableUtils)
{
	$(function () 
	{
		var tableSelector = "#" + tableName;
		$(tableSelector).DataTable({
			"responsive": true, "lengthChange": false, "autoWidth": false,"pageLength":rowsPerPage,
		   //"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
		  //"buttons": ["excel","colvis"]  
		  	"buttons": [...tableUtils]
		}).buttons().container().appendTo(tableSelector + '_wrapper .col-md-6:eq(0)');
		$('#example2').DataTable({
		   "paging": true,
		   "lengthChange": false,
		   "searching": false,
		   "ordering": true,
		   "info": true,
		   "autoWidth": false,
		   "responsive": true,
		   "pageLength":rowsPerPage,
		});
	});
}



//VERSION 1:
/*
export function dataTableCreator(tableName, rowsPerPage)
{
	$(function () 
	{
		var tableSelector = "#" + tableName;
		$(tableSelector).DataTable({
			"responsive": true, "lengthChange": false, "autoWidth": false,"pageLength":rowsPerPage,
		   //"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
		  "buttons": ["excel","colvis"]  
		}).buttons().container().appendTo(tableSelector + '_wrapper .col-md-6:eq(0)');
		$('#example2').DataTable({
		   "paging": true,
		   "lengthChange": false,
		   "searching": false,
		   "ordering": true,
		   "info": true,
		   "autoWidth": false,
		   "responsive": true,
		   "pageLength":rowsPerPage,
		});
	});
}

*/



/*
// Original code for reference:

  $(function () {
					$("#example1").DataTable({
					  "responsive": true, "lengthChange": false, "autoWidth": false,"pageLength":10,
					   //"buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
					  "buttons": ["excel","colvis"]
					  
					}).buttons().container().appendTo('#example1_wrapper .col-md-6:eq(0)');
					$('#example2').DataTable({
					  "paging": true,
					  "lengthChange": false,
					  "searching": false,
					  "ordering": true,
					  "info": true,
					  "autoWidth": false,
					  "responsive": true,
					  "pageLength":10,
					});
				  });

 */