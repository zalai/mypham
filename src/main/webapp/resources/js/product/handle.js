/*
Author: QuiNV
Date create: 2016/11/24
Date update: 1017/31/12
*/

$(document).ready(function() {

	// Create golobal variable
	var page = 0;
	var stopped = false;
	var is_busy = false;

	// Url to request
	var UrlSearch = "search/";

	// Create effect for show item
	new WOW().init();
	
	/* Product tab clicked*/
	$('.productTabType').click(function() {

		// Get tab id was selected
		var tab_id = $(this).attr('data-tab');

		// Prevent for current tab click again
		if(!$(this).hasClass('current') && !$(this).hasClass('endData')) {

			setDefaultLoadPage();

			// Load data with default page 
			getProductByType($(this).attr('productType'), "#" + tab_id, page + 1);

		}

		// Remove current class in tab title
		$('.productTabType').removeClass('current');

		// Remove current class in tab content
		$('.tab-content.product').removeClass('current');

		$(this).addClass('current');
		$("#" + tab_id).addClass('current');
	});

	function getProductByType($productType, $tabContentId, $pageSet) {

		$.ajax({
			type : "POST",
			contentType : "text",
			url : UrlSearch + $productType + "/" + $pageSet,
			success : function(data) {

				// Print data if result in data is not null
				if (data.result.length != 0) {
					var templateSource = $("#product-template").html();

					template = Handlebars.compile(templateSource);
					productHtml = template(data);

					$($tabContentId).append(productHtml);
				} else {
					
					// Add class to tick tab is not have data
					$('.productTabType.current').addClass('endData');
					$('.tab-content.product.current').addClass('endData');
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
			// Show loadding element
			$loadding.addClass('hidden');
			is_busy = false;
		});

	}

	function setDefaultLoadPage() {
		page = 0;
		stopped = false;
		is_busy = false;
	}

	// Khi kéo scroll thì xử lý
    $(window).scroll(function() {
        // Element tab content current selected
        $element = $('.tab-content.product.current');

        // ELement hiển thị chữ loadding
        $loadding = $('#loadding');

		$productType = $('.tab-link.current').attr('productType')

		// console.log("element hight " + $element.height() + "$(window).scrollTop() + $(window).height() :" + $(window).scrollTop() + $(window).height());
		if(!$element.hasClass('endData')) {
			// Nếu màn hình đang ở dưới cuối thẻ thì thực hiện ajax
	        if($(window).scrollTop() + $(window).height() >= $element.height()) 
	        {
	            // Nếu đang gửi ajax thì ngưng
	            if (is_busy == true){
	                return false;
	            }

	            // Nếu hết dữ liệu thì ngưng
	            if (stopped == true){
	                return false;
	            }

	            // Thiết lập đang gửi ajax
	            is_busy = true;

	            // Tăng số trang lên 1
	            page++;

	            // Hiển thị loadding
	            $loadding.removeClass('hidden');

				getProductByType($productType, '.tab-content.current', page);

	            return false;
	        }
		}
    });

	
	/*Silder*/
	$('#slider-news').tinycarousel({
		axis : 'x'
	});

})