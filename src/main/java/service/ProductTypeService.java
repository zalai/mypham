package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductTypeDao;
import model.RstProducTypeDto;

@Service("productTypeService")
@Transactional(readOnly = false)
public class ProductTypeService {

	@Autowired
	private ProductTypeDao productTypeDao;

	@Transactional(readOnly = true)
	public List<RstProducTypeDto> getAllProductType() {

		return productTypeDao.getAllProductType();
	}
}
