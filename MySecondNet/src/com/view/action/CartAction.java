package com.view.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.domain.Cart;
import com.domain.CartItem;
import com.domain.Product;
import com.opensymphony.xwork2.ActionSupport;
import com.service.ProductService;

@Controller("cartAction")
@Scope("prototype")
public class CartAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	// 接收pid
	private Integer pid;
	// 接收数量count
	private Integer count;
	// 注入商品的Service
	@Resource
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
/**
 * 
 * @return
 */
	// 将购物项添加到购物车:执行的方法
	public String addCart() {
		// 找出该产品
		Product product = productService.selectbyID(pid);
	   boolean addsuccess= getCart().addCart(product,count);
	   if(addsuccess){
		   return "addCart";  
	   }else{
		   this.addActionMessage("不能购买自己的产品！！！");
		   return  "addCartFail";
	   }
		
	}

	// 清空购物车的执行的方法:
	public String clearCart() {
		// 获得购物车对象.
		Cart cart = getCart();
		// 调用购物车中清空方法.
		cart.clearCart();
		return "clearCart";
	}


	// 从购物车中移除购物项的方法:
	
	
	public String removeCart() {
		
		String  uploadername=productService.finduploaderbypid(pid);
		
		// 获得购物车对象
		Cart cart = getCart();
		// 调用购物车中移除的方法:
		cart.removeCart(pid,uploadername);
		// 返回页面:
	return "removeCart";
	}

	// 我的购物车:执行的方法
	public String myCart() {
		return "myCart";
	}


	private Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		if (cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession()
					.setAttribute("cart", cart);
		}
		return cart;
	}
}
