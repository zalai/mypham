package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CardDto implements Serializable {

	private static final long serialVersionUID = -8686597628709939403L;

	private Map<Integer, RstProductDto> products;

	public Map<Integer, RstProductDto> getProducts() {

		if (products == null) {

			products = new HashMap<Integer, RstProductDto>();
		}

		return products;
	}

	public void setProducts(Map<Integer, RstProductDto> products) {
		this.products = products;
	}

	public double getTotalPrice() {

		double totalPrice = 0;
		RstProductDto productDto;

		// Caculate total price
		for (Map.Entry<Integer, RstProductDto> entry : products.entrySet()) {

			productDto = entry.getValue();
			totalPrice += productDto.getSoLuong() * productDto.getGiaBan();
		}

		return totalPrice;
	}

}
