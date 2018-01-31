package action;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import model.AjaxResponseBodyDto;
import model.CardDto;
import model.RstProductDto;
import service.ProductService;

@Controller
@RequestMapping(value = "card")
public class CardAction extends AbstractCardAction{

	@Autowired
	private ProductService productService;

	private CardDto cardItems;

	@RequestMapping(value = "/show")
	@ResponseBody
	public AjaxResponseBodyDto showCard(HttpSession session) {

		AjaxResponseBodyDto response = new AjaxResponseBodyDto();

		cardItems = getCardSession(session);

		response.setResult(cardItems);
		response.setCode("200");

		return response;
	}

	@RequestMapping(value = "/add/{productId}")
	@ResponseBody
	public AjaxResponseBodyDto addCard(@PathVariable Integer productId, HttpSession session) {

		AjaxResponseBodyDto response = new AjaxResponseBodyDto();

		// Check exist product
		RstProductDto product = productService.findProductByID(productId);

		if (product != null) {

			cardItems = getCardSession(session);

			// Process add or remove product
			cardItems = processAddCard(cardItems, product);

			session.setAttribute("cardItems", cardItems);

			response.setResult(cardItems);
			response.setCode("200");
		} else {

			response.setCode("400");
		}

		return response;
	}

	@RequestMapping(value = "/delete/{productId}")
	@ResponseBody
	public AjaxResponseBodyDto deleteCard(@PathVariable Integer productId, HttpSession session) {

		AjaxResponseBodyDto response = new AjaxResponseBodyDto();

		cardItems = getCardSession(session);

		if (cardItems != null) {

			cardItems.getProducts().remove(productId);
		}

		response.setCode("201");
		response.setResult(cardItems);

		return response;
	}

	@RequestMapping(value = "/minuse/{productId}")
	@ResponseBody
	public AjaxResponseBodyDto minuseCard(@PathVariable Integer productId, HttpSession session) {

		AjaxResponseBodyDto response = new AjaxResponseBodyDto();

		cardItems = getCardSession(session);

		if (cardItems != null) {

			RstProductDto product = cardItems.getProducts().get(productId);
			if(product != null && product.getSoLuong() > 1) {

				product.setSoLuong(product.getSoLuong() - 1);
			}
		}

		response.setCode("201");
		response.setResult(cardItems);

		return response;
	}

	private CardDto processAddCard(CardDto cardDto, RstProductDto product) {

		if (cardDto == null) {

			cardDto = new CardDto();
		}

		Map<Integer, RstProductDto> productMap = cardDto.getProducts();

		RstProductDto productNew = productMap.get(product.getMaSp());

		// If product exist in card then increase quantity
		if (productNew != null) {

			int qualityOld = productNew.getSoLuong();
			productNew.setSoLuong(qualityOld + 1);
		} else {

			productNew = new RstProductDto();
			productNew.setMaSp(product.getMaSp());
			productNew.setTenSp(product.getTenSp());
			productNew.setSoLuong(1);
			productNew.setGiaBan(product.getGiaBan());

			productMap.put(productNew.getMaSp(), productNew);
		}

		return cardDto;
	}

}
