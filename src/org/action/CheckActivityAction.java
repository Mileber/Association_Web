package org.action;

import java.io.*;
import java.util.*;
import org.tool.Pager;
import org.dao.imp.*;
import org.model.*;
import com.opensymphony.xwork2.*;

public class CheckActivityAction extends ActionSupport{
	private int pageNow=1;
	private int pageSize=4;
	private Activity activity;
	private List list;
	private Association association;
	
	private ActivityDaoImpl activityDaoImpl;
	
	public int getPageNow(){
		return pageNow;
	}
	public void setPageNow(int pageNow){
		this.pageNow=pageNow;
	}
	public int getPageSize(){
		return pageSize;
	}
	public void setPageSize(int pageSize){
		this.pageSize=pageSize;
	}
	public Activity getActivity(){
		return activity;
	}
	public void setActivity(Activity activity){
		this.activity=activity;
	}
	public Association getAssociation(){
		return association;
	}
	public void setAssociation(Association association){
		this.association=association;
	}
	public ActivityDaoImpl getActivityDaoImpl(){
		return activityDaoImpl;
	}
	public void setActivityDaoImpl(ActivityDaoImpl activityDaoImpl){
		this.activityDaoImpl=activityDaoImpl;
	}
	public String selectAllActivityByTime() throws Exception{
		List list=activityDaoImpl.selectActivityByTime(pageNow, pageSize);
		Pager page=new Pager(pageNow,activityDaoImpl.selectActivitySize());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("list", list);
		request.put("page", page);
		return SUCCESS;
	}
	
	public String addActivity() throws Exception{
		Activity ac = activityDaoImpl.selectActivity(activity.getId());
		if(ac!=null){
			//this.setMessage("活动已存在");
			return SUCCESS;
		}
		Activity a=new Activity();
		a.setName(activity.getName());
		a.setAssociation(activity.getAssociation());
		a.setClass_(activity.getClass_());
		a.setInfo(activity.getInfo());
		a.setTime(activity.getTime());
		a.setPhoto(activity.getPhoto());
		activityDaoImpl.addActivity(a);
		//this.setMessage("添加成功");
		return SUCCESS;
	}
	
	public String deleteActivity() throws Exception{
		if(activity.getId()==null||activity.getId().equals("")){
			//this.setMessage("请输入活动号");
			return SUCCESS;
		}
		Activity ac=activityDaoImpl.selectActivity(activity.getId());
		if(ac==null){
			//this.setMessage("要删除的图书不存在！");
			return SUCCESS;
		}
		activityDaoImpl.deleteActivity(activity.getId());
		//this.setMessage("删除成功！");
		return SUCCESS;
	}

	public String updateActivity() throws Exception{
		Activity a=activityDaoImpl.selectActivity(activity.getId());
		if(a==null){
			//this.setMessage("要修改的图书不存在，请先查看是否存在该图书！");
			return SUCCESS;
		}
		a.setName(activity.getName());
		a.setAssociation(activity.getAssociation());
		a.setClass_(activity.getClass_());
		a.setInfo(activity.getInfo());
		a.setTime(activity.getTime());
		a.setPhoto(activity.getPhoto());
		activityDaoImpl.updateActivity(a);
		//this.setMessage("修改成功！");
		return SUCCESS;
	}
	
	public String selectActivity() throws Exception{
		Activity a=activityDaoImpl.selectActivity(activity.getId());
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("activity", a);
		return SUCCESS;
	}
}
