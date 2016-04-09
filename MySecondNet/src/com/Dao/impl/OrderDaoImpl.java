package com.Dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.Dao.OrderDao;
import com.domain.Order;

@Component
public class OrderDaoImpl implements OrderDao {
	@Resource
	private SessionFactory sessionFactory;

	// 获取session
	public Session getSession() {
		return sessionFactory.getCurrentSession();

	}

	// 保存订单
	@Override
	public void saveOrder(Order order) {
     getSession().save(order);
	}

	@Override
	public Order findByOid(String oid) {
		Order order=(Order) getSession().createQuery("from Order o where o.oid="+oid).uniqueResult();
		System.out.println(order);
		return order;
	}

	@Override
	public void update(Order currOrder) {
		 getSession().update(currOrder);
		
	}

	@Override
	public List<Order> findbyuser(int id) {
	   List<Order>  myOrders=getSession().createQuery("from Order o  where  o.user.id="+id).list();
	
	   return myOrders;
	}

}
