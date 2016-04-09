package com.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.Dao.OrderDao;
import com.domain.Cart;
import com.domain.CartItem;
import com.domain.Order;
import com.domain.OrderItem;
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;


@Component
@Transactional
public class OrderService {
	@Resource
	private OrderDao orderDao;
	
	
	public void save(Order order) {
	
		/*for (String sellername : cart.getMap().keySet()) {
			// 查出该订单的出售者
			//***********************************************
			User seller=userService.findByUsername(sellername);
			
			//**********************************************
		    //订单的总计
			double total = 0;
			List<CartItem> cartItems = cart.getMap().get(sellername);
			for (CartItem cartItem : cartItems) {
				OrderItem orderItem = new OrderItem();
				orderItem.setCount(cartItem.getCount());
				orderItem.setProduct(cartItem.getProduct());
				orderItem.setSubtotal(cartItem.getSubtotal());
				total += cartItem.getSubtotal();
				orderItem.setOrder(order);
				order.getOrderitems().add(orderItem);
			}
			order.setTotal(total);
			//***********************************************
			order.setSeller(seller);
			//***********************************************
			order.setBuyer(buyer);	
			order.setDateTime(new Date());
			order.setStatus(1);// 未付款
			
			orders.add(order);
		}
		// 清空购物车
	     cart.clearCart();
		ActionContext.getContext().getSession().put("orders", orders);*/
		
		
		orderDao.saveOrder(order);
	}

	public Order findByOid(String Oid) {
	Order order =	orderDao.findByOid(Oid);
		return order;
	}

	public void update(Order currOrder) {
		orderDao.update(currOrder);
		
	}

	public List<Order> findbyuser(int id) {
		List<Order> myOrders=orderDao.findbyuser(id);
		return myOrders;
	}



}
