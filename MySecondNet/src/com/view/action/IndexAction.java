package com.view.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.domain.Category;
import com.domain.CategorySecond;
import com.domain.Product;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.CategorySecondService;
import com.service.CategoryService;
import com.service.ProductService;

@Controller("indexAction")
@Scope("prototype")
public class IndexAction extends ActionSupport {
	
	@Resource
	private   CategoryService categoryService;
	@Resource
	private   ProductService  productService;
	@Override
	public String execute() throws Exception {
		
		//一级分类存入到session中
		List<Category>  clist=categoryService.selectAll();
		ActionContext.getContext().getSession().put("clist", clist);
		//最新产品
		List<Product> newProducts =productService.desctime();
		ActionContext.getContext().getValueStack().set("newproducts", newProducts);
		return "index";
	}
	


}
