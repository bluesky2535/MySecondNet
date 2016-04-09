package com.Dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.Dao.UserDao;
import com.domain.User;


@Component
public class UserDaoImpl  implements UserDao{

	@Resource
	private SessionFactory sessionFactory;
	public Session getSession() {

		return  sessionFactory.getCurrentSession();

	}
	
	//添加用户
	@Override
	public void save(User user) {
			getSession().save(user);
		
	}
	
	//根据激活码激活用户
	@Override
	public User findByActiveCode(String activecode) {
		User existUser=	 (User) getSession().createQuery("from User u where u.activecode="+"'"+activecode+"'").list().get(0);
		System.out.println(existUser);
		return existUser;
	}
	
	//更新用户
	@Override
	public void update(User existUser) {
		getSession().update(existUser);
		
	}


	
	
	//根据用户名和密码判断是否有该用户
	@Override
	public User findbyUser(User user) {
		
	List<User> users =getSession().createQuery("from User u where u.name=? and u.password=? and u.islive=1").setString(0, user.getName()).setString(1, user.getPassword()).list();
		if(users==null){
			return null;
		}	
	    return users.get(0);
		
	}

	
	//根据姓名查询用户是否存在
	@Override
	public User findByUsername(String name) {
		
		User  user =(User) getSession().createQuery("from User u where u.name=:name").setParameter("name", name).uniqueResult();
		if(user==null){
			return null;
		}	
		System.out.println(user+"fin");
	    return user;
		
	}

 
}
