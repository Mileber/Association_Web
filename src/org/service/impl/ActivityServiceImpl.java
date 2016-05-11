package org.service.impl;

import java.util.List;

import org.dao.ActivityDao;
import org.service.ActivityService;
import org.vo.Activity;

public class ActivityServiceImpl implements ActivityService{
	private ActivityDao activityDao;

	@Override
	public void addActivity(Activity activity) {
		activityDao.addActivity(activity);
	}

	@Override
	public void deleteActivity(int id) {
		activityDao.deleteActivity(id);
		
	}

	@Override
	public void updateActivity(Activity activity) {
		activityDao.updateActivity(activity);
	}

	@Override
	public Activity selectActivity(int id) {
		return activityDao.selectActivity(id);
	}
	
	public ActivityDao getActivityDao(){
		return activityDao;
	}

	public void setActivityDao(ActivityDao activityDao){
		this.activityDao=activityDao;
	}

	@Override
	public List selectActivityByTime(int pageNow, int pageSize) {
		return activityDao.selectActivityByTime(pageNow, pageSize);
	}

	@Override
	public int selectActivitySize() {
		return activityDao.selectActivitySize();
	}
}
