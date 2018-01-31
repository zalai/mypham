package action;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import form.OrderForm;
import model.CardDto;

@Controller
@RequestMapping(value = "/order")
public class OrderAction extends AbstractCardAction {

	@RequestMapping(value = "")
	public String index(Model model, HttpSession session) {

		CardDto cardItems = getCardSession(session);

		if (cardItems != null) {
			OrderForm orderForm = new OrderForm();

			model.addAttribute("orderForm", orderForm);		

			return "order/order";
		}

		return "redirect:/";
	}

	@RequestMapping(value = "confirm")
	public String confirm(Model model, @ModelAttribute("orderForm") OrderForm orderForm, HttpSession session) {

		CardDto cardItems = getCardSession(session);

		if (cardItems != null) {
			model.addAttribute("orderForm", orderForm);

			return "order/confirmOrder";
		}

		return "redirect:/"; 
	}

	private void validate(BindingResult result) {
		
	}
}
