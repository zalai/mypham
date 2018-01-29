package action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import form.OrderForm;
import form.SearchtForm;

@Controller
public class OrderAction {

	@RequestMapping(value = "order")
	public String index(Model model) {

		OrderForm orderForm = new OrderForm();

		model.addAttribute("orderForm", orderForm);		
		model.addAttribute("searchForm", new SearchtForm());

		return "order";
	}

}
