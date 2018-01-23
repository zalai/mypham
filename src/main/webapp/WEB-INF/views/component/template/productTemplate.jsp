<!--Templete to print product -->
<script id="product-template" type="text/x-handlebars-template">
	{{#each result}}
	<ul>
		<li class="box wow fadeInDown animated" product-id="{{this.maSp}}"
			style="visibility: visible; animation-name: fadeInDown;">
			<div class="demo6 showProductDetail">
				<a
					href="#"><img
					src="{{this.hinh}}"
					width="250" alt="{{this.moTa}}"
					title="{{this.tenSp}}"></a>
			</div>
			<div class="title-product">
				<a href="#">{{this.tenSp}}</a>
			</div>
			<!-- <div class="bad-code">Mã sản phẩm : {{this.maSp}}</div> -->
			<div class="price">{{formatCurrency this.giaBan}} VNĐ</div>
			<div class="add-card">
				<button class="btn btn-add-card">
					<i class="fa fa-shopping-cart"></i> Thêm vào giỏ
				</button>
			</div>
		</li>
	</ul>
	{{/each}}
</script>