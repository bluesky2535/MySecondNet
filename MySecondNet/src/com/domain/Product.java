package com.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Product {

	private int id;// 产品id
	private String name;// 产品名称
	private double initprice;// 产品价格
	private double secondprice;// 产品价格
    private Date uploadtime;//产品上传时间
    private User seller;//上传者
	

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public double getInitprice() {
		return initprice;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

	public void setInitprice(double initprice) {
		this.initprice = initprice;
	}

	public double getSecondprice() {
		return secondprice;
	}

	public void setSecondprice(double secondprice) {
		this.secondprice = secondprice;
	}

	private String short_intro;// 产品简介

	private String description;// 产品详情

	private int quantity;// 产品总量

	private int havesell;// 已出售

	private Set<Reply> replys = new HashSet<Reply>();// 该产品的评价回复
	private List img_srcs = new ArrayList<String>();// 产品图片
	
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", initprice="
				+ initprice + ", secondprice=" + secondprice + ", uploadtime="
				+ uploadtime + ", seller=" + seller + ", short_intro="
				+ short_intro + ", description=" + description + ", quantity="
				+ quantity + ", havesell=" + havesell + ", replys=" + replys
				+ ", img_srcs=" + img_srcs + ", categorySecond="
				+ categorySecond + "]";
	}

	private CategorySecond categorySecond;// 二级分类

	public CategorySecond getCategorySecond() {
		return categorySecond;
	}

	public void setCategorySecond(CategorySecond categorySecond) {
		this.categorySecond = categorySecond;
	}

	public String getDescription() {
		return description;
	}

	public int getHavesell() {
		return havesell;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public Set<Reply> getReplys() {
		return replys;
	}

	public String getShort_intro() {
		return short_intro;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setHavesell(int havesell) {
		this.havesell = havesell;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List getImg_srcs() {
		return img_srcs;
	}

	public void setImg_srcs(List img_srcs) {
		this.img_srcs = img_srcs;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}

	public void setShort_intro(String short_intro) {
		this.short_intro = short_intro;
	}

}
