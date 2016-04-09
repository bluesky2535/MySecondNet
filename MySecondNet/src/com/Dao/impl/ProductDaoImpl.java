package com.Dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.Dao.ProductDao;
import com.domain.Product;

@Component
public class ProductDaoImpl implements ProductDao {

	@Resource
	private SessionFactory sessionFactory;

	public Session getSession() {

		return sessionFactory.getCurrentSession();

	}

	// 查询所有
	@Override
	public List<Product> findall() {

		List<Product> Products = getSession().createQuery("from Product")
				.list();

		return Products;
	}

	// 添加产品
	public void add(Product p) {
		getSession().save(p);
	}

	// 查询总数
	@Override
	public int totalcount() {
		Number n = (Number) getSession().createQuery(
				"select count(*) from Product").uniqueResult();
		return n.intValue();
	}

	// 分页查询
	@Override
	public List<Product> selectPage(int currentpage, int pagesize) {
		List<Product> products = getSession().createQuery("from Product")
				.setFirstResult(currentpage).setMaxResults(pagesize).list();
		return products;
	}

	// 删除产品
	@Override
	public void delete(Product p) {
		getSession().delete(p);

	}

	// 更新产品
	@Override
	public void update(Product p) {
		getSession().update(p);

	}

	@Override
	public Product selectbyID(int id) {
		Product p = (Product) getSession().createQuery(
				"from Product p  where p.id=" + id).uniqueResult();
		return p;
	}

	
	//根据最新产品
	@Override
	public List<Product> desctime() {
		
		List<Product> products =(List<Product>) getSession().createQuery(
				"from Product p  order by p.uploadtime desc").setFirstResult(0).setMaxResults(10).list();	
		return products;
	}

	
	//根据一级分类显示的产品
	@Override
	public List<Product> findbycid(int cid) {
		List<Product> products =(List<Product>) getSession().createQuery(
				"select p from Product p  join p.categorySecond  cs  join cs.category  c where  c.id ="+cid).list();
		return products;
	}

	
	//根据二级分类查询商品
	@Override
	public List<Product> findbycsid(int csid) {
		List<Product> products =(List<Product>) getSession().createQuery(
				"select p from Product p  join p.categorySecond  cs  where  cs.id ="+csid).list();
		
		return products;
	}

	
	//根据产品id查出其主人名
	@Override
	public String finduploaderbypid(Integer pid) {
	String uploader= (String) getSession().createSQLQuery("select  u.name  from   Product p  join User  u  on uploder_id=u.id   where  p.id=?").setInteger(0, pid).uniqueResult();
				
		return uploader;
	}

}
