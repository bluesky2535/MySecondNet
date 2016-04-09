package com.Dao;

import java.util.List;

import org.springframework.stereotype.Component;
import com.domain.Category;

@Component
public interface CategoryDao {

public 	List<Category> selectAll();

public void add(Category category);

public void delete(Category category);

public void update(Category category);

public Category findById(int cid);

}
