$(document).ready(function() {

	var URL_DELETE_CARD = "card/delete/";
	var URL_ADD_CARD = "card/add/";
	var URL_MINUSE_CARD = "card/minuse/";
	var URL_SHOW_CARD = "card/show";

	var is_busy = false;

	function minuse($input) {

		var min = $input.attr('min');
		var currentValue = $input.val();

		if(currentValue > 1 && currentValue > min) {

			currentValue--;
			$input.val(currentValue);
		} else {

			return false;
		}

	}

	function pluss($input) {

		var max = $input.attr('max');
		var currentValue = $input.val();

		if(currentValue < max) {

			currentValue++;
			$input.val(currentValue);
		} else {

			return false;
		}

	}

	$(document).on('click', '.btn-minuse', function() {

		// Stop when busy
		if (is_busy == true) {
			return false;
		}

		// Stop when can not minuse
		if (minuse($(this).parent().siblings('input')) == false) {

			return false;
		}

		// Get product ID in current row
		var productId = $(this).closest('tr').attr('product-id');

		// Call click add-card
		requestCard(URL_MINUSE_CARD, productId);

	});

	$(document).on('click', '.btn-pluss', function() {

		// Stop when busy
		if (is_busy == true) {
			return false;
		}

		// Stop when can not pluss more
		if (pluss($(this).parent().siblings('input')) == false) {

			return false;
		}

		// Get product ID in current row
		var productId = $(this).closest('tr').attr('product-id');

		// Call click add-card
		requestCard(URL_ADD_CARD, productId);
	});

	// Add productId to card
	function requestCard(urlRequest ,productId) {

		// Stop when busy
		if (is_busy == true) {
			return false;
		}

		// Busy
		is_busy = true;

		//$("#modal").empty();
		$.ajax({
			type : "POST",
			contentType : "text",
			url : urlRequest + productId,
			success : function(data) {

				console.log(data.result);

				// show product size in button card
				showProductSize(data);

				var templateSource = $("#checkout-product-template").html();

				template = Handlebars.compile(templateSource);
				productHtml = template(data);

				$('#checkout-product').html(productHtml);
				$('#checkout-product').modal();
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
	}

	$(document).on('click', '.btn-add-card', function() {
		// Get product ID
		var productId = $(this).closest('li').attr('product-id');

		// Add product to card
		requestCard(URL_ADD_CARD, productId);

	});

	$(document).on('click', '.btn-delete-card', function() {

		// Stop when busy
		if (is_busy == true) {
			return false;
		}

		// Get product ID in current row
		var productId = $(this).closest('tr').attr('product-id');

		// Request delete
		requestCard(URL_DELETE_CARD, productId);
	});

	$(document).on('click', '.btn-show-card', function() {

		// Stop when busy
		if (is_busy == true) {
			return false;
		}

		// Busy
		is_busy = true;

		//$("#modal").empty();
		$.ajax({
			type : "POST",
			contentType : "text",
			url : URL_SHOW_CARD,
			success : function(data) {

				console.log(data.result);

				// Check return data is not null
				if (data.result != null) {

					var productSize = Object.keys(data.result.products).length;

					if (productSize > 0) {

						showProductSize(data);

						// Show card infor
						var templateSource = $("#checkout-product-template").html();

						template = Handlebars.compile(templateSource);
						productHtml = template(data);

						$('#checkout-product').html(productHtml);
						$('#checkout-product').modal();
					}
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

	function showProductSize(data) {

		var productSize = Object.keys(data.result.products).length;

		// Add the number in card button
		$('.btn-show-card .badge').html(productSize);
	}
})