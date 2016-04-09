package com.Dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.domain.Order;


@Component
public interface OrderDao {
	
	public  void saveOrder(Order order) ;

	public Order findByOid(String oid);

	public void update(Order currOrder);

	public List<Order> findbyuser(int id);

}
