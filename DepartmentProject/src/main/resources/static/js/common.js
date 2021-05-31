$(document).ready(
	function() {
		$("#buttonClear").on("click", function() {
			window.location = "[[@{/departments}]]";
		});

		$(".link-delete").on("click", function(e) {
			e.preventDefault();
			link = $(this);
			departmentId = link.attr("departmentId");
			$("#confirm").attr("href", link.attr("href"));
			$("#confirmText").text("Are you sure to Delete this User has Department ID: " + departmentId + " ?");
			$("#confirmModal").modal();
		});
		
		$(".link-cancel").on("click", function(e) {
			e.preventDefault();
			link = $(this);
			bookingId = link.attr("bookingId");
			$("#confirm1").attr("href", link.attr("href"));
			$("#confirmText1").text("Are you sure to cancel booking ID: " + bookingId + " ?");
			$("#confirmModal1").modal();
			/*$(".link-cancel").prop( "disabled", true );*/
		});
	});