package com.view.action;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.domain.Category;
import com.domain.CategorySecond;
import com.domain.PageBean;
import com.domain.Product;
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.CategorySecondService;
import com.service.CategoryService;
import com.service.ProductService;

@Controller("productAction")
@Scope("prototype")
public class ProductAction extends ActionSupport implements
		ModelDriven<Product> {
	private static final long serialVersionUID = 1L;

	public List<CategorySecond> getCategorySeconds() {
		return categorySeconds;
	}

	private int cid;

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	// 接收二级分类的id
	private int csid;

	public int getCsid() {
		return csid;
	}

	public void setCsid(int csid) {
		this.csid = csid;
	}

	public void setCategorySeconds(List<CategorySecond> categorySeconds) {
		this.categorySeconds = categorySeconds;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	private List<CategorySecond> categorySeconds;
	private List<Category> categories;
	@Resource
	private CategoryService categoryService;
	@Resource
	private CategorySecondService categorySecondService;
	private List img_srcs = new ArrayList();
	private int currentpage;

	private PageBean pageBean;

	private Product product = new Product();

	public void setCurrentpage(int currentpage) {
		this.currentpage = currentpage;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getCurrentpage() {
		return currentpage;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public Product getModel() {

		return product;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	// 多文件上传需要的三个属性:
	private List<File> upload = new ArrayList<File>();
	private List<String> uploadFileName = new ArrayList<String>();
	private List<String> uploadContentType = new ArrayList<String>();
	@Resource
	private ProductService productService;

	// 添加产品
	public String add() throws Exception {
		System.out.println(product);
		if (upload != null) {
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath(
					"/products");
			for (int i = 0; i < upload.size(); i++) {
				// 创建文件类型对象:
				File diskFile = new File(path + "//" + uploadFileName.get(i));
				File diskFile2 = new File(
						"F:/MyeclipseWorkspace/MySecondNet/WebRoot/products"
								+ "//" + uploadFileName.get(i));
				File file = upload.get(i);
				String img_src = "products/" + uploadFileName.get(i);
				img_srcs.add(img_src);
				// 文件上传到服务器:
				FileUtils.copyFile(file, diskFile);
				//文件上传到webroot目录下
				FileUtils.copyFile(file, diskFile2);

			}

		}
		User  existUser=(User) ServletActionContext.getRequest().getSession()
	.getAttribute("existUser");
	
		//设置产品的主人
        product.setSeller(existUser);
		product.setCategorySecond(categorySecondService.findById(csid));// 设置二级分类
		product.setImg_srcs(img_srcs);
		product.setUploadtime(new Date());// 上传时间
		productService.add(getModel());
		return "addSuccess";
	}

	public List<File> getUpload() {
		return upload;
	}

	public void setUpload(List<File> upload) {
		this.upload = upload;
	}

	public List<String> getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(List<String> uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public List<String> getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(List<String> uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	// 添加产品页面,添加分类，让用户可以选择分类
	public String addUI() throws Exception {
		
		categories = categoryService.selectAll();
		categorySeconds = categorySecondService.selectAll();
		return "addUI";
	}

	// 删除页面
	public String delete() throws Exception {
		product = productService.selectbyID(product.getId());
		productService.delete(product);
		return "delete";
	}

	// 查询页面
	public String select() throws Exception {
		pageBean = productService.selectPage(currentpage);
		return "select";
	}

	// 更新产品
	public String update() throws Exception {

		productService.update(product);
		System.out.println("更新产品成功");
		return "updateSuccess";
	}

	// 更新产品页面
	public String updateUI() throws Exception {

		product = productService.selectbyID(product.getId());
		return "updateUI";
	}

	// 显示单个产品页面
	public String showProduct() throws Exception {
		product = productService.selectbyID(product.getId());
		return "showProduct";
	}

	// 根据一级分类查询产品和所属的二级分类
	public String findbycid() throws Exception {
		// 所有一级分类的产品
		List<Product> products = productService.findbycid(cid);
		ActionContext.getContext().getValueStack().set("products", products);
		return "findbycid";
	}

	// 所有二级分类的产品
	public String findbycsid() throws Exception {
		
		List<Product> products = productService.findbycsid(csid);
		ActionContext.getContext().getValueStack().set("products", products);
		return "findbycsid";
	}

}
