package com.Dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.Dao.CategoryDao;
import com.domain.Category;

@Component
public class CategoryDaoImpl implements  CategoryDao{
	@Resource
	private SessionFactory sessionFactory;

	public Session getSession() {

		return sessionFactory.getCurrentSession();

	}
	
	//查询所有的一级分类
	@Override
	public List<Category> selectAll() {
		return getSession().createQuery("from Category").list();
	}

	@Override
	public void add(Category category) {
		getSession().save(category);
		
	}

	@Override
	public void delete(Category category) {
		getSession().delete(category);
		
	}

	@Override
	public void update(Category category) {
		getSession().update(category);
		
	}

	@Override
	public Category findById(int cid) {
	Category category=	(Category) getSession().createQuery("from Category c where c.id="+cid).uniqueResult();
		return category;
	}

}
