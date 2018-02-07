package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.VillageDao;
import model.RstVillageDto;

@Service
@Transactional
public class VillageService {

	@Autowired
	private VillageDao villageDao;

	public List<RstVillageDto> getByDistrictId(String districtId) {

		return villageDao.getByDistrictId(districtId);
	}
}
