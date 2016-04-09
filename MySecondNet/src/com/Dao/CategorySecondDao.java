package com.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.domain.CategorySecond;

@Component
public interface CategorySecondDao {

	
    public 	List<CategorySecond>  selectAll();

	public CategorySecond findById(int csid);

	public void delete(CategorySecond cs);

	public void add(CategorySecond cs);

	public List<CategorySecond> findbycid(int cid);
}
