package com.domain;

public class CartItem {
	
	
	
	private Product product;//产品信息
	private int count;//该产品的数量
	private double subtotal;//购买该商品的总钱数
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getSubtotal() {
		subtotal=count*product.getSecondprice();
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal =subtotal;

	}

}
