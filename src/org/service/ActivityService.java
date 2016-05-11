package org.service;

import java.util.List;

import org.vo.Activity;

public interface ActivityService {
	public List selectActivityByTime(int pageNow,int pageSize);
	public int selectActivitySize();
	public void addActivity(Activity activity);
	public void deleteActivity(int id);
	public void updateActivity(Activity activity);
	public Activity selectActivity(int id);
}
