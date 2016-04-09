package com.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Category  implements Serializable{
	
	private int id;
	private String name;
	private Set<CategorySecond> categorySeconds =new HashSet<CategorySecond>();
	public Set<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}
	public void setCategorySeconds(Set<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
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
	
	

}
