package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Component;

import com.sun.org.apache.xml.internal.security.transforms.Transforms;

import enums.Constant;
import model.RstProductDto;

@Component
public class ProductDao extends AbstractDao<Integer, RstProductDto> {

	private ProjectionList projectionList1 = columns("maSp", "tenSp", "moTa", "noiSx", "mauSac", "hinh", "giaBan");
	
	public List<RstProductDto> getAllProduct(int offset, boolean isDeleted) {

		String sql = "SELECT new RstProductDto(maSp, tenSp, moTa, noiSx, mauSac, hinh, giaBan)"
				+ " FROM RstProductDto"
				+ " WHERE"
				+ " remove = :isRemove";

		query = createQuery(sql);
		query.setParameter("isRemove", isDeleted);
		settingRecord(query, offset);

		return query.list();
	}

	public List<RstProductDto> findByProductType(int offset, String productType) {

		String sql = "SELECT new RstProductDto(maSp, tenSp, moTa, noiSx, mauSac, hinh, giaBan)"
				+ " FROM RstProductDto"
				+ " WHERE"
				+ " remove = :isRemove"
				+ " AND rstProducTypeDto.maLoai = :productType"
				+ " ORDER BY"
				+ " rstProducTypeDto.maLoai DESC, ngayNhap DESC";

		query = createQuery(sql);
		query.setParameter("isRemove", Constant.ACTIVE);
		query.setParameter("productType", productType);

		settingRecord(query, offset);

		return query.list();
	}

	public List<RstProductDto> findByPriority(boolean isPrioritied) {

/*		criteria = createEntityCriteria();
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.eq("uuTien", isPrioritied));
		criteria.add(Restrictions.eq("delete", Constant.NOT_DELETED));
		addCommonSort(criteria);*/

		String sql = "SELECT new RstProductDto(maSp, tenSp, moTa, noiSx, mauSac, hinh, giaBan)"
				+ " FROM RstProductDto"
				+ " WHERE"
				+ " remove = :isRemove"
				+ " AND uuTien = :isPrioritied"
				+ " ORDER BY"
				+ " rstProducTypeDto.maLoai DESC, ngayNhap DESC";

		query = createQuery(sql);
		query.setParameter("isRemove", Constant.ACTIVE);
		query.setParameter("isPrioritied", isPrioritied);

		return query.list();
	}

	public List<RstProductDto> findByName(String productName, int offset) {

/*		criteria = createEntityCriteria();
		criteria.setProjection(projectionList);

		criteria.add(Restrictions.ilike("tenSp", productName, MatchMode.ANYWHERE));
		criteria.add(Restrictions.eq("remove", Constant.NOT_REMOVED));
		criteria.setResultTransformer(new AliasToBeanConstructorResultTransformer(RstProductDto.class.getConstructors()[0]));
		
		return criteria.list();*/

		String sql = "SELECT new RstProductDto(maSp, tenSp, moTa, noiSx, mauSac, hinh, giaBan)"
				+ " FROM RstProductDto"
				+ " WHERE"
				+ " remove = :isRemove"
				+ " AND tenSp like :productName"
				+ " ORDER BY"
				+ " rstProducTypeDto.maLoai DESC, ngayNhap DESC";

		query = createQuery(sql);
		query.setParameter("isRemove", Constant.ACTIVE);
		query.setParameter("productName", "%" + productName + "%");

		settingRecord(query, offset);

		return query.list();
		
	}

	public Long countResultByFindName(String productName) {

		criteria = createEntityCriteria();
		criteria.add(Restrictions.like("tenSp", productName, MatchMode.ANYWHERE));
		criteria.add(Restrictions.eq("remove", Constant.ACTIVE));
		criteria.setProjection(Projections.rowCount());
		
		return (Long)criteria.uniqueResult();
	}

	public RstProductDto findProductByID(Integer maSp) {

/*		criteria = createEntityCriteria();
		criteria.add(Restrictions.idEq(maSp));
		criteria.setProjection(projectionList1);
		criteria.setResultTransformer(new AliasToBeanConstructorResultTransformer(RstProductDto.class.getConstructors()[0]));

		return (RstProductDto)criteria.uniqueResult();*/
		String sql = "SELECT new RstProductDto(maSp, tenSp, moTa, noiSx, mauSac, hinh, giaBan)"
				+ " FROM RstProductDto"
				+ " WHERE"
				+ " remove = :isRemove"
				+ " AND maSp like :maSp";

		query = createQuery(sql);
		query.setParameter("isRemove", false);
		query.setParameter("maSp", maSp);

		return (RstProductDto)query.uniqueResult();
	}

	private void settingRecord(Query query, int offset) {

		query.setFirstResult(offset);
		query.setMaxResults(Constant.MAX_RECORD_DEFAULT);
	}

}
