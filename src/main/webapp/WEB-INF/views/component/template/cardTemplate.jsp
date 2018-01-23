<!-- Checkout card -->
<script id="checkout-product-template" type="text/x-handlebars-template">
	<div class="modal-dialog modal-lg">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Giỏ hàng của bạn</h4>
			</div>
			<div class="modal-body">
				<!--If have data -->
				{{#ifCond (get_length result.products) '>' 0}}
					<!--If return code=200: add card success-->
					{{#ifCond code '==' 200}}
						<div class="alert alert-success">
							<a href="#" class="close" data-dismiss="alert" aria-label="close" title="close">×</a>
							<span>Một mặt hàng đã được thêm vào giỏ</span>
						</div>
					{{else ifCond code '==' 201}}
						<div class="alert alert-info">
							<a href="#" class="close" data-dismiss="alert" aria-label="close" title="close">×</a>
							<span>Một mặt hàng đã được xóa khỏi giỏ</span>
						</div>
					{{else}}
						<div class="alert alert-danger">
							<a href="#" class="close" data-dismiss="alert" aria-label="close" title="close">×</a>
							<span>Thao tác không thành công vui lòng thử lại</span>
						</div>
					{{/ifCond}}
					<table class="table">
						<thead class="">
							<tr>
								<th scope="col" style="width: 5%">#</th>
								<th scope="col" style="width: 65%">Mặt hàng</th>
								<th scope="col" style="width: 10%">Số lượng</th>
								<th scope="col" style="width: 15%">Giá(VND)</th>
								<th scope="col" style="width: 5%">Act</th>
							</tr>
						</thead>
						<tbody>
							{{#each result.products}}
							<tr product-id="{{this.maSp}}">
								<th scope="row">{{inc @index}}</th>
								<td>{{this.tenSp}}</td>
								<td>
									<div class="input-group quantity">
										<span class="input-group-btn">
											<span class="btn btn-white btn-minuse" type="button">-</span>
										</span>
										<input type="text" min="1" max="5" class="form-control no-padding text-center" value="{{this.soLuong}}" disabled>
										<span class="input-group-btn">
											<span class="btn btn-pluss" type="button">+</span>
										</span>
									</div>
								</td>
								<td>
									{{formatCurrency this.giaBan}}
								</td>
								<td>
									<span class="input-group-btn">
										<button class="btn btn-primary btn-delete-card" type="button">Xóa</button>
									</span>
								</td>
							</tr>
							{{/each}}
							<tr>
								<td colspan="2"></td>
								<th scope="row">Tổng số tiền</th>
								<th colspan="2">{{formatCurrency result.totalPrice}} VND</th>
							</tr>
						</tbody>
					</table>
					<div class="pull-righ">
						<button class="btn btn-warning">Tiếp tục mua hàng</button>
						<button class="btn btn-warning">Thanh toán</button>
					</div>
				{{else}}
					<h4>Không có mặt hàng nào trong giỏ</h4>
				{{/ifCond}}
			</div>
			<div class="modal-footer"></div>
		</div>
	</div>
</script>
