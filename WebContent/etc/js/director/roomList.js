$(document).ready(function() {
	console.log('roomList function');

	$("#jqGrid").jqGrid(
			{

				url : "http://localhost:8080/RoomMgtApp/room",
				datatype : "json",
				height : 'auto',
				
				colNames : [ 'id', 'Room Number','Status', 'First Name', 'Last Name', 'Frame', 'Mattress', 'Desk',
						'Chair', 'Bookshelf','Dresser','Waste Basket','Recycle Bin','Arrival Number','Departure Number','Last Updated By','Notes'],
				colModel : [ {
					name : 'id',
					index : 'id',
					hidden : true,
					key : true,
					search : false
				}, {
					name : 'room_number',
					index : 'room_number',
				}, {
					name : 'status',
					index : 'status',
					edittype: 'select',
					formatter:'select',
					align: 'center',
					editoptions: { value:"Occupied:Occupied;Vacant:Vacant;Needs Cleaning:Needs Cleaning;Ready:Ready;Reserved:Reserved;Vacant:Vacant" }
				}, {
					name : 'studentName',
					index : 'studentName',
					editable: false
				}, {
					name : 'studentLastName',
					index : 'studentLastName',
					editable: false
				}, {
					name : 'frame',
					index : 'frame',
					edittype: 'select',
					formatter:'select',
					align: 'center',
					width: 80,
					editoptions: { value:"Good:Good;Fix it:Fix it;Missing:Missing" }
				}, {
					name : 'mattress',
					index : 'mattress',
					edittype: 'select',
					formatter:'select',
					align: 'center',
					width: 80,
					editoptions: { value:"Good:Good;Fix it:Fix it;Missing:Missing" }
				}, {
					name : 'desk',
					index : 'desk',
					edittype: 'select',
					formatter:'select',
					align: 'center',
					width: 80,
					editoptions: { value:"Good:Good;Fix it:Fix it;Missing:Missing" }
				}, {
					name : 'chair',
					index : 'chair',
					edittype: 'select',
					formatter:'select',
					align: 'center',
					width: 80,
					editoptions: { value:"Good:Good;Fix it:Fix it;Missing:Missing" }
				},  {
					name : 'bookshelf',
					index : 'bookshelf',
					edittype: 'select',
					formatter:'select',
					align: 'center',
					width: 80,
					editoptions: { value:"Good:Good;Fix it:Fix it;Missing:Missing" }
				},  {
					name : 'dresser',
					index : 'dresser',
					edittype: 'select',
					formatter:'select',
					align: 'center',
					width: 80,
					editoptions: { value:"Good:Good;Fix it:Fix it;Missing:Missing" }
				},  {
					name : 'wasteBasket',
					index : 'wasteBasket',
					edittype: 'select',
					formatter:'select',
					align: 'center',
					width: 80,
					editoptions: { value:"Good:Good;Fix it:Fix it;Missing:Missing" }
				},  {
					name : 'recycleBin',
					index : 'recycleBin',
					edittype: 'select',
					formatter:'select',
					align: 'center',
					width: 80,
					editoptions: { value:"Good:Good;Fix it:Fix it;Missing:Missing" }
				},  {
					name : 'arrivalId',
					index : 'arrivalId',
					editable: false,
					width: 100,
				},  {
					name : 'departureId',
					index : 'departureId',
					editable: false,
					width: 130,
				}, {
					name : 'Last_Updated_By',
					index : 'Last_Updated_By',
					editable: false
				}, {
					name : 'notes',
					index : 'notes',
					width: 180
				}],
				cmTemplate : {
					editable : true
				},
				multiselect : false,
				paging : true,
				loadonce : true,
				sortname : 'room_number',
				rowList : [],
				pager : $("#page"),
				viewrecords : true,
				pgbuttons : true,
				pgtext : null,
				rowNum : 20,
				cellEdit: true,
				pager : "#jqGridPager",
				shrinkToFit : false,
				pager : "#jqGridPager"
			});	
	
			$('#jqGrid').navGrid('#jqGridPager',
			// the buttons to appear on the toolbar of the grid
			{
				edit : true,
				add : true,
				del : true,
				search : false,
				refresh : false,
				view : false,
				position : "left",
				cloneToTop : false
			},
			// options for the Edit Dialog
			{
				editCaption : "Edit Room Information",
				recreateForm : true,
				//checkOnUpdate : true,
				//checkOnSubmit : true,
				beforeSubmit : function(postdata, form, oper) {
					if (confirm('Are you sure you want to update this row?')) {
						console.log(' the data to postdata is: ', postdata);
						// do something
				        $.ajax({
				            url: 'http://localhost:8080/RoomMgtApp/room?actionRoom=edit',
				            data: postdata,
				            type: 'POST', 
				            dataType : 'json'
				        })
				        .done(success)
				        .fail(fail);
				        function success(response){
				            console.log(response);
				            alert('The data was upgraded');
				        }
				        function fail(){
				            console.log('fail');
				        }
						return [ true, '' ];
					} else {
						return [ false, 'You cannot submit!' ];
					}
				},
				closeAfterEdit : true,
				errorTextFormat : function(data) {
					return 'Error: ' + data.responseText
				}
			},
			// options for the Add Dialog
			{
				addCaption : "New Room Information",
				recreateForm : true,
				closeAfterAdd : true,
				errorTextFormat : function(data) {
			        $.ajax({
			            url: 'http://localhost:8080/RoomMgtApp/room?actionRoom=new',
			            data: postdata,
			            type: 'POST', 
			            dataType : 'json'
			            
			        })
			        .done(success)
			        .fail(fail);
			        function success(response){
			            console.log(response);
			            alert('The data was inserted');
			        }
			        function fail(){
			            console.log('fail');
			        }					
					return 'Error: ' + data.responseText
				}
			},
			// options for the Delete Dailog
			{
				errorTextFormat : function(data) {
					if (confirm('Are you sure you want to delete this row?')) {
				        $.ajax({
				            url: 'http://localhost:8080/RoomMgtApp/room?actionRoom=delete',
				            data: postdata,
				            type: 'POST', 
				            dataType : 'json'
				            
				        })
				        .done(success)
				        .fail(fail);
				        function success(response){
				            console.log(response);
				            alert('The data was deleted');
				        }
				        function fail(){
				            console.log('fail');
				        }					
						return 'Error: ' + data.responseText						
					} else {
						return [ false, 'You cannot submit!' ];
					}
				}
			});	
});