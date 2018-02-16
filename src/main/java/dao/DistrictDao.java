package dao;

import java.util.List;

import org.springframework.stereotype.Component;

import model.RstDistrictDto;

@Component
public class DistrictDao extends AbstractDao<String, RstDistrictDto>{

	
	public List<RstDistrictDto> getByProvinceID(String provinceId) {

/*		criteria = createEntityCriteria();

		criteria.setProjection(columns("districtId", "name"));
		criteria.add(Restrictions.eq("provinceId", provinceId));
		criteria.setResultTransformer(new AliasToBeanConstructorResultTransformer(RstDistrictDto.class.getConstructors()[1]));*/
		sql = "SELECT new RstDistrictDto(districtId, name)"
				+ " FROM RstDistrictDto"
				+ " WHERE provinceId = :provinceId";

		query = createQuery(sql);
		query.setParameter("provinceId", provinceId);

		return query.list();
	}
}
