/**
 * @version 1.0 18 March 2018
 * @author Joseph Kelly Tusoy
 */


$(document).ready(function(){  
	
	 
		$("#jqGridStudent").jqGrid(
				{
                  //change to relative path
					url : "http://localhost:8080/RoomMgtApp/student",
					mtype:"POST",
					datatype : "json",
					height : 'auto',
					colNames : [ 'id', 'lastName', 'name', 'email', 'phone',
							'sex', 'nationality' ],
					colModel : [ {
						name : 'Id',
						index : 'id',
						hidden : true,
						key : true,
						search : false
					}, {
						name : 'name',
						index : 'name',
					}, {
						name : 'lastName',
						index : 'lastName',
					}, {
						name : 'email',
						index : 'email',
					}, {
						name : 'phone',
						index : 'phone',
					}, {
						name : 'sex',
						index : 'sex',
					}, {
						name : 'nationality',
						index : 'nationality',
					} ],
					cmTemplate : {
						editable : true
					},
					multiselect : false,
					paging : true,
					loadonce : true,
					sortname : 'Last Name',
					rowList : [],
					pager : $("#page"),
					viewrecords : true,
					pgbuttons : true,
					pgtext : null,
					rowNum : 10,
					pager : "#jqGridPagerStudent"
				});

		$('#jqGridStudent').navGrid('#jqGridPagerStudent',
		// the buttons to appear on the toolbar of the grid
		{
			edit : true,
			add : true,
			del : true,
			search : true,
			refresh : true,
			view : false,
			position : "left",
			cloneToTop : false
		},
		// options for the Edit Dialog
		{
			editCaption : "The Edit Dialog",
			recreateForm : true,
			//checkOnUpdate : true,
			//checkOnSubmit : true,
			beforeSubmit : function(postdata, form, oper) {
				if (confirm('Are you sure you want to update this row?')) {
					// do something
					return [ true, '' ];
				} else {
					return [ false, 'You can not submit!' ];
				}
			},
			closeAfterEdit : true,
			errorTextFormat : function(data) {
				return 'Error: ' + data.responseText
			}
		},
		// options for the Add Dialog
		{
			closeAfterAdd : true,
			recreateForm : true,
			errorTextFormat : function(data) {
				return 'Error: ' + data.responseText
			}
		},
		// options for the Delete Dailog
		{
			errorTextFormat : function(data) {
				return 'Error: ' + data.responseText
			}

		});

	 
    

});