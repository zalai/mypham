package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ProvinceDao;
import model.RstProvinceDto;

@Service
@Transactional
public class ProvinceService {

	@Autowired
	private ProvinceDao provinceDao;

	public List<RstProvinceDto> getProvices() {

		return provinceDao.getList();
	}
}
