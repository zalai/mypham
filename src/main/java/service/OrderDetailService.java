package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.OrderDetailDao;
import model.RstOrderDetailDto;

@Service
@Transactional
public class OrderDetailService {

	@Autowired
	private OrderDetailDao orderDetailDao;

	public void insert(RstOrderDetailDto orderDetailDto) {

		orderDetailDao.persist(orderDetailDto);
	}
}
