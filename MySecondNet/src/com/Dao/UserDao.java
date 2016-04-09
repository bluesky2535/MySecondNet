package com.Dao;

import org.springframework.stereotype.Component;

import com.domain.User;

@Component
public interface UserDao {

	public void save(User user);
	public User findByActiveCode(String activecode);
	public void update(User existUser);
	public User findbyUser(User user);
	public User findByUsername(String name);
}
