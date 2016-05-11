package org.service.impl;

import java.util.List;
import org.dao.UsertoactivityDao;
import org.service.UsertoactivityService;
import org.vo.Activity;
import org.vo.User;
import org.vo.Usertoactivity;

public class UsertoactivityServiceImpl implements UsertoactivityService{
	private UsertoactivityDao usertoactivityDao;
	
	@Override
	public List selectActivity(int userId, int pageNow, int pageSize) {
		return usertoactivityDao.selectActivity(userId, pageNow, pageSize);
	}

	@Override
	public int selectActivitySize(int userId) {
		return usertoactivityDao.selectActivitySize(userId);
	}

	@Override
	public void enrollActivity(Usertoactivity usertoactivity,
			Activity activity, User user) {
		usertoactivityDao.enrollActivity(usertoactivity, activity, user);
	}

	@Override
	public Usertoactivity selectByActivityId(int id) {
		return usertoactivityDao.selectByActivityId(id);
	}
	
	public UsertoactivityDao getUsertoactivityDao(){
		return usertoactivityDao;
	}
	
	public void setUsertoactivityDao(UsertoactivityDao usertoactivityDao){
		this.usertoactivityDao=usertoactivityDao;
	}

}
