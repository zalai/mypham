package action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import enums.BreadcrumbI;
import enums.PageEnum;
import form.SearchtForm;
import model.AjaxResponseBodyDto;
import model.BreadcrumbCustomDto;
import model.RstProducTypeDto;
import model.RstProductDto;
import service.ProductService;
import service.ProductTypeservice;

@Controller
public class IndexAction {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductTypeservice productTypeservice;

	private List<RstProductDto> productList;
	private List<RstProductDto> productNewList;
	private List<RstProducTypeDto> productTypeList;

	private List<BreadcrumbI> breadcrumbList;

	@RequestMapping(value = "/")
	public String index(Model model) {

		// find product type
		productTypeList = productTypeservice.getAllProductType();

		// Find product type by priority
		productNewList = productService.findByPriority(true);
		// Create default search form
		SearchtForm searchForm = new SearchtForm();

		// Add attribute to model
		model.addAttribute("productTypeList", productTypeList);
		model.addAttribute("productNewList", productNewList);
		model.addAttribute("searchForm", searchForm);

		return "index";
	}

	@RequestMapping(value = "/search/{productType}/{page}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public AjaxResponseBodyDto getProductByType(@PathVariable String productType,
			@PathVariable Integer page) {

		AjaxResponseBodyDto response = new AjaxResponseBodyDto();

		productList = productService.findByProductType(productType, page);
		response.setResult(productList);

		return response;
	}

	@RequestMapping(value = "/showProductDetail/{productId}")
	@ResponseBody
	public AjaxResponseBodyDto showProductDetail(@PathVariable Integer productId) {

		AjaxResponseBodyDto response = new AjaxResponseBodyDto();
		RstProductDto rstProductDto = productService.findProductByID(productId);
		response.setResult(rstProductDto);

		return response;
	}

	@RequestMapping(value = "/search")
	public String searchProduct(Model model, @ModelAttribute("searchForm") SearchtForm searchtForm) {

		if (StringUtils.isEmpty(searchtForm.getSearchValue())) {

			return "redirect:index";
		}

		// Find product
		productList = productService.findByName(searchtForm.getSearchValue(), searchtForm.getPage());

		searchtForm.setResultSize(productService.productCountByName(searchtForm.getSearchValue()));

		// Add attribute to model
		model.addAttribute("productList", productList);

		// Create searchParameter
		searchtForm.setSearchParam(createSearchParam(searchtForm));

		// Create breadcrumb
		createBreadCrumb(model, searchtForm);

		return "productSearch";
	}

	private void createBreadCrumb(Model model, SearchtForm searchtForm) {

		breadcrumbList = new ArrayList<BreadcrumbI>();

		breadcrumbList.add(PageEnum.TRANG_CHU);
		breadcrumbList.add(new BreadcrumbCustomDto(String.format("Có %d kết quả tìm kiếm cho '%s'",
				searchtForm.getResultSize(), searchtForm.getSearchValue())));


		model.addAttribute("breadcrumbList", breadcrumbList);
	}

	private MultiValueMap<String, String> createSearchParam(SearchtForm searchtForm) {

		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("searchValue", searchtForm.getSearchValue());

		return params;
	}

}
