package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ProductDao;
import enums.Constant;
import model.RstProductDto;

@Service("productService")
@Transactional(readOnly = true)
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public List<RstProductDto> getAllProduct(int page, boolean isDeleted) {

		return productDao.getAllProduct(getOffset(page), isDeleted);
	}

	public List<RstProductDto> findByProductType(String productType, int page) {

		int offset = getOffset(page);

		// Get all product with productType = ALL
		if(Constant.PRODUCT_TYPE_ALL.equals(productType)) {

			return productDao.getAllProduct(offset, Constant.ACTIVE);
		}

		return productDao.findByProductType(offset, productType);
	}

	public List<RstProductDto> findByPriority(boolean isPrioritied) {

		return productDao.findByPriority(isPrioritied);
	}

	public List<RstProductDto> findByName(String productName, int page) {

		if (productName != null) {

			return productDao.findByName(productName, getOffset(page));
		}

		return null;
	}

	public Long productCountByName(String productName) {

		return productDao.countResultByFindName(productName);
	}

	public RstProductDto findProductByID(Integer maSp) {

		return productDao.findProductByID(maSp);
	}

	private int getOffset(int page) {

		return (page * Constant.MAX_RECORD_DEFAULT) - Constant.MAX_RECORD_DEFAULT;
	}

}
