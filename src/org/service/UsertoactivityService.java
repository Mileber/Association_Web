package org.service;

import java.util.List;
import org.vo.Activity;
import org.vo.User;
import org.vo.Usertoactivity;

public interface UsertoactivityService {
	//分页查询指定用户的活动
	public List selectActivity(int userId,int pageNow,int pageSize);
	//查询指定用户所参与活动总数
	public int selectActivitySize(int userId);
	//报名活动
	public void enrollActivity(Usertoactivity usertoactivity, Activity activity, User user);
	//根据活动编号查询报名情况
	public Usertoactivity selectByActivityId(int id);
}
