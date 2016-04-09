package com.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.domain.CartItem;
import com.opensymphony.xwork2.ActionContext;

public class Cart {
	// 购物车属性
	// 购物项集合:Map的key就是商家的id,value:购物项
	private Map<String, List<CartItem>> map = new LinkedHashMap<String, List<CartItem>>();

	// Cart对象中有一个叫cartItems属性.
	public Collection<List<CartItem>> getCartItems() {
		return map.values();
	}

	// 购物总计:
	private double total;

	public double getTotal() {
		return total;
	}

	// 购物车的功能:
	// 1.将购物项添加到购物车
	public boolean  addCart(Product product, Integer count) {
		// 找出产品的商家
		String sellername = product.getSeller().getName();
      User existUser=  (User) ActionContext.getContext().getSession().get("existUser");
	
      if(existUser.getName().equals(sellername)){
			return false;
		}
		
		// 购物车里有该商家
		if (map.containsKey(sellername)) {
			List<CartItem> cartItems = map.get(sellername);
			boolean exist = true;// 设置标识位
			// 遍历该商家每个CartItem
			for (CartItem cartItem : cartItems) {
				// 找到该产品的cartItem,并添加数目
				if (product.getId() == cartItem.getProduct().getId()) {
					// 现有的产品项总价格
					double s = cartItem.getSubtotal();
					cartItem.setCount(cartItem.getCount() + count);
					total += cartItem.getSubtotal() - s;
					exist = false;
				}
			}
			if (exist) {
				CartItem cartItem = new CartItem();
				// 设置数量:
				cartItem.setCount(count.intValue());
				// 设置商品:
				cartItem.setProduct(product);
				cartItems.add(cartItem);

				total += cartItem.getSubtotal();
			}
		} else {// 购物车没有该商家

			List<CartItem> cartItems = new ArrayList<CartItem>();
			// 封装一个CartItem对象.
			CartItem cartItem = new CartItem();
			// 设置数量:
			cartItem.setCount(count.intValue());
			// 设置商品:
			cartItem.setProduct(product);
			total += cartItem.getSubtotal();
			cartItems.add(cartItem);
			map.put(product.getSeller().getName(), cartItems);
		}
		return true;

	}

	// 2.从购物车移除购物项
	public void removeCart(Integer pid, String sellername) {

		List<CartItem> cartItems = map.get(sellername);
		CartItem rcItem = null;
		
		for (CartItem cartItem : cartItems) {
			if (cartItem.getProduct().getId() == pid) {
				rcItem = cartItem;
			}
		}
		cartItems.remove(rcItem);
		
		if(cartItems.size()==0){
			map.remove(sellername);
		}
		// 总计 = 总计 -移除的购物项小计:
		total -= rcItem.getSubtotal();
	}

	// 3.清空购物车
	public void clearCart() {
		// 将所有购物项清空
		map.clear();
		// 将总计设置为0
		total = 0;
	}

	public Map<String, List<CartItem>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<CartItem>> map) {
		this.map = map;

	}

}
