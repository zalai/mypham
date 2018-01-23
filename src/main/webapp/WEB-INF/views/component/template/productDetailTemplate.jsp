<script id="product-detail-template" type="text/x-handlebars-template">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Thông tin chi tiết sản phẩm</h4>
			</div>
			<div class="modal-body">
				<div class="row">
					<div class="col-md-3 col-sm-12 text-center">
						<img src="{{result.hinh}}" style="max-height:200px; max-weight:200px">
					</div>
					<div class="col-md-9 col-md-12">
						<div class="detail-info">
							<h2>{{result.tenSp}}</h2>
							<p>
								{{result.moTa}}
							 </p>
							<form method="post">
								<ul>
									<li>
										<label>Nơi sản xuất</label>
										<span>{{result.noiSx}}</span>
									</li>
									<li class="price-detail">
										<label>Giá bán</label>
										<span>{{result.giaBan}}</span>
									</li>
									<li>
										<label>Số lượng</label>
										<input name="soluong" type="text" class="form-control"/>
									</li>
									<li>
										<label>Màu sắc</label>
										<span>{{result.mauSac}}c</span>
									</li>
									<li>
										<button class="btn btn-primary">Đặt hàng</button>
										<button class="btn btn-primary">Thêm vào giỏ</button>
									</li>
								</ul>
							</form>
						</div>
					</div>
				</div>
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</script>