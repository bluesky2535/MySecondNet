package com.domain;

import java.util.HashSet;
import java.util.Set;

public class User {

	private String activecode;
	private String addr;
	private String email;
	private int id;
	private int islive;
	private String name;
	private Set<Order> sellorders = new HashSet<Order>();
	private Set<Order> buyorders = new HashSet<Order>();
	public Set<Order> getSellorders() {
		return sellorders;
	}

	public void setSellorders(Set<Order> sellorders) {
		this.sellorders = sellorders;
	}

	public Set<Order> getBuyorders() {
		return buyorders;
	}

	public void setBuyorders(Set<Order> buyorders) {
		this.buyorders = buyorders;
	}

	private String password;
	private String phone;
/*	@Override
	public String toString() {
		return "User [activecode=" + activecode + ", addr=" + addr + ", email="
				+ email + ", id=" + id + ", islive=" + islive + ", name="
				+ name + ", sellorders=" + sellorders + ", buyorders="
				+ buyorders + ", password=" + password + ", phone=" + phone
				+ ", type=" + type + ", uploadproducts=" + uploadproducts + "]";
	}*/

	private String type;

	private Set<Product> uploadproducts;// 自己上传的产品

	public String getActivecode() {
		return activecode;
	}

	public String getAddr() {
		return addr;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public int getIslive() {
		return islive;
	}

	public String getName() {
		return name;
	}

	
	public String getPassword() {
		return password;
	}

	public String getPhone() {
		return phone;
	}

	public String getType() {
		return type;
	}

	public Set<Product> getUploadproducts() {
		return uploadproducts;
	}

	public void setActivecode(String activecode) {
		this.activecode = activecode;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIslive(int islive) {
		this.islive = islive;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setUploadproducts(Set<Product> uploadproducts) {
		this.uploadproducts = uploadproducts;
	}


}
