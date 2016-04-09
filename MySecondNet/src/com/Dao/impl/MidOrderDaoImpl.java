package com.Dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.Dao.OrderDao;
import com.domain.MidOrder;
import com.domain.Order;
import com.service.MidOrderDao;

@Component
public class MidOrderDaoImpl implements MidOrderDao {
	@Resource
	private SessionFactory sessionFactory;

	// 获取session
	public Session getSession() {
		return sessionFactory.getCurrentSession();

	}


	
	//保存中转订单
	@Override
	public void save(MidOrder midOrder) {
	   getSession().save(midOrder);
		
	}


//根据中转订单id查出对象
	@Override
	public MidOrder finBymidorderid(String midorderid) {
		MidOrder midOrder=(MidOrder) getSession().createQuery("from MidOrder m where  midOid=：midOid").setString("midOid", midorderid).uniqueResult();
		return midOrder;
	}

}
