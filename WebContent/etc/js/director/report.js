/**
 * @version 1.0 18 March 2018
 * @author Joseph Kelly Tusoy
 */

$(document).ready(
		function() {

			$("#jqGridReport1").jqGrid(
					{
						url : "http://localhost:8080/RoomMgtApp/report?type=1",
						mtype : "GET",
						datatype : "json",
						height : 'auto',
						colNames : [ 'roomNumber', 'bldgNumber', 'roomStatus',
								'occupiedBy', 'occupiedSince', 'notes' ],
						colModel : [ {
							name : 'roomNumber',
							index : 'roomNumber',
							hidden : true,
							key : true,
							search : false
						}, {
							name : 'bldgNumber',
							index : 'bldgNumber',
						}, {
							name : 'roomStatus',
							index : 'roomStatus',
						}, {
							name : 'occupiedBy',
							index : 'occupiedBy',
						}, {
							name : 'occupiedSince',
							index : 'occupiedSince',
						}, {
							name : 'notes',
							index : 'notes',
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
						rowNum : 100,
					});

			$("#jqGridReport2").jqGrid(
					{
						url : "http://localhost:8080/RoomMgtApp/report",
						mtype : "POST",
						datatype : "json",
						height : 'auto',
						colNames : [ 'id', 'bookshelf', 'chair', 'departureid',
								'desk', 'dresser', 'frame', 'mattress',
								'wastebasket' ],
						colModel : [ {
							name : 'id',
							index : 'id',
							hidden : true,
							key : true,
							search : false
						}, {
							name : 'bookshelf',
							index : 'bookshelf',
						}, {
							name : 'chair',
							index : 'chair',
						}, {
							name : 'departureid',
							index : 'departureid',
						}, {
							name : 'desk',
							index : 'desk',
						}, {
							name : 'dresser',
							index : 'dresser',
						}, {
							name : 'frame',
							index : 'frame',
						}, {
							name : 'mattress',
							index : 'mattress',
						}, {
							name : 'wastebasket',
							index : 'wastebasket',
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
						rowNum : 100,
					});

		});