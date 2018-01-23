package dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Component;

import model.RstProducTypeDto;

@Component
public class ProductTypeDao extends AbstractDao<Integer, RstProducTypeDto>{

	public List<RstProducTypeDto> getAllProductType() {

		Criteria criteria = createEntityCriteria();
		criteria.addOrder(Order.asc("stt"));
		return criteria.list();
	}
}
