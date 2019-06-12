package com.stamina.stamina.common.util;


import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/*
 * Repository基类
 * 模块编号：pcitc_ecs_dal_common_class_BaseRepository
 * 作       者：pcitc
 * 创建时间：2017/09/17
 * 修改编号：1
 * 描       述：Repository基类
 */
@NoRepositoryBean
public class BaseRepository<T, ID extends Serializable> {

	private Class<T> entityClass;
	private EntityManager entityManager;

	/**
	 * 注入EntityManager，同时实例化SimpleJpaRepository
	 *
	 * @param entityManager
	 * @author pcitc 2017-09-18
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	/**
	 * 获取EntityManager，操作jpa api的入口
	 *
	 * @return EntityManager
	 * @author pcitc 2017-09-18
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}


	public List<T> findAll(String jpql, Map<String, Object> paramList) {
		TypedQuery<T> query = this.entityManager.createQuery(jpql, entityClass);
		this.setParameterList(query, paramList);
		List<T> resultList = query.getResultList();
		return resultList;
	}


	/**
	 * 设置Query的参数
	 *
	 * @param query Query查询对象
	 * @param paramList 参数列表
	 * @author pcitc 2017-09-18
	 */
	protected void setParameterList(Query query, Map<String, Object> paramList) {
		for (Entry<String, Object> pair : paramList.entrySet()) {
			query.setParameter(pair.getKey(), pair.getValue());
		}
	}

	
	public List<?> getByParam(String table, String key, Object value,Class clazz) {
		StringBuilder builder = new StringBuilder("from ");
		builder.append(table).append(" where isDelete=0 and ").append(key).append(" = :value");
		TypedQuery<?> query = this.entityManager.createQuery(builder.toString(), clazz);
		query.setParameter("value", value);
		List<?> resultList = query.getResultList();	
		return resultList;


	}


	/**
	 * 获取分页数据
	 *
	 * @param page
	 *            分页参数
	 * @param jpql
	 *            hql语句
	 * @param paramList
	 *            参数列表
	 * @return 分页数据
	 * @author pcitc 2017-09-18
	 */
	public PaginationBean<org.hibernate.mapping.List> findAllCustom(Pagination page, String jpql, Map<String, Object> paramList) {
		Long count = getCount(jpql, paramList);
		PaginationBean<org.hibernate.mapping.List> resultList = new PaginationBean<org.hibernate.mapping.List>(page, count);
		Query query = this.entityManager.createQuery(jpql);

		this.setParameterList(query, paramList);
		query.setFirstResult(resultList.getBeginIndex()).setMaxResults(resultList.getPageSize());
		resultList.setPageList(query.getResultList());
		return resultList;
	}

	/**
	 * 获取分页数据的总量
	 *
	 * @param jpql
	 *            查询语句
	 * @param paramList
	 *            参数列表
	 * @return 数据条数
	 * @author pcitc 2017-09-18
	 */
	protected long getCount(String jpql, Map<String, Object> paramList) {
		String countHql = CountHqlBuilder.toCountHql(jpql);
		TypedQuery<Long> query = this.entityManager.createQuery(countHql, Long.class);
		this.setParameterList(query, paramList);
		if (query.getResultList().size() == 0)
			return 0;
		else{
			TypedQuery<Long> createQuery = this.entityManager.createQuery(countHql, Long.class);
			this.setParameterList(createQuery, paramList);

			if (createQuery.getResultList().size() > 1) {
				return Long.parseLong(createQuery.getResultList().size()+"");
			}

			return createQuery.getSingleResult();
		}


	}
}
