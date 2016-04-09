package com.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class CategorySecond implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private Category category;
	private Set<Product> products = new HashSet<Product>();

	@Override
	public String toString() {
		return "CategorySecond [id=" + id + ", name=" + name + ", category="
				+ category + ", products=" + products + "]";
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
