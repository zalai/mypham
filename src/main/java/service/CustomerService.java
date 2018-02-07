package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CustomerDao;
import model.RstCustomerDto;

@Service
@Transactional(readOnly = false)
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public void insert(RstCustomerDto customerDto) {

		customerDao.persist(customerDto);
	}

}
