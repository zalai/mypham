package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.OrderDao;
import model.RstOrderDto;

@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	public void insert(RstOrderDto orderDto) {

		orderDao.persist(orderDto);
	}
}
