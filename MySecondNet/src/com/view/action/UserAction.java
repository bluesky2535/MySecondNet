package com.view.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.UserService;

@Controller("UserAction")
@Scope("prototype")
public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = 1L;
	//提交的验证码
	private String checkcode;

	public String getCheckcode() {
		return checkcode;
	}

	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	private User user = new User();
	@Resource
	private UserService userService;

	// 用戶登录页面
	public String loginUI() throws Exception {
		return "loginUI";
	}

	// 用户登录
	public String login() throws Exception {

		User existUser = userService.findbyUser(user);
		if (existUser == null) {
			return "loginUI";
		}
		// 保存登录用户到session
		ServletActionContext.getRequest().getSession()
				.setAttribute("existUser", existUser);
		this.addActionMessage("用户名或密码错误或未激活");
		return "loginSuccess";
	}

	// 用户注册页面
	public String registUI() throws Exception {
		return "registUI";
	}
	/**
	 * AJAX进行异步校验用户名的执行方法
	 * 
	 * @throws IOException
	 */
	public String findByName() throws IOException {
		System.out.println(user.getName());
		// 调用Service进行查询:
		User existUser = userService.findByUsername(user.getName());
		// 获得response对象,项页面输出:
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		// 判断
		if (existUser != null) {
			// 查询到该用户:用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		} else {
			// 没查询到该用户:用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		return NONE;
	}
	// 注册用户
	public String regist() throws Exception {
		if(checkcode==null){		
			return "registUI";
		}
		
		String checkcode1 = (String) ActionContext.getContext().getSession()
				.get("checkcode");
		if (checkcode1.toUpperCase().equals(checkcode.toUpperCase())) {
			userService.regist(user);
			return "registSuccess";
		}
		this.addActionMessage("验证码错误");
		return "registUI";

	}

	// 激活用戶
	public String active() {
		// 根据激活码查询用户:
		User existUser = userService.findByActiveCode(user.getActivecode());
		// 判断
		if (existUser == null) {
			// 激活码错误的
			this.addActionMessage("激活失败:激活码错误!");
		} else {
			// 激活成功
			// 修改用户的状态
			existUser.setIslive(1);
			existUser.setActivecode(null);
			userService.update(existUser);
			this.addActionMessage("激活成功:请去登录!");
		}
		return "activeSuccess";
	}

	public String quit() {
		ActionContext.getContext().getSession().remove("existUser");
		return "quitSuccess";
	}

	@Override
	public User getModel() {
		return user;
	}
}
