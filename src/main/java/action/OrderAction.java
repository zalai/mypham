package action;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import enums.Constant;
import form.OrderForm;
import model.AjaxResponseBodyDto;
import model.CardDto;
import model.RstCustomerDto;
import model.RstDistrictDto;
import model.RstOrderDetailDto;
import model.RstOrderDto;
import model.RstProductDto;
import model.RstProvinceDto;
import model.RstVillageDto;
import service.CustomerService;
import service.DistrictService;
import service.OrderDetailService;
import service.OrderService;
import service.ProvinceService;
import service.VillageService;
import utils.DateUtils;

@Controller
@RequestMapping(value = "/order")
public class OrderAction extends AbstractCardAction {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private OrderService orderService;

	@Autowired
	private OrderDetailService orderDetailService;

	@Autowired
	private ProvinceService provinceService;

	@Autowired
	private DistrictService districtService;

	@Autowired
	private VillageService villageService;

	private List<RstProvinceDto> provinceList;

	@RequestMapping(value = "")
	public String index(Model model, HttpSession session) {

		CardDto cardItems = getCardSession(session);

		if (cardItems != null) {
			OrderForm orderForm = new OrderForm();

			model.addAttribute("orderForm", orderForm);		

			initPulldow(model);

			return "order/order";
		}

		return "redirect:/";
	}

	@RequestMapping(value = "confirm", method = RequestMethod.POST)
	public String confirm(Model model, @Valid OrderForm orderForm,
			BindingResult result, HttpSession session) {

		CardDto cardItems = getCardSession(session);

		if (cardItems != null) {

			if (result.hasErrors()) {

				return "order/order";
			}

			model.addAttribute("orderForm", orderForm);
			initPulldow(model);

			return "order/confirmOrder";
		}

		return "redirect:/";
	}

	@RequestMapping(value = "complete", method = RequestMethod.POST)
	public String complete(Model model, @Valid OrderForm orderForm,
			BindingResult result, HttpSession session) {

		CardDto cardItems = getCardSession(session);

		if (cardItems != null) {

			if (result.hasErrors()) {

				return "order/order";
			}

			// Insert customer
			RstCustomerDto customerDto = new RstCustomerDto();
			BeanUtils.copyProperties(orderForm, customerDto);

			customerService.insert(customerDto);

			// Insert order
			RstOrderDto orderDto = new RstOrderDto();
			orderDto.setCustomerDto(customerDto);
			orderDto.setOrderDate(DateUtils.getCurrentDate());

			orderDto.setDeliveryAdress(orderForm.getAddress());
			orderDto.setProvinceDto(new RstProvinceDto(orderForm.getProvince()));
			orderDto.setDistrictDto(new RstDistrictDto(orderForm.getDistrict()));
			orderDto.setVillageDto(new RstVillageDto(orderForm.getVillage()));

			orderDto.setState(Constant.ACTIVE);
			orderDto.setTotalPrice(cardItems.getTotalPrice());

			// Insert order detail
			Set<RstOrderDetailDto> orderDetailDtos = new HashSet<RstOrderDetailDto>();
			RstOrderDetailDto orderDetailDto;
			RstProductDto productDto;

			for(Map.Entry<Integer, RstProductDto> entry: cardItems.getProducts().entrySet()) {

				// Get product in card
				productDto = entry.getValue();

				// Get 
				orderDetailDto = new RstOrderDetailDto();
				orderDetailDto.setMaSp(productDto.getMaSp());
				orderDetailDto.setGia(productDto.getGiaBan());
				orderDetailDto.setSoLuong(productDto.getSoLuong());
				orderDetailDto.setOrderDto(orderDto);
				orderDetailDtos.add(orderDetailDto);
			}

			orderDto.setOrderDetailDtos(orderDetailDtos);
			orderService.insert(orderDto);

			return "order/confirmOrder";
		}

		return "redirect:/";
	}

	@RequestMapping(value = "district/{provinceId}", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponseBodyDto getDistrictByProvinceId(@PathVariable String provinceId) {

		AjaxResponseBodyDto responseDto = new AjaxResponseBodyDto();

		responseDto.setResult(districtService.getByProvinceID(provinceId));
		responseDto.setCode(HttpStatus.OK.value());

		return responseDto;
	}

	@RequestMapping(value = "village/{districtId}", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResponseBodyDto getVillageByDistrictId(@PathVariable String districtId) {

		AjaxResponseBodyDto responseDto = new AjaxResponseBodyDto();

		responseDto.setResult(villageService.getByDistrictId(districtId));
		responseDto.setCode(HttpStatus.OK.value());

		return responseDto;
	}

	private void initPulldow(Model model) {

		provinceList = provinceService.getProvices();
		model.addAttribute("provinceList", provinceList);
	}

}
