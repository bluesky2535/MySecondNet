package com.domain;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {
	
	private  String  oid;
	private  Set<OrderItem>  orderitems=new HashSet<OrderItem>();
	private  double total;
	private  Date dateTime;
	private  User buyer;//购买者
	private  User seller;//出售者
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	private  int status;//1:未付款   2:订单已经付款   3:已经发货   4:订单结束
	private  String  name;
	private  String  phone;
	private  String  addr;
	private MidOrder midOrder;
	
	public MidOrder getMidOrder() {
		return midOrder;
	}
	public void setMidOrder(MidOrder midOrder) {
		this.midOrder = midOrder;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Set<OrderItem> getOrderitems() {
		return orderitems;
	}
	public void setOrderitems(Set<OrderItem> orderitems) {
		this.orderitems = orderitems;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	

}
