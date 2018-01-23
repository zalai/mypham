/*
Author: QuiNV
Date create: 2017/01/12
*/

$(document).ready(function(){

	// Prevent double click when requesting
	var is_busy = false;
	var UrlShowProductDetail = "showProductDetail/";

	$(document).on("click", ".showProductDetail", function(e){

		e.preventDefault();

		// Stop when busy
		if (is_busy == true) {
			return false;
		}

		// Busy
		is_busy = true;

		// Get product ID
		var productId = $(this).closest('li').attr('product-id');

		//$("#modal").empty();
		$.ajax({
			type : "POST",
			contentType : "text",
			url : UrlShowProductDetail + productId,
			success : function(data) {

				// Print data if result in data is not null
				if (data.result.length != 0) {
					var templateSource = $("#product-detail-template").html(),
					template = Handlebars.compile(templateSource),
					productHtml = template(data);

					$('#detail-product').html(productHtml);
					$('#detail-product').modal();
				}
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
})