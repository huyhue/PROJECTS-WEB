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
	});