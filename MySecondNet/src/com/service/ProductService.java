package com.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.Dao.ProductDao;
import com.domain.PageBean;
import com.domain.Product;

@Transactional("transactionManager")
@Component
public class ProductService {

	@Resource
	private ProductDao productDao;

	// 添加
	public void add(Product p) {
		productDao.add(p);

	}

	// 查询出所有
	public List<Product> findall() {

		return productDao.findall();
	}

	// 分页查询数据
	public PageBean selectPage(int currentpage) {
		int pagesize = 10;
		int totalcount = productDao.totalcount();
		if (totalcount == 0) {
			return null;
		}

		List<Product> recordList = productDao.selectPage(currentpage, pagesize);

		PageBean pageBean = new PageBean(currentpage, totalcount, pagesize,
				recordList);
		return pageBean;
	}

	// 更新产品
	public void update(Product p) {
		productDao.update(p);

	}

	// 删除产品
	public void delete(Product p) {
		productDao.delete(p);

	}

	public Product selectbyID(int id) {
	
		Product p = productDao.selectbyID(id);
		return p;
	}

	public List<Product> desctime() {
		
		List<Product>  products=productDao.desctime();
		 
		return products;
	}

	public List<Product> findbycid(int cid) {
		List<Product>  products=productDao.findbycid(cid);

		return  products;
	}

	public List<Product> findbycsid(int csid) {
		List<Product>  products=productDao.findbycsid(csid);
		
		return products;
	}



	public String finduploaderbypid(Integer pid) {
		String  uploader =productDao.finduploaderbypid( pid);
		return uploader;
	}

}