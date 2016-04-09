package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.Dao.CategoryDao;
import com.domain.Category;

@Component
public class CategoryService {

	@Resource
	private  CategoryDao categoryDao;
	
	
	//查询所有一级分类
	public List<Category> selectAll() {		
		return categoryDao.selectAll();
	}
	//添加
	public void add(Category category) {		
		 categoryDao.add(category);
	}
	//删除
	public void delete(Category category) {		
		 categoryDao.delete(category);
	}
	//更新
	public void update(Category category) {		
		 categoryDao.update(category);
	}
	
	
	public Category findById(int  cid) {		
		return categoryDao.findById(cid);
	}

}
