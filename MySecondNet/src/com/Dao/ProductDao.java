package com.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.domain.Product;

@Component
public interface ProductDao {

	public List<Product> findall();
	
	public void  add(Product p);

	public int totalcount();

	public List<Product> selectPage(int currentpage, int pagesize);
	
	public void delete(Product p);
	
	public void update(Product p);

	public Product selectbyID(int id);

	public List<Product> desctime();

	public List<Product> findbycid(int cid);

	public List<Product> findbycsid(int csid);

	public String finduploaderbypid(Integer pid);
	
	
}
