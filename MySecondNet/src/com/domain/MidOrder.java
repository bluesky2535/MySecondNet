package com.domain;

import java.util.HashSet;
import java.util.Set;

public class MidOrder {
	private String midOid;
	private Set<Order>  orders =new HashSet<Order>();
	public String getMidOid() {
		return midOid;
	}
	public void setMidOid(String midOid) {
		this.midOid = midOid;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	

}
