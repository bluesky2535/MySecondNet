package com.view.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.utils.PaymentUtil;
import com.utils.UUIDUtils;
import com.domain.Cart;
import com.domain.CartItem;
import com.domain.Order;
import com.domain.OrderItem;
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.OrderService;
import com.service.UserService;

@Controller("orderAction")
@Scope("prototype")
public class OrderAction extends ActionSupport implements ModelDriven<Order> {

	private static final long serialVersionUID = 1L;
	private Order order = new Order();
	@Resource
	private OrderService orderService;
	@Resource
	private UserService userService;
	// 接收支付通道编码
	private String pd_FrpId;
	// 接收付款成功后的参数:
	private String r3_Amt;

	private String r6_Order;

	@Override
	public Order getModel() {
		return order;
	}

	public String getPd_FrpId() {
		return pd_FrpId;
	}

	public String getR3_Amt() {
		return r3_Amt;
	}
//需要保存在session中的，需要遍历，因为不同商家是不同的订单
	private Set<Order> orders = new  LinkedHashSet<Order>();



	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

	public String getR6_Order() {
		return r6_Order;
	}

	// 评论我的订单
	public String comment() {
		order = orderService.findByOid(order.getOid());

		return "findByUid";
	}

	// 查询我的订单
	public String findByUid() {
		User existUser = (User) ActionContext.getContext().getSession()
				.get("existUser");
		List<Order> myorders = orderService.findbyuser(existUser.getId());
		ActionContext.getContext().getValueStack().set("myorders", myorders);
		return "findByUid";
	}

	// 根据订单id查询
	public String findByOid() {
		order = orderService.findByOid(order.getOid());
		return "findByOid";
	}
	
	

	// 修改订单的状态:
	public String updateState() {
		Order currOrder = orderService.findByOid(order.getOid());
		currOrder.setStatus(4);
		orderService.update(currOrder);
		return "updateStateSuccess";
	}

	// 保存订单
	public String saveOrder() {
		User buyer = (User) ServletActionContext.getRequest().getSession()
				.getAttribute("existUser");
		if (buyer == null) {
			this.addActionMessage("亲!您还没有登录!");
			return "msg";
		}
		Cart cart = (Cart) ServletActionContext.getRequest().getSession()
				.getAttribute("cart");
		// 同时防止用户不断的刷新该路径，将会不断的提交空订单。
		if (cart.getCartItems().size() == 0) {
			this.addActionMessage("亲!您还没有购物!");
			return "msg";
		}

		for (String sellername : cart.getMap().keySet()) {
			// 查出该订单的出售者
			User seller = userService.findByUsername(sellername);
			Order order = new Order();

			// 订单的总计
			double total = 0;
			List<CartItem> cartItems = cart.getMap().get(sellername);
			for (CartItem cartItem : cartItems) {
				OrderItem orderItem = new OrderItem();
				orderItem.setCount(cartItem.getCount());
				orderItem.setProduct(cartItem.getProduct());
				orderItem.setSubtotal(cartItem.getSubtotal());
				total += cartItem.getSubtotal();
				orderItem.setOrder(order);
				order.getOrderitems().add(orderItem);
			}
			int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
			int r2=(int)(Math.random()*(10));
			long now = System.currentTimeMillis();//一个13位的时间戳
			String orderID =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
			order.setOid(orderID);
			order.setTotal(total);
			order.setSeller(seller);
			order.setBuyer(buyer);
			order.setDateTime(new Date());
			order.setStatus(1);// 未付款
			orderService.save(order);
			orders.add(order);
		}
		ActionContext.getContext().getSession().put("orders", orders);
		// 清空购物车
		cart.clearCart();
		return "saveOrder";
	}

	public String saveOrder1() {

		return "saveOrder1";
	}

	public void setPd_FrpId(String pd_FrpId) {
		this.pd_FrpId = pd_FrpId;
	}

	public void setR3_Amt(String r3_Amt) {
		this.r3_Amt = r3_Amt;
	}

	public void setR6_Order(String r6_Order) {
		this.r6_Order = r6_Order;
	}

}
