package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import model.RstVillageDto;

@Component
public class VillageDao extends AbstractDao<String, RstVillageDto>{

	public List<RstVillageDto> getByDistrictId(String districtId) {

		sql = "SELECT new RstVillageDto(id, name)"
				+ " FROM RstVillageDto"
				+ " WHERE districtId = :districtId";

		query = createQuery(sql);
		query.setParameter("districtId", districtId);

		return query.list();
		
	}

}
