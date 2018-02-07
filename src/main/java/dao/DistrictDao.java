package dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.springframework.stereotype.Component;

import model.RstDistrictDto;

@Component
public class DistrictDao extends AbstractDao<String, RstDistrictDto>{

	
	public List<RstDistrictDto> getByProvinceID(String provinceId) {

		criteria = createEntityCriteria();

		criteria.setProjection(columns("districtId", "name"));
		criteria.add(Restrictions.eq("provinceId", provinceId));
		criteria.setResultTransformer(new AliasToBeanConstructorResultTransformer(RstDistrictDto.class.getConstructors()[1]));

		return criteria.list();
	}
}
