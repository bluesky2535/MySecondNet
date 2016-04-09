package com.Dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.stereotype.Component;

import com.Dao.CategorySecondDao;
import com.domain.CategorySecond;
import com.domain.Product;

@Component
public class CategorySecondDaoImpl implements CategorySecondDao {

	@Resource
	private SessionFactory sessionFactory;

	// 获取session
	public Session getSession() {
		return sessionFactory.getCurrentSession();

	}

	
	//获取所有二级分类
	@Override
	public List<CategorySecond> selectAll() {

		return getSession().createQuery("from CategorySecond").list();
	}

	// 根据id查询相应的二级分类
	@Override
	public CategorySecond findById(int csid) {
		return (CategorySecond) getSession().createQuery(
				"from CategorySecond cs where cs.id=" + csid).uniqueResult();
	}

	// 删除
	@Override
	public void delete(CategorySecond cs) {
		getSession().delete(cs);
	}

	// 添加
	@Override
	public void add(CategorySecond cs) {
		getSession().save(cs);
	}


	
	//查询一级分类下的二级分类
	@Override
	public List<CategorySecond> findbycid(int cid) {
		List<CategorySecond>  cslist =getSession().createQuery("from CategorySecond cs  join c.Category c where c.id="+cid ).list();
		return cslist;
	}

}
