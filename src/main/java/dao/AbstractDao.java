package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao<KEY extends Serializable, MODEL> {

	protected Criteria criteria;
	protected Query query;
	protected String sql;

	private final Class<MODEL> persistentClass;
	
	@SuppressWarnings("unchecked")
	public AbstractDao(){
		this.persistentClass =(Class<MODEL>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
	}
	
	@Autowired
	private SessionFactory sessionFactory;

	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<MODEL> getList() {

		return createEntityCriteria().list();
	}

	@SuppressWarnings("unchecked")
	public MODEL getByKey(KEY key) {
		return (MODEL) getSession().get(persistentClass, key);
	}

	public void persist(MODEL entity) {
		getSession().persist(entity);
	}

	public void delete(MODEL entity) {
		getSession().delete(entity);
	}
	
	protected Criteria createEntityCriteria(){
		return getSession().createCriteria(persistentClass);
	}

	protected Query createQuery(String sql) {
		return getSession().createQuery(sql);
	}

	protected ProjectionList columns(String...columns) {
		ProjectionList projectionList = Projections.projectionList();

		for(String name : columns) {
			projectionList.add(Projections.property(name));
		}

		return projectionList;
	}
}
