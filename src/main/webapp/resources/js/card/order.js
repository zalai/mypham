$(document).ready(function(){

	var is_busy = false;
	var waiting_text = "<option value=''>Đang tải...</option>";

	var URL_GET_DISTRICT = context_path + "/order/district/";
	var URL_GET_VILLAGE = context_path + "/order/village/";

	$('#orderForm select[name="province"]').on('change', function(){

		// Stop when busy
		if (is_busy == true) {
			return false;
		}

		$districtSelect = $('#orderForm select[name="district"]');

		// Append waiting text
		$districtSelect.html(waiting_text);

		// Busy
		is_busy = true;

		//$("#modal").empty();
		$.ajax({
			type : "POST",
			contentType : "text",
			url : URL_GET_DISTRICT + $(this).val(),
			success : function(data) {

				console.log(data);

				var optionText = "<option value=''>Vui lòng chọn</option>";
				for(var i = 0; i < data.result.length; i++) {

					optionText += "<option value='" + data.result[i].districtId + "'>" + data.result[i].name + "</option>";
				}

				$districtSelect.html(optionText);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		})
		.always(function() {
			is_busy = false;
		});
	});

	$('#orderForm select[name="district"]').on('change', function(){

		// Stop when busy
		if (is_busy == true) {
			return false;
		}

		$villageSelect = $('#orderForm select[name="village"]');

		// Append waiting text
		$villageSelect.html(waiting_text);

		// Busy
		is_busy = true;

		//$("#modal").empty();
		$.ajax({
			type : "POST",
			contentType : "text",
			url : URL_GET_VILLAGE + $(this).val(),
			success : function(data) {

				console.log(data);

				var optionText = "<option value=''>Vui lòng chọn</option>";
				for(var i = 0; i < data.result.length; i++) {

					optionText += "<option value='" + data.result[i].id + "'>" + data.result[i].name + "</option>";
				}

				$villageSelect.html(optionText);
			},
			error : function(e) {
				console.log("ERROR: ", e);
			},
			done : function(e) {
				console.log("DONE");
			}
		})
		.always(function() {
			is_busy = false;
		});
	});
});