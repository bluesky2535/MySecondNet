package com.view.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.utils.PaymentUtil;
import com.utils.UUIDUtils;
import com.domain.Cart;
import com.domain.CartItem;
import com.domain.MidOrder;
import com.domain.Order;
import com.domain.OrderItem;
import com.domain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.MidOrderService;
import com.service.OrderService;
import com.service.UserService;

@Controller("midorderAction")
@Scope("prototype")
public class MidOrderAction extends ActionSupport implements
		ModelDriven<MidOrder> {

	private static final long serialVersionUID = 1L;

	@Resource
	private MidOrderService midOrderService;
	// 接收支付通道编码
	private String pd_FrpId;
	// 接收付款成功后的参数:
	private String r3_Amt;

	private String r6_Order;

	public String getPd_FrpId() {
		return pd_FrpId;
	}

	public String getR3_Amt() {
		return r3_Amt;
	}

	public String getR6_Order() {
		return r6_Order;
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

	// 付款
	public String payMidOrder() {
		midOrderService.paymidOrder(pd_FrpId);
		return NONE;
	}

	@Override
	public MidOrder getModel() {
		MidOrder midOrder = new MidOrder();
		return midOrder;
	}

	// 付款成功后跳转回来的路径:
	public String callBack() {
		midOrderService.callBack(r6_Order);
		this.addActionMessage("支付成功!订单编号为: " + r6_Order + " 付款金额为: " + r3_Amt);
		return "msg";
	}

}
