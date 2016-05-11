package org.service.impl;

import org.dao.UserDao;
import org.service.UserService;
import org.vo.User;

public class UserServiceImpl implements UserService{
	private UserDao userDao;

	@Override
	public User checkUser(String name, String password) {
		return userDao.checkUser(name, password);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public void deleteUser(String name, String password) {
		userDao.deleteUser(name, password);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
	
	public UserDao getUserDao(){
		return userDao;
	}
	
	public void setUserDao(UserDao userDao){
		this.userDao=userDao;
	}

}
