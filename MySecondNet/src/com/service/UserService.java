package com.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.utils.UUIDUtils;
import com.Dao.UserDao;
import com.domain.User;
import com.utils.MailUitls;

@Transactional("transactionManager")
@Component
public class UserService {
	@Resource
	private UserDao userDao;

	// 根据激活码激活用户
	public User findByActiveCode(String activecode) {
		User existUser = userDao.findByActiveCode(activecode);
		return existUser;
	}

	// 更新用户
	public void update(User existUser) {
		userDao.update(existUser);
	}

	// 查询用户
	public User findbyUser(User user) {
		User existUser = userDao.findbyUser(user);
		return existUser;
	}

	// 注册用户
	public void regist(User user) {
		
		String email = user.getEmail();
		String activecode = UUIDUtils.getUUID() + UUIDUtils.getUUID();
		user.setActivecode(activecode);
		MailUitls.sendMail(email, activecode);
		userDao.save(user);
	}
//根据姓名查询用户
	public User findByUsername(String name) {
		User user=userDao.findByUsername(name);
		return user;
	}

	

}
