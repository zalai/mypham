package action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/sanpham")
public class ProductAction {

	@RequestMapping(value = "")
	public String index() {

		
		return "admin/product/NewFile";
	}
}
