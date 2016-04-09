package com.service;

import java.io.IOException;
import java.util.Set;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.Dao.OrderDao;
import com.domain.MidOrder;
import com.domain.Order;
import com.opensymphony.xwork2.ActionContext;
import com.utils.PaymentUtil;


@Component
@Transactional
public class MidOrderService  {
	
	@Resource
	private OrderDao orderDao;
	
	@Resource
	 private MidOrderDao midOrderDao;
	
	public void paymidOrder(String pd_FrpId1){
		        // 获取session中保存的订单
				Set<Order> orders =  (Set<Order>) ActionContext.getContext().getSession().get("orders");
			    MidOrder midOrder=new MidOrder();
			    int r1=(int)(Math.random()*(10));//产生2个0-9的随机数
				int r2=(int)(Math.random()*(10));
				long now = System.currentTimeMillis();//一个13位的时间戳
				String midOid =String.valueOf(r1)+String.valueOf(r2)+String.valueOf(now);// 订单ID
			    midOrder.setMidOid(midOid);
			    midOrder.setOrders(orders);
			    midOrderDao.save(midOrder) ;
				// 2.完成付款:   
				// 付款需要的参数:
				String p0_Cmd = "Buy"; // 业务类型:
				String p1_MerId = "10001126856";// 商户编号:
				String p2_Order = midOrder.getMidOid();// 订单编号:
				String p3_Amt = "0.01"; // 付款金额:
				String p4_Cur = "CNY"; // 交易币种:
				String p5_Pid = ""; // 商品名称:
				String p6_Pcat = ""; // 商品种类:
				String p7_Pdesc = ""; // 商品描述:
				String p8_Url = "http://222.24.59.141:8080/MySecondNet/midOrder_callBack.action"; // 商户接收支付成功数据的地址:
				String p9_SAF = ""; // 送货地址:
				String pa_MP = ""; // 商户扩展信息:
				String pd_FrpId = pd_FrpId1;// 支付通道编码:
				String pr_NeedResponse = "1"; // 应答机制:
				String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl"; // 秘钥
				String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt,
						p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc, p8_Url, p9_SAF, pa_MP,
						pd_FrpId, pr_NeedResponse, keyValue); // hmac
				// 向易宝发送请求:
				StringBuffer sb = new StringBuffer(
						"https://www.yeepay.com/app-merchant-proxy/node?");
				sb.append("p0_Cmd=").append(p0_Cmd).append("&");
				sb.append("p1_MerId=").append(p1_MerId).append("&");
				sb.append("p2_Order=").append(p2_Order).append("&");
				sb.append("p3_Amt=").append(p3_Amt).append("&");
				sb.append("p4_Cur=").append(p4_Cur).append("&");
				sb.append("p5_Pid=").append(p5_Pid).append("&");
				sb.append("p6_Pcat=").append(p6_Pcat).append("&");
				sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
				sb.append("p8_Url=").append(p8_Url).append("&");
				sb.append("p9_SAF=").append(p9_SAF).append("&");
				sb.append("pa_MP=").append(pa_MP).append("&");
				sb.append("pd_FrpId=").append(pd_FrpId).append("&");
				sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
				sb.append("hmac=").append(hmac);

				// 重定向:向易宝出发:
				try {
					ServletActionContext.getResponse().sendRedirect(sb.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

	//付款成功后，改变订单状态
	public void callBack(String r6_Order) {
	      MidOrder midOrder=midOrderDao.finBymidorderid(r6_Order);
	      Set<Order> orders= midOrder.getOrders();
	      for (Order order :orders){
	    	order.setStatus(2); //已付款 
	    	orderDao.update(order);
	      }
	}

}
