package dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.springframework.stereotype.Component;

import model.RstVillageDto;

@Component
public class VillageDao extends AbstractDao<String, RstVillageDto>{

	public List<RstVillageDto> getByDistrictId(String districtId) {

		criteria = super.createEntityCriteria();

		criteria.setProjection(columns("id", "name"));
		criteria.add(Restrictions.eq("districtId", districtId));
		criteria.setResultTransformer(new AliasToBeanConstructorResultTransformer(RstVillageDto.class.getConstructors()[1]));

		return criteria.list();
	}

}
